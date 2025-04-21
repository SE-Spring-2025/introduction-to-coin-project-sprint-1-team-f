import java.util.ArrayList;

public class CoinCounter implements CoinSubject {

    ArrayList<CoinObserver> observers = new ArrayList<>();
    private int pennyCount = 0;
    private int nickelCount = 0;
    private int dimeCount = 0;
    private int quarterCount = 0;
    private int halfDollarCount = 0;
    private int dollarCount = 0;

    public void incrementPenny() {
        pennyCount++;
        notifyObservers();
    }

    public void incrementNickel() {
        nickelCount++;
        notifyObservers();
    }

    public void incrementDime() {
        dimeCount++;
        notifyObservers();
    }

    public void incrementQuarter() {
        quarterCount++;
        notifyObservers();
    }

    public void incrementHalfDollar() {
        halfDollarCount++;
        notifyObservers();
    }

    public void incrementDollar() {
        dollarCount++;
        notifyObservers();
    }

    //GETTERS
    public int getPennyCount() {
        return pennyCount;
    }

    public int getNickelCount() {
        return nickelCount;
    }

    public int getDimeCount() {
        return dimeCount;
    }

    public int getQuarterCount() {
        return quarterCount;
    }

    public int getHalfDollarCount() {
        return halfDollarCount;
    }

    public int getDollarCount() {
        return dollarCount;
    }

    //SETTERS
    public void setPennyCount(int pennyCount) {
        this.pennyCount = pennyCount;
    }

    public void setDimeCount(int dimeCount) {
        this.dimeCount = dimeCount;
    }

    public void setNickelCount(int nickelCount) {
        this.nickelCount = nickelCount;
    }
    
    public void setQuarterCount(int quarterCount) {
        this.quarterCount = quarterCount;
    }

    public void setHalfDollarCount(int halfDollarCount) {
        this.halfDollarCount = halfDollarCount;
    }

    public void setDollarCount(int dollarCount) {
        this.dollarCount = dollarCount;
    }

    //Subject Methods
    public void addObserver(CoinObserver co) {
        if (!observers.contains(co))
        observers.add(co);
    }

    public void removeObserver(CoinObserver co) {
        if (!observers.contains(co))
        observers.remove(co);
    }

    public void notifyObservers() {
        for (CoinObserver co : observers) {
            co.update();
        }
    }
}