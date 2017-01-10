package com.ideyatech.ut.exercise;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringCalculatorTest {
	
	StringCalculator sc;
	
	@BeforeClass
	public static void initClass()
	{
		System.out.println("[TEST] String Calculator Start");
	}
	
	@Before
	public void init()
	{
		sc =  new StringCalculator();
	}
	
	@Test
	public void testEmptyString()
	{
		assertEquals(sc.calculate(""), 0);
	}
	
	@Test
	public void testSingleNumber()
	{
		assertEquals(sc.calculate("55"),55);
	}
	
	@Test
	public void testDoubleNumber()
	{
		//System.out.println(sc.calculate("55,5"));
		assertEquals(sc.calculate("55,5"),60);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoubleNumberWithNegative()
	{
		//System.out.println(sc.calculate("55,5"));
		assertEquals(sc.calculate("55,-5"),60);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeNumber()
	{
		sc.calculate("-32");
	}
	
	@Test
	public void testGreaterThan1000()
	{
		assertEquals(sc.calculate("55,1001"),55);
	}
	
	@Test
	public void testDelimeter()
	{
		assertEquals(sc.calculate("10,20,30,1001"), 60);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDelimeterWithNegative()
	{
		assertEquals(sc.calculate("10,-20,30,1001"), 60);
	}
	
	@Test
	public void testSpecifiedDelimeter()
	{
		assertEquals(sc.calculate("//=10=20=30=1001"), 60);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSpecifiedDelimeterWithNegative()
	{
		assertEquals(sc.calculate("//=10=-20=30=1001"), 60);
	}
	
	@Test
	public void testSpecifiedMultiCharDelimeter()
	{
		assertEquals(sc.calculate("//[abc]10abc20abc30abc1001"), 60);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSpecifiedMultiCharDelimeterWithNegative()
	{
		assertEquals(sc.calculate("//[abc]10abc20abc-30abc1001"), 60);
	}
	
	
	

}
