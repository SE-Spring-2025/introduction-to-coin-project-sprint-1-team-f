public abstract class Coin implements Metallurgy {
	public String commonName;
	public double value;
	public String frontMotto;
	public int manufactureYear;
	public String backMotto;
	public String frontLabel;
	public String backLabel;
	public String frontImage;
	public String backImage;
	public String valueDescription;
	public boolean ridgedEdge;
	public Metallurgy smelter;
	public String metallurgy;

	public Coin(
			String commonName, 
			double value,
			String frontMotto,
			int manufactureYear, 
			String backMotto, 
			String frontLabel, 
			String backLabel, 
			String frontImage, 
			String backImage, 
			String valueDescription, 
			boolean ridgedEdge, 
			Metallurgy smelter
		) 
	{
		this.value = value;
		this.commonName = commonName;
		this.frontMotto = frontMotto;
		this.manufactureYear = manufactureYear;
		this.frontImage = frontImage;
		this.backImage = backImage;
		this.backMotto = backMotto;
		this.frontLabel = frontLabel;
		this.backLabel = backLabel;
		this.valueDescription = valueDescription;
		this.ridgedEdge = ridgedEdge;
		this.smelter = smelter;
		this.smelt();
	}

	public String toString() {
		String formattedValue = String.format("%.2f", value);

		return "[" + commonName
				+ "," + formattedValue
				+ "," + manufactureYear
				+ ",'" + frontMotto
				+ "','" + backMotto
				+ "','" + frontImage
				+ "','" + backImage
				+ "','" + frontLabel
				+ "','" + backLabel
				+ "','" + valueDescription
				+ "'," + (ridgedEdge ? "ridges" : "smooth")
				+ ",'" + metallurgy
				+ "']";
	}

	public String smelt() {
		if (value == 0.01) {
			smelter = new Copper();
		} else {
			smelter = new CuproNickel();
		}
		metallurgy = smelter.smelt();
		return metallurgy;
	}

	// GETTERS
	public String getCommonName() {
		return commonName;
	}

	public double getValue() {
		return value;
	}

	public String getFrontMotto() {
		return frontMotto;
	}

	public String getBackMotto() {
		return backMotto;
	}

	public String getFrontLabel() {
		return frontLabel;
	}

	public String getBackLabel() {
		return backLabel;
	}

	public String getFrontImage() {
		return frontImage;
	}

	public String getBackImage() {
		return backImage;
	}

	public String getValueDescription() {
		return valueDescription;
	}

	public boolean getRidgedEdge() {
		return ridgedEdge;
	}

	public String getMetallurgy() {
		return metallurgy;
	}

	public int getYear() {
		return manufactureYear;
	}

	//SETTERS
	public void setCommonName (String commonName) {
		this.commonName = commonName;
	}

	public void setValue (double value) {
		this.value = value;
	}

	public void setFrontMotto (String frontMotto) {
		this.frontMotto = frontMotto;
	}

	public void setYear (int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public void setFrontImage (String frontImage) {
		this.frontImage = frontImage;
	}

	public void setBackImage (String backImage) {
		this.backImage = backImage;
	}

	public void setBackMotto (String backMotto) {
		this.backMotto = backMotto;
	}

	public void setFrontLabel (String frontLabel) {
		this.frontLabel = frontLabel;
	}

	public void setBackLabel (String backLabel) {
		this.backLabel = backLabel;
	}

	public void setValueDescription (String valueDesctiption) {
		this.valueDescription = valueDesctiption;
	}

	public void setRidgedEdge (boolean ridgedEdge) {
		this.ridgedEdge = ridgedEdge;
	}

	public void setSmelter (Metallurgy smelter) {
		this.smelter = smelter;
		this.smelt();
	}
}
