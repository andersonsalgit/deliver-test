package br.com.compasso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.model.PautaModel;
import br.com.compasso.model.PautaResponse;
import br.com.compasso.repository.PautaRepository;

@Service
public class PautaService {

	@Autowired
	PautaRepository pautaRepository;

	public void insert(PautaModel pautaModel) {
		pautaRepository.save(pautaModel);
	}
	
	public List<PautaModel> listAll() {
		return pautaRepository.findAll();
	}
	
	public PautaResponse listFinalResult(Long pautaID) {
		
		PautaModel pautaModel = pautaRepository.findById(pautaID).get();
		
		long votoSim = pautaModel.getVotos().stream().filter(pm -> pm.isVoto()).count();
		long votoNao = pautaModel.getVotos().stream().filter(pm -> !pm.isVoto()).count();
		
		PautaResponse response = new PautaResponse();
		response.setTitulo(pautaModel.getTitulo());
		response.setAssunto(pautaModel.getAssunto());
		response.setVotoSim(votoSim);
		response.setVotoNao(votoNao);
		response.setDataCriacao(pautaModel.getDataCriacao());
		
		return response;
	}
}
