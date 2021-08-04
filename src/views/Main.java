
package views;

import Config.Conexion;
import Config.ModelRoles;
import Entities.Roles;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JApplet { 
    
    Connection cn  = Conexion.getConnection();
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    String name;   
    
    @Override
    public void init() {
        
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    //setLocationRelativeTo(null);
                    InsertRols();
                    FillRoles(0);
                    ListUser("");
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnQuery = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtQrName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox<>();
        opcYes = new javax.swing.JRadioButton();
        opcNo = new javax.swing.JRadioButton();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();

        jLabel1.setText("GESTION DE USUARIOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametros de Búsqueda"));
        jPanel1.setToolTipText("");
        jPanel1.setName("Parametros"); // NOI18N

        btnQuery.setText("CONSULTAR");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });

        btnClear.setText("LIMPIAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel6.setText("NOMBRE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtQrName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de usuarios"));
        jPanel2.setName("Lista"); // NOI18N

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_usuario", "rolnombre", "nombre", "activo", "id_rol"
            }
        ));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);
        if (dataTable.getColumnModel().getColumnCount() > 0) {
            dataTable.getColumnModel().getColumn(3).setMinWidth(50);
            dataTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            dataTable.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        btnCreate.setText("CREAR");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de usuario"));
        jPanel3.setName("Info"); // NOI18N

        jLabel2.setText("ID");

        btnSave.setText("GUARDAR");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setText("EDITAR");
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("ELIMINAR");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("NOMBRE");

        jLabel4.setText("ROL");

        jLabel5.setText("ACTIVO");

        cbxRol.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                cbxRolComponentMoved(evt);
            }
        });
        cbxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolActionPerformed(evt);
            }
        });

        group.add(opcYes);
        opcYes.setText("SI");
        opcYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcYesActionPerformed(evt);
            }
        });

        group.add(opcNo);
        opcNo.setText("NO");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(opcYes)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(opcNo))
                                        .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxRol))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(opcYes)
                    .addComponent(opcNo))
                .addContainerGap())
        );

        btnExit.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(143, 143, 143)
                .addComponent(btnExit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        ClearFields();
        btnSave.setEnabled(true);
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        FindName();
    }//GEN-LAST:event_btnQueryActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        ClearFields(); 
    }//GEN-LAST:event_btnClearActionPerformed

    private void cbxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       SaveUser();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxRolComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cbxRolComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolComponentMoved

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        int row=dataTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "...User not selected!.....");
        }else{
          int id_usuario = Integer.parseInt((String)dataTable.getValueAt(row,0).toString());  
          int id_rol = Integer.parseInt((String)dataTable.getValueAt(row,4).toString()); 
          String option = (String)dataTable.getValueAt(row, 3).toString();
          name = (String)dataTable.getValueAt(row, 2);
          FillRoles(id_rol);
          txtId.setText(""+id_usuario);
          txtName.setText(""+name);
          if(option.equals("SI")){
              opcYes.setSelected(true);
          }else{
              opcNo.setSelected(true);
          }
          btnEdit.setEnabled(true);
          btnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_dataTableMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       EditUser();
       ListUser("");
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeleteUser();
        ClearData();
        ListUser("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void opcYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcYesActionPerformed
    
    private void ClearFields(){
        txtQrName.setText("");
        txtId.setText("");
        txtName.setText("");  
        FillRoles(0);
        ListUser("");
    }
    
    private void SaveUser(){
        String name = txtName.getText();
        int rolId = cbxRol.getItemAt(cbxRol.getSelectedIndex()).getId_rol();
        String activeOption = "";
        
        if (opcYes.isSelected()){
            activeOption=opcYes.getText();
        }
        else if (opcNo.isSelected()){
            activeOption=opcNo.getText();
        }
        if(name.equals("")||activeOption.equals("")){
            JOptionPane.showMessageDialog(null,"...Empty fields !!!...");
        }else{
            
            String sql="INSERT INTO usuario (nombre,id_rol,activo) VALUES (' "+name+" ',' "+rolId+" ','"+activeOption+"');";
            try{
                if ( this.ValideteUser(name) ){
                    st=cn.createStatement();
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "User Successfull created!!");
                    ClearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "User already exist!!");
                }
                
            }
            catch(Exception e){                            
                System.out.println(e);
            }  finally {
                 try {st.close();} catch(Exception e){}
                 try {rs.close();} catch(Exception e){}
                 try {cn.close();} catch(Exception e){}
            }  
        }  
    }
    
    private boolean ValideteUser(String nameUser) throws SQLException{
        String sql = "SELECT COUNT(*) FROM usuario WHERE nombre ='"+nameUser+"'";
             try{
                int countResult=0;
                st=cn.createStatement();
                rs=st.executeQuery(sql);
                if(rs.next()){
                    countResult=rs.getInt(1);            
                }
                if (countResult == 0){
                    return true;
                }else{
                    return false;  
                }
            }
            catch (Exception e){ 
               System.out.println(e);
                return false;
            }
    }  
    
    private void FillRoles(int idRol ){
        ModelRoles modRoles = new ModelRoles();
        ArrayList <Roles> listRoles=modRoles.getRoles();
        
        cbxRol.removeAllItems(); 
        int index = 0;
        for(int i=0;i<listRoles.size();i++){
           if ( idRol == listRoles.get(i).getId_rol() ){
               index = i;
           }
            cbxRol.addItem(new Roles(listRoles.get(i).getId_rol(), listRoles.get(i).getNombre()));
        }
        cbxRol.setSelectedIndex(index);
    }
    
    private void DeleteUser(){
        int selectRow=dataTable.getSelectedRow();
        int id_user = Integer.parseInt(txtId.getText());
        if(selectRow == -1){
            JOptionPane.showMessageDialog(null, "...You must select a row!...");
        }else{
            String sql="DELETE  FROM usuario where id_usuario = '"+id_user+"';";
            try{
                st=cn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "....User sucessfull deleted!.....");
            }
            catch(Exception e){
                System.out.println(e);                   
            }
        }
    }
    
    private void EditUser(){
        int id_user = Integer.parseInt(txtId.getText());
        int rolId = cbxRol.getItemAt(cbxRol.getSelectedIndex()).getId_rol();
        String activeOption = "";
        
        if (opcYes.isSelected()){
            activeOption=opcYes.getText();
        }
        else if (opcNo.isSelected()){
            activeOption=opcNo.getText();
        }
        String nombre = txtName.getText();
        String sql="UPDATE usuario SET nombre='"+nombre+"', id_rol='"+rolId+"',activo='"+activeOption+"' WHERE id_usuario = '"+id_user+"'";

         if(name.equals(" ")){
             JOptionPane.showMessageDialog(null, "...You must to write some name!....");
         }else{
             try{
                 st=cn.createStatement();
                 st.executeUpdate(sql);
                 JOptionPane.showMessageDialog(null, "....User sucessfull Updated!.....");
             }
             catch (Exception e){
                 System.out.println(e);
             }
         }

    }
    
    private void ClearData(){
      for(int i=0;i<dataTable.getRowCount();i++){
          modelo.removeRow(i);
          i = i -1;
      }  
    }
    
    private void FindName(){
      String nameToFind = txtQrName.getText();
      ListUser(nameToFind);   
    } 
    
    private void InsertRols(){
        String count = "SELECT count(*) AS count FROM octans_proyect.rol ;";        
        String sql="INSERT INTO rol (nombre) VALUES ('ADMINISTRADOR'),('AUDITOR'),('AUXILIAR')";
                
         try{
            int countResult=0;
            st=cn.createStatement();
            rs=st.executeQuery(count);
            if(rs.next()){
            countResult=rs.getInt(1);            
            }
            if (countResult == 0){
                st.executeUpdate(sql);
                System.out.println("...Roles inserted sussefully...");
            }else{
                System.out.println("...Roles already exist in database..."); 
            }     
         }
         catch (Exception e){
             System.out.println(e);
         }
    }
    
    private void ListUser(String x){
        ClearData();
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        String sql;   
        sql = "SELECT u.*, r.nombre AS rolnombre FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id_rol WHERE u.nombre LIKE '%"+x+"%' ORDER BY id_usuario ASC";
        
        try{
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]usuario=new Object[5];
            modelo = (DefaultTableModel)dataTable.getModel();
            while (rs.next()){
                    usuario[0]=rs.getInt("id_usuario");
                    usuario[1]=rs.getString("rolnombre");
                    usuario[2]=rs.getString("nombre");
                    usuario[3]=rs.getString("activo");
                    usuario[4]=rs.getInt("id_rol");
                    
                    modelo.addRow(usuario);
             }
            dataTable.setModel(modelo);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Roles> cbxRol;
    private javax.swing.JTable dataTable;
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opcNo;
    private javax.swing.JRadioButton opcYes;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQrName;
    // End of variables declaration//GEN-END:variables

