/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ManageDeviceController.listInteraction;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Interaction;

/**
 * FXML Controller class
 *
 * @author joseb
 */
public class ActionDeviceController implements Initializable {

    @FXML
    private MenuButton menubtnDispositivos;
    @FXML
    private MenuItem itemGestionarDipositivos;
    @FXML
    private MenuButton menuBtnAction;
    @FXML
    private MenuButton menuBtnReport;
    @FXML
    private MenuButton menuBtnUser;
    @FXML
    private TableColumn colIdentify;
    @FXML
    private TableColumn colType;
    @FXML
    private TableColumn colName;
    @FXML
    private TableView<Interaction> tblListDevice;
    
    static ObservableList<Interaction> listInteraction = FXCollections.observableArrayList();;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Interaction interaction;

        ArrayList<String> list = new ArrayList<>();

        interaction = new Interaction(0, null, null, null, false, false);
        list = interaction.SearchForTable();

        int id = 1;
        for (int i = 1; i < list.size(); i++) {
            String copy = list.get(i);
            String[] tmp = copy.split(",");

            this.colIdentify.setCellValueFactory(new PropertyValueFactory("idDevice"));
            this.colType.setCellValueFactory(new PropertyValueFactory("typeDevice"));
            this.colName.setCellValueFactory(new PropertyValueFactory("nameDevice"));

            interaction = new Interaction(id, tmp[0], tmp[3], tmp[4], Boolean.parseBoolean(tmp[5]), Boolean.parseBoolean(tmp[6]));

            listInteraction.add(interaction);
            this.tblListDevice.setItems(listInteraction);
            id++;
        }
    }    

    @FXML
    private void clickManageDevice(ActionEvent event) {
    }
    
}
