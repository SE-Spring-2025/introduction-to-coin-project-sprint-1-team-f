import java.util.Calendar;
import java.text.DecimalFormat;

public class Coin {
    public static final double PENNY_VALUE = 0.01;
    public static final double NICKEL_VALUE = 0.05;
    public static final double DIME_VALUE = 0.10;
    public static final double QUARTER_VALUE = 0.25;
    public static final double HALFDOLLAR_VALUE = 0.50;
    public static final double DOLLAR_VALUE = 1.00;
    private String familiarName;
    private double value;
    private String frontMotto;
    private String backMotto;
    private String frontLabel;
    private String backLabel;
    private String frontImage;
    private String backImage;
    private String valueDescription;
    private boolean ridgedEdge;
    private String metallurgy;
    private int manufactureYear;
    
    public Coin() {
	this(0);
    }
    public Coin(double value) {
	this(value, (Calendar.getInstance()).get(Calendar.YEAR));
    }
}
