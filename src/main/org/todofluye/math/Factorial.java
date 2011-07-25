package org.todofluye.math;

import java.math.BigInteger;

public class Factorial {

	  public static BigInteger factorial(int n) {
		    if (n <= 1) {
		      return(new BigInteger("1"));
		    } else {
		      BigInteger bigN = new BigInteger(String.valueOf(n));
		      return(bigN.multiply(factorial(n - 1)));
		    }
		  }
}
