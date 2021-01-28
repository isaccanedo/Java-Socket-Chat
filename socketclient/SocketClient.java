package socketclient;

import java.io.IOException;

// +=============================+
// | @author Isac Canedo         |
// +=============================+

public class SocketClient {

    /**
     * Iniciar Cliente para conexão com servidor
     *
     * @param host
     * @param port
     */
    public static void executarCliente(String host, int port) {
        ClienteSocket cliente = new ClienteSocket(host, port);

        try {
            cliente.executar();
        } catch (IOException ioe) {
            System.out.println("Problemas ao executar cliente: " + ioe.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //iniciando cliente
        executarCliente("192.168.1.1", 12345);

    }

}
