package com.ideyatech.ut.exercise;

import java.util.ArrayList;

public class StringCalculator implements Calculator{

	ArrayList<String> subInputList;
	ArrayList<Integer> subInputIntList;
	
	
	public long calculate(String input) {
		
		String delimeter = ",";
		if(input.contains("//"))
		{
			if(input.contains("[") && input.contains("]"))
			{
				delimeter = input.substring(input.indexOf("[")+1, input.indexOf("]"));
				System.out.println(delimeter);
				input = input.substring(input.indexOf("]")+1, input.length());
				System.out.println(input);
			}
			else
			{
				delimeter = input.substring(2, 3);
				input = input.substring(3, input.length());
			}
		}
		
		if(input == null || input.isEmpty() || input.trim().isEmpty())
			return 0;
		subInputList = new ArrayList<String>();
		subInputIntList = new ArrayList<Integer>();
		String[] tempList = input.split(delimeter);
		for(int i = 0; i < tempList.length; i++)
		{
			if(Integer.parseInt(tempList[i]) < 0)
				throw new IllegalArgumentException();
			
			if(Integer.parseInt(tempList[i]) <= 1000)
				subInputIntList.add(Integer.parseInt(tempList[i]));
			
			//System.out.println(tempList[i]);
		}
		
		for(int j = 0; j < subInputIntList.size(); j++)
		{
			if(subInputIntList.get(j) >= 0)
			{	
				if(subInputIntList.size() == 1)
					return subInputIntList.get(0);
				/*else if (subInputIntList.size() == 2)
					return subInputIntList.get(0) + subInputIntList.get(1);*/
				else
				{	int sum = 0;
					for(int x = 0; x < subInputIntList.size() ; x++)
					{
						sum += subInputIntList.get(x);
						
					}
					return sum;
				}
			} else
					throw new IllegalArgumentException();
		}
		
		return 0;
	}
	
/*	public static void main(String[] a)
	{
		StringCalculator sc = new StringCalculator();
		sc.calculate("20,30,50");
	//	for(int i = 0; i < sc)
	}*/

}
