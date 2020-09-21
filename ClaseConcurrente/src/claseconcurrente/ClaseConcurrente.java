
package claseconcurrente;

public class ClaseConcurrente {


    public static void main(String[] args) {
           Thread t1 = new Thread(new Runnable(){
      public void run(){
          int i=0;
          while (i<50){
              System.out.println("Hola");
              i++;
          }
      } 
   });
   
   Thread t2 = new Thread(new Runnable(){
      public void run(){
          int i=0;
          while (i<50){
              System.out.println("mundo");
              i++;
          }
      } 
   });
        t1.start();
        t2.start();
    }
    
}
