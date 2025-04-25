import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotalCoins extends JFrame implements Runnable, CoinObserver {

    private CoinCounter cc;

    private Penny penny = new Penny();
    private JPanel pennyPanel;
    private JLabel pennyLabel = new JLabel();
    private JButton pennyButton;
    private JButton pennyWindow;

    private Nickel nickel = new Nickel();
    private JPanel nickelPanel;
    private JLabel nickelLabel = new JLabel();
    private JButton nickelButton;
    private JButton nickelWindow;

    private Dime dime = new Dime();
    private JPanel dimePanel;
    private JLabel dimeLabel = new JLabel();
    private JButton dimeButton;
    private JButton dimeWindow;

    private Quarter quarter = new Quarter();
    private JPanel quarterPanel;
    private JLabel quarterLabel = new JLabel();
    private JButton quarterButton;
    private JButton quarterWindow;

    private HalfDollar halfDollar = new HalfDollar();
    private JPanel halfDollarPanel;
    private JLabel halfDollarLabel = new JLabel();
    private JButton halfDollarButton;
    private JButton halfDollarWindow;

    private Dollar dollar = new Dollar();
    private JPanel dollarPanel;
    private JLabel dollarLabel = new JLabel();
    private JButton dollarButton;
    private JButton dollarWindow;

    private void initializePanel(JPanel panel, JLabel label, JButton button, JButton window, Coin coin) {
        coin.cc.addObserver(this);
        panel = new JPanel();
        label.setText(coin.getCommonName() + ": "
            + coin.getCount());
        button = new JButton("Add " + coin.getCommonName());
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coin.increment();
            }
        });
        window = new JButton("<html>Create " + coin.getCommonName() + "<br>Counter Window</html>");
        window.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CoinWindow(coin);
            }
        });
        panel.add(label);
        panel.add(button);
        panel.add(window);
        add(panel);
    }

    public TotalCoins() {
        this.cc = new CoinCounter();
        this.cc.addObserver(this);
    }

    public void update() {
        pennyLabel.setText(penny.getCommonName() + ": " + penny.getCount());
        nickelLabel.setText(nickel.getCommonName() + ": " + nickel.getCount());
        dimeLabel.setText(dime.getCommonName() + ": " + dime.getCount());
        quarterLabel.setText(quarter.getCommonName() + ": " + quarter.getCount());
        halfDollarLabel.setText(halfDollar.getCommonName() + ": " + halfDollar.getCount());
        dollarLabel.setText(dollar.getCommonName() + ": " + dollar.getCount());
    }

    public void run() {
        setTitle("Total Coins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        createPanels();
        visualize();
    }

    private void createPanels() {
        initializePanel(pennyPanel, pennyLabel, pennyButton, pennyWindow, penny);
        initializePanel(nickelPanel, nickelLabel, nickelButton, nickelWindow, nickel);
        initializePanel(dimePanel, dimeLabel, dimeButton, dimeWindow, dime);
        initializePanel(quarterPanel, quarterLabel, quarterButton, quarterWindow, quarter);
        initializePanel(halfDollarPanel, halfDollarLabel, halfDollarButton, halfDollarWindow, halfDollar);
        initializePanel(dollarPanel, dollarLabel, dollarButton, dollarWindow, dollar);
    }

    private void visualize() {
        pack();
        setVisible(true);
    }
}
