/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insuranceproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private Button gotologin; 
    @FXML
    private Button gotosignup;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        

    }    
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;

/*
    private void submit(ActionEvent event) throws SQLException {
        
       DBConnect dbc = new DBConnect();
        try {
          conn  = dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsuranceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        String Username = username.getText();
        String Phone = phone.getText();
        String Email = email.getText();
        String Address = address.getText();
        
       String query = "Insert into Info(UserName,Phone,Email,Address) values(?,?,?,?)";
       
       //boolean datainserted = dbc.insertDataToDB(query);
        pst = (PreparedStatement)conn.prepareStatement(query);
        pst.setString(1,Username);
        pst.setString(2,Phone);
        pst.setString(3,Email);
        pst.setString(4,Address);
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Submitted");
        
    }
*/
  /*  private void SeeTable(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ShowData.fxml"));
        Stage stage = (Stage)(Window)seetable.getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
*/


    @FXML
    private void GOTOLOGIN(ActionEvent event) throws IOException {
        
         
        Parent root = FXMLLoader.load(getClass().getResource("CustomerLogin.fxml"));
        Stage stage = (Stage)(Window)gotologin.getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void GOTOSIGNUP(ActionEvent event) throws IOException {
        
      
        
        Parent root = FXMLLoader.load(getClass().getResource("CustomerSignup.fxml"));
        Stage stage = (Stage)(Window)gotosignup.getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
    

}

