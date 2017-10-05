package com.example.wen.hibernatepackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
    try{
    	String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
    	String user = "hbstudent";
    	String pass = "hbstudent";
    	System.out.println("connection to db");
    	conn = DriverManager.getConnection(jdbcurl,user,pass);
    	System.out.println("connection granted");
    	conn.close();
    }catch (Exception e){
    	e.printStackTrace();
    }finally{
    	
    }
	}

}
