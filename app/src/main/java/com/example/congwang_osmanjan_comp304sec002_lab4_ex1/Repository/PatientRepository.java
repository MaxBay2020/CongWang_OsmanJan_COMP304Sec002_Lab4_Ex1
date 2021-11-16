package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.PatientDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;

import java.util.List;

public class PatientRepository {
    private LiveData<List<Patient>> allPatientsLive;
    private Assignment04Database database;
    private PatientDao patientDao;

    public PatientRepository(Context context) {
        database=Assignment04Database.getDatabase(context.getApplicationContext());
        patientDao=database.getPatientDao();
        allPatientsLive=patientDao.getAllPatientsLive();
    }

    public LiveData<List<Patient>> getAllPatientsLive(){
        return allPatientsLive;
    }

    public void insertPatients(Patient... patients){
        patientDao.insertPatient(patients);
    }

    public Patient getPatientById(int patientId){
        Patient patient = patientDao.getPatientById(patientId);
        return patient;
    }

    public void updatePatient(Patient... patient){
        patientDao.updatePatient(patient);
    }


}
