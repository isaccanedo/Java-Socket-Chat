package socketclient;

import java.io.InputStream;
import java.util.Scanner;

// +=============================+
// | @author Isac Canedo         |
// +=============================+

public class Recebedor implements Runnable{
    
    InputStream servidor;

    public Recebedor(InputStream servidor) {
        this.servidor = servidor;
    }
    
    @Override
    public void run(){
        //Recebe Mesagens do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);
        while(s.hasNextLine()){
            System.out.println(s.nextLine());
        }
    }
    
    
}
