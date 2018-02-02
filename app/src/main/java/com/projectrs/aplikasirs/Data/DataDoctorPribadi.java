package com.projectrs.aplikasirs.Data;

/**
 * Created by Ayo Maju on 01/02/2018.
 */

public class DataDoctorPribadi {
    private int Img;
    private String dokter, spesialis, alamat;

    public DataDoctorPribadi(int img, String dokter, String spesialis, String alamat) {
        Img = img;
        this.dokter = dokter;
        this.spesialis = spesialis;
        this.alamat = alamat;
    }

    public DataDoctorPribadi() {
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
