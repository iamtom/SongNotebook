package com.mycompany.songnotebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tom
 */
public class Song {
    private String title;
    private String tuning;
    private String vibe;
    private String lyrics;
    private String notes;
    
    public Song(String title, String tuning, String vibe, String lyrics, String notes) {
        this.title = title;
        this.tuning = tuning;
        this.vibe = vibe;
        this.lyrics = lyrics;
        this.notes = notes;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTuning() {
        return this.tuning;
    }
    
    public void setTuning (String tuning) {
        this.tuning = tuning;
    }

    public String getVibe() {
        return vibe;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }
    
    public String getLyrics() {
        return this.lyrics;
    }
    
    public void setLyrics (String lyrics) {
        this.lyrics = lyrics;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public void setAll(String title, String tuning, String vibe, String lyrics, String notes) {
        this.title = title;
        this.tuning = tuning;
        this.vibe = vibe;
        this.lyrics = lyrics;
        this.notes = notes;        
    }
    
    public void writeToFile() {
        //writing to txt file
        //what if the song title is changed? delete/overwrite old one somehow?
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("songfiles/" + this.title + ".txt"));
            writer.write(this.title + "|"); //the | separates the different attributes
            writer.write(this.tuning + "|");
            writer.write(this.vibe + "|");
            writer.write(this.lyrics + "|");
            writer.write(this.notes);
            writer.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }       
    }
    
    @Override
    public String toString() {
        return this.title;
    }
    
    public String printSong() {
        return "Song{" + "title=" + title + ", tuning=" + tuning + ", vibe=" + vibe + ", lyrics=" + lyrics + ", notes=" + notes + '}';
    }
   
}
