package gui.DevelopmentTeam.Frame;


import gui.Server.InformationFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
        try {
            if (a.getSource() == stockSituation) {
                new InformationFrame();
            } else if (a.getSource() == BuyAndSell) {
                new DCreditFrame();
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
