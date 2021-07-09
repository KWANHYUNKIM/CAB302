package gui.DevelopmentTeam.Frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientFrame extends JFrame implements ActionListener{
    private JTextArea jtextarea = new JTextArea();
    private JTextField jtf = new JTextField();
    private socket.client client = new socket.client();

    /**
     * ClientFrame
     *  1:1 socket communication
     *  It can be used when connected to server.
     * @author startcoding
     * I put it under the reference.
     */

    public ClientFrame(){

        add(jtextarea, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,300, 300, 300);
        setTitle("Client");

        client.setGui(this);
        client.connect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = jtf.getText() + "\n";
        jtextarea.append(client.getClientName() + " : " + message);
        try {
            client.getOut().writeUTF(client.getClientName() + " : " + message);
        } catch (IOException e1){
            e1.printStackTrace();
        }
        jtf.setText("");

    }
    public void appendMsg(String message) {
        jtextarea.append(message);
    }

    public static void main(String[] args) {
        new ClientFrame();
    }

}

// reference https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=kkj6369&logNo=220599003847


