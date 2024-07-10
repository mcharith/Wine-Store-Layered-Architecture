package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.util.Regex;

import java.sql.SQLException;

public class AddNewCusFormController {
    public AnchorPane cPane;
    public TextField txtCusId;
    public TextField txtCusName;
    public TextField txtCusAddress;
    public TextField txtCusTele;
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    public void btnAddNewOnAction(ActionEvent actionEvent) {
        String cusId = txtCusId.getText();
        String cusName = txtCusName.getText();
        String address = txtCusAddress.getText();
        String telephone = txtCusTele.getText();

        if(isValid()) {
            try {
                boolean isSaved = customerBO.addCustomer(new CustomerDTO(cusId,cusName,address,telephone));
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved!!!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isValid() {
        if(!Regex.setTextColour(lk.ijse.util.TextField.CONTACT,txtCusTele))return false;
        return true;
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    private void clearFields(){
        txtCusId.setText("");
        txtCusName.setText("");
        txtCusAddress.setText("");
        txtCusTele.setText("");
    }

    public void txtTelephoneOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(lk.ijse.util.TextField.CONTACT,txtCusTele);
    }
}
