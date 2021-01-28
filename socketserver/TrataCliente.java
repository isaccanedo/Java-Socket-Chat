package socketserver;

import java.io.InputStream;
import java.util.Scanner;

// +=============================+
// | @author Isac Canedo         |
// +=============================+

public class TrataCliente implements Runnable {

    InputStream cliente;
    ServidorSocket servidor;

    public TrataCliente(String host, InputStream cliente, ServidorSocket servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }
    
    @Override
    public void run() {
        Scanner scan = new Scanner(this.cliente);
        while(scan.hasNextLine()){
            servidor.distribuiMensagem(scan.nextLine());
            //System.out.println(host+": "+scan.nextLine());
        }
        
    }

}
