package com.ollo.exam.cheque;

/**
 * Construct a text description of a dollar amount suitable to write on a cheque.
 * <p/>
 * Do not edit.
 */
public interface Cheque {

	/**
	 * Convert the amount to a text description suitable to write on a cheque.
	 * <p/>
	 * Only values between $0.00 and $10,000,000.00 (inclusive) will be accepted.
	 * 
	 * @param amount	The dollar amount
	 * @return	The text description
	 * @throws ChequeException	If amount less than zero or greater than $10,000,000
	 */
	public String inWords(double amount) throws ChequeException;
}
