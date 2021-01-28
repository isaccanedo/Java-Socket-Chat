package socketclient;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// +=============================+
// | @author Isac Canedo         |
// +=============================+

public class ChatSocket {

    public ChatSocket() {

        final int PORT = 12345;
        final String HOST = "192.168.1.1";

        Scanner scaner = new Scanner(System.in);
        Socket cliente;
        PrintStream saida;
        
        try {

            //Conectando o clinte
            cliente = new Socket(HOST, PORT);
            System.out.println("Cliente se conectou ao servidor");

            //Enviar Texto via IO
            saida = new PrintStream(cliente.getOutputStream());
            while (scaner.hasNextLine()) {
                saida.println(scaner.nextLine());
            }

            saida.close();
            scaner.close();
            cliente.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
