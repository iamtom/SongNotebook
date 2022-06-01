package com.mycompany.songnotebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PrimaryController {
    
    
    Song currentSong;
    
    ObservableList loadedSongs;
    
    ObservableList vibesList;


    @FXML
    private Button primaryButton;
    @FXML
    private ComboBox<?> songSelectCombo;
    @FXML
    private Button saveButton;
    @FXML
    private Button newButton;
    @FXML
    private TextArea titleField;
    @FXML
    private TextArea tuningField;
    @FXML
    private TextArea lyricsField;
    @FXML
    private TextArea notesField;
    @FXML
    private Label vibeCombo;
    @FXML
    private ComboBox<?> vibeComboBox;
    @FXML
    private Button loadButton;
    


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void selectSong(ActionEvent event) {
    }

    @FXML
    private void handle(KeyEvent event) {
        if (event.getCode().equals(KeyCode.TAB)) {
            //move to next text field
        }
    }

    @FXML
    private void saveSong(ActionEvent event) {
        saveSong();
    }

    @FXML
    private void newSong(ActionEvent event) {
        initialize();
        System.out.println(currentSong);
    }
    
    public void initialize() {
        //Populate the vibes combo box
        vibesList = FXCollections.observableArrayList("Bright", "Mysterious", "Dark");
        
        vibeComboBox.getItems().clear();
        vibeComboBox.setItems(vibesList);
        
        //Create a Song instance
//        ArrayList lyrics = new ArrayList();
//        lyrics.add("Type your lyrics here");
//        
//        ArrayList notes = new ArrayList();
//        notes.add("Type your notes here");
        currentSong = new Song("Type your title here", "Tuning e.g. EADGBE", "Test Vibe", "Lyrics here", "Notes here");
        
        //Load songs into an observable list or arraylist here
        //Declare it at the top somewhere
        //Put the names into the song combobox
    }
    
    public void saveSong() {
        String newTitle = titleField.getText();
        String newTuning = tuningField.getText();
        String newVibe = vibeComboBox.getValue().toString();
        String newLyrics = lyricsField.getText();
        String newNotes = notesField.getText();
        currentSong.setAll(newTitle, newTuning, newVibe, newLyrics, newNotes);
        currentSong.writeToFile();

        System.out.println(newLyrics);
        System.out.println("");
        System.out.println(currentSong);         



    }
    
    @FXML
    public void loadSong() throws IOException {
        //takes name of song from combo box
        //Find in the observable list
        //Load its data from there into a new currentSong
        //Then populate fields from currentSong getters?
         // Creating a path choosing file from local
        // directory by creating an object of Path class
        Path fileName = Path.of("test_file.txt");

        String str = Files.readString(fileName);

        System.out.println(str);
        
        //need to split it into the respective bits and create new object
    }
    
    public ArrayList stringToArrayList(String inputString) {
        ArrayList i = new ArrayList();
        return i;
    }
    

}
