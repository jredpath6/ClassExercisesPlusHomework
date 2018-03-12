/**
 * ChemicalDataBankTest.java 1.0 Mar 8, 2018
 *
 * Copyright (c) 2018 Jack Redpath. All Rights Reserved
 * Campuse Box 8499, Elon University, Elon, NC 27244
 */
package elon.edu.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Start each class or interface with a summary description line
 *
 * @author jredpath
 * @version 1.0
 *
 */
class ChemicalDataBankTest {

	/**
	 * Test method for
	 * {@link elon.edu.adapter.ChemicalDataBank#getCriticalPoint(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetCriticalPoint() {
		String compound = "w";
		String point = "M";
		ChemicalDataBank data = new ChemicalDataBank();
		float actual = data.getCriticalPoint(compound, point);
		float expected = 0.0f;
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link elon.edu.adapter.ChemicalDataBank#getMolecularStructure(java.lang.String)}.
	 */
	@Test
	void testGetMolecularStructure() {
		String compoundName = "benzene";
		ChemicalDataBank data = new ChemicalDataBank();
		String actual = data.getMolecularStructure(compoundName);
		String expected = "C6H6";
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link elon.edu.adapter.ChemicalDataBank#getMolecularWeight(java.lang.String)}.
	 */
	@Test
	void testGetMolecularWeight() {
		String compound = "alcohol";
		ChemicalDataBank data = new ChemicalDataBank();
		double actual = data.getMolecularWeight(compound);
		double expected = 46.0688;
		Assertions.assertEquals(expected, actual);
	}
}
