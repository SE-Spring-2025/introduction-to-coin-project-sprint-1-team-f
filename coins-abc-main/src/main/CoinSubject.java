public interface CoinSubject {
    public void addObserver(CoinObserver co);
    public void removeObserver(CoinObserver co);
    public void notifyObservers();    
}