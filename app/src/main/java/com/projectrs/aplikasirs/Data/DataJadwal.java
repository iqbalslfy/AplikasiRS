package com.projectrs.aplikasirs.Data;

/**
 * Created by Ayo Maju on 31/01/2018.
 */

public class DataJadwal {
    private int Image;
    private String Judul;

    public DataJadwal() {
    }

    public DataJadwal(int image, String judul) {
        Image = image;
        Judul = judul;
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
