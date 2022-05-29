package com.mycompany.songnotebook;

import java.io.IOException;
import java.util.ArrayList;
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
        String title = titleField.getText();
        String tuning = tuningField.getText();
        //need to add lyrics and notes to their respective ArrayLists
        
        currentSong.setTitle(title);
        currentSong.setTuning(tuning);
        System.out.println(currentSong);
    }

    @FXML
    private void newSong(ActionEvent event) {
        initialize();
        System.out.println(currentSong);
    }
    
    public void initialize() {
        //also need to clear the fields on screen
        ArrayList lyrics = new ArrayList();
        lyrics.add("Type your lyrics here");
        
        ArrayList notes = new ArrayList();
        notes.add("Type your notes here");
        currentSong = new Song("Type your title here", "Tuning e.g. EADGBE", "Test Vibe", lyrics, notes);
    }

}
