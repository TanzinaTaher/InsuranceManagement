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
public class CustomerPageController implements Initializable {

    @FXML
    private TextField customerid;
    @FXML
    private TextField firstname;
    @FXML
    private TextField nid;
    @FXML
    private TextField dlno;

    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;
    @FXML
    private TextField issuedate;
    @FXML
    private TextField email;
    
    
    public static String CustomerIdFromLogin = "";
    @FXML
    private Button vehiclego;
    @FXML
    private Button logout;
    @FXML
    private Button Applyforpolicy;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         DBConnect dbc = new DBConnect();
        try {
            conn = dbc.connectToDB();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        
        
        String query = "select* from Customer where Email='"+CustomerLoginController.EmailFromLogin+"'";
        try {
            rs = conn.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            while(rs.next())
            {
                CustomerIdFromLogin = rs.getString("Customerid");
                
                 firstname.setText(rs.getString("FirstName"));
                 nid.setText(rs.getString("NID"));
                 customerid.setText(rs.getString("Customerid"));
                 dlno.setText(rs.getString("DL_no"));
                 issuedate.setText(rs.getString("CurrentDate"));
                 email.setText(rs.getString("Email"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ApplyForVehicle(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("ApplyingVehicle.fxml"));
                Stage stage = (Stage)(Window)vehiclego.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void LogOutbtn(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("Insurance.fxml"));
                Stage stage = (Stage)(Window)logout.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void ApplyForPolicy(ActionEvent event) throws IOException {
        
                Parent root = FXMLLoader.load(getClass().getResource("ApplyPolicy_1stStep.fxml"));
                Stage stage = (Stage)(Window)Applyforpolicy.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
}

