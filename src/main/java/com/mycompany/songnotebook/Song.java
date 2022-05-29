/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.songnotebook;

import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Song {
    private String title;
    private String tuning;
    private String vibe;
    private ArrayList lyrics;
    private ArrayList notes;
    
    public Song(String title, String tuning, String vibe, ArrayList lyrics, ArrayList notes) {
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
    
    public ArrayList getLyrics() {
        return this.lyrics;
    }
    
    public void setLyrics (ArrayList lyrics) {
        //newLyrics arraylist is created in save button code then passed to this method
    }
    
    public ArrayList getNotes() {
        return this.notes;
    }
    
    public void setNotes(ArrayList notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return "Song{" + "title=" + title + ", tuning=" + tuning + ", vibe=" + vibe + ", lyrics=" + lyrics + ", notes=" + notes + '}';
    }
   
}
