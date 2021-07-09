package socket;

import gui.SoftwareTeam.Frame.serverFrame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    /**
      * server function
      * spend a message and receive a message.
      * It serves to open the server.
      * @author : startcoding
      * */

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
    public void setting(){
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
    public static void main(String[] args) {
        server server = new server();
        server.setting();
    }
}

// reference https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=kkj6369&logNo=220599003847
