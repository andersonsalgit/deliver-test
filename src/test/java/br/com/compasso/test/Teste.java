package br.com.compasso.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class Teste {

	static final long EXPIRATION_TIME = 860_000_000;
	
	@Test
	public void test() {
		
		//System.out.println(System.currentTimeMillis()+EXPIRATION_TIME);
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.getTimeInMillis());
		
		cal.add(Calendar.MINUTE, 1);
		
		System.out.println(cal.getTimeInMillis());
		
		//System.out.println(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
	}

}
