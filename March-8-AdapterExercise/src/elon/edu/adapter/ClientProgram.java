/**
 * ClientProgram.java 1.0 March 7, 2018
 * 
 * Copyright (c) 2018 Elon University Elon, North Carolina, 27244
 * U.S.A. All Rights Reserved
 */
package elon.edu.adapter;

/**
 * Client program to test our implementation
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */
public class ClientProgram {

	/**
	 * Main application to test interface for three chemicals. You need to create
	 * the Adapter called Compound for the main method to work
	 * 
	 * @param args
	 *          String array of command line args. It is not currently used by
	 *          application.
	 */
	public static void main(String[] args) {
		ChemicalCompound water = new Compound("Water");
		System.out.println(water.display());
		ChemicalCompound benzene = new Compound("Benzene");
		System.out.println(benzene.display());
		ChemicalCompound alcohol = new Compound("Alcohol");
		System.out.println(alcohol.display());
		System.exit(0);
	}

}
