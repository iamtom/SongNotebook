package com.mycompany.songnotebook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PrimaryController {
    
    
    Song currentSong;
    
    ArrayList<Song> loadedSongs;
    
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
    private TextField vibeField;
    


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
    
    @FXML
    private void loadSongIntoGUI(ActionEvent event) {
        titleField.setText(currentSong.getTitle());
        tuningField.setText(currentSong.getTuning());
        vibeField.setText(currentSong.getVibe());
        lyricsField.setText(currentSong.getLyrics());
        notesField.setText(currentSong.getNotes());
    }
    
    public void initialize() {
        //Populate the vibes combo box
        //vibesList = FXCollections.observableArrayList("Bright", "Mysterious", "Dark");
        
        loadedSongs = loadSongsIntoArrayList();
        //put file names in combo here
        
        //making song at index 0 the default song
        //putting the Song data into the GUI
        currentSong = loadedSongs.get(0);
        titleField.setText(currentSong.getTitle());
        tuningField.setText(currentSong.getTuning());
        vibeField.setText(currentSong.getVibe());
        lyricsField.setText(currentSong.getLyrics());
        notesField.setText(currentSong.getNotes());
        
        //vibeComboBox.getItems().clear();
        //vibeComboBox.setItems(vibesList);
        
        songSelectCombo.getItems().clear();
        //songSelectCombo.setItems(loadedSongs); need to change this

    }
    
    public void saveSong() {
        String newTitle = titleField.getText();
        String newTuning = tuningField.getText();
        String newVibe = vibeField.getText();
        String newLyrics = lyricsField.getText();
        String newNotes = notesField.getText();
        currentSong.setAll(newTitle, newTuning, newVibe, newLyrics, newNotes);
        currentSong.writeToFile();

        System.out.println(currentSong);         



    }
       
    public ArrayList loadSongsIntoArrayList() {
        //get the file names from the songfiles folder and add to array
        String[] fileNames;        
        File file = new File("songfiles/");        
        fileNames = file.list();        
        //System.out.println(Arrays.toString(fileNames));
        
        //convert to ArrayList and remove gitignore file
        ArrayList fileNamesList = new ArrayList();
        for (String piece: fileNames) {
            if (!piece.equals(".gitignore")) {
                fileNamesList.add(piece);
            }
        }
        System.out.println(fileNamesList);       
 
        //for each item in fileNamesList - read it to a string, split, then create object with each part
        //put each Song object in the below ArrayList
        ArrayList<Song> songs = new ArrayList<Song>();
        
        for (int i = 0; i < fileNamesList.size(); i++) {
            try {

                Path fileName = Path.of("songfiles/" + fileNamesList.get(i));
                String str = Files.readString(fileName);

                String[] split = str.split("\\|");   
                System.out.println(Arrays.toString(split));
                
                //make a new Song object with the split string. split[0] will be title [1] tuning etc
                Song newSong = new Song(split[0], split[1], split[2], split[3], split[4]);
                songs.add(newSong);
                 
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return songs;  
        
    }

   

}
