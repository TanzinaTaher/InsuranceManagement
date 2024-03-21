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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class ApplyPolicy_1stStepController implements Initializable {

    @FXML
    private TableColumn<ApplyPolicy_1stTable,String> customerid;
    @FXML
    private TableColumn<ApplyPolicy_1stTable,String> vehicleid;
    @FXML
    private TableColumn<ApplyPolicy_1stTable,String> vehiclename;
    @FXML
    private TableColumn<ApplyPolicy_1stTable,String> vehicletype;
    @FXML
    private TableColumn<ApplyPolicy_1stTable,String> vehiclelicense;
    @FXML
    private TableColumn<ApplyPolicy_1stTable,String> vehicleissuedate;
    @FXML
    private Button selectrow;
    @FXML
    private TextField customeridselect;
    @FXML
    private TextField vehicleidselect;
    @FXML
    private TextField vehiclenameselect;
    @FXML
    private TextField vehicletypeselect;
    @FXML
    private TextField vehiclelicenseselect;
    @FXML
    private TextField vehicleissuedateselect;

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;
    
    ObservableList<ApplyPolicy_1stTable> oblist  = FXCollections.observableArrayList();
    String Customerid_get;
    @FXML
    private TableView<ApplyPolicy_1stTable> table;
    
    ApplyPolicy_1stTable ApplyPolicy_1stTable;
    @FXML
    private Button next;
    /**
     * Initializes the controller class.
     */
    
    public static int Vehicleid_get = 0;
    public static String VehicleType_get = "";
    @FXML
    private Button back;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Customerid_get = CustomerPageController.CustomerIdFromLogin;
                
        DBConnect dbc = new DBConnect();
        try {
            conn = dbc.connectToDB();
        }  catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        String query = "select* from Vehicle where Customerid='"+Customerid_get+"'";
        
        
        try {
            rs = conn.createStatement().executeQuery(query);
            
            while(rs.next())
            {
             
                
             oblist.add(new ApplyPolicy_1stTable(
             
             rs.getInt("Customerid"),rs.getInt("Vehicleid"),
             rs.getString("VehicleName"),rs.getString("VehicleType"),rs.getString("VehicleLicense"),rs.getString("VehicleIssueDate")
                     
             ));
                
                
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
        
        
        
        
        
        customerid.setCellValueFactory(new PropertyValueFactory<>("Customerid"));
        vehicleid.setCellValueFactory(new PropertyValueFactory<>("Vehicleid"));
        vehiclename.setCellValueFactory(new PropertyValueFactory<>("VehicleName"));
        vehicletype.setCellValueFactory(new PropertyValueFactory<>("VehicleType"));
        vehiclelicense.setCellValueFactory(new PropertyValueFactory<>("VehicleLicense"));
        vehicleissuedate.setCellValueFactory(new PropertyValueFactory<>("VehicleIssueDate"));
        
        table.setItems(oblist);
        
        
        
        
    }    

    @FXML
    private void RowSelection(ActionEvent event) {
        
      ApplyPolicy_1stTable = table.getSelectionModel().getSelectedItem();
      int customeridint = ApplyPolicy_1stTable.getCustomerid();
      String customeridstring = Integer.toString(customeridint);
      
      
      int vehicleidint  = ApplyPolicy_1stTable.getVehicleid();
      String vehicleidstring = Integer.toString(vehicleidint);
      
      Vehicleid_get = vehicleidint;
      VehicleType_get = ApplyPolicy_1stTable.getVehicleType();
      
      
      customeridselect.setText(customeridstring);
      vehicleidselect.setText(vehicleidstring);
      vehiclenameselect.setText(ApplyPolicy_1stTable.getVehicleName());
      vehicletypeselect.setText(ApplyPolicy_1stTable.getVehicleType());
      vehiclelicenseselect.setText(ApplyPolicy_1stTable.getVehicleLicense());
      vehicleissuedateselect.setText(ApplyPolicy_1stTable.getVehicleIssueDate());
      
        
    }

    @FXML
    private void Next(ActionEvent event) throws IOException {
        
        
                Parent root = FXMLLoader.load(getClass().getResource("ApplyPolicy_2ndStep.fxml"));
                Stage stage = (Stage)(Window)next.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
        
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
                
                Parent root = FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
                Stage stage = (Stage)(Window)back.getScene().getWindow();
                Scene scene = new Scene(root);
        
                stage.setScene(scene);
                stage.show();
        
    }
    
}

