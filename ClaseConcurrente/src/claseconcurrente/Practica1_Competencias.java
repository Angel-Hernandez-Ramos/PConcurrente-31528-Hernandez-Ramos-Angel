package claseconcurrente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Practica1_Competencias extends JFrame{
    JButton bRun,bPausa,bDetener;
    JLabel etiHilo1,etiHilo2;
    JTextArea areaHilo1,areaHilo2;
    JScrollPane japHilo1,japHilo2;
    
    public Practica1_Competencias(){
    setSize(400,400);
    setTitle("Condiciones de Competencias");
    MisComponentes();
    }
    private void MisComponentes(){
        bRun = new JButton("Run");
        bPausa = new JButton("Pausa");
        bDetener = new JButton("Detener");
        etiHilo1 = new JLabel("Hilo 1");
        etiHilo2 = new JLabel("Hilo 2");
        areaHilo1 = new JTextArea();
        areaHilo1.setEditable(false);
        areaHilo2 = new JTextArea();
        areaHilo2.setEditable(false);
        japHilo1 = new JScrollPane(areaHilo1);
        japHilo2 = new JScrollPane(areaHilo2);
        
        setLayout(null);
        bRun.setBounds(10,100,100,25);
        bPausa.setBounds(10,150,100,25);
        bDetener.setBounds(10,200,100,25);
        etiHilo1.setBounds(150,200,100,25);
        etiHilo2.setBounds(250,200,100,25);
        japHilo1.setBounds(150,50,100,300);
        japHilo2.setBounds(250,50,100,300);
        
        add(bRun);
        add(bPausa);
        add(bDetener);
        add(etiHilo1);
        add(etiHilo2);
        add(japHilo1);
        add(japHilo2);
                
        bRun.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               Hilo1 t1 = new Hilo1(areaHilo1);
               Hilo2 t2 = new Hilo2(areaHilo2);
               t1.start();
               t2.start();
            }
        
        });
    }
    
    public static void main(String[] args){
        Practica1_Competencias fr = new Practica1_Competencias();
        fr.setVisible(true);
        
    }
}
