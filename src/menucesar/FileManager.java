package menucesar;
import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 *
 * Este es La clase FileManager
 *
 */
public class FileManager {

    public static String readFile(String nombArch) throws IOException {
        String  mensaje = "";
        try {
            Path path = Paths.get(nombArch);
            mensaje = Files.readString(path);

        } catch (IOException e) {

            e.printStackTrace();

        }
        return mensaje;
    }

    /**
     *
     *La clase FileManager: Permite las operaciones apropiadas de lectura y escritura de archivos
     * y que los resultados se escriben en un archivo y se guardan en la ruta donde el usuario disponga
     *
     * @param Messagefinal = mensaje que se v a guardar
     * @param ruta = ruta donde se guardara el mensaje
     * @param opc = permite escoger si el archivo se guarda o se remplaza
     */
    public static void writeFile(String Messagefinal,String ruta, int opc) {

        try {

            if (Files.exists(Path.of(ruta))){
                //System.out.println("Este Archivo esta creado");

                if (Files.deleteIfExists(Path.of(ruta)) ) {
                    //System.out.println("El fichero ha sido borrado satisfactoriamente");
                    Path path = Files.writeString(Path.of(ruta), "", StandardOpenOption.CREATE_NEW);
                    Path path1 = Files.writeString(Path.of(ruta), Messagefinal, StandardOpenOption.WRITE);
                    if ( opc == 1) {
                        System.out.println("Se ha Generado y Guardado Un Nuevo Documento Cifrado En: " + path1.normalize().toAbsolutePath());
                    } else if (opc ==2 || opc ==3 ) {
                        System.out.println("Se ha Generado y Se Remplazó El  Documento Decifrado En: " + path1.normalize().toAbsolutePath());
                    }
                } else{
                    System.out.println("El fichero no pudó ser borrado");
                }
            } else {

                Path path = Files.writeString(Path.of(ruta), "", StandardOpenOption.CREATE_NEW);
                Path path1 = Files.writeString(Path.of(ruta), Messagefinal, StandardOpenOption.WRITE);
                System.out.println();
                System.out.println("Se ha Generado y Guardado Un Nuevo Documento Cifrado En: " +   path1.normalize().toAbsolutePath());

            }

        } catch (Exception e) {

            //e.printStackTrace();
            System.out.println(Ansi.ANSI_RED +"La Ruta : ( " +  ruta  + " ), No Existe!!, Este Archivo No Se Guardo." + Ansi.ANSI_RESET);

        }


    }
}
