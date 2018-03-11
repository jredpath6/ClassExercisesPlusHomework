/**
 * ChemicalDataBank.java 1.0 March 7, 2018
 * 
 * Copyright (c) 2018 Elon University Elon, North Carolina, 27244
 * U.S.A. All Rights Reserved
 */
package elon.edu.adapter;

/**
 * Legacy Chemical Data Bank Class for three chemicals
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */
public class ChemicalDataBank {

  /**
   * Determines melting point or boiling point of chemical
   * 
   * @param compound String name of chemical compound
   * @param point String single character M for melting point other values returns boiling point
   * @return float value of boiling point or melting point
   */

  public float getCriticalPoint(String compound, String point) {
    float temperature = 0.0f;

    if (point.equals("M")) {
      String tempCompare = compound.toLowerCase();
      if (tempCompare.equals("water")) {
        temperature = 0.0f;
      } else if (tempCompare.equals("benzene")) {
        temperature = 5.5f;
      } else if (tempCompare.equals("alcohol")) {
        temperature = -114.1f;
      }
    } else {
      String tempCompare = compound.toLowerCase();
      if (tempCompare.equals("water")) {
        temperature = 100.0f;
      } else if (tempCompare.equals("benzene")) {
        temperature = 80.1f;
      } else if (tempCompare.equals("alcohol")) {
        temperature = 78.3f;
      }
    }
    return temperature;
  }

  /**
   * 
   * Gets molecular structure for chemical instance
   * 
   * @param compound String representing name of chemical
   * @return String representation of chemical structure
   */

  public String getMolecularStructure(String compound) {

    String tempCompare = compound.toLowerCase();
    String structure = "";

    if (tempCompare.equals("water")) {
      structure = "H2O";
    } else if (tempCompare.equals("benzene")) {
      structure = "C6H6";
    } else if (tempCompare.equals("alcohol")) {
      structure = "C2H6O2";
    }

    return structure;
  }

  /**
   * Gets molecular weight for chemical
   * 
   * @param compound String name of chemical
   * @return double value of molecular weight
   */
  public double getMolecularWeight(String compound) {

    String tempCompare = compound.toLowerCase();
    double weight = 0.0;

    if (tempCompare.equals("water")) {
      weight = 18.015;
    } else if (tempCompare.equals("benzene")) {
      weight = 78.1134;
    } else if (tempCompare.equals("alcohol")) {
      weight = 46.0688;
    }

    return weight;
  }

}
