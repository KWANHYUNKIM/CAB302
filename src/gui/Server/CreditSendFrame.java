package gui.Server;


import dto.CreditDTO;
import dao.CreditDAO;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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

        super("Credit");
        super.setResizable(true);
        setSize(350, 400);
        setLocationRelativeTo(null);

        rPanel = new JPanel();
        rPanel.setLayout(new BorderLayout());
        setContentPane(rPanel);

        rLabel = new JLabel("Credit");
        rLabel.setFont(new Font("Serif", Font.BOLD, 40));
        rLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rPanel.add(rLabel, BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));

        rCredit = new JLabel("Credit");
        rCredit.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rCredit);

        tCredit = new JTextField();
        main.add(tCredit);

        rDevelopmentTeam = new JRadioButton("DevelopmentTeam");
        rDevelopmentTeam.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rDevelopmentTeam);


        rSoftwareTeam = new JRadioButton("SoftwareTeam");
        rSoftwareTeam.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rSoftwareTeam);

        rPanel.add(main, BorderLayout.CENTER);

        JPanel sMain = new JPanel();
        rPanel.add(sMain, BorderLayout.EAST);

        rButton = new JButton("Register");
        rButton.setFont(new Font("Serif", Font.BOLD, 20));
        rPanel.add(rButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        rButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CreditDTO cdto = new CreditDTO();
                cdto.setCredit(Integer.parseInt(tCredit.getText()));

                if(rDevelopmentTeam.isSelected())
                    cdto.setDepartment(rDevelopmentTeam.getText());
                else
                    cdto.setDepartment(rSoftwareTeam.getText());

                CreditDAO cdao = CreditDAO.getInstance();
                int result = cdao.insertCredit(cdto);


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