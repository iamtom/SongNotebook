package com.mycompany.songnotebook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    
    ObservableList<Song> observableSongList;


    @FXML
    private ComboBox<Song> songSelectCombo;
    @FXML
    private Button saveButton;
    @FXML
    private Button newButton;
    @FXML
    private TextField titleField;
    @FXML
    private TextField tuningField;
    @FXML
    private TextArea lyricsField;
    @FXML
    private TextArea notesField;
    @FXML
    private TextField vibeField;
    @FXML
    private Label vibeCombo;
    


    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void selectSong(ActionEvent event) {
        currentSong = songSelectCombo.getValue();
        titleField.setText(currentSong.getTitle());
        tuningField.setText(currentSong.getTuning());
        vibeField.setText(currentSong.getVibe());
        lyricsField.setText(currentSong.getLyrics());
        notesField.setText(currentSong.getNotes());
    }

//    private void handle(KeyEvent event) {
//        if (event.getCode().equals(KeyCode.TAB)) {
//            //move to next text field
//        }
//    }

    @FXML
    private void save(ActionEvent event) {
        String newTitle = titleField.getText();
        String newTuning = tuningField.getText();
        String newVibe = vibeField.getText();
        String newLyrics = lyricsField.getText();
        String newNotes = notesField.getText();

        currentSong.setTitle(newTitle);
        currentSong.setTuning(newTuning);
        currentSong.setVibe(newVibe);
        currentSong.setLyrics(newLyrics);
        currentSong.setNotes(newNotes);
        
        currentSong.writeToFile();

        System.out.println(currentSong); 
    }

    @FXML
    private void newSong(ActionEvent event) {
        //make blank new song
        //add "New Song" to the song select combobox - isn't saved until save is pressed
        //populate fields from new song
        //any unsaved new songs will be lost
        currentSong = new Song("New Song", " ", " ", " ", " ");
        observableSongList.add(currentSong);
        titleField.setText(currentSong.getTitle());
        tuningField.setText(currentSong.getTuning());
        vibeField.setText(currentSong.getVibe());
        lyricsField.setText(currentSong.getLyrics());
        notesField.setText(currentSong.getNotes());
        System.out.println(currentSong);
    }
    
    
//    private void loadSongIntoGUI(ActionEvent event) {
//        titleField.setText(currentSong.getTitle());
//        tuningField.setText(currentSong.getTuning());
//        vibeField.setText(currentSong.getVibe());
//        lyricsField.setText(currentSong.getLyrics());
//        notesField.setText(currentSong.getNotes());
//    }
    
    public void initialize() {   
        //loading the songs and populating the song selection combobox
        List<Song> loadedSongs = loadSongsIntoList();
        observableSongList = FXCollections.observableList(loadedSongs);
        songSelectCombo.setItems(observableSongList);
        
        System.out.println("");
        System.out.println("Observable");
        System.out.println(observableSongList);
        
        //making song at index 0 the default song
        //putting the Song data into the GUI
        currentSong = loadedSongs.get(0);
        titleField.setText(currentSong.getTitle());
        tuningField.setText(currentSong.getTuning());
        vibeField.setText(currentSong.getVibe());
        lyricsField.setText(currentSong.getLyrics());
        notesField.setText(currentSong.getNotes());
    }
         
    public List loadSongsIntoList() {
        //get the file names from the songfiles folder and add to array
        String[] fileNames;        
        File file = new File("songfiles/");        
        fileNames = file.list();
        //System.out.println(Arrays.toString(fileNames));
        
        //convert to ArrayList and remove gitignore file
        ArrayList fileNamesList = new ArrayList();
        for (String fileName: fileNames) {
            if (!fileName.equals(".gitignore")) {
                fileNamesList.add(fileName);
            }
        }
        System.out.println(fileNamesList);       
 
        //for each item in fileNamesList - read it to a string, split, then create object with each part
        //put each Song object in the below list
        List<Song> songs = new ArrayList<Song>();
        
        for (int i = 0; i < fileNamesList.size(); i++) {
            try {

                Path fileName = Path.of("songfiles/" + fileNamesList.get(i));
                String str = Files.readString(fileName);

                String[] split = str.split("\\|");   
                System.out.println(Arrays.toString(split));
                               
                //make a new Song object with the split string. split[0] will be title, [1] tuning etc
                Song newSong = new Song(split[0], split[1], split[2], split[3], split[4]);
                songs.add(newSong);               
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return songs;          
    }
       
//    public ArrayList loadSongsIntoArrayList() {
//        //get the file names from the songfiles folder and add to array
//        String[] fileNames;        
//        File file = new File("songfiles/");        
//        fileNames = file.list();        
//        //System.out.println(Arrays.toString(fileNames));
//        
//        //convert to ArrayList and remove gitignore file
//        ArrayList fileNamesList = new ArrayList();
//        for (String piece: fileNames) {
//            if (!piece.equals(".gitignore")) {
//                fileNamesList.add(piece);
//            }
//        }
//        System.out.println(fileNamesList);       
// 
//        //for each item in fileNamesList - read it to a string, split, then create object with each part
//        //put each Song object in the below ArrayList
//        ArrayList<Song> songs = new ArrayList<Song>();
//        
//        for (int i = 0; i < fileNamesList.size(); i++) {
//            try {
//
//                Path fileName = Path.of("songfiles/" + fileNamesList.get(i));
//                String str = Files.readString(fileName);
//
//                String[] split = str.split("\\|");   
//                System.out.println(Arrays.toString(split));
//                
//                //make a new Song object with the split string. split[0] will be title [1] tuning etc
//                Song newSong = new Song(split[0], split[1], split[2], split[3], split[4]);
//                songs.add(newSong);
//                 
//                
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        return songs;  
//        
//    }



   

}
