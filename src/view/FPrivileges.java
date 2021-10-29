/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.dao.PrivilegesDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import model.bean.Privileges;

/**
 *
 * @author Tong
 */
public class FPrivileges extends javax.swing.JFrame {

    /**
     * Creates new form Privileges
     */
    public FPrivileges() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTPrivileges.getModel();
        jTPrivileges.setRowSorter(new TableRowSorter(modelo));

        readJTable();
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jTPrivileges.getModel();
        modelo.setNumRows(0);
        PrivilegesDAO pdao = new PrivilegesDAO();

        for (Privileges p : pdao.list()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.isIs_superadmin()
            });

        }

    }

    public void readJTableForDesc(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTPrivileges.getModel();
        modelo.setNumRows(0);
        PrivilegesDAO pdao = new PrivilegesDAO();

        for (Privileges p : pdao.loadById(id)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.isIs_superadmin()
            });

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtIdPrivileges = new javax.swing.JTextField();
        txtNomePrivileges = new javax.swing.JTextField();
        txtIsAdminPrivileges = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPrivileges = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtBuscaPrivileges = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("NOME");

        jLabel9.setText("ID");

        jLabel2.setText("É ADMINISTRADOR");

        jTPrivileges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "É SUPER ADMINISTRADOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTPrivileges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPrivilegesMouseClicked(evt);
            }
        });
        jTPrivileges.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPrivilegesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTPrivileges);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtBuscaPrivileges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaPrivilegesActionPerformed(evt);
            }
        });

        jButton4.setText("Busca");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdPrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNomePrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtIsAdminPrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3)
                        .addGap(176, 176, 176)
                        .addComponent(txtBuscaPrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIsAdminPrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdPrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomePrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscaPrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jTPrivilegesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPrivilegesMouseClicked
        if (jTPrivileges.getSelectedRow() != -1) {

            txtIdPrivileges.setText(jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 0).toString());
            txtNomePrivileges.setText(jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 1).toString());
            txtIsAdminPrivileges.setText(jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 2).toString());

        }
    }//GEN-LAST:event_jTPrivilegesMouseClicked

    private void jTPrivilegesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrivilegesKeyReleased
        if (jTPrivileges.getSelectedRow() != -1) {
            txtIdPrivileges.setText(jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 0).toString());
            txtNomePrivileges.setText(jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 1).toString());
            txtIsAdminPrivileges.setText(jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 2).toString());
            txtIdPrivileges.setText(jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_jTPrivilegesKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Privileges p = new Privileges();
        PrivilegesDAO dao = new PrivilegesDAO();
        p.setId(Integer.parseInt(txtIdPrivileges.getText()));
        p.setName(txtNomePrivileges.getText());
        p.setIs_superadmin(Boolean.parseBoolean(txtIsAdminPrivileges.getText()));
        dao.create(p);
        txtIdPrivileges.setText("");
        txtNomePrivileges.setText("");
        txtIsAdminPrivileges.setText("");
        readJTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTPrivileges.getSelectedRow() != -1) {

            Privileges p = new Privileges();
            PrivilegesDAO dao = new PrivilegesDAO();
            p.setId((int) jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 0));
            dao.delete(p);
            txtIdPrivileges.setText("");
            txtNomePrivileges.setText("");
            txtIsAdminPrivileges.setText("");
            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um privilegio para excluir.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTPrivileges.getSelectedRow() != -1) {

            Privileges p = new Privileges();
            PrivilegesDAO dao = new PrivilegesDAO();
            p.setId(Integer.parseInt(txtIdPrivileges.getText()));
            p.setName(txtNomePrivileges.getText());
            p.setIs_superadmin(Boolean.parseBoolean(txtIsAdminPrivileges.getText()));
            p.setId((int) jTPrivileges.getValueAt(jTPrivileges.getSelectedRow(), 0));
            try {
                dao.alter(p);
            } catch (Exception ex) {
                Logger.getLogger(FPrivileges.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtIdPrivileges.setText("");
            txtNomePrivileges.setText("");
            txtIsAdminPrivileges.setText("");
            readJTable();

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtBuscaPrivilegesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaPrivilegesActionPerformed
        jButton4.setEnabled(true);
    }//GEN-LAST:event_txtBuscaPrivilegesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

//        readJTableForDesc(txtBuscaPrivileges.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPrivileges().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPrivileges;
    private javax.swing.JTextField txtBuscaPrivileges;
    private javax.swing.JTextField txtIdPrivileges;
    private javax.swing.JTextField txtIsAdminPrivileges;
    private javax.swing.JTextField txtNomePrivileges;
    // End of variables declaration//GEN-END:variables
}
