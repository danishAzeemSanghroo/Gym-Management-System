/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.GymBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danish
 */
public class ListOfMembers extends javax.swing.JFrame {

    /**
     * Creates new form NewMember
     */
    public ListOfMembers() {
        initComponents();
        getNewMember();
    }
    /*
private  void getDefaulterList(){
 
        
    String dateOfIssue1=dateTextField.getText();
    String dateOfIssue2=toTextField.getText();
          
    
    try{
        Vector v = DatabaseManager.getDefaulterList(dateOfIssue1,dateOfIssue2);

        
        //disply in JTable
        DefaultTableModel model=(DefaultTableModel)defaulterListTable.getModel();
                    clear();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   BookIssueBean bean= (BookIssueBean)v.elementAt(i);
//                   Object[] obj={bean.getRollNo(), bean.getName(),bean.getFname(),bean.getSurname(),bean.getBookTitle(),bean.getAuthor(),bean.getPublisher(),bean.getPrice()};
                    vector = new Vector();
                     vector.addElement(bean.getRollNo());
                     vector.addElement(bean.getName());
                     vector.addElement(bean.getFname());
                     vector.addElement(bean.getSurname());
                     vector.addElement(bean.getBookTitle());
                     vector.addElement(bean.getAuthor());
                     vector.addElement(bean.getPublisher());
                     vector.addElement(bean.getPrice());
                     
                     model.addRow(vector);
                     
                }   
    }catch(Exception e)
    {
        
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    }    
    
}    
    
*/    
    private void getNewMember(){
	try{
		java.util.Vector v=DatabaseManager.getNewMember();		
        //disply in JTable
        DefaultTableModel model=(DefaultTableModel)membersTable.getModel();
                    clear();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   GymBean bean= (GymBean)v.elementAt(i);

                    vector = new Vector();
                     vector.addElement(bean.getMemberId());
                     vector.addElement(bean.getName());
                     vector.addElement(bean.getfName());
                     vector.addElement(bean.getGender());
                     vector.addElement(bean.getAge());
                     vector.addElement(bean.getMobile());
                     vector.addElement(bean.getAmount());
                     vector.addElement(bean.getAddmissionDate());
                     vector.addElement(bean.getTiming());
                     vector.addElement(bean.getAddress());
                     vector.addElement(bean.getEmail());
                     vector.addElement(bean.getRemarks());
                     
                     model.addRow(vector);
                     
                }  
	}catch(Exception e){
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}    
    
    }
private void clear(){
    DefaultTableModel model=(DefaultTableModel)membersTable.getModel();
    while(model.getRowCount()>0){
        for(int i=0;i<model.getRowCount();++i){
            model.removeRow(i);
        }
    }
}    
/*
private void deleteMember(){
    int rows = 0;
    
    Object obj[]=(Object[])membersList.getSelectedValues();
    for(int i=0; i<obj.length;i++){
        GymBean bean = (GymBean)obj[i];
  
    try{
        rows += DatabaseManager.deleteMember(bean.getMemberId());
    }catch(Exception e){
            e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }//Exception end
    }//Loop end
             if(rows>=1){
           javax.swing.JOptionPane.showMessageDialog(this,rows+"Record Removed.");
           getNewMember();
           clear();
           }
}//end seatlist

private void updateMember(){
    int rows = 0;
    Object obj[] = (Object[])membersList.getSelectedValues();
    for(int i = 0; i<obj.length; i++){
        GymBean bean = (GymBean)obj[i];
        
    String name=nameTextField.getText();
    String fName=fathersNameTextField.getText();
    String gender=(String) genderComboBox.getSelectedItem();
    String age=ageTextField.getText();
    String mobile=mobileTextField.getText();
    String amount=amountTextField.getText();
    String addmissionDate=Decoder.getDateFormat(addmissionDateChooser.getDate());    
    String timing=timingTextField.getText();
    String address=addressTextField.getText();
    String email=emailTextField.getText();
    String remarks=remarksTextArea.getText();  
  
     try{
	 rows += DatabaseManager.updateMember(bean.getMemberId(),name,fName,gender,age,mobile,amount,addmissionDate,timing,address,email,remarks);
        }catch(Exception e){
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
     } 
    }
	if(rows>=1){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	    getNewMember();
	    clear();
        	}
}    
    
 /*   
    
    private void addNewMember(){
    String name=nameTextField.getText();
    String fName=fathersNameTextField.getText();
    String gender=(String) genderComboBox.getSelectedItem();
    String age=ageTextField.getText();
    String mobile=mobileTextField.getText();
    String amount=amountTextField.getText();
    String addmissionDate=Decoder.getDateFormat(addmissionDateChooser.getDate());    
    String timing=timingTextField.getText();
    String address=addressTextField.getText();
    String email=emailTextField.getText();
    String remarks=remarksTextArea.getText();

    try{
               	int rows=DatabaseManager.addNewMember(name,fName,gender,age,mobile,amount,addmissionDate,timing,address,email,remarks);
	if(rows>=1){
	        	javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted."); 
		clear();						
	}
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}   //end

    private void clear()
    {
    memberIdTextField.setText("");
    nameTextField.setText("");
    fathersNameTextField.setText("");
    ageTextField.setText("");
    mobileTextField.setText("");
    amountTextField.setText("");
    addmissionDateChooser.setDate(null);
    timingTextField.setText("");
    addressTextField.setText("");
    emailTextField.setText("");
    remarksTextArea.setText("");    
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        membersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2000, 1000));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2000, 1000));
        jPanel1.setMinimumSize(new java.awt.Dimension(2000, 1000));
        jPanel1.setPreferredSize(new java.awt.Dimension(2000, 1000));

        jLabel1.setForeground(new java.awt.Color(0, 118, 221));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close-icon_20.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 118, 221));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/list of members.png"))); // NOI18N
        jLabel2.setText("List of members");

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(0, 118, 221));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete111_1_20.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resetButton.setForeground(new java.awt.Color(0, 118, 221));
        resetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset-images_2_16.jpg"))); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 118, 221));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_20.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        membersTable.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        membersTable.setForeground(new java.awt.Color(0, 112, 221));
        membersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member ID", "Name", "F.Name", "Gender", "Age", "Mobile", "Amount", "Addmission Date", "Timing", "Address", "Email", "Remarks"
            }
        ));
        jScrollPane3.setViewportView(membersTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(533, 533, 533)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 498, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(197, 197, 197))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
   
            setVisible(false);
            new Home().setVisible(true);
       
    }//GEN-LAST:event_jLabel1MouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       // deleteMember();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        //clear();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        //updateMember();
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ListOfMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfMembers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfMembers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable membersTable;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
