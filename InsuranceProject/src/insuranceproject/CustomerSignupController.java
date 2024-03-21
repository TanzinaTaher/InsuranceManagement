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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class CustomerSignupController implements Initializable {

    @FXML
    private TextField firstname;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField age;
    @FXML
    private TextField dlno;
    @FXML
    private TextField address;
    @FXML
    private TextField lastname;
    @FXML
    private TextField nid;
    @FXML
    private Button submit;
    @FXML
    private Button goto_login;

    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;
    @FXML
    private TextField currentdate;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        currentdate.setText(dtf.format(now));
    }    
    
    @FXML
    private void submitbtn(ActionEvent event) throws SQLException {
         DBConnect dbc = new DBConnect();
        try {
          conn  = dbc.connectToDB();
        }  catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        String Firstname = firstname.getText();
        String Lastname = lastname.getText();
        String Agestr = age.getText();
        String NIDstr = nid.getText();
        String Address = address.getText();
        String Phone = phone.getText();
        String Email = email.getText();
        String Dl_nostr = dlno.getText();
        
        int Age = Integer.valueOf(Agestr);
        int NID = Integer.valueOf(NIDstr);
        int Dl_no = Integer.valueOf(Dl_nostr);
        
        
      
        String DateOfBirth = currentdate.getText();
        
        
        
        try{String query = "Insert into Customer(FirstName,LastName,NID,CurrentDate,Age,Address,"
                + "Phone,Email,DL_no) values(?,?,?,?,?,?,?,?,?)";
        
        pst = (PreparedStatement)conn.prepareStatement(query);
        pst.setString(1,Firstname);
        pst.setString(2,Lastname);
        pst.setInt(3, NID);
        pst.setString(4,DateOfBirth);
        pst.setInt(5, Age);
        pst.setString(6,Address);
        pst.setString(7,Phone);
        pst.setString(8,Email);
        pst.setInt(9,Dl_no);
        
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Submitted");
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
        }

    @FXML
    private void GotoLoginbtn(ActionEvent event) throws IOException {
        
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = (Stage)(Window)goto_login.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
    }
    
}

