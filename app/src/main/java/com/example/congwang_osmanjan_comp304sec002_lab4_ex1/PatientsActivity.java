package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.PatientDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.MyAdapters.PatientAdapter;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.PatientViewModel;

import java.util.List;

public class PatientsActivity extends AppCompatActivity {
    private Intent intent;

    private Assignment04Database database;
    private PatientDao patientDao;
    private Button addButton;
    private RecyclerView myRecyclerView;
    private LiveData<List<Patient>> allPatientsLive;
    private PatientViewModel patientViewModel;
    private PatientAdapter patientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        patientViewModel=new ViewModelProvider(this).get(PatientViewModel.class);

        myRecyclerView=findViewById(R.id.patient_recyclerView);

        patientAdapter=new PatientAdapter();

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(patientAdapter);

        patientViewModel.getAllPatientsLive().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                patientAdapter.setAllPatients(patients);
                patientAdapter.notifyDataSetChanged();
            }
        });

    }


    public void insertPatient(View view){
        for (int i = 0; i < 20; i++) {
            int index=patientViewModel.getAllPatientsLive().getValue().size()+1+i;
            Patient patient=new Patient(
                    "Firstname"+index,
                    "Lastname"+index,
                    "Department"+index,
                    index,
                    "Room"+index);
            patientViewModel.insertPatients(patient);
        }
    }

    /**
     * click to visit Tests activity
     * @param view
     */
    public void gotoTestsActivity(View view) {
        intent = new Intent(getApplicationContext(), TestsActivity.class);
        startActivity(intent);
    }
}