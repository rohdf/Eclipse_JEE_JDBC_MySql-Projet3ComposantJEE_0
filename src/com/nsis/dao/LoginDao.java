package com.nsis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javafx.fxml.LoadException;

public class LoginDao {
 public static boolean validate(String identifiant, String motDePasse){
  boolean status = false;
  Connection conn = null;
  PreparedStatement pst = null;
  ResultSet rs = null;

  try {

   Class.forName("org.postgresql.Driver");

   Properties props = new Properties();
   props.setProperty("user", "tom");
   props.setProperty("password", "tom");

   String bd = "dblogin";
   String url = "jdbc:postgresql://localhost:5432/" + bd;

   conn = DriverManager.getConnection(url, props);

   pst = conn
     .prepareStatement("select * from utilisateur where identifiant=? and motdepasse=?");
   pst.setString(1, identifiant);
   pst.setString(2, motDePasse);

   rs = pst.executeQuery();

   status = rs.next();

   System.out.println("status" + status);

  } catch (Exception e) {
   e.printStackTrace();
	   try {
		throw new LoadException();
		} catch (LoadException e1) {
			e1.printStackTrace();
		}
  } finally {
   if (conn != null) {
    try {
     conn.close();
    } catch (SQLException e) {
     e.printStackTrace();
    }
   }
   if (pst != null) {
    try {
     pst.close();
    } catch (SQLException e) {
     e.printStackTrace();
    }
   }
   if (rs != null) {
    try {
     rs.close();
     
    } catch (SQLException e) {
     e.printStackTrace();
    }
   }
  }
  return status;
 }
}