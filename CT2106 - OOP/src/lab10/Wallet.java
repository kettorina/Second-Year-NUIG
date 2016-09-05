package lab10;

import java.util.ArrayList;
import java.util.Collections;

public class Wallet {
	
	private String name;
	private ArrayList <Currency> allcurrency = new ArrayList<Currency>(); //initialise arraylist to take in AUD, CAD, GBP, USD
	
	public Wallet(String string) {
		this.name=string;
		this.allcurrency = new ArrayList<Currency>();
	}

	public void addCurrency(Currency currency){//this allows to add all currencies into one arraylist rather than adding them individually
		Converter convert = new Converter();//new instance of the object convert
		convert.setEuroValue(currency);//this send currency to get the euro equivalent before adding it to arraylist
		allcurrency.add(currency);//this adds currency to the arraylist 
	}
	
	/*
	 * This method calculates and returns the total Euro value of 
	 * each currency in the wallet
	*/
	public double getTotalEuroValue(){
		double totalEuro =0.00;
		for (Currency cur:allcurrency){
			totalEuro+=cur.getEuroValue();//gets the eurovalue that has been set by currency by setEuroValue by addCurrency
		}
		return totalEuro;
	}
	
	/*
	 * This method sorts the currencies in ascending order according to their euro Values
	*/
	public void sort(){
		Collections.sort(allcurrency);//a way to sort allcurrency using Collections 
	}
	
	@Override
	/*
	 * The toString() method returns a String value of each currency and its amount in the wallet
	 * each currency- amount pair is separated by a comma
	 * e.g. USD:100,CAD:250,GBP:99,AUD:123
	 * 
	*/
	public String toString(){
		String fullString = "";
		for(Currency cur:allcurrency){
			fullString += cur.getCurrencyName() + ":" + cur.getAmount() + ",";//adds the name and the amount of the currency with a : separator
		}
		return fullString;
	}

	
}
