package DatabaseManager;


import BeanClasses.GymBean;
import BeanClasses.PaymentBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


//package DatabaseManager;

public class DatabaseManager {
   

    
    //gym connection starts
	private static Connection con;
    
	static{
		try{
			init();
		}catch(Exception e){
		}
	}
	private static void init()throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:gym");
                System.out.println("Connection succesfull");
	}// gym connection ends
        

	public static int addNewMember(String name,String fName,String gender,String age,String mobile,String amount,String addmissionDate,String timing,String address,String email,String remarks)throws Exception{
	    if(addmissionDate.trim().equals(""))
                addmissionDate=null;
            else
                addmissionDate="#"+addmissionDate+"#";	
            String query="INSERT into NewMember (name,fathersname,gender,age,mobile,amount,addmission_date,timing,address,email,remarks) values ('"+name+"','"+fName+"','"+gender+"','"+age+"','"+mobile+"','"+amount+"',"+addmissionDate+",'"+timing+"','"+address+"','"+email+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
    public static Vector getNewMember()throws Exception{
                Vector v=new Vector();
		String query="select * from NewMember";
		System.out.println(query);
		
                PreparedStatement st=con.prepareStatement(query);
		ResultSet result=st.executeQuery();
		try{
			
			
			
			while(result.next()){
				GymBean bean=new GymBean();	
				bean.setMemberId( result.getInt("memberId") );
				bean.setName( result.getString("name") );
                                bean.setfName( result.getString("fathersname") );
                                bean.setGender( result.getString("gender") );
                                bean.setAge( result.getString("age") );
                                bean.setMobile( result.getString("mobile") );
                                bean.setAmount( result.getString("amount") );
                                bean.setAddmissionDate( result.getDate("addmission_date") );
                                bean.setTiming( result.getString("timing") );
                                bean.setAddress( result.getString("address") );
                                bean.setEmail( result.getString("email") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}        

	public static int deleteMember(int memberId)throws Exception{
		String query="DELETE from NewMember where memberId="+memberId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}

	public static int updateMember(int memberId,String name,String fName,String gender,String age,String mobile,String amount,String addmissionDate,String timing,String address,String email,String remarks)throws Exception{
             if(addmissionDate.trim().equals(""))
                  addmissionDate=null;
            else
                addmissionDate="#"+addmissionDate+"#";
            String query="UPDATE NewMember set name='"+name+"' , fathersname ='"+fName+"', gender='"+gender+"', age='"+age+"' , mobile='"+mobile+"' , amount='"+amount+"',addmission_date="+addmissionDate+" , timing='"+timing+"', address='"+timing+"',email='"+email+"' , remarks='"+remarks+"' where memberId="+memberId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
	
   //subint.karbi@outlook.com 1111
    public static Vector getPayment(int memberId)throws Exception{
                Vector v=new Vector();
		String query="select * from payment where memberId="+memberId;
		System.out.println(query);
		
                PreparedStatement st=con.prepareStatement(query);
		ResultSet result=st.executeQuery();
		try{
			
			
			
			while(result.next()){
				PaymentBean bean=new PaymentBean();	
				bean.setMemberId( result.getInt("memberId") );
				bean.setPaymentId( result.getInt("payment_id") );
                                bean.setPaymentMonth( result.getDate("payment_month") );
                                bean.setPaymentAmount( result.getString("payment_amount") );
				bean.setRemarks( result.getString("remarks") );			
				v.addElement(bean);
			}
			return v;
		}finally{
			if(result!=null)result.close();
			if(st!=null)st.close();
		}
	}      
	public static int addPayment(int memberId,String paymentMonth,String paymentAmount,String remarks)throws Exception{
	    if(paymentMonth.trim().equals(""))
                paymentMonth=null;
            else
                paymentMonth="#"+paymentMonth+"#";	
            String query="INSERT into payment (memberId,payment_month,payment_amount,remarks) values ("+memberId+","+paymentMonth+",'"+paymentAmount+"','"+remarks+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}    
	public static int deletePayment(String paymentId)throws Exception{
		String query="DELETE from payment where payment_id="+paymentId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	} 
	public static int updatePayment(int memberId,String paymentId,String paymentMonth,String paymentAmount,String remarks)throws Exception{
             if(paymentMonth.trim().equals(""))
                  paymentMonth=null;
            else
                paymentMonth="#"+paymentMonth+"#";
            String query="UPDATE payment set memberId="+memberId+", payment_month="+paymentMonth+" , payment_amount ='"+paymentAmount+"'  , remarks='"+remarks+"' where payment_id="+paymentId;
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}        

       public static PaymentBean getPaymentById(String paymentId){
        
            PaymentBean bean = null;
            ResultSet result = null;
            try{
                
                String query = "select * from payment where payment_id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, paymentId);
                
                result = pstmt.executeQuery();
                
                if(result.next()){
                    bean= new PaymentBean();
                                bean=new PaymentBean();	
				bean.setMemberId( result.getInt("memberId") );
				bean.setPaymentId( result.getInt("payment_id") );
                                bean.setPaymentMonth( result.getDate("payment_month") );
                                bean.setPaymentAmount( result.getString("payment_amount") );
				bean.setRemarks( result.getString("remarks") );
                }
                
                
            }catch(Exception e){
            
                e.printStackTrace();
                
            }
         return bean;   
 }     
        
        
}
     