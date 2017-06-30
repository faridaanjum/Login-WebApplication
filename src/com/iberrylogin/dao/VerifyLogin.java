package com.iberrylogin.dao;

import java.sql.*;

public class VerifyLogin {
    public static boolean validate(String name, String pass) {
        //This program validates the user id and password
    	boolean status = false;
    	try{
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farida", "root", "root");
    	/*Statement st=con.createStatement();
    	String s1="select * from userdetails where username=name ";
        ResultSet rs=st.executeQuery(s1);
        while(rs.next())
        {
        	if(rs.getString(1).equals(name)&&rs.getString(2).equals(pass)){
        		status=true;
        	}
        }*/
    	PreparedStatement pst=con.prepareStatement("select * from userdetails");
    	ResultSet rs=pst.executeQuery();
    	while(rs.next())
        {
        	if(rs.getString(1).equals(name)&&rs.getString(2).equals(pass)){
        		status=true;
        	}
        } 
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
        return status;
    }
}