package test;

import junit.framework.Assert;

public class TestCalculator {
	Calcualtor c = new Calcualtor();
	
	public void testadd()
	{
		Assert.assertEquals(5,c.add(2, 5) );
		System.out.println("good morning");
	}

}
