package com.ollo.exam.cheque;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Cheque interface.
 * <p/>
 * Make your changes here.
 */
public class MyCheque implements Cheque {

	//@Override
	//public String inWords(double amount) throws ChequeException {
		// TODO implement your solution here
		//throw new UnsupportedOperationException("Not supported yet.");
	//}
	
	//public String spell(String amount) throws Exception{
	@Override
	public String inWords(double amount) throws ChequeException {
		String[] vector;
		String number = new String();
		int num;
		if((amount > 10000000)||(amount < 0)){
			throw new UnsupportedOperationException("ChequeException");
		}
		String amountString = String.valueOf(amount);
		vector = split(amountString);
		//number = vector[0]+vector[1];
		//num = Integer.parseInt(number);
		//if ((num > 1000000000)||(num < 0)){
		
		
		String text = new String("");
		text = printOut(vector);
		text = takeOfSpaces(text);
		text = CapitalizeString(text);
		return text;
	}
	
	//This Function just Capitalize the first letter.
	public String CapitalizeString(String Spelled){
		char[] charArray = Spelled.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		return new String(charArray);
	}
	
	//This function take off double spaces
	public String takeOfSpaces(String Spelled){
		String text = new String("");
		String[] v1 = Spelled.split("\\s+");
		for(int i = 0;i < v1.length;i++){
			text += v1[i];
			if(i == v1.length-1) break;
			text += " ";
		}
		return text;
	}
	
	//this function returns a array of strings
	//Position 0 = String Bills
	//Position 1 = String Cents
	public String[] split(String amount) {
		String justNumber;
		//This line take off the signal $ from the number
		String[] v1 = amount.split("\\$");
		
		//This line is just to make sure that after the split
		//the program will use the right string
		//Because after the split of $ we always have one string
		//Empty and one with the amount of money
		if (v1.length == 1) {
			justNumber = v1[0];
		} else {
			if (v1[0].equals("")) {
				justNumber = v1[1];
			} else {
				justNumber = v1[0];
			}
		}
		
		//This split divide the number in the '.'
		//it puts Bills and Cents in different Strings.
		String[] v2 = justNumber.split("\\.");

		//This Split take of all commas
		//From vector v2 and put it in
		//vector v3.
		String[] v3 = v2[0].split(",");

		
		String justBills = new String("");
		//After took off the commas this for
		//Create a String justBills with the amount
		//of bills without commas
		for (int i = 0; i < v3.length; i++) {
			justBills = justBills + v3[i];
		}
		//it just change the name of the vector with 
		//the amount of cents.
		String justCents = v2[1];
		
		//Create a array with Bills and Cents to return.
		String[] money = new String[2];
		money[0] = justBills;
		money[1] = justCents;
		
		return money;
	}

	
	//This function create a dirty spell of the number
	//This spell has double spaces and it is not capitalized.
	public String printOut(String[] v) {
		String textMoney = new String("");

		Map<Integer, String> units = new HashMap();
		units.put(0, "");
		units.put(1, "one");
		units.put(2, "two");
		units.put(3, "three");
		units.put(4, "four");
		units.put(5, "five");
		units.put(6, "six");
		units.put(7, "seven");
		units.put(8, "eight");
		units.put(9, "nine");
		units.put(10, "ten");
		units.put(11, "eleven");
		units.put(12, "twelve");
		units.put(13, "thirteen");
		units.put(14, "fourteen");
		units.put(15, "fifteen");
		units.put(16, "sixteen");
		units.put(17, "seventeen");
		units.put(18, "eighteen");
		units.put(19, "nineteen");

		Map<Integer, String> dozens = new HashMap();
		dozens.put(2, "twenty");
		dozens.put(3, "thirty");
		dozens.put(4, "forty");
		dozens.put(5, "fifty");
		dozens.put(6, "sixty");
		dozens.put(7, "seventy");
		dozens.put(8, "eighty");
		dozens.put(9, "ninety");

		if (Integer.parseInt(v[0]) != 0) {// verify if there are Bills
		// This line "String[] bills = v[0].split("");" divide the number in
		// many characters (The first position of
		// Bills[] is always empty)
		String[] bills = v[0].split("");
		int position = 1;// position counter of the Bill vector
		int numberOfDigits = v[0].length(); // Discovery how long is the number

		// After discovered the size of the number this switch start spelling
		// the number from the most significant number
		switch (numberOfDigits) {
		// This position just can be 1 or 0 (So, it do not need do nothing).
		case 8:
			position++;
		case 7:
			// If this position is 0 it should not appear in the spelling
			// number.
			if (!bills[position].equals("0")) {
				if (bills[position - 1].equals("1")) {
					// If the previous number concatenated with this number is
					// from 1 to 19 so I need use this line
					textMoney += units.get(Integer.parseInt(""
							+ bills[position - 1] + bills[position]));
					textMoney += " million ";
				} else {
					// If the previous number is number is not 1, forget that.
					textMoney += units.get(Integer.parseInt(""
							+ bills[position]));
					textMoney += " million ";
				}
			} else {
				if (bills[position - 1].equals("1")) {
					// It is due the special case when the previous number is 1
					// and this number is 0;
					textMoney += units.get(Integer.parseInt(""
							+ bills[position - 1] + bills[position]));
					textMoney += " million ";
				}
			}
			position++;
		case 6:
			// If this position is 0 it should not appear in the spelling
			// number.
			if (!bills[position].equals("0")) {
				textMoney += units.get(Integer.parseInt("" + bills[position]));
				textMoney += " hundred ";
			}
			position++;
		case 5:
			// If this position is 0 it should not appear in the spelling
			// number.
			if ((!bills[position].equals("0"))
					&& (!bills[position].equals("1"))) {
				textMoney += dozens.get(Integer.parseInt("" + bills[position]));
				textMoney += " ";
			}
			position++;
		case 4:
			// If this position is 0 it should not appear in the spelling
			// number.
			if (!bills[position].equals("0")) {
				if (bills[position - 1].equals("1")) {
					textMoney += units.get(Integer.parseInt(""
							+ bills[position - 1] + bills[position]));
					textMoney += " thousand ";
				} else {
					textMoney += units.get(Integer.parseInt(""
							+ bills[position]));
					textMoney += " thousand ";
				}
			} else {
				// It is due the special case when the previous number is 1 and
				// this number is 0;
				if (bills[position - 1].equals("1")) {
					textMoney += units.get(Integer.parseInt(""
							+ bills[position - 1] + bills[position]));
				}
				// This if avoid print the word THOUSAND when all 'thousand'
				// numbers are 0. Ex: 12000456.56
				if ((numberOfDigits > 4) && (!bills[position - 1].equals("0"))) {
					textMoney += " thousand ";
				} else {
					if ((numberOfDigits > 5)
							&& (!bills[position - 2].equals("0"))) {
						textMoney += " thousand ";
					}
				}
			}
			position++;
		case 3:
			if (!bills[position].equals("0")) {
				textMoney += units.get(Integer.parseInt("" + bills[position]));
				textMoney += " hundred ";
			}

			position++;
		case 2:
			if ((!bills[position].equals("0"))
					&& (!bills[position].equals("1"))) {
				textMoney += dozens.get(Integer.parseInt("" + bills[position]));
				textMoney += " ";
			}
			position++;
		case 1:
			if (!bills[position].equals("0")) {
				if (bills[position - 1].equals("1")) {
					textMoney += units.get(Integer.parseInt(""
							+ bills[position - 1] + bills[position]));
				} else {
					textMoney += units.get(Integer.parseInt(""
							+ bills[position]));
				}
			} else {
				if (bills[position - 1].equals("1")) {
					textMoney += units.get(Integer.parseInt(""
							+ bills[position - 1] + bills[position]));
				}
			}
			position++;
		}// END SWITCH
		} else {
			textMoney += " no";
		}
		// START here spelling the cents!
		// cents are always 2 characters. So I will not use a Switch
		// I just will start position with 1 and after increase it to 2.
		if(Integer.parseInt(v[0]) == 1){
			textMoney += " dollar and ";
		}else {
			textMoney += " dollars and ";
		}
		if (Integer.parseInt(v[1]) != 0) {// verify if there are cents
			String[] cents = v[1].split("");
			int position = 1;// position counter of the Cents vector.

			// If the most significant character from cents is 0 or 1 it should
			// not be spelling.
			if ((!cents[position].equals("0"))
					&& (!cents[position].equals("1"))) {
				textMoney += dozens.get(Integer.parseInt("" + cents[position]));
				textMoney += " ";
			}
			position++;

			// If the less significant character from cents is 0 it should not
			// be spelling.
			if (!cents[position].equals("0")) {
				if (cents[position - 1].equals("1")) {
					// if the most significant character from cents is 1 so
					// I should use this line.
					textMoney += units.get(Integer.parseInt(""
							+ cents[position - 1] + cents[position]));
				} else {
					textMoney += units.get(Integer.parseInt(""
							+ cents[position]));
				}
			} else {
				// This line if for the special case when the most significant
				// digit from cents
				// is 1 and the less is 0.
				if (cents[position - 1].equals("1")) {
					textMoney += units.get(Integer.parseInt(""
							+ cents[position - 1] + cents[position]));
				}
			}
		} else {
			textMoney += " no";
		}
		textMoney += " cents.";
		
		return textMoney;
	}

}
