package com.projectrs.aplikasirs.Data;

/**
 * Created by Ayo Maju on 31/01/2018.
 */

public class DataJadwalLasik {
    private String Tanggal, Hari, Jam;

    public DataJadwalLasik() {
    }

    public DataJadwalLasik(String tanggal, String hari, String jam) {
        Tanggal = tanggal;
        Hari = hari;
        Jam = jam;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getHari() {
        return Hari;
    }

    public void setHari(String hari) {
        Hari = hari;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        Jam = jam;
    }
}
