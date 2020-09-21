package condicionescompetencias;
import javax.swing.JTextArea;
public class Hilo extends Thread{
    private JTextArea Area;
    private RCompartido rc;
    Hilo(JTextArea Area,RCompartido rc){
        this.Area=Area;
        this.rc=rc;
    }
    public void run(){
        while(true){
            try{
               rc.setRc(this.getName());
               Area.append(rc.getRc()+" Eats"+"\n");
               Thread.sleep(MIN_PRIORITY);
            }catch(Exception e){e.printStackTrace();}
        }
    }
}
