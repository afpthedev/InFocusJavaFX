/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Cyber Micro
 */
public class LoginController implements Initializable {

   
    @FXML
    private Label label_1;
    
    @FXML
    private TextField txtUsername;
     @FXML
    private TextField txtPassword;
      @FXML
    private Button btnSignİn;   
      @FXML
    private Button lblError;

    /**
     * Initializes the controller class.
     */
    public void HandleButtonAction(ActionEvent event){
        if(event.getSource()== label_1){
              System.exit(0);
        }
         if(event.getSource() == btnSignİn){
             //login burada
         } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private void LogIn(){
        String email = txtUsername.getText().toString();
         String password = txtPassword.getText().toString();
        // Sıralama ve taban login işlemi
         String sql = "SELECT * FROM users Where email = ? and password =  ? ";
         try{
          preparedStatement = con.prepareStatement(sql);
          preparedStatement.setString(1,email);
          preparedStatement.setString(2,password);
          resultSet = preparedStatement.executeQuery();
          if(!resultSet.next()){
                lblError.setText("Please Enter Corrret Email/Password");
          }else{
              showDialog("Login Succesfull !",null, "Succesfull");
          }
          
         }catch(Exception ex){
              
         }
      
         
    }
  private void showDialog(String info,String header,String title){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Login Succesfull");
        alert.setContentText(info);
       alert.setHeaderText(header);
       alert.showAndWait();
  }
 
    
}
