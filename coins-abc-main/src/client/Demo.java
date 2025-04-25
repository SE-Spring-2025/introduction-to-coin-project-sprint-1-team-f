public class Demo {

	public static void main(String[] args) {

		TotalCoins demo = new TotalCoins();
		Thread totalCoins = new Thread(demo);
		totalCoins.start();

	}
}
