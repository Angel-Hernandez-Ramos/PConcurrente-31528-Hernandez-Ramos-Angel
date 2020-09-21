package claseconcurrente;
import javax.swing.JTextArea;
public class Hilo1 extends Thread {
    private JTextArea Area;
    Hilo1(JTextArea area){
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
