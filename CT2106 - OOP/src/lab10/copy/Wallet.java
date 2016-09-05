package lab10.copy;

import java.util.ArrayList;
import java.util.Collections;

public class Wallet {
	
	private String name;
	private ArrayList<Currency> currencies;
	
	
	public Wallet(String string) {
		this.name = string;
		this.currencies = new ArrayList<Currency>();
	}

	public void addCurrency(Currency currency){
		
		Converter converter = new Converter();
		converter.setEuroValue(currency);
		currencies.add(currency);
		
	}
	
	/*
	 * This method calculates and returns the total Euro value of 
	 * each currency in the wallet
	*/
	public double calcTotalEuroValue(){
		
		double euroTotal = 0;
		
		for (Currency currency: currencies){
				euroTotal+=currency.getEuroValue();	
		}
		return euroTotal;
	}
	
	/*
	 * This method sorts the currencies in ascending order according to their euro Values
	*/
	public void sort(){
		Collections.sort(currencies);
	}
	
	@Override
	/*
	 * The toString() method returns a String value of each currency and its amount in the wallet
	 * each currency- amount pair is separated by a comma
	 * e.g. USD:100,CAD:250,GBP:99,AUD:123
	 * 
	*/
	public String toString(){
		String out= "";
		for (Currency curr : currencies){
			out=out+curr.getCurrencyName()+":"+ curr.getAmount()+",";
		}
		out = out.substring(0, out.length()-1); // clips off the trailing comma
		return out;
	}
	
}
