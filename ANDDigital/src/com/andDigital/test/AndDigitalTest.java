package com.andDigital.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.andDigital.services.Services;

public class AndDigitalTest {
	private Services classUnderTest;

	@Before
	public void setUp() throws Exception
	{
		classUnderTest = new Services();
	}

	@Test
	public void testGetAllPhones() {
		assertEquals(200, classUnderTest.getAllPhones().getStatus());
	}

	@Test
	public void testGetPhoneById() {
		assertEquals(200, classUnderTest.getPhoneById(2).getStatus());

		assertEquals(400, classUnderTest.getPhoneById(22).getStatus());
	}

	@Test
	public void testActivatedNumber() {
		assertEquals(200, classUnderTest.activatedNumber("493789456").getStatus());
		assertEquals(400, classUnderTest.activatedNumber("000000000").getStatus());
	}
}
