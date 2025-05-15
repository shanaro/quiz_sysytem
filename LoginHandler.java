package ClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginHandler {

    String line;
    final String address = "localhost";
    final int port = 8080;
    Socket clientsocket;
    String response;
    int code;
    String msg;

    public String login(String line,int code) {
        this.line = line;
        this.code = code;
        msg = line+":"+code;

        try {        
            clientsocket = new Socket(address, port);

            PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
            out.println(msg);
            
            InputStream in = clientsocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader Bfreader = new BufferedReader(reader);
            response = Bfreader.readLine();
            
             

            clientsocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response; 
    }
}
