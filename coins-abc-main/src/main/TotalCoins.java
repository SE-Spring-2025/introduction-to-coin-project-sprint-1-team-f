import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotalCoins extends JFrame implements Runnable, CoinObserver {

    private CoinCounter cc;
    private JPanel pennyPanel;
    private JLabel pennyLabel;
    private JButton pennyButton;
    private JPanel nickelPanel;
    private JLabel nickelLabel;
    private JButton nickelButton;
    private JPanel dimePanel;
    private JLabel dimeLabel;
    private JButton dimeButton;
    private JPanel quarterPanel;
    private JLabel quarterLabel;
    private JButton quarterButton;
    private JPanel halfDollarPanel;
    private JLabel halfDollarLabel;
    private JButton halfDollarButton;
    private JPanel dollarPanel;
    private JLabel dollarLabel;
    private JButton dollarButton;

    private void initializePanel(JPanel panel, JLabel label, JButton button, Coin coin) {
        panel = new JPanel();
        label = new JLabel(coin.getCommonName() + ": "
            + coin.getCount());
        button = new JButton("Add " + coin.getCommonName());
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coin.increment();
                update();
            }
        });
        panel.add(label);
        panel.add(button);
        add(panel);
    }

    public TotalCoins(CoinCounter cc) {
        this.cc = cc;
    }

    public void update() {
        setVisible(false);
        getContentPane().removeAll();
        createPanels();
        visualize();
    }

    public void run() {
        setTitle("Total Coins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        createPanels();
        visualize();
    }

    private void createPanels() {
        initializePanel(pennyPanel, pennyLabel, pennyButton, new Penny());
        initializePanel(nickelPanel, nickelLabel, nickelButton, new Nickel());
        initializePanel(dimePanel, dimeLabel, dimeButton, new Dime());
        initializePanel(quarterPanel, quarterLabel, quarterButton, new Quarter());
        initializePanel(halfDollarPanel, halfDollarLabel, halfDollarButton, new HalfDollar());
        initializePanel(dollarPanel, dollarLabel, dollarButton, new Dollar());
    }

    private void visualize() {
        pack();
        setVisible(true);
    }
}
