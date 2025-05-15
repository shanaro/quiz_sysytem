package ServerSide;

import static ServerSide.Server.clientsocket;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginL extends Thread {

    Socket clientsocket;
    String line;
    int count = 0;

    public LoginL(Socket clientsocket) {
        this.clientsocket = clientsocket;
    }

    public void input(String line) {
        this.line = line;
    }

    @Override
    public void run() {

        String file = "C:\\Users\\UPEKa\\Documents\\NetBeansProjects\\Storage\\Login\\loginL.csv";

        FileInputStream fl;
        try {
            fl = new FileInputStream(file);
            try (Scanner input = new Scanner(fl)) {
                while (input.hasNext()) {
                    if (line.equals(input.next())) {
                        count = 0;
                        break;
                    } else {
                        count++;
                    }
                }
            }

            if (count == 0) {
                OutputStream outs = clientsocket.getOutputStream();
                PrintWriter write = new PrintWriter(outs, true);
                write.println("Hello Client! This is the Server...");

            } else {
                OutputStream outs = clientsocket.getOutputStream();
                PrintWriter write = new PrintWriter(outs, true);
                write.println("Please check the username and password");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
