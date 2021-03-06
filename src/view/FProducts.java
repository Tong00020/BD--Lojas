/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import model.dao.ProductsDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Products;

/**
 *
 * @author Tong
 */
public class FProducts extends javax.swing.JFrame {

    /**
     * Creates new form Products
     *
     * @throws java.sql.SQLException
     */
    public FProducts() throws SQLException {
        initComponents();

        jButton4.setEnabled(false);
        /*DefaultTableModel modelo = (DefaultTableModel) jTProducts.getModel();
        jTProducts.setRowSorter(new TableRowSorter(modelo));

        readJTable();*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProducts = new javax.swing.JTable();
        txtQtdProdutos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtBuscaProducts = new javax.swing.JTextField();
        txtNomeProdutos = new javax.swing.JTextField();
        txtPrecoProdutos = new javax.swing.JTextField();
        txtIdProdutos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBarCodeProdutos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCategoriaProdutos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescProdutos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdProvedorProdutos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton4.setText("Busca");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "DESCRI????O", "CATEGORIA", "PRE??O", "BARCODE", "QUANTIDADE", "ID PROVEDOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProductsMouseClicked(evt);
            }
        });
        jTProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProductsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProducts);

        jLabel4.setText("BARCODE");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("NOME");

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("CATEGORIA");

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        txtBuscaProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaProductsActionPerformed(evt);
            }
        });

        jLabel1.setText("DESCRI????O");

        jLabel2.setText("QUANTIDADE");

        jLabel3.setText("PRE??O");

        jLabel8.setText("ID PROVEDOR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(740, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProvedorProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDescProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtQtdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                            .addGap(33, 33, 33)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(txtPrecoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(25, 25, 25)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtIdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(txtBarCodeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(txtCategoriaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(30, 30, 30)
                                    .addComponent(jButton2)
                                    .addGap(26, 26, 26)
                                    .addComponent(jButton3)
                                    .addGap(85, 85, 85)
                                    .addComponent(txtBuscaProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton4))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
                    .addGap(52, 52, 52)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdProvedorProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel7))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDescProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQtdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBarCodeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCategoriaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton2)
                        .addComponent(txtBuscaProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGap(24, 24, 24)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void readJTableForDesc(String desc) throws SQLException {

        DefaultTableModel modelo = (DefaultTableModel) jTProducts.getModel();
        modelo.setNumRows(0);
        ProductsDAO pdao = new ProductsDAO();

        for (Products p : pdao.readForDesc(desc)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getCategory(),
                p.getPrice(),
                p.getBarcode(),
                p.getQuantity(),
                p.getProvidersId()
            });

        }

    }

    public void readJTable() throws SQLException {

        DefaultTableModel modelo = (DefaultTableModel) jTProducts.getModel();
        modelo.setNumRows(0);
        ProductsDAO pdao = new ProductsDAO();

        for (Products p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getCategory(),
                p.getPrice(),
                p.getBarcode(),
                p.getQuantity(),
                p.getProvidersId()
            });

        }

    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            readJTableForDesc(txtBuscaProducts.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProductsMouseClicked
        if (jTProducts.getSelectedRow() != -1) {

            txtIdProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 1).toString());
            txtDescProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 2).toString());
            txtQtdProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 3).toString());
            txtPrecoProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 4).toString());
            txtNomeProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 5).toString());
            txtIdProvedorProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 8).toString());
            txtBarCodeProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 7).toString());
            txtCategoriaProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_jTProductsMouseClicked

    private void jTProductsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProductsKeyReleased
        if (jTProducts.getSelectedRow() != -1) {

            txtIdProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 1).toString());
            txtDescProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 2).toString());
            txtQtdProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 3).toString());
            txtPrecoProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 4).toString());
            txtNomeProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 5).toString());
            txtIdProvedorProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 8).toString());
            txtBarCodeProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 7).toString());
            txtCategoriaProdutos.setText(jTProducts.getValueAt(jTProducts.getSelectedRow(), 6).toString());
        }

    }//GEN-LAST:event_jTProductsKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Products p = new Products();
            ProductsDAO dao = new ProductsDAO();

            p.setId(Integer.parseInt(txtIdProdutos.getText()));
            p.setName(txtNomeProdutos.getText());
            p.setDescription(txtDescProdutos.getText());
            p.setProvidersId(Integer.parseInt(txtIdProvedorProdutos.getText()));
            p.setPrice(Double.parseDouble(txtPrecoProdutos.getText()));
            p.setBarcode(Integer.parseInt(txtQtdProdutos.getText()));
            p.setQuantity(Integer.parseInt(txtQtdProdutos.getText()));
            p.setCategory(txtCategoriaProdutos.getText());
            dao.create(p);

            txtDescProdutos.setText("");
            txtQtdProdutos.setText("");
            txtPrecoProdutos.setText("");
            txtNomeProdutos.setText("");
            txtIdProdutos.setText("");
            txtBarCodeProdutos.setText("");
            txtIdProvedorProdutos.setText("");
            txtCategoriaProdutos.setText("");
            readJTable();

        } catch (SQLException ex) {
            Logger.getLogger(FProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTProducts.getSelectedRow() != -1) {

            try {

                Products p = new Products();
                ProductsDAO dao = new ProductsDAO();

                p.setId((int) jTProducts.getValueAt(jTProducts.getSelectedRow(), 0));

                dao.delete(p);

                txtDescProdutos.setText("");
                txtQtdProdutos.setText("");
                txtPrecoProdutos.setText("");
                txtNomeProdutos.setText("");
                txtIdProdutos.setText("");
                txtBarCodeProdutos.setText("");
                txtIdProvedorProdutos.setText("");
                txtCategoriaProdutos.setText("");

                readJTable();

            } catch (SQLException ex) {
                Logger.getLogger(FProducts.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTProducts.getSelectedRow() != -1) {

            try {

                Products p = new Products();
                ProductsDAO dao = new ProductsDAO();

                p.setId(Integer.parseInt(txtIdProdutos.getText()));
                p.setName(txtNomeProdutos.getText());
                p.setDescription(txtDescProdutos.getText());
                p.setProvidersId(Integer.parseInt(txtIdProvedorProdutos.getText()));
                p.setPrice(Double.parseDouble(txtPrecoProdutos.getText()));
                p.setBarcode(Integer.parseInt(txtQtdProdutos.getText()));
                p.setQuantity(Integer.parseInt(txtQtdProdutos.getText()));
                p.setCategory(txtCategoriaProdutos.getText());
                p.setId((int) jTProducts.getValueAt(jTProducts.getSelectedRow(), 0));

                try {
                    dao.alter(p);
                } catch (SQLException ex) {
                    Logger.getLogger(FProducts.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FProducts.class.getName()).log(Level.SEVERE, null, ex);
                }

                txtDescProdutos.setText("");
                txtQtdProdutos.setText("");
                txtPrecoProdutos.setText("");
                txtNomeProdutos.setText("");
                txtIdProdutos.setText("");
                txtBarCodeProdutos.setText("");
                txtIdProvedorProdutos.setText("");
                txtCategoriaProdutos.setText("");
                readJTable();

            } catch (SQLException ex) {
                Logger.getLogger(FProducts.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtBuscaProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaProductsActionPerformed
        jButton4.setEnabled(true);
    }//GEN-LAST:event_txtBuscaProductsActionPerformed

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
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new FProducts().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FProducts.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProducts;
    private javax.swing.JTextField txtBarCodeProdutos;
    private javax.swing.JTextField txtBuscaProducts;
    private javax.swing.JTextField txtCategoriaProdutos;
    private javax.swing.JTextField txtDescProdutos;
    private javax.swing.JTextField txtIdProdutos;
    private javax.swing.JTextField txtIdProvedorProdutos;
    private javax.swing.JTextField txtNomeProdutos;
    private javax.swing.JTextField txtPrecoProdutos;
    private javax.swing.JTextField txtQtdProdutos;
    // End of variables declaration//GEN-END:variables

}
