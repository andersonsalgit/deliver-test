package br.com.deliver.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.deliver.model.BillsPayModel;
import br.com.deliver.service.BillsPayService;

@RunWith(MockitoJUnitRunner.class)
public class BillPayServiceTest {

	@InjectMocks
	private BillsPayService service;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testVerifyAccountOne() {

		BillsPayModel model = new BillsPayModel();
		
		model.setOriginalValue(new BigDecimal("100"));
		
		Calendar cal = Calendar.getInstance();
		
		model.setDueDate(cal.getTime());
		
		cal.add(Calendar.DATE, 1);
		model.setPayDay(cal.getTime());
		
		model = service.verifyAccount(model);
		
		assertEquals(new BigDecimal("102.1020"), model.getCorrectedValue());
		
	}
	
	@Test
	public void testVerifyAccountTwo() {

		BillsPayModel model = new BillsPayModel();
		
		model.setOriginalValue(new BigDecimal("100"));
		
		Calendar cal = Calendar.getInstance();
		
		model.setDueDate(cal.getTime());
		
		cal.add(Calendar.DATE, 4);
		model.setPayDay(cal.getTime());
		
		model = service.verifyAccount(model);
		
		assertEquals(new BigDecimal("103.8265"), model.getCorrectedValue());
		
	}
	
	@Test
	public void testVerifyAccountThree() {

		BillsPayModel model = new BillsPayModel();
		
		model.setOriginalValue(new BigDecimal("100"));
		
		Calendar cal = Calendar.getInstance();
		
		model.setDueDate(cal.getTime());
		
		cal.add(Calendar.DATE, 6);
		model.setPayDay(cal.getTime());
		
		model = service.verifyAccount(model);
		
		assertEquals(new BigDecimal("106.9042"), model.getCorrectedValue());
		
	}
}
