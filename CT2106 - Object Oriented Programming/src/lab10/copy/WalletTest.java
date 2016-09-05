package lab10.copy;

import static org.junit.Assert.*;
import lab10.copy.AUD;
import lab10.copy.CAD;
import lab10.copy.GBP;
import lab10.copy.USD;
import lab10.copy.Wallet;

import org.junit.Before;
import org.junit.Test;

public class WalletTest {
	
	Wallet myWallet = new Wallet("my trip");

	@Before
	public void setUp() throws Exception {
		
		USD usDollars = new USD(100);
		CAD canDollars = new CAD(250);
		GBP sterling = new GBP(99);
		AUD ausDollars = new AUD(123);

		
		myWallet.addCurrency(usDollars);
		myWallet.addCurrency(canDollars);
		myWallet.addCurrency(sterling);
		myWallet.addCurrency(ausDollars);

	}

	@Test
	public void testCalcTotalEuroValue() {
		
		double expected = 100 * 0.66 + 250 * 0.7 + 99 *1.4 + 123 * 0.93;
		
		double actual = myWallet.calcTotalEuroValue();
		
		assertEquals(expected, actual, 0.00001);
		
		
		
	}

	@Test
	public void testSort() {
		myWallet.sort();
		String wallet = myWallet.toString();
		String[] currencies = wallet.split(",");
		
		assertEquals(currencies[0], "USD:100.0");
		assertEquals(currencies[1], "AUD:123.0");
		assertEquals(currencies[2], "GBP:99.0");
		assertEquals(currencies[3], "CAD:250.0");
	}

	

}
