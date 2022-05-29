package com.mycompany.songnotebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 960, 720);
        stage.setScene(scene);
        stage.show();
        
//        ArrayList lyrics = new ArrayList();
//        lyrics.add("Type your lyrics here");
//        
//        ArrayList notes = new ArrayList();
//        notes.add("Type your notes here");
//        
//        Song currentSong = new Song("Type your title here", "Tuning e.g. EADGBE", "Test Vibe", lyrics, notes);
        //testing
        System.out.println("TEST TEST");



    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}