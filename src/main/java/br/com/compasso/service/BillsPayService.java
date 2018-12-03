package br.com.deliver.service;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliver.model.BillsPayModel;
import br.com.deliver.repository.BillsPayRepository;
import br.com.deliver.utils.Rate;

@Service
public class BillsPayService {

	@Autowired
	BillsPayRepository payRepository;

	public Iterable<BillsPayModel> listAll() {
		return payRepository.findAll();
	}

	public void insert(BillsPayModel billsPayModel) {
		
		//verifica os dias em atraso e atualiza valor corrigido
		verifyAccount(billsPayModel);
		
		payRepository.save(billsPayModel);
	}

	public BillsPayModel verifyAccount(BillsPayModel billsPayModel) {
		
		Period periodo = Period.between(
				billsPayModel.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				billsPayModel.getPayDay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		
		//add dias em atraso
		billsPayModel.setDelayedDays(periodo.getDays());
		
		BigDecimal addition = BigDecimal.ZERO;
		
		if(periodo.getDays() <= 3){
			
			addition = calculation(billsPayModel.getOriginalValue(), Rate.RATE_ONE.getRate());
			
			for (int i = 0; i < periodo.getDays(); i++) {
				addition = calculation(addition, Rate.RATE_DAY_ONE.getRate());				
			}
			
		} else if (periodo.getDays() > 3 && periodo.getDays() <= 5) {
			
			addition = calculation(billsPayModel.getOriginalValue(), Rate.RATE_TWO.getRate());
			
			for (int i = 0; i < periodo.getDays(); i++) {
				addition = calculation(addition, Rate.RATE_DAY_TWO.getRate());				
			}
			
		} else if (periodo.getDays() > 5) {
			
			addition = calculation(billsPayModel.getOriginalValue(), Rate.RATE_THREE.getRate());
			
			for (int i = 0; i < periodo.getDays(); i++) {
				addition = calculation(addition, Rate.RATE_DAY_THREE.getRate());				
			}			
		}
		
		billsPayModel.setCorrectedValue(addition.setScale(4, RoundingMode.HALF_EVEN));
		
		return billsPayModel;
	}

	private BigDecimal calculation(BigDecimal value, String rate) {
		return value.multiply(BigDecimal.ONE.add(new BigDecimal(rate)));
	}
}
