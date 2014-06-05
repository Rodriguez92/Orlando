
import java.awt.TextArea;
import java.io.*;
import javax.swing.JFrame;
/**
 * @author diego rodriguez
 */
class Comando_Linux {
    
    static String comando = "find /home/diego -name *.jpg";
    //static String comando = "ps -aux";
    static String resultado="";
    static TextArea text=new TextArea();
    
     private static String convertirInputStreanaString(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line+"\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
    
    public static void main(String[] args) {
        try {
            final Process proceso = Runtime.getRuntime().exec(comando);

            InputStream lista = proceso.getInputStream();
            resultado=convertirInputStreanaString(lista);
            text.append("Archivos encontados con : "+comando+"\r\n");
            text.append("\r\n");
            text.append(resultado);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        
        JFrame ventana=new JFrame();
        ventana.setSize(700,500);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Resultado del comando: "+comando);
        ventana.add(text);
        ventana.setVisible(true);
    }
}

