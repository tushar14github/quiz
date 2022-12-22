package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Result {
	
	
	static Connection cons =null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	public static void getResult() throws Exception{
		try {
			 cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
			 ps = cons.prepareStatement("select * from resultInfo order by Std_Id");
			 rs =ps.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("Your Student Id is -" +rs.getInt(1));
				System.out.println("Your Full Nmae is  -" +rs.getString(2)+""+rs.getString(3));
				System.out.println("Your score is -" +rs.getInt(4));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			cons.close();
			ps.close();
			rs.close();
		}
		
	}
	

}
