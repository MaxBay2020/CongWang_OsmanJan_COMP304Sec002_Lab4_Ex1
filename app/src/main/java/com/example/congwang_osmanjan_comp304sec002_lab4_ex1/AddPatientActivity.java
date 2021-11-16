package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.PatientViewModel;

public class AddPatientActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;
    private EditText editText_firstName, editText_lastName, editText_department, editText_nurseId, editText_room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        editText_firstName=findViewById(R.id.editText_firstName);
        editText_lastName=findViewById(R.id.editText_lastName);
        editText_department=findViewById(R.id.editText_department);
        editText_nurseId=findViewById(R.id.editText_nurseId);
        editText_room=findViewById(R.id.editTextT_room);

        patientViewModel= new ViewModelProvider(this).get(PatientViewModel.class);
    }

    /**
     * click to add patient
     * @param view
     */
    public void addPatient(View view) {
        String firstName=String.valueOf(editText_firstName.getText()).trim();
        String lastName=String.valueOf(editText_lastName.getText()).trim();
        String department=String.valueOf(editText_department.getText()).trim();
        String nurseIdStr=String.valueOf(editText_nurseId.getText()).trim();
        String room=String.valueOf(editText_room.getText()).trim();

        if(firstName.trim().isEmpty()|| lastName.trim().isEmpty() || department.trim().isEmpty() || String.valueOf(editText_nurseId.getText()).trim().isEmpty() || room.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }else {
            // create this patient and add to the database
            // TODO: take nurseId to get the nurseName with nurseRepository
            // TODO: take nurseId to see whether the nurseId existed in the db

            int nurseId=Integer.parseInt(nurseIdStr);
            Patient patient=new Patient(firstName, lastName, department, nurseId, room);
            patientViewModel.insertPatients(patient);
            Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_SHORT).show();
            editText_firstName.setText("");
            editText_lastName.setText("");
            editText_department.setText("");
            editText_nurseId.setText("");
            editText_room.setText("");
        }
    }
}