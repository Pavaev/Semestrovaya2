package project;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.controller.MainLayoutController;
import project.controller.TableViewController;
import project.controller.UserEditController;
import project.controller.UserInfoController;
import project.model.User;
import project.service.UserService;

public class Main extends Application {

    private UserService userService;

    private Stage stage;
    private BorderPane mainLayout;
    private ObservableList<User> personData = FXCollections.observableArrayList();
    private boolean isView;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        userService = new UserService();
        this.stage = stage;
        this.stage.setTitle("My App");
        initRootLayout();
        showTable();
    }


    public void initRootLayout() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainLayout.fxml"));
        try {
            mainLayout = loader.load();
            stage.setResizable(false);
            Scene scene = new Scene(mainLayout);
            stage.setScene(scene);
            stage.show();
            MainLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTable() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/MainPane.fxml"));
            AnchorPane tableView = loader.load();
            mainLayout.setCenter(tableView);
            TableViewController controller = loader.getController();
            controller.setMainApp(this);
           isView = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void showUserEdit(User user, ObservableList<User> userList) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/UserEdit.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            UserEditController controller = loader.getController();
            controller.setStage(dialogStage);
            controller.setUser(user, userList);
            controller.setMainApp(this);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAlertWarningDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!!");
        alert.setHeaderText(message);
        alert.initOwner(stage);
        alert.showAndWait();
    }


    public void about() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/About.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("About");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showUserInfo(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/UserInfo.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Info");
            dialogStage.initOwner(stage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            UserInfoController controller = loader.getController();
            controller.setStage(dialogStage);
            controller.setUser(user);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isView() {
        return isView;
    }

    public ObservableList<User> getPersonData() {
        return personData;
    }
}