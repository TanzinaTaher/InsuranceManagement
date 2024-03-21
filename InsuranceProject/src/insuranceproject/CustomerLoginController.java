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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class CustomerLoginController implements Initializable {

    @FXML
    private TextField firstname;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private Button login;

    int flag = 0;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;
    @FXML
    private Button back;
    
    
    public static String EmailFromLogin = "";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginBtn(ActionEvent event) throws SQLException, IOException {
        
        DBConnect dbc = new DBConnect();
        try {
            conn = dbc.connectToDB();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        String FirstName = firstname.getText();
        String Phone = phone.getText();
        String Email = email.getText();
        
        
        String query = "select* from Customer ";
        rs = conn.createStatement().executeQuery(query);
        
        String FirstNamedb = "";
        String Phonedb = "";
        String Emaildb = "";
        
        while(rs.next())
        {
            FirstNamedb = rs.getString("FirstName");
            Phonedb = rs.getString("Phone");
            Emaildb = rs.getString("Email");
            
            
            if((FirstName.equals(FirstNamedb)) && (Phone.equals(Phonedb)) && (Email.equals(Emaildb)) )
            {
                EmailFromLogin = Emaildb;
                flag=1;
                break;
                
            }

            
           
        }
        
        if(flag==1)
        {
                Parent root = FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
                Stage stage = (Stage)(Window)login.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Data Mismatched");
        }
        
    }

    @FXML
    private void BackBtn(ActionEvent event) throws IOException {
        
                Parent root = FXMLLoader.load(getClass().getResource("Insurance.fxml"));
                Stage stage = (Stage)(Window)back.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
        
    }
    
}
