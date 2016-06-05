package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.model.User;


public class UserInfoController {


    @FXML
    private Button button;

    //names
    @FXML
    private Label idLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label phoneLabel;

    //values
    @FXML
    private Label idValueLabel;

    @FXML
    private Label phoneValueLabel;

    @FXML
    private Label usernameValueLabel;


    private Stage dialogStage;

    private User user;


    @FXML
    private void initialize() {
        button.setOnAction((e) -> handleOKAction(e));
    }

    public void setStage(Stage stage) {
        dialogStage = stage;
    }

    public void setUser(User user) {
        this.user = user;
        idValueLabel.setText(String.valueOf(user.getId()));
        phoneValueLabel.setText(String.valueOf(user.getPhone()));
        usernameValueLabel.setText(user.getUsername());
    }

    @FXML
    private void handleOKAction(ActionEvent e) {
        dialogStage.close();
    }
}
