/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.GymBean;
import BeanClasses.PaymentBean;
import DatabaseManager.DatabaseManager;
import EnDeCoder.Decoder;
import EnDeCoder.Encoder;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danish
 */
public class Payment extends javax.swing.JFrame {

    /**
     * Creates new form NewMember
     */
    public Payment() {
        initComponents();
        getNewMember();
    }
    private void getNewMember(){
	try{
		java.util.Vector v=DatabaseManager.getNewMember();		
		membersComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			membersComboBox.addItem(v.elementAt(i));
	}catch(Exception e){
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}    
    }

    private void getPayment(){
        GymBean gymBean=(GymBean)membersComboBox.getSelectedItem();
        if(gymBean==null)return;
	try{
		java.util.Vector v=DatabaseManager.getPayment(gymBean.getMemberId());		
        //disply in JTable
        DefaultTableModel model=(DefaultTableModel)paymentTable.getModel();
                    clearTable();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   PaymentBean bean= (PaymentBean)v.elementAt(i);

                    vector = new Vector();
                    String paymentMonth=Decoder.getDateFormat(bean.getPaymentMonth());
                     vector.addElement(bean.getPaymentId());
                     vector.addElement(paymentMonth);
                     vector.addElement(bean.getPaymentAmount());
                     vector.addElement(bean.getRemarks());
                     
                     model.addRow(vector);
                     
                }  
	}catch(Exception e){
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}    
    
    }
private void clearTable(){
    DefaultTableModel model=(DefaultTableModel)paymentTable.getModel();
    while(model.getRowCount()>0){
        for(int i=0;i<model.getRowCount();++i){
            model.removeRow(i);
        }
    }
}    

    private void addPayment(){
        GymBean gymBean=(GymBean)membersComboBox.getSelectedItem();
        if(gymBean==null)return;        

    String paymentMonth=Decoder.getDateFormat(paymentDateChooser.getDate());    
    String paymentAmount=paymentAmountTextField.getText();
    String remarks=remarksTextArea.getText();

    try{
               	int rows=DatabaseManager.addPayment(gymBean.getMemberId(),paymentMonth,paymentAmount,remarks);
	if(rows>=1){
	        	javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted."); 
		clear();
                getPayment();
	}
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}   //end
private void deletePayment(){
     int row =paymentTable.getSelectedRow();
     String paymentId=paymentTable.getModel().getValueAt(row, 0).toString();
    try{
           int rows = DatabaseManager.deletePayment(paymentId);
           if(rows>=1){
           javax.swing.JOptionPane.showMessageDialog(this,rows+" Rrecord Removed.");
           getPayment();
           clear();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }
}   
private void updatePayment(){
        GymBean gymBean=(GymBean)membersComboBox.getSelectedItem();
        if(gymBean==null)return;        

    String paymentMonth=Decoder.getDateFormat(paymentDateChooser.getDate());    
    String paymentAmount=paymentAmountTextField.getText();
    String remarks=remarksTextArea.getText();        
        
     int row =paymentTable.getSelectedRow();
     String paymentId=paymentTable.getModel().getValueAt(row, 0).toString();
     
     try{
	int rows=DatabaseManager.updatePayment(gymBean.getMemberId(),paymentId,paymentMonth,paymentAmount,remarks);
	if(rows>=1){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	    getPayment();
	    clear();
        	}
     }catch(Exception e){
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
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
 */   
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
 
    ageTextField.setText("");
    mobileTextField.setText("");
    amountTextField.setText("");
    addmissionDateChooser.setDate(null);
    timingTextField.setText("");
    addressTextField.setText("");
    emailTextField.setText("");
    
    paymentIdTextField.setText("");
    paymentDateChooser.setDate(null);
    paymentAmountTextField.setText("");
    
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
        nameLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
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
        updateButton = new javax.swing.JButton();
        membersComboBox = new javax.swing.JComboBox();
        ageLabel1 = new javax.swing.JLabel();
        paymentIdTextField = new javax.swing.JTextField();
        addmissionDateLabel1 = new javax.swing.JLabel();
        paymentDateChooser = new com.toedter.calendar.JDateChooser();
        amountLabel1 = new javax.swing.JLabel();
        paymentAmountTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/payment.png"))); // NOI18N
        jLabel2.setText("payment");

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 118, 221));
        nameLabel.setText("Members");

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
        amountLabel.setText("Addmission Amount");

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

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 118, 221));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_20.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        membersComboBox.setBackground(new java.awt.Color(0, 118, 221));
        membersComboBox.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        membersComboBox.setForeground(new java.awt.Color(0, 118, 221));
        membersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersComboBoxActionPerformed(evt);
            }
        });

        ageLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ageLabel1.setForeground(new java.awt.Color(0, 118, 221));
        ageLabel1.setText("Payment ID");

        paymentIdTextField.setEditable(false);
        paymentIdTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        paymentIdTextField.setForeground(new java.awt.Color(0, 118, 221));

        addmissionDateLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        addmissionDateLabel1.setForeground(new java.awt.Color(0, 118, 221));
        addmissionDateLabel1.setText("Payment Month");

        paymentDateChooser.setForeground(new java.awt.Color(0, 118, 221));
        paymentDateChooser.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        amountLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        amountLabel1.setForeground(new java.awt.Color(0, 118, 221));
        amountLabel1.setText("Payment Amount");

        paymentAmountTextField.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        paymentAmountTextField.setForeground(new java.awt.Color(0, 118, 221));

        paymentTable.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        paymentTable.setForeground(new java.awt.Color(0, 112, 221));
        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Month", "Amount", "Remarks"
            }
        ));
        paymentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(paymentTable);

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 118, 221));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save-button-icon_1_5.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(644, 644, 644)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(769, 769, 769)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addComponent(nameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(membersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(amountLabel)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(genderLabel)
                                                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(ageLabel)
                                                                .addGap(92, 92, 92))
                                                            .addComponent(ageTextField)))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(timingLabel)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                            .addComponent(timingTextField))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(emailLabel)
                                                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(9, 9, 9))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(mobileLabel))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addressLabel)
                                        .addComponent(addmissionDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addmissionDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addressTextField))
                                    .addComponent(mobileTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(remarksLabel)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(paymentAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amountLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addmissionDateLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(paymentDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ageLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(paymentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(197, 197, 197))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderLabel)
                            .addComponent(ageLabel)
                            .addComponent(mobileLabel))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel)
                            .addComponent(membersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addmissionDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addmissionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(amountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(timingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ageLabel1)
                            .addComponent(paymentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addmissionDateLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(amountLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(remarksLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
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
        deletePayment();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clear();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updatePayment();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFieldActionPerformed

    private void membersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersComboBoxActionPerformed
        getPayment();
    }//GEN-LAST:event_membersComboBoxActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        addPayment();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void paymentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentTableMouseClicked
     int row =paymentTable.getSelectedRow();
     String paymentId=paymentTable.getModel().getValueAt(row, 0).toString();
             
     PaymentBean bean=DatabaseManager.getPaymentById(paymentId);
      
    paymentIdTextField.setText(""+bean.getPaymentId());
    paymentDateChooser.setDate(bean.getPaymentMonth());
    paymentAmountTextField.setText(bean.getPaymentAmount());
    
    remarksTextArea.setText(bean.getRemarks()); 
    }//GEN-LAST:event_paymentTableMouseClicked

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser addmissionDateChooser;
    private javax.swing.JLabel addmissionDateLabel;
    private javax.swing.JLabel addmissionDateLabel1;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel ageLabel1;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel amountLabel1;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox membersComboBox;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField mobileTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField paymentAmountTextField;
    private com.toedter.calendar.JDateChooser paymentDateChooser;
    private javax.swing.JTextField paymentIdTextField;
    private javax.swing.JTable paymentTable;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel timingLabel;
    private javax.swing.JTextField timingTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
