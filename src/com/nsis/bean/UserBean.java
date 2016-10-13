package com.nsis.bean;
public class UserBean {    
 private String login, password;       

 public UserBean(){      
  this.login = "anonyme";      
  this.password = "default";   
 }    

 public String getLogin() {      
  return login;   
 }    

 public void setLogin(String login) {      
  this.login = login;   
 }    

 public String getPassword() {      
  return password;   
 }    

 public void setPassword(String password) {    
  this.password = password;   
 }
}