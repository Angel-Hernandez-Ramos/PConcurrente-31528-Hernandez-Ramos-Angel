package condicionescompetencias;

public class Procesos {
    private int id_proc;
    private boolean Proc;

    Procesos(){
        this.Proc=true;
    }
    public int getId_proc() {
        
        return id_proc;
    }

    public void setId_proc(int id_proc) {
        this.id_proc = id_proc;
    }

    public boolean isProc() {
        return this.Proc;
    }
    public void setProc(boolean Proc) {
        this.Proc = Proc;
    }
}
