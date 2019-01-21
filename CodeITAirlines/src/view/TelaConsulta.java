/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AviaoDao;
import controller.PassageiroDao;
import controller.TripulanteDao;
import controller.VooDao;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.Aviao;
import model.Passageiro;
import model.Tripulante;
import model.Voo;

/**
 *
 * @author renilson
 */
public class TelaConsulta extends javax.swing.JFrame {

    private String classe;
    private final DefaultListModel model = new DefaultListModel();
    ArrayList<Passageiro> passageiros = new ArrayList<>();
    ArrayList<Voo> voos = new ArrayList<>();
    ArrayList<Aviao> avioes = new ArrayList<>();
    ArrayList<Tripulante> tripulantes = new ArrayList<>();

    ;

    /**
     * Creates new form TelaConsulta
     */
    public TelaConsulta() {
        initComponents();
    }

    public TelaConsulta(String classe) {
        initComponents();
        this.classe = classe;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtConsulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listResultados = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultaKeyReleased(evt);
            }
        });

        jScrollPane1.setViewportView(listResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(txtConsulta)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(416, 357));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaKeyReleased
        switch (classe) {
            case "voo":
                voos.clear();
                model.removeAllElements();
                listResultados.setModel(model);
                voos = new VooDao().buscarVoos(txtConsulta.getText());
                for (Voo v : voos) {
                    model.addElement(v.toString());
                    listResultados.setModel(model);
                }
                break;
            case "aviao":
                avioes.clear();
                model.removeAllElements();
                listResultados.setModel(model);
                avioes = new AviaoDao().buscarAviaoByString(txtConsulta.getText());
                for (Aviao a : avioes) {
                    model.addElement(a.toString());
                    listResultados.setModel(model);
                }
                break;
            case "passageiro":
                passageiros.clear();
                model.removeAllElements();
                listResultados.setModel(model);
                passageiros = new PassageiroDao().buscarPassageiroByString(txtConsulta.getText());
                for (Passageiro p : passageiros) {
                    model.addElement(p.toString());
                    listResultados.setModel(model);
                }
                break;
            case "tripulante":
                tripulantes.clear();
                model.removeAllElements();
                listResultados.setModel(model);
                tripulantes = new TripulanteDao().buscarTripulanteByString(txtConsulta.getText());
                for (Tripulante t : tripulantes) {
                    System.out.println(t.toString());
                    model.addElement(t.toString());
                    listResultados.setModel(model);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_txtConsultaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch (classe) {
            case "voo":
                new TelaVoo().setVisible(true);
                break;
            case "aviao":
                new TelaAviao().setVisible(true);
                break;
            case "passageiro":
                new TelaPassageiro().setVisible(true);
                break;
            case "tripulante":
                new TelaTripulante().setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listResultados;
    private javax.swing.JTextField txtConsulta;
    // End of variables declaration//GEN-END:variables
}
