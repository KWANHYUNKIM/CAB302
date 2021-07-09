package socket;

import gui.SoftwareTeam.Frame.serverFrame;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class serverTest {

    private ServerSocket serverSocket; // server socket
    private Socket socket; // socket is stored message.
    private DataInputStream datainput; // input data
    private DataOutputStream dataoutput; // output data
    private serverFrame serverframe;

    public DataOutputStream getOut() {
        return dataoutput;
    }

    public void setGui(serverFrame serverframe) {
        this.serverframe = serverframe;
    }
    @Test
    public void setting() {
            try{
                serverSocket = new ServerSocket(7777);
                System.out.println("sending socket.....");
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress()+"joining.");

                dataoutput = new DataOutputStream(socket.getOutputStream());
                datainput = new DataInputStream(socket.getInputStream());

                while(true){
                    String msg = datainput.readUTF();
                    serverframe.appendMsg(msg);
                }

            }catch(IOException e){
                e.printStackTrace();
            }
    }
    @Test
    public void main() {
        server server = new server();
        server.setting();
    }
}