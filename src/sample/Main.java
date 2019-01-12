package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane borderPane = new BorderPane();
        primaryStage.setTitle("Notepad420");
        Scene scene = new Scene(borderPane, 800, 800);


        // Menu
        MenuBar menuBar = new MenuBar();

        // File
        Menu menuFile = new Menu("File");
        MenuItem newFile = new MenuItem("New");
        newFile.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        MenuItem openFile = new MenuItem("Open...");
        openFile.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        MenuItem saveFile = new MenuItem("Save");
        saveFile.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        MenuItem saveAsFile = new MenuItem("Save As...");
        MenuItem pageSetupFile = new MenuItem("Page Setup...");
        MenuItem printFile = new MenuItem("Print...");
        printFile.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
        MenuItem exitFile = new MenuItem("Exit");
        menuFile.getItems().addAll(newFile, openFile, saveFile, saveAsFile,new SeparatorMenuItem(), pageSetupFile, printFile,new SeparatorMenuItem(), exitFile);

        // Edit
        Menu menuEdit = new Menu("Edit");

        //Format
        Menu menuFormat = new Menu("Format");

        //View
        Menu menuView = new Menu("View");

        //Help
        Menu menuHelp = new Menu("Help");

        menuBar.getMenus().addAll(menuFile, menuEdit, menuFormat, menuView, menuHelp);
        borderPane.setTop(menuBar);

        TextArea textArea = new TextArea();
        textArea.borderProperty();
        borderPane.setCenter(textArea);


        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) { launch(args);
    }
}
