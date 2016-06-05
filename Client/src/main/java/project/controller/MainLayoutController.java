package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import project.Main;


public class MainLayoutController {

    @FXML
    private MenuItem newMenu;

    @FXML
    private MenuItem exitMenu;

    @FXML
    private MenuItem refreshMenu;

    @FXML
    private MenuItem aboutMenu;

    private Main main;


    @FXML
    private void initialize() {
        aboutMenu.setOnAction((e) -> handleAboutAction(e));
        exitMenu.setOnAction((e) -> handleExitAction(e));
        refreshMenu.setOnAction((e) -> handleRefreshAction(e));
        newMenu.setOnAction((e) -> handleRemoveAction(e));
    }

    @FXML
    private void handleExitAction(ActionEvent e) {
        main.getStage().close();
    }


    @FXML
    private void handleRefreshAction(ActionEvent e) {
        if (main.isView())
            main.showTable();
    }

    //TODO:
    @FXML
   private void handleRemoveAction(ActionEvent e){
        main.showTable();
    }

    @FXML
    private void handleAboutAction(ActionEvent e) {
        main.about();
    }


    public void setMainApp(Main main) {
        this.main = main;
    }
}
