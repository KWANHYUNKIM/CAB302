package gui.SoftwareTeam.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



/**
 * It is the same as developmentTeam's functional description.
 * @author : startcoding
 */
public class serverFrame extends JFrame implements ActionListener{

    private JTextArea jtextarea = new JTextArea();
    private JTextField jtextfield = new JTextField();

    private socket.server server = new socket.server();

    public serverFrame(){

        add(jtextarea, BorderLayout.CENTER);
        add(jtextfield, BorderLayout.SOUTH);
        jtextfield.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300, 300, 300, 300);
        setTitle("server");
        server.setGui(this);
        server.setting();
    }

    public static void main(String[] args) {
        new serverFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = jtextfield.getText() + "\n";
        jtextarea.append("server : " +msg);
        try {
            server.getOut().writeUTF("server : " + msg);
        } catch (IOException e1){
            e1.printStackTrace();
        }
        jtextfield.setText("");

    }
    public void appendMsg(String message) {
        jtextarea.append(message);
    }
}

// reference https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=kkj6369&logNo=220599003847