package menucesar;

public class Bruteforce {
    private  String mensaje;
    private int  llave;
    public Bruteforce(){
     }
    public Bruteforce(String mensaje, int llave){
         this.mensaje = mensaje;
        this.llave = llave;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public String decipherSerch(String mensaje){
        String res = "";
        String encontrada = "";
        CesarCipher cifrar1 = new CesarCipher();
        System.out.println(Ansi.ANSI_GREEN +  "Iniciando  Proceso De Decifrado..... "+ Ansi.ANSI_RESET);
       // int desplaz = 0;
        System.out.println("Archivo Original: " + Ansi.ANSI_YELLOW + mensaje + Ansi.ANSI_RESET);
        for (int desplaz = 0;  desplaz <  27; desplaz++) {
            desplaz = desplaz % 27;

            for (int pos = 0; pos < mensaje.length(); pos++) {

                char actual = mensaje.charAt(pos);

                if (cifrar1.toperCases(actual)) {

                    int posActual =  cifrar1.ALPHMAY.indexOf(actual + "");
                    if (posActual - desplaz < 0) {
                        posActual = 27 + (posActual - desplaz);
                    }else {
                        posActual = (posActual - desplaz)%27;
                    }

                    actual = cifrar1.ALPHMAY.charAt(posActual);

                } else if (cifrar1.lowerCases(actual)) {
                    int posActual =  cifrar1.ALPHMIN.indexOf(actual + "");
                    if (posActual - desplaz < 0) {
                        posActual = 27 + (posActual - desplaz);
                    }else {
                        posActual = (posActual - desplaz)%27;
                    }
                    actual = cifrar1.ALPHMIN.charAt(posActual);
                } else {
                    actual = mensaje.charAt(pos);
                }
                res = res + actual;
            }
            System.out.println(desplaz +") " +  Ansi.ANSI_GREEN +  res + Ansi.ANSI_RESET);

            res = "";
        }

        return  res;
    }

    public String decipher(String mensaje,int desplaz){
        String res = "";
        String encontrada = "";
        CesarCipher cifrar1 = new CesarCipher();
        System.out.println(Ansi.ANSI_GREEN +  "Iniciando  Proceso De Decifrado..... "+ Ansi.ANSI_RESET);
        // int desplaz = 0;
        System.out.println("Archivo Original: " + Ansi.ANSI_YELLOW + mensaje + Ansi.ANSI_RESET);

            desplaz = desplaz % 27;

            for (int pos = 0; pos < mensaje.length(); pos++) {

                char actual = mensaje.charAt(pos);

                if (cifrar1.toperCases(actual)) {

                    int posActual =  cifrar1.ALPHMAY.indexOf(actual + "");
                    if (posActual - desplaz < 0) {
                        posActual = 27 + (posActual - desplaz);
                    }else {
                        posActual = (posActual - desplaz)%27;
                    }

                    actual = cifrar1.ALPHMAY.charAt(posActual);

                } else if (cifrar1.lowerCases(actual)) {
                    int posActual =  cifrar1.ALPHMIN.indexOf(actual + "");
                    if (posActual - desplaz < 0) {
                        posActual = 27 + (posActual - desplaz);
                    }else {
                        posActual = (posActual - desplaz)%27;
                    }
                    actual = cifrar1.ALPHMIN.charAt(posActual);
                } else {
                    actual = mensaje.charAt(pos);
                }
                res = res + actual;
            }

        return  res;
    }


}
