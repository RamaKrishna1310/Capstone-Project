package g;
import java.sql.*;

import g.GetCon;
public class RegisterUser {
static int status=0;

public static int register(String username,String password,String repassword,double amount,String adderess,String phone){
	
	Connection con=GetCon.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("Insert into NEWACCOUNT(USERNAME, PASSWORD, REPASSWORD, AMOUNT, ADDERESS, PHONE) values(?,?,?,?,?,?)");

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
