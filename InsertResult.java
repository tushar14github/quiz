package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertResult {
			
	public void getInsertResult(String firstname ,String lastname,int score)
{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
			
			PreparedStatement ps = cons .prepareStatement("insert into resultInfo (firstname,lastname,score) values (?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setInt(3, score);
			
			ps.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		}
}
