package com.nt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.service.OtpService;

public class BankServiceTest {
	private static OtpService otpService;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("setUp before class");
		otpService=new OtpService();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("tearDownAfterClass");
		otpService=null;
	}

	@Before
	public void setUp() {
		System.out.println("setup");
	}

	@After
	public void tearDown() {
		System.out.println("tearDown");
	}
	@Test
	public void testCalcSimpleIntrwithSmallValues() {
		System.out.println("Test method small values");
		float pAmt=1000.0f;
		float time=12.0f;
		float rate=2.0f;
		float expResult=240.0f;
		float actResult=otpService.calcSimpleIntrAmt(pAmt, rate, time);
		assertEquals("testCalcSimpleIntrWithSmallValues", expResult, actResult, 0.0f);
	}
	@Test(timeout=10000)
	public void testCalcSimpleIntrWithBigValues() {
		System.out.println("test method with big values");
		float pAmt=100000000000.0f;
		float time=120.0f;
		float rate=2.0f;
		float expResult=240000000000.0f;
		float actResult=otpService.calcSimpleIntrAmt(pAmt, rate, time);
		assertEquals("testCalcSimpleIntrWithBigValues", expResult, actResult, 0.0f);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testWithInvalidInputs() {
		float pAmt=0.0f;
		float rate=0.0f;
		float time=0.0f;
		otpService.calcSimpleIntrAmt(pAmt, rate, time);
		fail("System Error Should be generated for these inputs");
	}
}
