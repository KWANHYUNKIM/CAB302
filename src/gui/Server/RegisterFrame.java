package gui.Server;

import dao.Function.SHA256;
import dao.ManagementDAO;
import dto.ManagementDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * RegisterFrame
 *This information is moved to the database
 * by performing the registration function
 * and typing password, name, department, id.
 */
public class RegisterFrame extends JFrame {

    private JPanel rPanel;
    private JLabel rLabel;
    private JLabel rId, rPassword, rName;
    private JTextField tId, tPassword, tName;
    private JRadioButton rDevelopmentTeam, rSoftwareTeam ;
    private JButton rButton;
    private String salt = SHA256.generateSalt();


    public RegisterFrame() {

        super("Register");
        super.setResizable(true);
        setSize(350, 400);
        setLocationRelativeTo(null);

        rPanel = new JPanel();
        rPanel.setLayout(new BorderLayout());
        setContentPane(rPanel);

        rLabel = new JLabel("Register");
        rLabel.setFont(new Font("Serif", Font.BOLD, 40));
        rLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rPanel.add(rLabel, BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));

        rId = new JLabel("ID");
        rId.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rId);

        tId = new JTextField();
        main.add(tId);

        rPassword = new JLabel("password");
        rPassword.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rPassword);

        tPassword = new JTextField();
        main.add(tPassword);

        rName = new JLabel("name");
        rName.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rName);

        tName = new JTextField();
        main.add(tName);


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
                ManagementDTO mdto = new ManagementDTO();

                mdto.setId(tId.getText());

                String newPassword = SHA256.getHash(mdto.setPassword(tPassword.getText()),salt);

                mdto.setPassword(tPassword.getText());
                mdto.setFakePassword(newPassword);

                mdto.setName(tName.getText());

                if(rDevelopmentTeam.isSelected())
                    mdto.setDepartment(rDevelopmentTeam.getText());
                else
                    mdto.setDepartment(rSoftwareTeam.getText());

                ManagementDAO mdao = ManagementDAO.getInstance();
                int result = mdao.insertMember(mdto);

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
                    RegisterFrame rf = new RegisterFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}