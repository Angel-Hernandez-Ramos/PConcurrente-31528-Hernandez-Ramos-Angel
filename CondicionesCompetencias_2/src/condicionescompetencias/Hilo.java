package condicionescompetencias;
import java.util.concurrent.locks.Lock;
import javax.swing.JTextArea;
import java.util.concurrent.locks.ReentrantLock;
public class Hilo extends Thread{
    private JTextArea Area;
    private RCompartido rc;
    private boolean ejecutar= true;
    private int variable;
    private mutex m;
    private Lock mutex2;
    Hilo(JTextArea Area,RCompartido rc){
        this.Area=Area;
        this.rc=rc;
        this.variable=1;
        m=new mutex();
        mutex2 =  new ReentrantLock();
    }
    public void run(){
        while(ejecutar){
            try{
                if(variable==1){
                    rc.setRc(this.getName());
                    Area.append(rc.getRc()+" Eats"+"\n");
                }
                if(variable==2){
                    rc.setRcCerradura(this.getName());
                    Area.append(rc.getRcCerradura()+" Eats"+"\n");
                }
                if(variable==3){
                    String aux ="En espera MArtes\n";
                        m.look();
                    rc.setRc(this.getName());
                    Area.append(rc.getRc()+" Eats"+"\n");
                        m.unlook();
                }
                if(variable==4){
                    //if(mutex2.tryLock()){
                        mutex2.lock();
                            rc.setRc(this.getName());
                            Area.append(rc.getRc()+" Eats"+"\n");
                        mutex2.unlock();
                   // }
                }
                if(variable==5){
                    rc.setRcInterrupcion(this.getName());
                    Area.append(rc.getRcInterrupcion()+" Eats"+"\n");
                }
                if(variable==6){
                    rc.setRcDekker(this.getName());
                    Area.append(rc.getRcDekker()+" Eats"+"\n");
                }
               Thread.sleep(MIN_PRIORITY);
            }catch(Exception e){e.printStackTrace();}
        }
    }
    public void detener() {
        ejecutar = false;
    }
    
     public void start() {
        ejecutar=true;
        new Thread(this).start();
    }
     
 
    public void CambioCondicionesComp(){
        variable = 1;
    }
    
      public void CambioCerradura() {
        variable = 2;
    }
     
    public void CambioMutexArtesanal(){
        variable = 3;
    }
    
    public void CambioMutexLibreria(){
        variable = 4;
    }
    
    public void CambioDesactivacionInters(){
        variable = 5;
    }
    
    public void CambioDekker(){
        variable = 6;
    }
    
}
