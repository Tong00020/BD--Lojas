/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.bean.Providers;
import model.dao.ProvidersDAO;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Tong
 */
public class FProviders extends javax.swing.JFrame {

    /**
     * Creates new form Providers
     */
    public FProviders() {
        initComponents();
        
        jButton4.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCepProviders = new javax.swing.JTextField();
        txtEstadoProviders = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCidadeProviders = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtComplementoProviders = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEnderecoProviders = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNomeProviders = new javax.swing.JTextField();
        txtCelularProviders = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCnpjProviders = new javax.swing.JTextField();
        txtSiteProviders = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdProviders = new javax.swing.JTextField();
        txtNumEnderecoProviders = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProviders = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBuscaProviders = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTelefoneProviders = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("CIDADE");

        jLabel1.setText("ENDERE??O");

        jLabel5.setText("NOME");

        jLabel8.setText("CELULAR");

        jLabel2.setText("CNPJ");

        jLabel6.setText("COMPLEMENTO");

        jLabel3.setText("CEP");

        jLabel7.setText("ESTADO");

        jLabel11.setText("URL DE SITE");

        jLabel9.setText("ID");

        jLabel10.setText("NUMERO DE ENDERE??O");

        jTProviders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CNPJ", "CELULAR", "TELEFONE FIXO", "CEP", "ENDERE??O", "N?? DE ENDERE??O", "COMPLEMENTO", "CIDADE", "ESTADO", "URL DO SITE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProviders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProvidersMouseClicked(evt);
            }
        });
        jTProviders.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProvidersKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProviders);

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

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtBuscaProviders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaProvidersActionPerformed(evt);
            }
        });

        jButton4.setText("Busca");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setText("TELEFONE FIXO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtNomeProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCnpjProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtEnderecoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtCidadeProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCepProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEstadoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComplementoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtSiteProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCelularProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtNumEnderecoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefoneProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(38, 38, 38)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)
                        .addGap(166, 166, 166)
                        .addComponent(txtBuscaProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton4)))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnpjProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCepProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnderecoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidadeProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplementoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSiteProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelularProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumEnderecoProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefoneProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscaProviders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(42, 42, 42)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void readJTable() throws SQLException {
        
        DefaultTableModel modelo = (DefaultTableModel) jTProviders.getModel();
        modelo.setNumRows(0);
        ProvidersDAO pdao = new ProvidersDAO();

        for (Providers p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getAddress(),
                p.getComplement(),
                p.getState(),
                p.getCity(),
                p.getCep(),
                p.getCnpj(),
                p.getCell_phone(),
                p.getFixed_phone(),
                p.getAddress_number(),
                p.getUrl_site()
            });
        }
    }
    
    
    public void readJTableForDesc(String desc) throws SQLException {
        
        DefaultTableModel modelo = (DefaultTableModel) jTProviders.getModel();
        modelo.setNumRows(0);
        ProvidersDAO pdao = new ProvidersDAO();

        for (Providers p : pdao.readForDesc(desc)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getCnpj(),
                p.getCell_phone(),
                p.getFixed_phone(),
                p.getCep(),
                p.getAddress(),
                p.getAddress_number(),
                p.getComplement(),
                p.getCity(),
                p.getState(),
                p.getUrl_site()
            });

        }
    }
    
    private void jTProvidersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProvidersMouseClicked
        if (jTProviders.getSelectedRow() != -1) {

            txtIdProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 1).toString());
            txtNomeProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 2).toString());
            txtCelularProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 3).toString());
            txtCnpjProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 4).toString());
            txtCepProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 5).toString());
            txtNumEnderecoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 6).toString());
            txtEstadoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 7).toString());
            txtCidadeProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 8).toString());
            txtComplementoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 9).toString());
            txtEnderecoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 10).toString());
            txtSiteProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 11).toString());
            txtTelefoneProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 12).toString()); 
        }
    }//GEN-LAST:event_jTProvidersMouseClicked

    private void jTProvidersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProvidersKeyReleased
        if (jTProviders.getSelectedRow() != -1) {

            txtIdProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 1).toString());
            txtNomeProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 2).toString());
            txtCelularProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 3).toString());
            txtCnpjProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 4).toString());
            txtCepProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 5).toString());
            txtNumEnderecoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 6).toString());
            txtEstadoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 7).toString());
            txtCidadeProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 8).toString());
            txtComplementoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 9).toString());
            txtEnderecoProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 10).toString());
            txtSiteProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 11).toString());
            txtTelefoneProviders.setText(jTProviders.getValueAt(jTProviders.getSelectedRow(), 12).toString()); 
        }
    }//GEN-LAST:event_jTProvidersKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTProviders.getSelectedRow() != -1) {

            try {

                Providers p = new Providers();
                ProvidersDAO dao = new ProvidersDAO();

                p.setId((int) jTProviders.getValueAt(jTProviders.getSelectedRow(), 0));

                dao.delete(p);

                txtIdProviders.setText("");
                txtNomeProviders.setText("");
                txtEnderecoProviders.setText("");
                txtComplementoProviders.setText("");
                txtEstadoProviders.setText("");
                txtCidadeProviders.setText("");
                txtCepProviders.setText("");
                txtCnpjProviders.setText("");
                txtCelularProviders.setText("");
                txtNumEnderecoProviders.setText("");
                txtSiteProviders.setText(""); 
                txtTelefoneProviders.setText("");  
                readJTable();

            } catch (SQLException ex) {
                Logger.getLogger(FProviders.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTProviders.getSelectedRow() != -1) {

            try {

                Providers p = new Providers();
                ProvidersDAO dao = new ProvidersDAO();

                p.setId(Integer.parseInt(txtIdProviders.getText()));
                p.setName(txtNomeProviders.getText());
                p.setCell_phone(txtCelularProviders.getText());
                p.setCnpj(txtCnpjProviders.getText());
                p.setCep(txtCepProviders.getText());
                p.setAddress_number(Integer.parseInt(txtNumEnderecoProviders.getText()));
                p.setState(txtEstadoProviders.getText());
                p.setCity(txtCidadeProviders.getText());
                p.setComplement(txtComplementoProviders.getText());
                p.setAddress(txtEnderecoProviders.getText());
                p.setUrl_site(txtSiteProviders.getText());
                p.setId((int) jTProviders.getValueAt(jTProviders.getSelectedRow(), 0));

                try {
                    dao.alter(p);
                } catch (SQLException ex) {
                    Logger.getLogger(FProviders.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FProviders.class.getName()).log(Level.SEVERE, null, ex);
                }

                txtIdProviders.setText("");
                txtNomeProviders.setText("");
                txtEnderecoProviders.setText("");
                txtComplementoProviders.setText("");
                txtEstadoProviders.setText("");
                txtCidadeProviders.setText("");
                txtCepProviders.setText("");
                txtCnpjProviders.setText("");
                txtCelularProviders.setText("");
                txtNumEnderecoProviders.setText("");
                txtSiteProviders.setText(""); 
                txtTelefoneProviders.setText("");  
                readJTable();

            } catch (SQLException ex) {
                Logger.getLogger(FProviders.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Providers p = new Providers();
            ProvidersDAO dao = new ProvidersDAO();

            p.setId(Integer.parseInt(txtIdProviders.getText()));
            p.setName(txtNomeProviders.getText());
            p.setCell_phone(txtCelularProviders.getText());
            p.setCnpj(txtCnpjProviders.getText());
            p.setCep(txtCepProviders.getText());
            p.setAddress_number(Integer.parseInt(txtNumEnderecoProviders.getText()));
            p.setState(txtEstadoProviders.getText());
            p.setCity(txtCidadeProviders.getText());
            p.setComplement(txtComplementoProviders.getText());
            p.setAddress(txtEnderecoProviders.getText());
            p.setUrl_site(txtSiteProviders.getText());
            dao.create(p);

            txtIdProviders.setText("");
            txtNomeProviders.setText("");
            txtEnderecoProviders.setText("");
            txtComplementoProviders.setText("");
            txtEstadoProviders.setText("");
            txtCidadeProviders.setText("");
            txtCepProviders.setText("");
            txtCnpjProviders.setText("");
            txtCelularProviders  .setText("");
            txtNumEnderecoProviders.setText("");
            txtSiteProviders.setText("");    
            txtTelefoneProviders.setText("");    
            readJTable();

        } catch (SQLException ex) {
            Logger.getLogger(FProviders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FProviders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscaProvidersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaProvidersActionPerformed
        jButton4.setEnabled(true);
    }//GEN-LAST:event_txtBuscaProvidersActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            readJTableForDesc(txtBuscaProviders.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FProviders.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(FProviders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FProviders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FProviders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FProviders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FProviders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProviders;
    private javax.swing.JTextField txtBuscaProviders;
    private javax.swing.JTextField txtCelularProviders;
    private javax.swing.JTextField txtCepProviders;
    private javax.swing.JTextField txtCidadeProviders;
    private javax.swing.JTextField txtCnpjProviders;
    private javax.swing.JTextField txtComplementoProviders;
    private javax.swing.JTextField txtEnderecoProviders;
    private javax.swing.JTextField txtEstadoProviders;
    private javax.swing.JTextField txtIdProviders;
    private javax.swing.JTextField txtNomeProviders;
    private javax.swing.JTextField txtNumEnderecoProviders;
    private javax.swing.JTextField txtSiteProviders;
    private javax.swing.JTextField txtTelefoneProviders;
    // End of variables declaration//GEN-END:variables
}
