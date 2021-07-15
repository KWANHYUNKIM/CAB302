package gui.DevelopmentTeam.Frame;


import gui.Server.InformationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * DListFrame
 * It is main page.
 * All Frames connected to Button function.
 */

public class DListFrame extends JFrame implements ActionListener{
    ImageIcon icon;
    JButton chatting,stockSituation,BuyAndSell;
    JPanel background;
    public DListFrame() {
        setSize(1100,510);
        setTitle("SoftwareTeam");

        super.setResizable(true);
        setLocationRelativeTo(null);

        icon = new ImageIcon("C:\\Users\\molba_000\\Desktop\\backgroundDevelopmentTeam.png");
        background = new JPanel(){
            public void paint(Graphics g)
            {
                g.drawImage(icon.getImage(),0,0, null);
                setOpaque(false);
                super.paint(g);
            }
        };
        // Main Frame with StockSituation, BuyAndSell and Chatting.
        stockSituation = new JButton("stockSituation");
        BuyAndSell = new JButton("BuyAndSell");
        chatting = new JButton("chatting");

        stockSituation.addActionListener(this);
        BuyAndSell.addActionListener(this);
        chatting.addActionListener(this);

        background.add(stockSituation);
        background.add(BuyAndSell);
        background.add(chatting);

        add(background);
        setContentPane(background);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        //If click the stockSituation, page is changed to InformationFrame.
        try {
            if (a.getSource() == stockSituation) {
                new InformationFrame();
                // The same as above
            } else if (a.getSource() == BuyAndSell) {
                new DCreditFrame();
                // The same as above
            } else if (a.getSource() == chatting) {
                new ClientFrame();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new DListFrame();
    }
}
