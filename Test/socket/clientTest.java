package socket;

import gui.DevelopmentTeam.Frame.ClientFrame;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static org.junit.Assert.*;

public class clientTest {
    private Socket socket;
    private DataInputStream datainput;
    private DataOutputStream dataoutput;
    private ClientFrame clientframe;
    private String nickname;

    public DataOutputStream getOut() {
        return dataoutput;
    }
    public String getClientName() {
        return nickname;
    }
    public void setGui(ClientFrame clientframe) {
        this.clientframe = clientframe;
    }

    @Test
    public void connect() {
        try {
            socket = new Socket("127.0.0.1", 7777);
            System.out.println("connect server");

            dataoutput = new DataOutputStream(socket.getOutputStream());
            datainput = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("nickname or department : ");
            nickname = scanner.next();

            while (true) {
                String msg = datainput.readUTF();
                clientframe.appendMsg(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
