/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Diyanada Gunawardhan
 */
public class DbConnection {
    
    private Connection _Connection = null;
    
    DbConnection(){
        
        String Driver = "com.mysql.jdbc.Driver";
        String DataBase = "jdbc:mysql://localhost:3306/test";
        String UserName = "root";
        String Password = "";
        
        try{
            
            Class.forName(Driver);
            this._Connection = DriverManager.getConnection(DataBase, UserName, Password);
            
        }
        catch(ClassNotFoundException ex){
            
            JOptionPane.showMessageDialog(null, "JDBC Driver is not found");
            System.out.println(ex.toString());
            
        } 
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Database not found");
            System.out.println(ex.toString());
            
        }
    }
    
    public void Execute(String Query){
        
        Statement _Statement;
        
        try{
            
            _Statement = this._Connection.createStatement();
            _Statement.executeUpdate(Query);
        }
        catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Incorrect Query");
            System.out.println(ex.toString());
        }
    }
    
    public ResultSet GetData(String Query){
        
        Statement _Statement;
        ResultSet _ResultSet = null;
        
        try{
            
            _Statement = this._Connection.createStatement();
            _ResultSet = _Statement.executeQuery(Query);
            
        }
        catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Incorrect Query");
            System.out.println(ex.toString());
        }
        
        return _ResultSet;
    }
}
