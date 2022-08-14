package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {


    public TextField txtUserName;
    public AnchorPane LoginFormContext;

    static String username;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        username=txtUserName.getText();

        Stage stage1 = (Stage) txtUserName.getScene().getWindow();
        stage1.close();
        Stage stage2=new Stage();
        stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ServerForm.fxml"))));
        stage2.setResizable(false);
        stage2.setTitle("sample title");
        stage2.centerOnScreen();
        stage2.show();
    }
}
