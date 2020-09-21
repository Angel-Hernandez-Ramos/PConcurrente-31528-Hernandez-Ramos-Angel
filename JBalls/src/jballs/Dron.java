package jballs;
import javax.swing.*;
public class Dron extends Thread{
   
    private MiX x;
    private MiY y;
    private JPanel panel;
    private int a = 1;
    private int b = 1;
    Dron(MiX x,MiY y, DibujaDrones panel){
        this.x=x;
        this.y=y;
        this.panel=panel;
    }
    public void run(){
        while(true){

             try{
                          y.setY(y.getY()+b);
                          x.setX(x.getX()+a);
                          if (y.getY()==430){
                              b=-b;
                          }
                           if (y.getY()==0){

                              b=-b;
                          }
                          if (x.getX()==520){
                              a=-a;
                          }
                          if (x.getX()==-2){
                              a=-a;
                          }
                           panel.repaint();
                           Thread.sleep(8);
                           }catch(Exception e){e.printStackTrace();}
        /*while (true){
            try{
                x.setX(x.getX()+5);
                y.setY(y.getY()+5);// es decir x=x+1 
                panel.repaint();
                Thread.sleep(100);
            }catch(Exception e){e.printStackTrace();}
        }*/
    }
    
    }
}
