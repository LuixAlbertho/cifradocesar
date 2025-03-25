package menucesar;

/**
 * cifrado cesar
 */
public class CesarCipher {

    private  String mensaje;
    private int  llave;
    //las posiciones parten en  0 hasta 26 porq es una cadena (teniendo 27 letras)
    final String ALPHMAY = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    final String ALPHMIN = "abcdefghijklmnñopqrstuvwxyz";

    public CesarCipher(){
        //super(); // llamada al  constructor de la clase objecto
    }
    public CesarCipher(String mensaje, int llave){
       // super();
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

    public String cipher(String mensaje, int desplaz){
        String res = "";
        System.out.println(Ansi.ANSI_GREEN +  "Iniciando  Procedo De Cifrado..... "+ Ansi.ANSI_RESET);

        desplaz = desplaz%27;
        for(int pos = 0; pos < mensaje.length(); pos++){
            char actual = mensaje.charAt(pos);
            if (toperCases(actual)){
                // debe saber que el caracter actual que posicion ocupa dntro del alfabeto
                //indexOf recibe como parametro un String para convertirlo em estring uso ""
                int posActual =  ALPHMAY.indexOf(actual + "");
                posActual = posActual + desplaz;
                if (posActual > 26) {
                    posActual = posActual - 27;
                }
                actual = ALPHMAY.charAt(posActual);

            } else if (lowerCases(actual)){
                int posActual =  ALPHMIN.indexOf(actual + "");
                    posActual = posActual + desplaz;
                    if (posActual > 26) {
                        posActual = posActual - 27;
                    }
                    actual = ALPHMIN.charAt(posActual);
            }else {
                actual = mensaje.charAt(pos);
            }
            res = res + actual;
        }
        return res;

    }

    public String decipher(String mensaje, int desplaz){
        String res = "";
        System.out.println(Ansi.ANSI_GREEN +  "Iniciando  Proceso De Decifrado..... "+ Ansi.ANSI_RESET);
        for(int pos = 0; pos < mensaje.length(); pos++){
            char actual = mensaje.charAt(pos);
            if (toperCases(actual)){
                // debe saber que el caracter actual que posicion ocupa dntro del alfabeto
                //indexOf recibe como parametro un String para convertirlo em estring uso ""
                int posActual =  ALPHMAY.indexOf(actual + "");
                //posActual = posActual - desplaz;

                if (posActual - desplaz < 0) {
                    posActual = 27 + (posActual - desplaz);
                }else {
                    posActual = (posActual - desplaz)%27;
                }

                actual = ALPHMAY.charAt(posActual);
            } else if (lowerCases(actual)){
                int posActual =  ALPHMIN.indexOf(actual + "");
                if (posActual - desplaz < 0) {
                    posActual = 27 + (posActual - desplaz);
                }else {
                    posActual = (posActual - desplaz)%27;
                }
                actual = ALPHMIN.charAt(posActual);
            }else {
                actual = mensaje.charAt(pos);
            }
            res = res + actual;
        }
        return res;

    }

    public  boolean toperCases(char letra){
        return letra >= 'A' && letra <= 'Z' || letra == 'Ñ';
    }
    public  boolean lowerCases(char letra){
        return letra >= 'a' && letra <= 'z' || letra == 'ñ';
    }

}


