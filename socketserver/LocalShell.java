package socketserver;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

// +=============================+
// | @author Isac Canedo         |
// +=============================+

public class LocalShell {

    private static final Logger log = Logger.getLogger(LocalShell.class.getName());

    public void executeCommand(final String command) throws IOException {

        final ArrayList<String> commands = new ArrayList<>();

        commands.add("/bin/bash");
        commands.add("-c");
        commands.add(command);

        BufferedReader br = null;

        try {

            final ProcessBuilder p = new ProcessBuilder(commands);
            final Process process = p.start();
            final InputStream is = process.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            String line;
            while((line = br.readLine()) != null){
                System.out.println("Retorno do comando = [" + line + "]");
            }
            
        } catch (IOException ioe) {
            log.severe("Erro ao executar o comando Shell" + ioe.getMessage());
        } finally {
            secureClose(br);
        }

    }

    public void secureClose(final Closeable resource) {
    
        try{
            if(resource != null){
                resource.close();
            }
        }catch(IOException ex){
            log.severe("Erro = "+ex.getMessage());
        }
    
    }

}
