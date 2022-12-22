package com.velocity.quiz;

public class ResultClass {
		
	private String grade;
	
	public String getResultClass(int score) {
		
		if(score<=10 && score> 8) {
			System.out.println("Grade A");
		}else if (score <=8 && score >=6) {
			System.out.println("Grade B");
		}else if (score == 5) {
			System.out.println("Grade C");
		}else if (score < 5 ) {
			System.out.println("Grade D");
		}else {
			System.out.println("Invalid Input");
		}
		
		
		
		return grade;
	}
}
