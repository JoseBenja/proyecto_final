package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Headphone;
import model.Interaction;
import model.SmartPhone;

/**
 * FXML Controller class
 *
 * @author joseb
 */
public class NewDeviceController implements Initializable {

    @FXML
    private ChoiceBox<String> menuBtnTypeDevice;;
    @FXML
    private CheckBox checkBtnVisible;
    @FXML
    private CheckBox checkBtnStatus;
    @FXML
    private Button btnSaveDevice;
    @FXML
    private Button btnCancelDevice;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNameDevice;
    @FXML
    private TextField txtPhoneNumber;

    private ObservableList<Interaction> interaction;
    private ObservableList list = FXCollections.observableArrayList();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalData();
    }

    public void LocalData() {
        String device1 = "Computadora Portatil";
        String device2 = "Tablet";
        String device3 = "SmartWatch";
        String device4 = "SmartPhone";
        String device5 = "Auriculares Inalambricos";

        this.list.addAll(device1, device2, device3, device4, device5);

        this.menuBtnTypeDevice.getItems().addAll(list);
    }

    @FXML
    private void clickSelectTypeDevice(MouseEvent event) {
    }
    
    @FXML
    private void clickVisible(ActionEvent event) {

    }

    @FXML
    private void clickStatus(ActionEvent event) {
    }

    @FXML
    private void clickSave(ActionEvent event) {
        if (!this.menuBtnTypeDevice.getValue().equals("SmartPhone") && !this.menuBtnTypeDevice.getValue().equals("Auriculares Inalambricos") && this.menuBtnTypeDevice.getValue() != null) {
            Interaction interaction = new Interaction(0, this.menuBtnTypeDevice.getValue(), this.txtEmail.getText(), this.txtNameDevice.getText(), this.checkBtnVisible.isSelected(), this.checkBtnStatus.isSelected());
            interaction.NewDevice();
        } else {/*else if (this.menuBtnTypeDevice.getValue().equals("SmartPhone")) {
            SmartPhone smartPhone = new SmartPhone(0, this.menuBtnTypeDevice.getValue(), this.txtEmail.getText(), this.txtNameDevice.getText(), this.checkBtnVisible.isSelected(), this.txtPhoneNumber.getText(), this.checkBtnStatus.isSelected());
            smartPhone.NewSmartphone();
        } else if (this.menuBtnTypeDevice.getValue().equals("Auriculares Inalambricos")) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NewDeviceHeadPhoneView.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnSaveDevice.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            System.out.println("Error " + e);
        }
            Headphone headPhone = new Headphone(0, this.menuBtnTypeDevice.getValue(), this.txtEmail.getText(), this.txtNameDevice.getText(), this.checkBtnVisible.isSelected(), null, this.checkBtnStatus.isSelected());
        } */
        
            System.out.println("No se pudo crear el dispositivo");
        
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ManageDeviceView.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnSaveDevice.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void clickCancel(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ManageDeviceView.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnCancelDevice.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

}
