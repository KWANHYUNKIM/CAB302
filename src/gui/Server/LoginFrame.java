package gui.Server;

import dao.ManagementDAO;
import gui.DevelopmentTeam.Frame.DListFrame;
import gui.SoftwareTeam.Frame.SListFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginFrame
 * It is the main page for all users.
 * Login and manage membership.
 * If logged in, it sends a signal from the server to see if the values match,
 * and moves to another server depending on the department.
 */
public class LoginFrame extends JFrame {
    ImageIcon icon;

    private JPanel background;
    private JLabel  lId, lPassword;
    private JTextField tId ;
    private JPasswordField tPassword;
    private JButton login, register, exit;

    public LoginFrame() {
        super("Main Page");
        super.setResizable(true);
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        icon = new ImageIcon("C:\\Users\\molba_000\\Desktop\\LoginFrame.jpg");
        background = new JPanel(){
            public void paint(Graphics g)
            {
                g.drawImage(icon.getImage(),0,0, null);
                setOpaque(false);
                super.paint(g);
            }
        };

        JPanel Main = new JPanel();

        lId = new JLabel("ID");
        lId.setFont(new Font("Serif", Font.BOLD, 15));
        lId.setHorizontalAlignment(SwingConstants.RIGHT);
        Main.add(lId);

        tId = new JTextField();
        tId.setColumns(10);
        Main.add(tId);

        lPassword = new JLabel("password");
        lPassword.setFont(new Font("Serif", Font.BOLD, 15));
        lPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        Main.add(lPassword);

        tPassword = new JPasswordField();
        tPassword.setColumns(10);
        Main.add(tPassword);

        background.add(Main, BorderLayout.EAST);

        JPanel btnMain = new JPanel();

        login = new JButton("Login");
        login.setBackground(Color.white);
        login.setAlignmentX(RIGHT_ALIGNMENT);
        btnMain.add(login);

        register = new JButton("Register");
        register.setBackground(Color.white);
        register.setAlignmentX(RIGHT_ALIGNMENT);
        btnMain.add(register);

        exit = new JButton("Exit");
        exit.setBackground(Color.white);
        exit.setAlignmentX(RIGHT_ALIGNMENT);
        btnMain.add(exit);

        background.add(btnMain, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(background);
        setVisible(true);

        login.addActionListener(new ActionListener() {

            /**
             * A total of three values are given, depending on the department.
             * But admin is the only exception.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = tId.getText();
                String password = tPassword.getText();


                ManagementDAO mdao = ManagementDAO.getInstance();


                String result = mdao.idPassword(id, password);
                // If admin login, return 1


                if (result == "admin") {
                    JOptionPane.showMessageDialog(null, "Log in");
                    MainFrame mf = new MainFrame();
                    dispose();
                }
                // If user who development is DevelopmentTeam login,
                else if (result == "DevelopmentTeam")
                {
                    JOptionPane.showMessageDialog(null,"Log in");
                            DListFrame df = new DListFrame();
                            dispose();
                        }
                    // If user who development is SoftwareTeam login,
                    else if (result == "SoftwareTeam")
                        {
                            JOptionPane.showMessageDialog(null,"Log in");
                            SListFrame sf = new SListFrame();
                            dispose();
                        }
                else {
                    JOptionPane.showMessageDialog(null, "Fail");
                }
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterFrame rf = new RegisterFrame();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame lif = new LoginFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}