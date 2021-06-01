/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Interaction;
import database.ManageData;
import database.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author joseb
 */
public class ManageDeviceController implements Initializable {

    @FXML
    private MenuButton menubtnDispositivos;
    @FXML
    private MenuItem itemGestionarDipositivos;
    @FXML
    private Button btnDeleteDevice;
    @FXML
    private Button btnNewDevice;
    @FXML
    private TableColumn colIdentify;
    @FXML
    private TableColumn colType;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colEmail;
    @FXML
    private TableColumn colStatus;
    @FXML
    private TableView<Interaction> tblListDevice;
    @FXML
    private TextField txtSelectDevice;
    @FXML
    private Button btnModify;

    static ObservableList<Interaction> listInteraction = FXCollections.observableArrayList();
    static ObservableList<Interaction> tblList = FXCollections.observableArrayList();

    static int selectDevice;

    static Interaction newInteraction;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {               
        ManageData md = new ManageData();
        Conection conection = new Conection(); 
        
        Connection conn = conection.getConnection();
        
        listInteraction = md.searchTable(conn);

        this.colIdentify.setCellValueFactory(new PropertyValueFactory("idDevice"));
        this.colType.setCellValueFactory(new PropertyValueFactory("typeDevice"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory("mail"));
        this.colName.setCellValueFactory(new PropertyValueFactory("nameDevice"));
        this.colStatus.setCellValueFactory(new PropertyValueFactory("status"));

        this.tblListDevice.setItems(listInteraction);
    }

    @FXML
    private void clickManageDevice(ActionEvent event) {
    }

    @FXML
    private void clickNewDevice(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NewDeviceView.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnNewDevice.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickDeleteDevice(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DeleteDeviceView.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickModify(ActionEvent event) {
        this.deviceSelect();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ModifyDeviceView.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deviceSelect() {
        selectDevice = Integer.parseInt(this.txtSelectDevice.getText());
        selectDevice--;

        newInteraction = new Interaction(listInteraction.get(selectDevice).getIdDevice(), listInteraction.get(selectDevice).getTypeDevice(), listInteraction.get(selectDevice).getMail(), listInteraction.get(selectDevice).getNameDevice(), listInteraction.get(selectDevice).isVisible(), listInteraction.get(selectDevice).isStatus());

    }

}
