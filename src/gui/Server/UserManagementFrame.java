package gui.Server;

import dao.ManagementDAO;
import dto.ManagementDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * UserManagementFrame
 * The server functions to identify customer data.
 * However, the server cannot access the customer's
 */

public class UserManagementFrame extends JFrame {

    private JPanel panel;
    private JTable table;
    private JLabel lilabel;
    private JButton logout;
    private DefaultTableModel tModel;


    public UserManagementFrame() {

        super("List");
        super.setResizable(true);
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);

        lilabel = new JLabel("Member list");
        lilabel.setFont(new Font("Serif", Font.BOLD, 50));
        lilabel.setHorizontalAlignment(SwingConstants.CENTER);
        lilabel.setPreferredSize(new Dimension(400, 80));
        panel.add(lilabel, BorderLayout.NORTH);

        ManagementDAO mdao = ManagementDAO.getInstance();
        List<ManagementDTO> list = mdao.managementList();

        String[] member = {"id", "password", "name", "department"};

        tModel = new DefaultTableModel(member, 0);

        // The value of the database is taken and outputted.
        for (int i = 0; i < list.size(); i++) {

            String id = list.get(i).getId();
            String password = list.get(i).getFakePassword();
            String name = list.get(i).getName();
            String department = list.get(i).getDepartment();

            Object[] data = {id, password, name,  department};

            tModel.addRow(data);

        }

        table = new JTable(tModel);
        table.setFont(new Font("Serif", Font.PLAIN, 20));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        logout = new JButton("Logout");
        panel.add(logout, BorderLayout.SOUTH);

        logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent a) {
                JOptionPane.showMessageDialog(null, "Logout");
                dispose();
                new LoginFrame();
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserManagementFrame lf = new UserManagementFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
