package gui.DevelopmentTeam.Frame;

import dao.TradeDAO;
import dto.TradeDTO;
import gui.DevelopmentTeam.Function.Buy;
import gui.SoftwareTeam.Frame.CreditFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DCreditFrame extends JFrame {
    /**
     * DCreditFrame
     * Buying and Selling function
     * During the trade, all the functions are taken from here.
     * "r" means to show in the GUI, and "t" means to enter the database
     * when the user enters a value.
     */

    private JPanel rPanel;
    private JLabel rLabel;
    private JLabel rasset, rquantity;
    private JTextField tasset, tquantity;
    private JRadioButton rsell, rbuy;
    private JButton rButton;

    private String development = "DevelopmentTeam";

    public int check = 0;

    public DCreditFrame() {

        //Background
        super("Trade");
        super.setResizable(true);
        setSize(350, 400);
        setLocationRelativeTo(null);

        rPanel = new JPanel();
        rPanel.setLayout(new BorderLayout());
        setContentPane(rPanel);

        rLabel = new JLabel("Trade");
        rLabel.setFont(new Font("Serif", Font.BOLD, 40));
        rLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rPanel.add(rLabel, BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));

        ButtonGroup bg = new ButtonGroup();

        rsell= new JRadioButton("Sell");
        rsell.setHorizontalAlignment(SwingConstants.CENTER);
        bg.add(rsell);

        main.add(rsell);
        rbuy = new JRadioButton("Buy");
        rbuy.setHorizontalAlignment(SwingConstants.CENTER);
        bg.add(rbuy);
        main.add(rbuy);

        rPanel.add(main, BorderLayout.CENTER);

        rasset = new JLabel("Value");
        rasset.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rasset);

        tasset = new JTextField();
        main.add(tasset);

        rquantity = new JLabel("Quantity");
        rquantity.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(rquantity);

        tquantity = new JTextField();
        main.add(tquantity);

        rButton = new JButton("Register");
        rButton.setFont(new Font("Serif", Font.BOLD, 20));
        rPanel.add(rButton, BorderLayout.SOUTH);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        rButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TradeDTO tdto = new TradeDTO();
                // dep
                int credit, quantity, asset = 0;
                credit = 100;
                tdto.setDepartment(development);
                // type
                if(rsell.isSelected())
                    tdto.setType(rsell.getText());
                else
                    tdto.setType(rbuy.getText());
                // value
                tdto.setQuantity(Integer.parseInt(tquantity.getText()));
                quantity = Integer.parseInt(tquantity.getText());

                tdto.setAsset(Integer.parseInt(tasset.getText()));
                asset = Integer.parseInt(tasset.getText());
                TradeDAO tdao = TradeDAO.getInstance();

                Buy Restriction = new Buy();

                Restriction.buy(credit,asset,quantity);
                if(Restriction.buy(credit,asset,quantity) == true) {
                    // check the value
                    int result = tdao.insertTrade(tdto);

                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "success to register");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "fail to register");
                        dispose();
                    }
                }

                else
                    System.out.print("Check the balance");
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