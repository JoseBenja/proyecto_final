/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.Interaction;

/**
 * FXML Controller class
 *
 * @author joseb
 */
public class ModifyDeviceController implements Initializable {

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNameDevie;
    @FXML
    private CheckBox checkBtnVisible;
    @FXML
    private CheckBox checkBtnStatus;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {               
        this.txtEmail.setText(ManageDeviceController.newInteraction.getMail());
        this.txtNameDevie.setText(ManageDeviceController.newInteraction.getNameDevice());
        
        if (ManageDeviceController.newInteraction.isVisible() == true) {
            this.checkBtnVisible.setSelected(true);
        } else {
            this.checkBtnVisible.setSelected(false);
        }
        
        if (ManageDeviceController.newInteraction.isStatus() == true) {
            this.checkBtnStatus.setSelected(true);
        } else {
            this.checkBtnStatus.setSelected(false);
        }
    }    

    @FXML
    private void clickSave(ActionEvent event) {
        String typeDevice = ManageDeviceController.newInteraction.getTypeDevice();    
        int id = ManageDeviceController.newInteraction.getIdDevice();
        
        Interaction interaction = new Interaction(id, typeDevice, this.txtEmail.getText(), this.txtNameDevie.getText(), this.checkBtnVisible.isSelected(), this.checkBtnStatus.isSelected());
        
        interaction.ModifyDevice();
    }

    @FXML
    private void clickCancel(ActionEvent event) {
        
    }
}
