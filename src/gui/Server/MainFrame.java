package gui.Server;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * MainFrame
 * It is the administrator's main page,
 * which is a link between registration, viewing information,
 * and sending credit to users.
 */
public class MainFrame extends JFrame implements ActionListener{
    ImageIcon icon;
    JButton RegisterManagement, InformationFrame,CreditSendManagement ,back;
    JPanel background;

    public MainFrame() {
        setTitle("MainFrame");
        super.setResizable(true);
        setSize(1000,1000);
        setLocationRelativeTo(null);

        icon = new ImageIcon("C:\\Users\\molba_000\\Desktop\\background.jpg");
        background = new JPanel(){
            public void paint(Graphics g)
            {
                g.drawImage(icon.getImage(),0,0, null);
                setOpaque(false);
                super.paint(g);
            }
        };

        RegisterManagement = new JButton("RegisterManagement");
        InformationFrame = new JButton("InformationManagement");
        CreditSendManagement = new JButton("SendToCredit");
        back = new JButton("Back");


        RegisterManagement.addActionListener(this);
        InformationFrame.addActionListener(this);
        CreditSendManagement.addActionListener(this);
        back.addActionListener(this);


        background.add(RegisterManagement);
        background.add(InformationFrame);
        background.add(CreditSendManagement);
        background.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(background);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==RegisterManagement) {
            new UserManagementFrame();
        }
        else if(e.getSource() == InformationFrame){
            new InformationFrame();
        }
        else if(e.getSource() == CreditSendManagement){
            new CreditSendFrame();
        }
        else if(e.getSource() == back){
            new LoginFrame();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame mf = new MainFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
