/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Budgets;
import model.dao.BudgetsDAO;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tong
 */
public class FBudget extends javax.swing.JFrame {

    /**
     * Creates new form Budget
     */
    public FBudget() {
        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) jTBudget.getModel();
        jTBudget.setRowSorter(new TableRowSorter(modelo));

        readJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtPrecoBudget = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSubtotalBudget = new javax.swing.JTextField();
        txtDateBudget = new javax.swing.JTextField();
        txtIdBudget = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBudget = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtBuscaBudget = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txttotalItensBudget = new javax.swing.JTextField();
        txtIdClientesBudget = new javax.swing.JTextField();
        txtIdVeiculosBudget = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtIdServicosBudget = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setText("ID");

        jLabel11.setText("DATA");

        jLabel4.setText("TOTAL");

        jLabel2.setText("PREÇO DE SERVIÇO");

        jTBudget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PREÇO DE SERVIÇO", "TOTAL", "DATA", "DESCRIÇÃO", "ID VEICULOS", "ID SERVIÇOS", "ID CLIENTES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTBudget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBudgetMouseClicked(evt);
            }
        });
        jTBudget.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTBudgetKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTBudget);

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

        txtBuscaBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaBudgetActionPerformed(evt);
            }
        });

        jButton4.setText("Busca");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("TOTAL DE ITENS");

        jLabel10.setText("ID CLIENTES");

        txtIdServicosBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdServicosBudgetActionPerformed(evt);
            }
        });

        jLabel12.setText("ID SERVIÇOS");

        jLabel7.setText("ID VEICULOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3)
                                .addGap(163, 163, 163)
                                .addComponent(txtBuscaBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtSubtotalBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtDateBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdVeiculosBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtIdServicosBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtPrecoBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotalItensBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtIdClientesBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(273, 273, 273))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(500, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(322, 322, 322)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttotalItensBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtPrecoBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addGap(10, 10, 10)
                        .addComponent(txtIdBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdClientesBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSubtotalBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDateBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtIdVeiculosBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdServicosBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscaBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jLabel7)
                    .addContainerGap(345, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jTBudget.getModel();
        modelo.setNumRows(0);
        BudgetsDAO pdao = new BudgetsDAO();

        for (Budgets p : pdao.list()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getPrice_services(),
                p.getTotal_items(),
                p.getTotal(),
                p.getDate(),
                p.getVehiclesId(),
                p.getServicesId(),
                p.getClientsId()
            });

        }

    }

    public void readJTableForDesc(int id) throws SQLException {

        DefaultTableModel modelo = (DefaultTableModel) jTBudget.getModel();
        modelo.setNumRows(0);
        BudgetsDAO pdao = new BudgetsDAO();

        for (Budgets p : pdao.loadById(id)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getPrice_services(),
                p.getTotal_items(),
                p.getTotal(),
                p.getDate(),
                p.getVehiclesId(),
                p.getServicesId(),
                p.getClientsId()
            });

        }

    }

    private void jTBudgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBudgetMouseClicked
        if (jTBudget.getSelectedRow() != -1) {

            txtIdBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 1).toString());
            txtPrecoBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 2).toString());
            txttotalItensBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 3).toString());
            txtSubtotalBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 4).toString());
            txtDateBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 5).toString());
            txtIdVeiculosBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 6).toString());
            txtIdServicosBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 7).toString());
            txtIdClientesBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 8).toString());
        }
    }//GEN-LAST:event_jTBudgetMouseClicked

    private void jTBudgetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBudgetKeyReleased
        if (jTBudget.getSelectedRow() != -1) {

            txtIdBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 1).toString());
            txtPrecoBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 2).toString());
            txttotalItensBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 3).toString());
            txtSubtotalBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 4).toString());
            txtDateBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 5).toString());
            txtIdVeiculosBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 6).toString());
            txtIdServicosBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 7).toString());
            txtIdClientesBudget.setText(jTBudget.getValueAt(jTBudget.getSelectedRow(), 8).toString());
        }
    }//GEN-LAST:event_jTBudgetKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Budgets p = new Budgets();
            BudgetsDAO dao = new BudgetsDAO();

            p.setId(Integer.parseInt(txtIdBudget.getText()));
            p.setPrice_services(Integer.parseInt(txtPrecoBudget.getText()));
            p.setTotal_items(Integer.parseInt(txttotalItensBudget.getText()));
            p.setTotal(Double.parseDouble(txtSubtotalBudget.getText()));
            p.setDate(Date.valueOf(txtDateBudget.getText()));
            p.setVehiclesId(Integer.parseInt(txtIdVeiculosBudget.getText()));
            p.setServicesId(Integer.parseInt(txtIdServicosBudget.getText()));
            p.setClientsId(Integer.parseInt(txtIdClientesBudget.getText()));
            dao.create(p);

            txtIdBudget.setText("");
            txtPrecoBudget.setText("");
            txttotalItensBudget.setText("");
            txtSubtotalBudget.setText("");
            txtDateBudget.setText("");
            txtIdVeiculosBudget.setText("");
            txtIdServicosBudget.setText("");
            txtIdClientesBudget.setText("");

            readJTable();

        } catch (Exception ex) {
            Logger.getLogger(FBudget.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTBudget.getSelectedRow() != -1) {

            Budgets p = new Budgets();
            BudgetsDAO dao = new BudgetsDAO();
            p.setId((int) jTBudget.getValueAt(jTBudget.getSelectedRow(), 0));
            dao.delete(p);
            txtIdBudget.setText("");
            txtPrecoBudget.setText("");
            txttotalItensBudget.setText("");
            txtSubtotalBudget.setText("");
            txtDateBudget.setText("");
            txtIdVeiculosBudget.setText("");
            txtIdServicosBudget.setText("");
            txtIdClientesBudget.setText("");
            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTBudget.getSelectedRow() != -1) {

            Budgets p = new Budgets();
            BudgetsDAO dao = new BudgetsDAO();
            p.setId(Integer.parseInt(txtIdBudget.getText()));
            p.setPrice_services(Integer.parseInt(txtPrecoBudget.getText()));
            p.setTotal_items(Integer.parseInt(txttotalItensBudget.getText()));
            p.setTotal(Double.parseDouble(txtSubtotalBudget.getText()));
            p.setDate(Date.valueOf(txtDateBudget.getText()));
            p.setVehiclesId(Integer.parseInt(txtIdVeiculosBudget.getText()));
            p.setServicesId(Integer.parseInt(txtIdServicosBudget.getText()));
            p.setClientsId(Integer.parseInt(txtIdClientesBudget.getText()));
            p.setId((int) jTBudget.getValueAt(jTBudget.getSelectedRow(), 0));
            try {
                dao.alter(p);
            } catch (Exception ex) {
                Logger.getLogger(FBudget.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtIdBudget.setText("");
            txtPrecoBudget.setText("");
            txttotalItensBudget.setText("");
            txtSubtotalBudget.setText("");
            txtDateBudget.setText("");
            txtIdVeiculosBudget.setText("");
            txtIdServicosBudget.setText("");
            txtIdClientesBudget.setText("");
            readJTable();

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtBuscaBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaBudgetActionPerformed
        jButton4.setEnabled(true);
    }//GEN-LAST:event_txtBuscaBudgetActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

//        readJTableForDesc(txtBuscaBudget.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtIdServicosBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdServicosBudgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdServicosBudgetActionPerformed

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
            java.util.logging.Logger.getLogger(FBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FBudget().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTBudget;
    private javax.swing.JTextField txtBuscaBudget;
    private javax.swing.JTextField txtDateBudget;
    private javax.swing.JTextField txtIdBudget;
    private javax.swing.JTextField txtIdClientesBudget;
    private javax.swing.JTextField txtIdServicosBudget;
    private javax.swing.JTextField txtIdVeiculosBudget;
    private javax.swing.JTextField txtPrecoBudget;
    private javax.swing.JTextField txtSubtotalBudget;
    private javax.swing.JTextField txttotalItensBudget;
    // End of variables declaration//GEN-END:variables
}
