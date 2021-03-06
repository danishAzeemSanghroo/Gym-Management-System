/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.GymBean;
import DatabaseManager.DatabaseManager;
import EnDeCoder.Decoder;
import EnDeCoder.Encoder;
import javax.swing.JOptionPane;

/**
 *
 * @author Danish
 */
public class UpdateAndDelete extends javax.swing.JFrame {

    /**
     * Creates new form NewMember
     */
    public UpdateAndDelete() {
        initComponents();
        getNewMember();
    }
    private void getNewMember(){
	try{
		java.util.Vector v=DatabaseManager.getNewMember();		
                membersList.setListData(v);
	}catch(Exception e){
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}    
    
    }
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
*/
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
        memberIdLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        memberIdTextField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        fathersNameLabel = new javax.swing.JLabel();
        fathersNameTextField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        mobileLabel = new javax.swing.JLabel();
        mobileTextField = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        addmissionDateLabel = new javax.swing.JLabel();
        timingLabel = new javax.swing.JLabel();
        timingTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addmissionDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersList = new javax.swing.JList();
        updateButton = new javax.swing.JButton();

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update & delete member.png"))); // NOI18N
        jLabel2.setText("Update and delete");

        memberIdLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        memberIdLabel.setForeground(new java.awt.Color(0, 118, 221));
        memberIdLabel.setText("Member ID: ");

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 118, 221));
        nameLabel.setText("Name");

        memberIdTextField.setEditable(false);
        memberIdTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        memberIdTextField.setForeground(new java.awt.Color(0, 118, 221));

        genderComboBox.setBackground(new java.awt.Color(0, 118, 221));
        genderComboBox.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        genderComboBox.setForeground(new java.awt.Color(0, 118, 221));
        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "Others" }));

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

        nameTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        nameTextField.setForeground(new java.awt.Color(0, 118, 221));

        fathersNameLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        fathersNameLabel.setForeground(new java.awt.Color(0, 118, 221));
        fathersNameLabel.setText("Father's Name");

        fathersNameTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        fathersNameTextField.setForeground(new java.awt.Color(0, 118, 221));

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(0, 118, 221));
        genderLabel.setText("Gender");

        ageLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ageLabel.setForeground(new java.awt.Color(0, 118, 221));
        ageLabel.setText("Age");

        ageTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ageTextField.setForeground(new java.awt.Color(0, 118, 221));

        mobileLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        mobileLabel.setForeground(new java.awt.Color(0, 118, 221));
        mobileLabel.setText("Mobile#");

        mobileTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        mobileTextField.setForeground(new java.awt.Color(0, 118, 221));

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(0, 118, 221));
        amountLabel.setText("Amount");

        amountTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        amountTextField.setForeground(new java.awt.Color(0, 118, 221));

        addmissionDateLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        addmissionDateLabel.setForeground(new java.awt.Color(0, 118, 221));
        addmissionDateLabel.setText("Addmission Date");

        timingLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        timingLabel.setForeground(new java.awt.Color(0, 118, 221));
        timingLabel.setText("Timing");

        timingTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        timingTextField.setForeground(new java.awt.Color(0, 118, 221));

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(0, 118, 221));
        addressLabel.setText("Address");

        addressTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        addressTextField.setForeground(new java.awt.Color(0, 118, 221));
        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 118, 221));
        emailLabel.setText("Email");

        emailTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(0, 118, 221));

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        remarksLabel.setForeground(new java.awt.Color(0, 118, 221));
        remarksLabel.setText("Remarks");

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        remarksTextArea.setForeground(new java.awt.Color(0, 118, 221));
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        addmissionDateChooser.setForeground(new java.awt.Color(0, 118, 221));
        addmissionDateChooser.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        membersList.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        membersList.setForeground(new java.awt.Color(0, 112, 221));
        membersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                membersListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(membersList);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 118, 221));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_20.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobileLabel)
                            .addComponent(mobileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(memberIdLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(memberIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameLabel)
                                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addmissionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addmissionDateLabel))
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fathersNameLabel)
                                            .addComponent(jLabel2)
                                            .addComponent(fathersNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ageLabel)
                                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(amountLabel)
                                            .addComponent(timingLabel)
                                            .addComponent(timingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailLabel)
                                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderLabel)
                                    .addComponent(remarksLabel)
                                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(197, 197, 197))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(memberIdLabel)
                            .addComponent(memberIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nameLabel)
                                            .addComponent(fathersNameLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fathersNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(55, 55, 55)
                                        .addComponent(genderLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ageLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mobileLabel)
                                    .addComponent(amountLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mobileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(addmissionDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addmissionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(timingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addComponent(remarksLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton))))
                .addContainerGap(59, Short.MAX_VALUE))
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
        deleteMember();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clear();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateMember();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFieldActionPerformed

    private void membersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_membersListValueChanged
   GymBean bean=(GymBean)membersList.getSelectedValue();
   if(bean==null)return;

                memberIdTextField.setText( ""+bean.getMemberId());
                nameTextField.setText( bean.getName());
                fathersNameTextField.setText( bean.getfName());
                ageTextField.setText( bean.getAge());
                mobileTextField.setText( bean.getMobile());
                amountTextField.setText( bean.getAmount());
                addmissionDateChooser.setDate( bean.getAddmissionDate());
                timingTextField.setText( bean.getTiming());
                addressTextField.setText( bean.getAddress());
                emailTextField.setText( bean.getEmail());
                remarksTextArea.setText( bean.getRemarks()); 
    }//GEN-LAST:event_membersListValueChanged

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
            java.util.logging.Logger.getLogger(UpdateAndDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAndDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAndDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAndDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAndDelete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser addmissionDateChooser;
    private javax.swing.JLabel addmissionDateLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel fathersNameLabel;
    private javax.swing.JTextField fathersNameTextField;
    private javax.swing.JComboBox genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel memberIdLabel;
    private javax.swing.JTextField memberIdTextField;
    private javax.swing.JList membersList;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField mobileTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel timingLabel;
    private javax.swing.JTextField timingTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
