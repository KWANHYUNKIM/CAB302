package gui.SoftwareTeam.Frame;

import gui.Server.InformationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * It is the same as developmentTeam's functional description.
 */
public class SListFrame extends JFrame implements ActionListener{
    ImageIcon icon;
    JButton chatting,stockSituation,BuyAndSell,Back;
    JPanel background;

    public SListFrame() {
        setSize(1390,650);
        setTitle("SoftwareTeam");

        super.setResizable(true);
        setLocationRelativeTo(null);
        //Background in SoftwareTeam

        icon = new ImageIcon("C:\\Users\\molba_000\\Desktop\\backgroundSofwareTeam.png");
        background = new JPanel(){
            public void paint(Graphics g)
            {
                g.drawImage(icon.getImage(),0,0, null);
                setOpaque(false);
                super.paint(g);
            }
        };

        // Main Page with StockSituation, BuyAndSell, Chatting and Back.
        stockSituation = new JButton("stockSituation");
        BuyAndSell = new JButton("BuyAndSell");
        chatting = new JButton("chatting");
        Back = new JButton("Back");


        stockSituation.addActionListener(this);
        BuyAndSell.addActionListener(this);
        chatting.addActionListener(this);
        Back.addActionListener(this);

        background.add(stockSituation);
        background.add(BuyAndSell);
        background.add(chatting);
        background.add(Back);


        setContentPane(background);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        // when user click the Stock's button, it is responded to next page.
        try {
            if (a.getSource() == stockSituation) {
                new InformationFrame();
                // The same as above.
            } else if (a.getSource() == BuyAndSell) {
                new CreditFrame();
                // The same as above.
            } else if (a.getSource() == chatting) {
                new serverFrame();
                // The same as above.
            } else if (a.getSource() == Back) {
                new gui.Server.LoginFrame();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SListFrame();
    }
}









