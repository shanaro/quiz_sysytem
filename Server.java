
package ServerSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static Socket clientsocket;
      
    public static void main(String[] args) {

        final int port = 8080; // server port

        ServerSocket serversocket; // instance of ServerSocket class

        try {
            serversocket = new ServerSocket(port); // 
            System.out.println(serversocket); // displays address and the port as the content of the ServerSocket instance

            
            while(true){
                
                clientsocket = serversocket.accept();
                
                InputStream in = clientsocket.getInputStream();
 
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader Bfreader = new BufferedReader(reader);
            String msg = Bfreader.readLine();
            
            String[] message = msg.split(":");
            String line = message[0];
            int code = Integer.parseInt(message[1]);
            //System.out.println(line);
            //System.out.println(code);
              
            
            
            
            //C:\Users\UPEKa\Documents\NetBeansProjects\Storage\Login
            if(code==2){
                LoginL ldb1 =new LoginL(clientsocket);
                Thread lt = new Thread(ldb1);
                ldb1.input(line);
                lt.start();
                
                //System.out.println(line);
                //System.out.println(code);
            }
            
            }
        } catch (IOException e) {
            System.out.println(" Cannot open a connection ");
        }

    }
}
