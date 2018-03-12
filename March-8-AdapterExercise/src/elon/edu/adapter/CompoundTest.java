/**
 * CompoundTest.java 1.0 Mar 12, 2018
 *
 * Copyright (c) 2018 Jack Redpath. All Rights Reserved
 * Campus Box 8499, Elon University, Elon, NC 27244
 */
package elon.edu.adapter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Start each class or interface with a summary description line
 *
 * @author jredpath
 * @version 1.0
 *
 */
class CompoundTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link elon.edu.adapter.Compound#display()}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testDisplay() throws Exception {
		Compound comp = new Compound("water");
		String actual = comp.display();
		String expected = "Compound: Water ------\n" + "Formula: H2O\n" + "Weight: 18.015\n"
				+ "Melting Pt: 0.0\n" + "BoilingPoint: 100.0";
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link elon.edu.adapter.Compound#getBoilingPoint()}.
	 */
	@Test
	void testGetBoilingPoint() {
		Compound comp = new Compound("benzene");
		double actual = comp.getBoilingPoint();
		float expected = 80.1f;
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link elon.edu.adapter.Compound#getMeltingPoint()}.
	 */
	@Test
	void testGetMeltingPoint() {
		Compound comp = new Compound("water");
		double actual = comp.getMeltingPoint();
		float expected = 0.0f;
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link elon.edu.adapter.Compound#getMolecularFormula()}.
	 */
	@Test
	void testGetMolecularFormula() {
		Compound comp = new Compound("alcohol");
		String actual = comp.getMolecularFormula();
		String expected = "C2H6O2";
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link elon.edu.adapter.Compound#getMolecularWeight()}.
	 */
	@Test
	void testGetMolecularWeight() {
		Compound comp = new Compound("water");
		double actual = comp.getMolecularWeight();
		double expected = 18.0150;
		Assertions.assertEquals(expected, actual);
	}

}
