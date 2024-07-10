package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RegisterBO;
import lk.ijse.dto.RegisterDTO;
import lk.ijse.util.Regex;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationFormController {

    public TextField txtFname;
    public TextField txtLname;
    public TextField txtEmail;
    public TextField txtUserId;
    public TextField txtPw;
    public AnchorPane node;
    RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTER);
    public void btnRegisterOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        String UserId = txtUserId.getText();
        String Fname = txtFname.getText();
        String Lname = txtLname.getText();
        String Email = txtEmail.getText();
        String Pw = txtPw.getText();
        if(isValid()) {
            RegisterDTO register = new RegisterDTO(UserId, Fname, Lname, Email, Pw);
            try {
                boolean isSaved = registerBO.addNewUser(register);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    private void clearFields() {
        txtUserId.setText("");
        txtFname.setText("");
        txtEmail.setText("");
        txtLname.setText("");
        txtPw.setText("");
    }

    private boolean isValid() {
        if ((!Regex.setTextColour(lk.ijse.util.TextField.ID,txtUserId)))return false;
        if(!Regex.setTextColour(lk.ijse.util.TextField.EMAIL,txtEmail))return false;
        return true;
    }
    public void txtEmailOnKeyReleased(KeyEvent keyEvent) {
       Regex.setTextColour(lk.ijse.util.TextField.EMAIL,txtEmail);
    }

    public void txtUserIdOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(lk.ijse.util.TextField.ID,txtUserId);
    }

    public void pfPasswordOnKeyReleased(KeyEvent keyEvent) {
    }

    public void linkLoginOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage)this.node.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");
    }

}
