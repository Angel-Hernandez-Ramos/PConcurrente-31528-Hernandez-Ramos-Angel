
package condicionescompetencias;

public class RCompartido {
    private String rc;
    private VCerraduraCop vcerr;
    private Interrupcion[] inters;
    private Procesos[] process;
    RCompartido(){
        rc="";
        vcerr= new VCerraduraCop();
        int n = 4;
        inters = new Interrupcion[n];
        for (int i=0; i < n; i++)
            inters[i] = new Interrupcion();
        
        process = new Procesos[4];
        for (int i=0; i < 4; i++){
            process[i] = new Procesos();
        }
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }
    
    //Cerradura programada
    public String getRcCerradura() {
        String aux="En espera Cerr...\n";  
        if(!vcerr.isVcerr()){
            vcerr.cierra();
                aux=rc; //Seccion Critica
            vcerr.abre();
        }
        return aux;
    }

    public void setRcCerradura(String rc) {
        vcerr.cierra();
            this.rc = rc;
        vcerr.abre();
    }
    
    //Todo para desactivacion de interrupciones
    public String getRcInterrupcion(){
        String aux = "En Espera Int...";
        if (verificar()){
            bloquear();
            aux = rc;
            desbloquear();
        }
        return aux;
    }
    
    public void setRcInterrupcion(String rc){
        
        if(verificar()){
            bloquear();
            this.rc = rc;
            desbloquear();
        }
    }
    
    public boolean verificar(){
        for (Interrupcion inter: inters){
            if (!inter.getEstado())
                return false;
        }
        return true;
    }
    
    public void bloquear(){
        for (Interrupcion inter: inters){
            inter.setEstado(false);
        }
    }
    
    public void desbloquear(){
        for (Interrupcion inter: inters){
            inter.setEstado(true);
        }
    }
    //Fin de codigo para desactivacion interrupciones
    
    //Algoritmo Dekker
    public String getRcDekker() {
        String aux = "En Espera DEK...";
        if(verificarDekker()){
            Esperar();
            aux = rc;
            SeccionCritica();
        }
        return aux;
    }

    public void setRcDekker(String rc) {
        if(verificarDekker()){
            Esperar();
            this.rc = rc;
            SeccionCritica();
        }
    }
    
    public boolean verificarDekker(){
        for (Procesos Proc: process){
            if (!Proc.isProc())
                return false;
        }
        return true;
    }

    public void Esperar(){
        for (Procesos Proc: process){
            Proc.setProc(false);
        }
    }
    
    public void SeccionCritica(){
        for (Procesos Proc: process){
            Proc.setProc(true);
        }
    }
    //Fin aLGORITMOS DE DEKKER
}
