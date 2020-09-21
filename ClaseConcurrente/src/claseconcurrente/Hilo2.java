package claseconcurrente;
import javax.swing.JTextArea;
public class Hilo2 extends Thread {
    private JTextArea Area;
    Hilo2(JTextArea area){
        this.Area = area;
    }
    public void run(){
     int i=0;
     while(i<1000){
         Area.append(i+"\n");
         i++;
     }
    }
}