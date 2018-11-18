package br.com.deliver.utils;

public enum Rate {

	RATE_ONE("0.02"),
	RATE_DAY_ONE("0.001"),
	RATE_TWO("0.03"),
	RATE_DAY_TWO("0.002"),
	RATE_THREE("0.05"),
	RATE_DAY_THREE("0.003");
 
    private String value;
 
    Rate(String value) {
        this.value = value;
    }
 
    public String getRate() {
        return value;
    }
	
}
