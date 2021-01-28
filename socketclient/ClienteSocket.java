package socketclient;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// +=============================+
// | @author Isac Canedo         |
// +=============================+

public class ClienteSocket {

    private int PORT = 12345;
    private String HOST = "192.168.1.1";
    private Socket cliente;
    private PrintStream saida;
    private Scanner scaner;
    private Recebedor r;

    public ClienteSocket(String host, int port) {

        this.HOST = host;
        this.PORT = port;

    }

    public void executar() throws IOException {

        String str;

        //Conectando o cliente
        cliente = new Socket(HOST, PORT);
        System.out.println("Conectado Servidor = " + HOST + ":" + PORT);

        //Tread receber Mensagem do servidor
        r = new Recebedor(cliente.getInputStream());
        new Thread(r).start();

        //Enviar Texto via PrintStream no outputStram do cliente
        scaner = new Scanner(System.in);
        saida = new PrintStream(cliente.getOutputStream());
        while (scaner.hasNextLine()) {
            str = scaner.nextLine();
            if (str.equalsIgnoreCase("sair")) {
                encerrar();

            } else {
                saida.println(cliente.getInetAddress().getHostAddress() + ": " + str);
            }
        }
    }

    private void secureClose(final Closeable resource) {

        try {
            if (resource != null) {
                resource.close();
            }
        } catch (IOException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

    public void encerrar() {
        secureClose(saida);
        secureClose(cliente);
        secureClose(scaner);
        System.exit(2);
    }
}
