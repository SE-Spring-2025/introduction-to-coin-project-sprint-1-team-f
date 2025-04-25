public abstract class Coin {

	private String commonName;
	private double value;
	private String frontMotto;
	private int manufactureYear;
	private String backMotto;
	private String frontLabel;
	private String backLabel;
	private String frontImage;
	private String backImage;
	private String valueDescription;
	private boolean ridgedEdge;
	private Metallurgy smelter;
	private String metallurgy;
	private boolean flipped;
	private boolean buffed;
	protected static CoinCounter cc = new CoinCounter();
	public abstract int getCount();
	public abstract void increment();

	public Coin(
			String commonName, 
			double value,
			Metallurgy smelter
		) 
	{
		this.value = value;
		this.commonName = commonName;
		this.smelter = smelter;
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

	//MANUFACTURE PROCESS
	public Coin manufacture(Coin c) {
		return c.smelt(c.ridge(c.imprintFront(c.flip(c.imprintBack(c.buff(c))))));
	}

	protected Coin smelt(Coin c) {
		c.metallurgy = c.smelter.smelt();
		return c;
	}

	protected abstract Coin ridge(Coin c);

	protected abstract Coin imprintFront(Coin c);

	protected Coin flip(Coin c) {
		c.setFlipped(true);
		return c;
	}

	protected abstract Coin imprintBack(Coin c);

	protected Coin buff(Coin c) {
		c.setBuffed(true);
		return c;
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

	public boolean getFlipped() {
		return flipped;
	}

	public boolean getBuffed() {
		return buffed;
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
	}

	public void setFlipped (boolean flipped) {
		this.flipped = flipped;
	}

	public void setBuffed (boolean buffed) {
		this.buffed = buffed;
	}
	
}
