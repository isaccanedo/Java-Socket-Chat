package socketserver;

import java.io.IOException;

// +=============================+
// | @author Isac Canedo         |
// +=============================+

public class SocketServer {

    /**
     * Função executar Comando no Bash
     *
     * @param command
     * @throws IOException
     */
    public static void executarComandoServidor(String command) throws IOException {
        LocalShell localShell = new LocalShell();
        localShell.executeCommand(command);
    }

    /**
     * Função iniciar o servidor
     *
     * @param port
     */
    public static void conectarServidor(int port) {
        ServidorSocket server = new ServidorSocket(port);
        try {
            server.execute();
        } catch (IOException ioe) {
            System.err.println("Erro ao conectar servidor: " + ioe.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Executar servidor socket
        conectarServidor(12345);

        //Executar Comandos Bash
        //executarComandoServidor("ls ~");
    }
}
