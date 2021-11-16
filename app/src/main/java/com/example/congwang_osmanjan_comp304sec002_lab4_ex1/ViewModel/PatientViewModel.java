package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.PatientDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Repository.PatientRepository;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {

    private LiveData<List<Patient>> allPatientsLive;
    private PatientRepository patientRepository;

    public LiveData<List<Patient>> getAllPatientsLive(){
        return patientRepository.getAllPatientsLive();
    }


    public PatientViewModel(@NonNull Application application) {
        super(application);

        patientRepository=new PatientRepository(application);
    }

    public void insertPatients(Patient... patients){
        patientRepository.insertPatients(patients);
    }

    public Patient getPatientById(int patientId){
        Patient patient = patientRepository.getPatientById(patientId);
        return patient;
    }

    public void updatePatient(Patient... patient){
        patientRepository.updatePatient(patient);
    }


}
