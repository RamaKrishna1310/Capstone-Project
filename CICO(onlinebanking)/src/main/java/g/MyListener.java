package g;
import javax.servlet.*;
import java.sql.*;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		int status=0;
		Connection con=null;
	
      try{
		con=GetCon.getCon();
		PreparedStatement ps1=con.prepareStatement("Select * from NEWACCOUNT");
		

      try{
		status=ps1.executeUpdate();
		}

      catch(Exception e)
		{e.printStackTrace();
		 status=2;
		 System.out.println("my staus is1111111"+status);
		 }		
		
       if(status==0)
		{System.out.println("your table name already exist"+status);}
		
         
       else if(status==2) 
		
        {System.out.println("else if part table does not exist new table has created"+status);
		
		PreparedStatement ps=con.prepareStatement("CREATE TABLE  NEWACCOUNT(ACCOUNTNO int not null auto_increment,USERNAME VARCHAR(40),PASSWORD VARCHAR(40),REPASSWORD VARCHAR(40),AMOUNT double(20, 5),ADDERESS VARCHAR(100),PHONE varchar(20),PRIMARY KEY (ACCOUNTNO))");
		ps.executeUpdate();
		
		
		
	
		}
		
		
		else{System.out.println("else part "+status);
		}}
	    catch(Exception e){e.printStackTrace();}
	    }
	    public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");
		
	}
}
