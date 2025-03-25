package menucesar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;


public class FileManager {
    public static String readFile(String nombArch) throws IOException {
        File documentoACiprar = new File(nombArch);
        String mensaje = Files.readString(documentoACiprar.toPath());
        //return mensaje.toUpperCase();
        return mensaje;
    }

     public static String writeFile(String Messagefinal) throws IOException {
         File documentoCifrado = new File( "Cifrado.txt" );

         if (documentoCifrado.createNewFile()) {
             System.out.println("Se ha Generado Un Nuevo Documento Cifrado Llamado: " + "<< " + documentoCifrado + " >>" );
             //System.out.println("Se ha Generado Un Nuevo Documento Cifrado En: " +   path.normalize().toAbsolutePath());
         }
         try {
             FileWriter writer = new FileWriter( "Cifrado.txt");
             writer.write(Messagefinal);
             writer.close();

         } catch (IOException e) {
             System.out.println( "Ha Ocurrido un error" );
         }
         return null;
     }
   /* public static String writeFile(String Messagefinal) throws IOException {
        try {
            Path directorio = Paths.get("Encritados");
            Path fichero = Paths.get(directorio.toString(), Messagefinal);
            Files.createDirectories(directorio);
            Files.createFile(fichero);

          /* if(Files.exists(directorio)){
               if (Files.exists(fichero)){

               }

           }

        } catch (IOException e) {
            System.out.println("Ha Ocurrido un error");
        }
        return null;

    }*/


}
