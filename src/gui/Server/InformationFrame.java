package gui.Server;

import dao.CreditDAO;
import dao.TradeDAO;
import dto.CreditDTO;
import dto.TradeDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * InformationFrame
 * This function allows the server to view and control all values.
 */
public class InformationFrame extends JFrame {

    private JPanel panel;
    private JTable table;
    private JLabel lilabel;
    private JButton logout;
    private DefaultTableModel tModel;


    public InformationFrame() {
        super("List");
        super.setResizable(true);
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        // Customer can see Credit Situation.
        // It is included in Department, ASSET, QUANTITY and TYPE.
        lilabel = new JLabel("Credit Situation");
        lilabel.setFont(new Font("Serif", Font.BOLD, 50));
        lilabel.setHorizontalAlignment(SwingConstants.CENTER);
        lilabel.setPreferredSize(new Dimension(400, 80));
        panel.add(lilabel, BorderLayout.NORTH);

        CreditDAO cdao = CreditDAO.getInstance();
        TradeDAO tdao = TradeDAO.getInstance();

        List<CreditDTO> creditList = cdao.creditList();
        List<TradeDTO> tradeList = tdao.tradeList();
        String[] member = {"Department","ASSET","QUANTITY","TYPE"};

        tModel = new DefaultTableModel(member, 0);
        // Displays values that are assigned to the database.
        for (int i = 0; i <tradeList.size(); i++)
        {
            String department = tradeList.get(i).getDepartment();
            Integer asset = tradeList.get(i).getAsset();
            Integer quantity = tradeList.get(i).getQuantity();
            String type = tradeList.get(i).getType();

            Object[] data = {department,asset,quantity,type};

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
            public void actionPerformed(ActionEvent e) {
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
                    InformationFrame cf = new InformationFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}