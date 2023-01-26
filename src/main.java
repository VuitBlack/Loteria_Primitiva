import java.util.Random;
import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args){
        Random rand = new Random(System.nanoTime());
        int [] combinacion = new int [6];
        int aux;
        String cadena = "";

// Escribo el Vector con la combinación
        for (int i=0; i<6; i++) {
            int num = numero();
            combinacion[i] = num;
            for (int e = 0; e < i; e++) {
                if (combinacion[e] == num){
                    num = numero();
                }
                combinacion[i] = num;
            }
        }
// Ordenar el Vector de la combinación
        for (int i=0; i<6; i++) {
            for (int j=i+1; j<6; j++) {
                if(combinacion[j]<combinacion[i]){
                    aux = combinacion[j];
                    combinacion[j] = combinacion[i];
                    combinacion[i] = aux;
                }
            }
        }
// Convierto el Vector de la combinación a un String para su impresión
        for (int i=0; i<6; i++) {
            if (i<5) {
                cadena = cadena + " " + combinacion[i] + ",";
            } else {cadena = cadena + " " + combinacion[i] + ".";}
        }

// Numero Complementario
        int comp = numero();
        for (int i=0; i<6; i++) {
            while (combinacion[i] == comp){
                comp = numero();
            }
        }
// Reintegro
        int reint =reintegro();

        JOptionPane.showMessageDialog(null,"\nLA COMBINACIÓN: "+ cadena +"\n\n"+
                "EL REINTEGRO: "+reint+
                "\n\n\n ¡¡¡¡ MUCHA SUERTE !!!!",
                "LOTERÍA PRIMITIVA",
                JOptionPane.PLAIN_MESSAGE);
    }

    //Métodos
    static int numero(){
        int num;
        Random rand = new Random(System.nanoTime());
        num = rand.nextInt(49);
        while (num == 0){
            num = rand.nextInt(49);
        }
        return num;
    }

    static int reintegro(){
        int reint;
        Random rand = new Random(System.nanoTime());
        reint = rand.nextInt(10);
        while (reint == 0){
            reint = rand.nextInt(10);
        }
        return reint;
    }
}
