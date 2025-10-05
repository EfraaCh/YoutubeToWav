import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Conversor {
    public static void main(String[] args) {
        try {
            
            //Aca cambia la carpeta de destino a tu gusto.
            String outputFolder = "C:\\Users\\TuUsuario\\Desktop\\Samples";
            
            System.out.print("Pegá el link de YouTube: ");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String url = reader.readLine();
            
            ProcessBuilder pb = new ProcessBuilder(
                "yt-dlp", "-x", "--audio-format", "wav",
                "-o", outputFolder + "/%(title)s.%(ext)s",
                url
            );

            pb.inheritIO(); // mostrar salida en consola
            Process process = pb.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Descarga completa en: " + outputFolder);
            } else {
                System.out.println("Hubo un error en la descarga");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
