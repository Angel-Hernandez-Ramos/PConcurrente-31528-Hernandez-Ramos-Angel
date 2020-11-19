
package condicionescompetencias;
public class VCerraduraCop {
  private boolean vcerr;
  VCerraduraCop(){
     vcerr = false; // false abierta, true cerrada
  }

    public boolean isVcerr(){return vcerr;}
    
    public void setVcerr(boolean vcerr) {this.vcerr = vcerr;}
    
    public void cierra(){vcerr =true;}
    public void abre(){vcerr = false;}
}  
