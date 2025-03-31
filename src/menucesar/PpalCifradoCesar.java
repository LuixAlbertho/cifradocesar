package menucesar;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @Author Luis Alberto Meneses
 *
 * Este es La clase principal
 * PpalCifradoCesar: Es la clase principal donde comienza la ejecución y el control del flujo del programa.
 *
 */


public class PpalCifradoCesar {
    public static void main(String[] args) {
        Menu Menu1 = new Menu();
        Menu1.setTitulo("BIENVENIDO A LA IMPLEMENTACION - CIFRADO CESAR");
        Menu1.setOpcion1("CIFRAR EL TEXTO DE UN ARCHIVO");
        Menu1.setOpcion2("DESCIFRAR EL TEXTO DE UN ARCHIVO");
        Menu1.setOpcion3("DESCIFRAR UN ARCHIVO METODO FUERZA BRUTA");
        Menu1.setOpcion4("VOLVER AL MENU");
        Menu1.setOpcion5("SALIR");


        Menu1.imprimirmnu();


        Scanner ingresopcion = null;

        int opcionAtomar = 0;
        ingresopcion = new Scanner(System.in);

        CesarCipher cifrar = new CesarCipher();

        do {
            try {

                opcionAtomar = ingresopcion.nextInt();

                switch (opcionAtomar) {
                    case 1:
                        Scanner nombArch = new Scanner(System.in);
                        System.out.print(Ansi.ANSI_BLUE +  "Ingresa La Ruta Del Archivo  Que Deseas Cifrar: "+ Ansi.ANSI_RESET);
                        String fileName = nombArch.nextLine();
                        File file = new File(fileName);

                        if (file.exists()){
                            System.out.println("El archivo Es validado");

                            System.out.print(Ansi.ANSI_BLUE + "Ingrese La Clave  Para Cifrar: " + Ansi.ANSI_RESET);

                            int  desplazar =   nombArch.nextInt();
                            String archivoCifrado = cifrar.cipher(FileManager.readFile((fileName)),desplazar);
                            System.out.println(Ansi.ANSI_GREEN +  "Tu Archivo Fue Cifrado Correctamente "+ Ansi.ANSI_RESET);
                            System.out.print(Ansi.ANSI_BLUE+  "Digite << 1 >>: Si Desea  especificar La Ruta Donde Se Guardará El Archivo, De Lo contrario Digite << 2 >>..."+ Ansi.ANSI_RESET);
                            int  opcLetra =   nombArch.nextInt();
                            String ruta = "";
                            if (opcLetra ==1){
                                System.out.print(Ansi.ANSI_YELLOW +  "Digite La Ruta (Ej: D:\\Cifrado.txt), Donde Se Guardara El Alchivo:"+ Ansi.ANSI_RESET);
                                nombArch.nextLine(); // limpiar el buffer
                                ruta = nombArch.nextLine();
                                FileManager.writeFile(archivoCifrado, ruta,1);
                            } else if (opcLetra ==2) {
                                ruta ="Cifrado.txt";
                                FileManager.writeFile(archivoCifrado, ruta,1);
                            }

                        } else {
                            System.out.println(Ansi.ANSI_RED + "Este archivo no existe!!. Por favor vuelva a intentarlo." + Ansi.ANSI_RESET);
                        }
                       // nombArch.close();
                        break;
                    case 2:
                        Scanner nombArch1 = new Scanner(System.in);
                        System.out.print(Ansi.ANSI_BLUE +  "Ingresa la Ruta  Del Archivo  Que Deseas Decifrar: "+ Ansi.ANSI_RESET);
                        String fileName1 = nombArch1.nextLine();
                        File file1 = new File(fileName1);

                        if (file1.exists()){
                            System.out.println("El archivo ha sido validado");

                            System.out.print(Ansi.ANSI_BLUE + "Ingrese La Clave  Para Decifrar: " + Ansi.ANSI_RESET);

                            int  desplazar =   nombArch1.nextInt();

                            String archivoDecifrado2 = cifrar.decipher(FileManager.readFile((fileName1)),desplazar);

                            FileManager.writeFile(archivoDecifrado2,fileName1,2);
                        } else {
                            System.out.println(Ansi.ANSI_RED + "Este archivo no existe!!. Por favor vuelva a intentarlo." + Ansi.ANSI_RESET);
                        }
                        //nombArch1.close();
                        break;

                    case 3:
                        Scanner nombArch2 = new Scanner(System.in);
                        System.out.print(Ansi.ANSI_BLUE +  "Ingresa La Ruta  Del Archivo  Que Deseas Decifrar: "+ Ansi.ANSI_RESET);
                        String fileName2 = nombArch2.nextLine();
                        File file2 = new File(fileName2);

                        if (file2.exists()){
                            System.out.println("El archivo ha sido validado");
                            Bruteforce bruteforce = new Bruteforce();
                            //String archivoDecifrado3 = bruteforce.decipherSerch(FileManager.readFile((fileName2)));
                            bruteforce.decipherSerch(FileManager.readFile((fileName2)));
                            System.out.println(Ansi.ANSI_BLUE+ "Elija La llave para Guardar El  Archivo " + Ansi.ANSI_RESET);


                            int  desplazar =   nombArch2.nextInt();

                            String archivoDecifrado3 = cifrar.decipher(FileManager.readFile((fileName2)),desplazar);

                            FileManager.writeFile(archivoDecifrado3,fileName2,3 );

                        } else {
                            System.out.println(Ansi.ANSI_RED + "Este archivo no existe!!. Por favor vuelva a intentarlo." + Ansi.ANSI_RESET);
                        }
                        break;
                    case 4:
                        Menu1.imprimirmnu();
                        break;
                    case 5:
                        System.out.println(Ansi.ANSI_YELLOW +  "Gracias Por Usar Este Programa..");
                        break;

                    default:
                        System.out.println("Opcion Invalidad, Elija Una Opcion Presentada En El Menu (1,2,3,4):");
                }
                if (opcionAtomar == 1 || opcionAtomar == 2 ||  opcionAtomar == 3){
                    System.out.print( Ansi.ANSI_BLUE  + "Elija La Opcion << 4 >> Para Volver Al Menu..." + Ansi.ANSI_RESET);
                }


            } catch (InputMismatchException e) {
                System.out.println(Ansi.ANSI_RED +"Opcion Invalidad, Elija una Opcion  valida( 1,2,3,4,5) Para Volvr Al  Menu" + Ansi.ANSI_RESET);
                //opcionAtomar = Integer.parseInt(ingresopcion.next());
                ingresopcion.next();
            }catch (IOException e) {
                System.out.println(Ansi.ANSI_RED + "El archivo ingresado no se encontró, por favor verifique el nombre del archivo" + Ansi.ANSI_RESET);

            }

        } while (opcionAtomar != 5);

    }


}
