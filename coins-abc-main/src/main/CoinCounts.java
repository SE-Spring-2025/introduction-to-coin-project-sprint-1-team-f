import java.util.Observable;

public class CoinCounts extends Observable {
    private int totalCoins = 0;
    private int quarters = 0;

    public void incrementQuarter() {
        quarters++;
        totalCoins++;
        setChanged();
        notifyObservers();
    }

    public void incrementOther() {
        totalCoins++;
        setChanged();
        notifyObservers();
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public int getQuarters() {
        return quarters;
    }
}
