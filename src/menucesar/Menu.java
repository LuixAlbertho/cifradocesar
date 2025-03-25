package menucesar;

public class Menu {
    //atributos
    String titulo;
    String opcion1;
    String opcion2;
    String opcion3;
    String opcion4;
    String opcion5;

    //metodos

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOpcion1() {
        return this.opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return this.opcion2;
    }
    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return this.opcion3;
    }

   public void setOpcion3(String opcion3 ){
        this.opcion3 = opcion3;
   }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(String opcion5) {
        this.opcion5 = opcion5;
    }

    //metodo para imprimir el menu
    public void imprimirmnu(){
       // System.out.println(ANSI.ANSI_BLUE + "Bienvenido al programa de cifrado Cesar" + ANSI.ANSI_RESET);
        System.out.println(Ansi.ANSI_BLUE + "--------------------------------------------------");
        System.out.println("- " +  getTitulo() +             " -");
        System.out.println("--------------------------------------------------" + Ansi.ANSI_RESET );
        System.out.println();
        System.out.println("1._ " + getOpcion1());
        System.out.println("2._ " + getOpcion2());
        System.out.println("3._ " + getOpcion3());
        System.out.println("4._ "  + getOpcion4());
        System.out.println("5._ " + getOpcion5());
        System.out.println();
        System.out.println();
        System.out.print(Ansi.ANSI_BLUE + "Por Favor Digite Una  Opcion..." + Ansi.ANSI_RESET);
    }


}


