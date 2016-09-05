package lab10;

public class USD extends Currency{ 
	
	public USD(int i) {
		this.amount=i;//taken from currency so that conversion to euros is done within currency
		this.currencyName = "USD";//taken from currency
	}

}
