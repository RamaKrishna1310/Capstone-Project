package g;
import java.sql.*;

import g.GetCon;
public class RegisterUser {
static int status=0;
//int accountno=1;
public static int register(String username,String password,String repassword,double amount,String adderess,String phone){
	//public static int register(String email,String password,String gender,String country,String name){

	Connection con=GetCon.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("Insert into NEWACCOUNT(USERNAME, PASSWORD, REPASSWORD, AMOUNT, ADDERESS, PHONE) values(?,?,?,?,?,?)");
//		int	nextvalue1=GetCon.getPrimaryKey();
		//ps.setInt(1,null);
		ps.setString(1,username);
		ps.setString(2,password);
		ps.setString(3,repassword);
		ps.setDouble(4,amount);
		ps.setString(5,adderess);
		ps.setString(6,phone);
		
		status=ps.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return status;
	
}
}
