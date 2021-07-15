package gui.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // Frame
        setTitle("MainFrame");
        super.setResizable(true);
        setSize(1000,1000);
        setLocationRelativeTo(null);

        // Image session
        icon = new ImageIcon("C:\\Users\\molba_000\\Desktop\\background.jpg");
        background = new JPanel(){
            public void paint(Graphics g)
            {
                g.drawImage(icon.getImage(),0,0, null);
                setOpaque(false);
                super.paint(g);
            }
        };
        // Button session
        RegisterManagement = new JButton("RegisterManagement");
        InformationFrame = new JButton("InformationManagement");
        CreditSendManagement = new JButton("SendToCredit");
        back = new JButton("Back");

        // register to button.
        RegisterManagement.addActionListener(this);
        InformationFrame.addActionListener(this);
        CreditSendManagement.addActionListener(this);
        back.addActionListener(this);

        // add to main background
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
        // When user click the RegisterManagement button, it can be shown UserManagementFrame.
        if(e.getSource()==RegisterManagement) {
            new UserManagementFrame();
        }
        // The same as above
        else if(e.getSource() == InformationFrame){
            new InformationFrame();
        }
        // The same as above
        else if(e.getSource() == CreditSendManagement){
            new CreditSendFrame();
        }
        // The same as above
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
