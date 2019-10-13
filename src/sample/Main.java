package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.*;


public class Main extends Application {
    TextArea textArea = new TextArea();
    private File filePath = null;
    FileChooser fileChooser = new FileChooser();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane borderPane = new BorderPane();
        primaryStage.setTitle("Notepad420");
        Scene scene = new Scene(borderPane, 800, 800);


        textArea.borderProperty();
        borderPane.setCenter(textArea);

        // Menu
        MenuBar menuBar = new MenuBar();

        // FILE
        Menu menuFile = new Menu("File");

            // New
        MenuItem newFile = new MenuItem("New");
        newFile.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        newFile.setOnAction (e -> textArea.setText(""));

            //Open
        MenuItem openFile = new MenuItem("Open...");
        openFile.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        openFile.setOnAction (e -> openFilex (primaryStage));


            //Save
        MenuItem saveFile = new MenuItem("Save");
        saveFile.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
//        saveFile.setOnAction(e -> );

            //Save As
        MenuItem saveAsFile = new MenuItem("Save As...");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"));
        saveAsFile.setOnAction(e -> fileChooser.showSaveDialog(primaryStage));

            //Page Setup
        MenuItem pageSetupFile = new MenuItem("Page Setup...");

            //Print
        MenuItem printFile = new MenuItem("Print...");
        printFile.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));

            //Exit
        MenuItem exitFile = new MenuItem("Exit");

            //Creates file menu items
        menuFile.getItems().addAll(newFile, openFile, saveFile, saveAsFile,new SeparatorMenuItem(), pageSetupFile, printFile,new SeparatorMenuItem(), exitFile);

        // EDIT
        Menu menuEdit = new Menu("Edit");

            //Format
        Menu menuFormat = new Menu("Format");

            //View
        Menu menuView = new Menu("View");

            //Help
        Menu menuHelp = new Menu("Help");

            //Creates file menu items
        menuBar.getMenus().addAll(menuFile, menuEdit, menuFormat, menuView, menuHelp);


        borderPane.setTop(menuBar);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) { launch(args);
    }

        private void openFilex (Stage stage) {
            fileChooser.setTitle("Opens");
            fileChooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Files", "*.txt"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
//                System.out.println(selectedFile);
                textArea.setText(openFileString(selectedFile));
                String basename;
                basename = selectedFile.getName();
                stage.setTitle(basename);

            }
        }


        private String openFileString (File file) {
            // The name of the file to open.
            String fileName = file.toString();

            // This will reference one line at a time
            String line = null;
            String fullText = "";

            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                        new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    fullText = fullText.concat(line + "\n");

                }

                // Always close files.
                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            }
            catch(IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }

            return fullText;
        }


}




