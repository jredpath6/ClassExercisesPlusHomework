package elon.edu.adapter;

/**
 * 
 * Class to be developed as part of exercise
 *
 */
public class Compound implements ChemicalCompound {

	private String compound;
	private ChemicalDataBank data = new ChemicalDataBank();

	public Compound(String aCompound) {
		this.compound = aCompound;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see elon.edu.adapter.ChemicalCompound#display()
	 */
	@Override
	public String display() {
		char firstLetter = compound.charAt(0);
		String letter = "" + firstLetter;
		String result = "Compound: " + letter.toUpperCase() + compound.substring(1) + " ------";
		result += "\nFormula: " + data.getMolecularStructure(compound);
		result += "\nWeight: " + data.getMolecularWeight(compound);
		result += "\nMelting Pt: " + data.getCriticalPoint(compound, "M");
		result += "\nBoilingPoint: " + data.getCriticalPoint(compound, "B");
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see elon.edu.adapter.ChemicalCompound#getBoilingPoint()
	 */
	@Override
	public double getBoilingPoint() {
		float boilingPoint = data.getCriticalPoint(compound, "B");
		return boilingPoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see elon.edu.adapter.ChemicalCompound#getMeltingPoint()
	 */
	@Override
	public double getMeltingPoint() {
		double meltingPoint = data.getCriticalPoint(compound, "M");
		return meltingPoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see elon.edu.adapter.ChemicalCompound#getMolecularFormula()
	 */
	@Override
	public String getMolecularFormula() {
		String molecularForm = data.getMolecularStructure(compound);
		return molecularForm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see elon.edu.adapter.ChemicalCompound#getMolecularWeight()
	 */
	@Override
	public double getMolecularWeight() {
		double weight = data.getMolecularWeight(compound);
		return weight;
	}
}
