package com.ollo.exam.cheque;

/**
 * Test harness for {@link MyCheque}.
 * <p/>
 * Add any extra tests here.
 */
public class MyChequeTest extends ChequeTest {

	@Override
	public Cheque createCheque() {
		return new MyCheque();
	}
	
	// Feel free to add your own tests after this point
}
