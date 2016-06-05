package project.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import project.Main;
import project.exception.ServerException;
import project.model.User;


import java.util.List;

/**
 * Created by Daniel Shchepetov on 05.06.2016.
 */
public class TableViewController {




    @FXML
    public Button saveButton;
    @FXML
    private TableView<User> personTable;
    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, Integer> phoneColumn;

    @FXML
    private TableColumn<User, User> infoColumn;

    @FXML
    private TableColumn<User, User> removeColumn;

    @FXML
    private TableColumn<User, User> editColumn;


    @FXML
    private Label idLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label phoneLabel;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField phoneField;


    private ObservableList<User> observableList;
    // Ссылка на главное приложение.
    private Main main;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public TableViewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        observableList = FXCollections.observableArrayList();

       saveButton.setOnAction((e) -> {
           handleSaveButtonAction(e);
       });


        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());

        infoColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue()));
        removeColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue()));
        editColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue()));

        infoColumn.setCellFactory(param -> new TableCell<User, User>() {

            final ImageView buttonGraphic = new ImageView("/view/info.png");
            final Button button = new Button("info", buttonGraphic);
            {
                button.setMinSize(20,20);

            }

            @Override
            protected void updateItem(User user, boolean flag) {
                super.updateItem(user, flag);
                if (user != null) {
                    setGraphic(button);
                    button.setOnAction(e -> main.showUserInfo(user));
                } else {
                    setGraphic(null);
                }
            }
        });


        removeColumn.setCellFactory(param -> new TableCell<User, User>() {

            final ImageView buttonGraphic = new ImageView("/view/remove.png");
            final Button button = new Button("remove", buttonGraphic);
            {
                button.setMinSize(20,20);

            }

            @Override
            protected void updateItem(User user, boolean flag) {
                super.updateItem(user, flag);
                if (user != null) {
                    setGraphic(button);
                    button.setOnAction(e -> {
                        try {
                            main.getUserService().delete(user.getId());
                            List<User> refreshItems = main.getUserService().getAll();
                            observableList.clear();
                            observableList.addAll(refreshItems);
                        } catch (ServerException ex) {
                            main.showAlertWarningDialog("This user cannot be removed");
                            ex.printStackTrace();
                        }
                    });
                } else {
                    setGraphic(null);
                }
            }
        });

        editColumn.setCellFactory(param -> new TableCell<User, User>() {

            final ImageView buttonGraphic = new ImageView("/view/edit.png");
            final Button button = new Button("edit", buttonGraphic);
            {
                button.setMinSize(20,20);

            }

            @Override
            protected void updateItem(User user, boolean flag) {
                super.updateItem(user, flag);
                if (user != null) {
                    setGraphic(button);
                    button.setOnAction(e -> {
                        main.showUserEdit(user, observableList);
                    });
                } else {
                    setGraphic(null);
                }
            }
        });


        personTable.setItems(observableList);
    }



    @FXML
    private void handleSaveButtonAction(ActionEvent e) {
        try {
            checkItem(usernameField.getText(), phoneField.getText());
            User newUser = new User(usernameField.getText(), Integer.parseInt(phoneField.getText()));
            observableList.add(main.getUserService().create(newUser));
            usernameField.clear();
            phoneField.clear();
        } catch (ServerException | RuntimeException e1) {
            main.showAlertWarningDialog(e1.getMessage());
        }
    }



    private void update() {
        try {
            List<User> userList = main.getUserService().getAll();
            observableList.clear();
            observableList.addAll(userList);

        } catch (ServerException e) {
            main.showAlertWarningDialog(e.getMessage());
        }
        personTable.setItems(observableList);
    }



    private void checkItem(String name, String phone) {
        if (name == null || name.isEmpty()|| phone == null || phone.isEmpty()) {
            throw new RuntimeException("Username and phone cannot be empty");
        }
        if (Integer.parseInt(phone)<0){
            throw new IllegalArgumentException("Phone is not valid");
        }
    }


    public void setMainApp(Main main) {
        this.main = main;
        update();
    }

}