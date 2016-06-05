package project.controller;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.Main;
import project.exception.ServerException;
import project.model.User;

import java.util.List;


public class UserEditController {

    @FXML
    private Label usernameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label idLabel;

    @FXML
    private Text idText;

    @FXML
    private Button saveButton;


    private Stage dialogStage;


    private ObservableList<User> userList;

    //Edited Item
    private User user;

    private Main main;

    @FXML
    private void initialize() {
        saveButton.setOnAction(this::handleSaveButtonAction);
    }


    public void setUser(User user, ObservableList<User> userList) {
        this.user = user;
        this.userList = userList;
        idText.setText(String.valueOf(user.getId()));
        usernameField.setText(user.getUsername());
        phoneField.setText(String.valueOf(user.getPhone()));
    }


    public void setStage(Stage stage) {
        dialogStage = stage;
    }


    @FXML
    private void handleSaveButtonAction(ActionEvent e) {

        try {
            checkItem(usernameField.getText(), phoneField.getText());

            User newUser = new User(usernameField.getText(), Integer.parseInt(phoneField.getText()));

            user = main.getUserService().update(user.getId(), newUser);

            List<User> refreshList = main.getUserService().getAll();
            userList.clear();
            userList.addAll(refreshList);

        } catch (ServerException e1) {
            main.showAlertWarningDialog(e1.getMessage());
            e1.printStackTrace();
        } finally {
            dialogStage.close();
        }
    }


    public void setMainApp(Main main) {
        this.main = main;
    }


    private void checkItem(String name, String phone) {
        if (name == null || name.isEmpty()|| phone == null || phone.isEmpty()) {
            throw new RuntimeException("Username and phone cannot be empty");
        }
        if (Integer.parseInt(phone)<0){
            throw new IllegalArgumentException("Phone is not valid");
        }
    }


}
