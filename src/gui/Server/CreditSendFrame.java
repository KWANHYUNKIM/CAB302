package gui.Server;


import dao.CreditDAO;
import dto.CreditDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CreditSendFrame
 * It serves to send credit to DevelopmentTeam and SoftwareTeam.
 */
public class CreditSendFrame extends JFrame {

    private JPanel rPanel;
    private JLabel rLabel;
    private JLabel rCredit;
    private JTextField tCredit;
    private JRadioButton  rDevelopmentTeam, rSoftwareTeam ;
    private JButton rButton;

    public CreditSendFrame() {
        //Credit
        super("Credit");
        super.setResizable(true);
        setSize(350, 400);
        setLocationRelativeTo(null);

        rPanel = new JPanel();
        rPanel.setLayout(new BorderLayout());
        setContentPane(rPanel);
        //Credit with Font and Size
        rLabel = new JLabel("Credit");
        rLabel.setFont(new Font("Serif", Font.BOLD, 40));
        rLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rPanel.add(rLabel, BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));
        // Credit with location
        rCredit = new JLabel("Credit");
        rCredit.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rCredit);

        tCredit = new JTextField();
        main.add(tCredit);
        // Button with DevelopmentTeam and SoftwareTeam.
        rDevelopmentTeam = new JRadioButton("DevelopmentTeam");
        rDevelopmentTeam.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rDevelopmentTeam);


        rSoftwareTeam = new JRadioButton("SoftwareTeam");
        rSoftwareTeam.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rSoftwareTeam);

        rPanel.add(main, BorderLayout.CENTER);

        JPanel sMain = new JPanel();
        rPanel.add(sMain, BorderLayout.EAST);
        //Button with Register, Size and Font
        rButton = new JButton("Register");
        rButton.setFont(new Font("Serif", Font.BOLD, 20));
        rPanel.add(rButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        rButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Customers' selected values store the database.
                CreditDTO cdto = new CreditDTO();
                cdto.setCredit(Integer.parseInt(tCredit.getText()));

                if(rDevelopmentTeam.isSelected())
                    cdto.setDepartment(rDevelopmentTeam.getText());
                else
                    cdto.setDepartment(rSoftwareTeam.getText());

                CreditDAO cdao = CreditDAO.getInstance();
                int result = cdao.insertCredit(cdto);

                // If all values are stored normally, the resulting value is 1, otherwise zero.
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "success to register");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "fail to register");
                    dispose();
                }
            }
        });

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreditSendFrame csf = new CreditSendFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}