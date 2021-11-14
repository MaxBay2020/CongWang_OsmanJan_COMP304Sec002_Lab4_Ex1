package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Patient {
    @PrimaryKey(autoGenerate = true)
    private int patientId;

    @ColumnInfo(name = "Firstname")
    private String firstname;
    @ColumnInfo(name = "Lastname")
    private String lastname;
    @ColumnInfo(name = "Department")
    private String department;
    @ColumnInfo(name = "NurseId")
    private int nurseId;
    @ColumnInfo(name = "Room")
    private String room;

    public Patient(String firstname, String lastname, String department, int nurseId, String room) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.nurseId = nurseId;
        this.room = room;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
