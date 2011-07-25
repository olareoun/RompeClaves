package org.todofluye.ext;

import java.math.BigInteger;

public class MiFactorial {

	  public static BigInteger factorial(int n) {
		    if (n <= 1) {
		      return(new BigInteger("1"));
		    } else {
		      BigInteger bigN = new BigInteger(String.valueOf(n));
		      return(bigN.multiply(factorial(n - 1)));
		    }
		  }
}
