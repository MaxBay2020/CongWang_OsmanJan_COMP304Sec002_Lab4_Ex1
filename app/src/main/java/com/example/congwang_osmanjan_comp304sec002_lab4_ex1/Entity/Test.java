package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Test {
    @PrimaryKey(autoGenerate = true)
    private int testId;
    @ColumnInfo(name = "PatientId")
    private int patientId;
    @ColumnInfo(name = "NurseId")
    private int nurseId;
    @ColumnInfo(name = "BPL")
    private String BPL;
    @ColumnInfo(name = "BPH")
    private String BPH;
    @ColumnInfo(name = "Temperature")
    private String temperature;

    public Test(int patientId, int nurseId, String BPL, String BPH, String temperature) {
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.BPL = BPL;
        this.BPH = BPH;
        this.temperature = temperature;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getBPL() {
        return BPL;
    }

    public void setBPL(String BPL) {
        this.BPL = BPL;
    }

    public String getBPH() {
        return BPH;
    }

    public void setBPH(String BPH) {
        this.BPH = BPH;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
