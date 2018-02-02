package com.projectrs.aplikasirs.Data;

/**
 * Created by Ayo Maju on 30/01/2018.
 */

public class DataMain {

    private int Image;
    private String Judul;

    public DataMain(int image, String judul) {
        Image = image;
        Judul = judul;
    }

    public DataMain() {

    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }
}
