package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class StudentMainPro {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	intro();
	
	//view();
	//insert();
	//delete();
	//edit();
	//view();
	//Step: 1
	Class.forName("com.mysql.cj.jdbc.Driver");
	Scanner s1=new Scanner(System.in);
	while(true) {
		intro();
		System.out.println("======================================");
		
	
	//step: 2
	// view the record
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url, "root", "12345");
	
	int choice;
	System.out.println("enter your choice:");
	choice=s1.nextInt();
	switch(choice)
	{
	case 1:
		System.out.println("********************************");
		System.out.println("*    *   INSERT RECORD   *        *");
		System.out.println("********************************");
		insert();
	break;
	case 2:
		System.out.println("********************************");
		System.out.println("*    *   EDIT RECORD   *        *");
		System.out.println("********************************");
		edit();
	break;
	case 3:
		System.out.println("********************************");
		System.out.println("*    *   VIEW RECORD   *        *");
		System.out.println("********************************");
		view();
	break;
	case 4:
		System.out.println("********************************");
		System.out.println("*    *   DELETE RECORD   *        *");
		System.out.println("********************************");
		delete();
	break;
	case 5:System.exit(0);
	
	default: System.out.println("invalid choice!!!!!!!!!!!");
	}
	}
}
	public static void insert() throws SQLException {
		Scanner s=new Scanner(System.in);

		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url, "root", "12345");
		System.out.println("Enter your name:  ");
		String n=s.nextLine();
		System.out.println("enter your class:");
		String c=s.nextLine();
		System.out.println("enter ur father name:");
		String f=s.nextLine();
		System.out.println("enter ur mobile no:");
		String m=s.nextLine();
		
		String query="insert into student_info (name,std,fname,mobile) " + "value (?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, n);
		ps.setString(2, c);
		ps.setString(3, f);
		ps.setString(4, m);
		
		ps.executeUpdate();
		System.out.println("Data inserted successfully.....");
		
		
	}
	public static void view() throws SQLException {
		String url1="jdbc:mysql://localhost:3306/sms_db";
		Connection con1=DriverManager.getConnection(url1, "root", "12345");

		Statement st=con1.createStatement();
		ResultSet rs=st.executeQuery("select * from student_info");
		System.out.println("ID | Name | std | father | Mobile");
		System.out.println("____________________________________");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ " | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5));
		}
		
	}

public static void intro() 
{
		System.out.println("**********************************");
		System.out.println("*        Students module        *");
		System.out.println("***********************************");
		System.out.println("\n 1.  Insert");
		System.out.println(" 2. Edit");
		System.out.println(" 3. View");
		System.out.println(" 4. Delete");
		System.out.println(" 5. Stop");
	}
	
public static void edit() throws SQLException

 {
	Scanner s=new Scanner(System.in);
	String url4="jdbc:mysql://localhost:3306/sms_db";
	Connection con4=DriverManager.getConnection(url4, "root", "12345");
	String query="UPDATE student_info SET Name = ?, std = ?, fname= ?, mobile=? WHERE (id =?);";
	view();
	PreparedStatement ps=con4.prepareStatement(query);
	System.out.println("enter id:");
	int i=s.nextInt();
	System.out.println("enter Name:");
	s.nextLine();
	String n=s.nextLine();
	System.out.println("enter your class:");
	String c=s.nextLine();
	System.out.println("enter ur father name:");
	String f=s.nextLine();
	System.out.println("enter ur mobile no:");
	String m=s.nextLine();
	
	
	ps.setString(1, n);
	ps.setString(2, c);
	ps.setString(3, f);
	ps.setString(4, m);
	ps.setInt(5, i);
	ps.executeUpdate();
	System.out.println("Data edited successfully.....");
	view();

}
public static void delete() throws SQLException {
	String url2="jdbc:mysql://localhost:3306/sms_db";
	Connection con2=DriverManager.getConnection(url2, "root", "12345");
	String query="DELETE FROM student_info WHERE id=?";
	PreparedStatement ps=con2.prepareStatement(query);
	Scanner s=new Scanner(System.in);
	System.out.println("SELECT ID to DELETE:");
	int id=s.nextInt();
	ps.setInt(1, id);
	ps.executeUpdate();
	System.out.println("data deleted successfully");
view();
	
}

}
