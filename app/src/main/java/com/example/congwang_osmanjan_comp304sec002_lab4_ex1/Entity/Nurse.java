package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nurse {
    @PrimaryKey(autoGenerate = true)
    private int nurseId;
    @ColumnInfo(name = "Firstname")
    private String firstname;
    @ColumnInfo(name = "Lastname")
    private String lastname;
    @ColumnInfo(name = "Department")
    private String department;
    @ColumnInfo(name = "Password")
    private String password;

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Nurse(String firstname, String lastname, String department, String password) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.department = department;
//        this.password = password;
//    }

    public Nurse(String password) {
        this.password = password;
    }
}
