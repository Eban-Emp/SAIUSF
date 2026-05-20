
package Controllers;

import com.mycompany.saiusf.views.Login;
import com.mycompany.saiusf.views.Principal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class PrincipalController extends javax.swing.JFrame implements ActionListener, MouseListener {

private Principal views;

//private boolean estado = true;

    public PrincipalController(Principal views) {
        this.views = views;
        this.views.txtnins.addMouseListener(this);
        this.views.txtcar.addMouseListener(this);
        this.views.txtest.addMouseListener(this);
        this.views.txtus.addMouseListener(this);
        this.views.txtcur.addMouseListener(this);
        this.views.txtprof.addMouseListener(this);
        this.views.txtestins.addMouseListener(this);
        this.views.txtcert.addMouseListener(this);
        this.views.txtrep.addMouseListener(this);
        
        this.views.Cerrar.addActionListener(this);
        this.views.Sesión.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==views.Sesión){
            Login log = new Login();
            log.setVisible(true);
            log.setLocationRelativeTo(null);
            this.views.dispose();
            JOptionPane.showMessageDialog(null,"Sesión Cerrada con exito.");
        }else if (e.getSource() ==views.Cerrar){
            int pregunta = JOptionPane.showConfirmDialog(null, "esta seguro que desea salir", "pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           if (pregunta == 0){
               System.exit(0);
           }else if (pregunta == 1){
           }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //ESTUDIANTES
        if (e.getSource() == views.txtest){
            views.jTabbedPane1.setSelectedIndex(0);
            
            views.panest.setBackground(new Color (190,55,55));
            views.txtest.setForeground(Color.WHITE);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK);
            //CURSOS
        }else if (e.getSource() == views.txtcur){
            views.jTabbedPane1.setSelectedIndex(1);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (190,55,55));
            views.txtcur.setForeground(Color.WHITE);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK);
            //PROFESOR(FACILITADOR)
        }else if (e.getSource() == views.txtprof){
            views.jTabbedPane1.setSelectedIndex(2);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (190,55,55));
            views.txtprof.setForeground(Color.WHITE);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK);
            //CARRERA
        }else if (e.getSource() == views.txtcar){
            views.jTabbedPane1.setSelectedIndex(3);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (190,55,55));
            views.txtcar.setForeground(Color.WHITE);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK);  
            //INSCRIPCION
        }else if (e.getSource() == views.txtnins){
            views.jTabbedPane1.setSelectedIndex(4);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (190,55,55));
            views.txtnins.setForeground(Color.WHITE);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK); 
            //ESTADO
        }else if (e.getSource() == views.txtestins){
            views.jTabbedPane1.setSelectedIndex(5);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (190,55,55));
            views.txtestins.setForeground(Color.WHITE);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK);    
            //CERTIFICADO
        }else if (e.getSource() == views.txtcert){
            views.jTabbedPane1.setSelectedIndex(6);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (190,55,55));
            views.txtcert.setForeground(Color.WHITE);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK);    
            //REPORTE
        }else if (e.getSource() == views.txtrep){
            views.jTabbedPane1.setSelectedIndex(7);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (190,55,55));
            views.txtrep.setForeground(Color.WHITE);
            views.panus.setBackground(new Color (235,218,218));
            views.txtus.setForeground(Color.BLACK);    
            //USUARIO
        }else if (e.getSource() == views.txtus){
            views.jTabbedPane1.setSelectedIndex(8);
            
            views.panest.setBackground(new Color (235,218,218));
            views.txtest.setForeground(Color.BLACK);
            views.pancur.setBackground(new Color (235,218,218));
            views.txtcur.setForeground(Color.BLACK);
            views.panprof.setBackground(new Color (235,218,218));
            views.txtprof.setForeground(Color.BLACK);
            views.pancar.setBackground(new Color (235,218,218));
            views.txtcar.setForeground(Color.BLACK);
            views.panin.setBackground(new Color (235,218,218));
            views.txtnins.setForeground(Color.BLACK);
            views.panestins.setBackground(new Color (235,218,218));
            views.txtestins.setForeground(Color.BLACK);
            views.pancert.setBackground(new Color (235,218,218));
            views.txtcert.setForeground(Color.BLACK);
            views.panrep.setBackground(new Color (235,218,218));
            views.txtrep.setForeground(Color.BLACK);
            views.panus.setBackground(new Color (190,55,55));
            views.txtus.setForeground(Color.WHITE);    
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
//    public static void izq(JComponent componente, int milisegundos, int saltos, int parar){
//        (new Thread(){
//            @Override
//            public void run(){
//                for (int i = componente.getWidth(); i >= parar; i -= saltos){
//                    try{
//                        Thread.sleep(milisegundos);
//                        componente.setPreferredSize(new Dimension(i, componente.getHeight()));
//                        SwingUtilities.updateComponentTreeUI(componente);
//                    } catch (InterruptedException e){
//                        System.out.println("error Thread interrumpido: "+ e);
//                    }
//                }
//            }
//        }).start();  
//    }
//    
//    public static void der(JComponent componente, int milisegundos, int saltos, int parar){
//        (new Thread(){
//            @Override
//            public void run(){
//                for (int i = componente.getWidth(); i <= parar; i += saltos){
//                    try{
//                        Thread.sleep(milisegundos);
//                        componente.setPreferredSize(new Dimension(i, componente.getHeight()));
//                        SwingUtilities.updateComponentTreeUI(componente);
//                    } catch (InterruptedException e){
//                        System.out.println("error Thread interrumpido: "+ e);
//                    }
//                }
//            }
//        }).start();  
//    }
        
}


    
    

