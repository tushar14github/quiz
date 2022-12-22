package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question {
	 
	private String firstname;
	private String lastname;
	private int score;
	
	public void getQuestion() throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet =null;
		Scanner scanner = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject" , "root","root");
			ps =connection.prepareStatement("select * from questionlist order by rand() limit 10 ");
			
			for(int i =1;i<=2;i++) {
				resultSet = ps.executeQuery();
				scanner = new Scanner(System.in);
				
				System.out.println("Enter your First name > ");
				firstname = scanner.next();
				
				System.out.println("Enter your Last Name > ");
				lastname = scanner.next();
				score = 0;
				while(resultSet.next()) {
					System.out.println("Question No>> "+resultSet.getInt(1));
					System.out.println("Question>> "+resultSet.getString(2));
					System.out.println("Option A>> "+resultSet.getString(3));
					System.out.println("Option B>> " +resultSet.getString(4));
					System.out.println("Option c>> " +resultSet.getString(5));
					System.out.println("Option D>> " +resultSet.getString(6));
					
					
					System.out.println("Enter the answer>> ");
					String ans = scanner.next();
					
					if(ans.equalsIgnoreCase("A") || ans.equalsIgnoreCase("B") || ans.equalsIgnoreCase("C") || ans.equalsIgnoreCase("D") ) 
					{
						if(ans.equalsIgnoreCase(resultSet.getString(7))) {
							score++;
						}
					}else {
						try {
							throw new InvalidInputException("Your Enter the Invalid Answer...Please try again...");
						}catch(Exception e) {
							System.out.println(e);
						}
					}
					
				}
				System.out.println("Your Name is>> " + firstname + "" + lastname);
				System.out.println("Your Score is>> " + score);
				ResultClass resultClass = new ResultClass();
				resultClass.getResultClass(score);
				
				
				InsertResult insertResult = new  InsertResult();
				insertResult.getInsertResult(firstname, lastname, score);
				
			}
			
			}catch (Exception e) {
				e.printStackTrace();
		}
		
	}
}	
	
	 
	
	
	
	

