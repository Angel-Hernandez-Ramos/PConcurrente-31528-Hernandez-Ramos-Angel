
package condicionescompetencias;

public class mutex {
    private boolean pase;
    mutex(){
            
    }
    public void look(){
        if(!pase){
            try{
               //wait();
               pase=true;
            }catch(Exception e){e.printStackTrace();}   
        }
    }
    public void unlook(){
        //notify();
        pase = false;
    }
    
}
