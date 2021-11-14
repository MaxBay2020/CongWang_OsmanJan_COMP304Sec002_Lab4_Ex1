package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;

import java.util.List;

@Dao
public interface PatientDao {

    @Insert
    public void insertPatient(Patient... patients);

    @Update
    public void updatePatient(Patient... patients);

    @Query("SELECT * FROM PATIENT ORDER BY PATIENTID DESC")
    public LiveData<List<Patient>> getAllPatientsLive();

}
