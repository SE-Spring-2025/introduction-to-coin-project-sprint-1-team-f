public abstract class Coin {
	
    public String familiarName;
    public double value;
    public String frontMotto;
    public String backMotto;
    public String frontLabel;
    public String backLabel;
    public String frontImage;
    public String backImage;
    public String valueDescription;
    public boolean ridgedEdge;
    public String metallurgy;
    public int manufactureYear;
    
    public Coin(
			String familiarName, 
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
			String metallurgy
		) 
	{
		this.value = value;
		this.familiarName = familiarName;
		this.frontMotto = frontMotto;
		this.manufactureYear = manufactureYear;
		this.frontImage = frontImage;
		this.backImage = backImage;
		this.backMotto = backMotto;
		this.frontLabel = frontLabel;
		this.backLabel = backLabel;
		this.valueDescription = valueDescription;
		this.ridgedEdge = ridgedEdge;
		this.metallurgy = metallurgy;
	}
	
    public String getFamiliarName() {
	return familiarName;
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

    public String toString() {
        String formattedValue = String.format("%.2f", value);
	
	return "[" + familiarName
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
}
