import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinWindow extends JFrame implements CoinObserver {

    private Coin c;
    private JLabel coinLabel = new JLabel();
    private JButton coinButton;
    

    private void initializePanel() {
        coinLabel.setText(c.getCommonName() + ": "
            + c.getCount());
        coinButton = new JButton("Add " + c.getCommonName());
        coinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.increment();
            }
        });
        add(coinLabel);
        add(coinButton);
    }

    public CoinWindow(Coin c) {
        this.c = c;
        c.cc.addObserver(this);
        setTitle(c.getCommonName() + " Counter");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        initializePanel();
        visualize();
    }

    public void update() {
        coinLabel.setText(c.getCommonName() + ": "
            + c.getCount());
    }

    private void visualize() {
        pack();
        setVisible(true);
    }
}