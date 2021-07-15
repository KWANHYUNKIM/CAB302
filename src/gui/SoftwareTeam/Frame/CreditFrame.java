package gui.SoftwareTeam.Frame;

import dao.TradeDAO;
import dto.TradeDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditFrame extends JFrame {
    /**
     * It is the same as developmentTeam's functional description.
     */

    private JPanel rPanel;
    private JLabel rLabel;
    private JLabel rasset, rquantity;
    private JTextField tasset, tquantity;
    private JRadioButton rsell, rbuy;
    private JButton rButton;

    private String development = "SoftwareTeam";

    public CreditFrame() {
        // title is "trade"
        super("Trade");
        super.setResizable(true);
        setSize(350, 400);
        setLocationRelativeTo(null);

        rPanel = new JPanel();
        rPanel.setLayout(new BorderLayout());
        setContentPane(rPanel);
        // Label with Trade, Font, Size, and Location.
        rLabel = new JLabel("Trade");
        rLabel.setFont(new Font("Serif", Font.BOLD, 40));
        rLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rPanel.add(rLabel, BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));

        ButtonGroup bg = new ButtonGroup();
        // Button with Sell
        rsell= new JRadioButton("Sell");
        rsell.setHorizontalAlignment(SwingConstants.CENTER);
        bg.add(rsell);
        main.add(rsell);

        // Button with Buy and Location
        rbuy = new JRadioButton("Buy");
        rbuy.setHorizontalAlignment(SwingConstants.CENTER);
        bg.add(rbuy);
        main.add(rbuy);

        rPanel.add(main, BorderLayout.CENTER);
        // Label with Value and Location.
        rasset = new JLabel("Value");
        rasset.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rasset);

        tasset = new JTextField();
        main.add(tasset);
        // The same as above
        rquantity = new JLabel("Quantity");
        rquantity.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rquantity);

        tquantity = new JTextField();
        main.add(tquantity);
        // The same as above
        rButton = new JButton("Register");
        rButton.setFont(new Font("Serif", Font.BOLD, 20));
        rPanel.add(rButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        /**
         * It stores the values assigned to the users in the database.
         * If the result is zero, an error occurs and the data is not stored.
         * And without Balance, the value is not stored.
         */
        rButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TradeDTO tdto = new TradeDTO();

                tdto.setDepartment(development);

                if(rsell.isSelected())
                    tdto.setType(rsell.getText());
                else
                    tdto.setType(rbuy.getText());

                tdto.setQuantity(Integer.parseInt(tquantity.getText()));

                tdto.setAsset(Integer.parseInt(tasset.getText()));

                TradeDAO tdao = TradeDAO.getInstance();

                int result = tdao.insertTrade(tdto);

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
                    CreditFrame tf = new CreditFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}