
package condicionescompetencias;

public class Interrupcion {
    
    private Boolean estado; //True = Ocupable
    
    Interrupcion(){
        this.estado = true;
    }
    
    public Boolean getEstado(){
        return this.estado;
    }
    
    public void setEstado(Boolean estado){
        this.estado = estado;
    }
    
}
