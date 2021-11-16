package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.PatientViewModel;

public class PatientUpdateInfoActivity extends AppCompatActivity {

    private Intent intent;
    private PatientViewModel patientViewModel;
    private TextView textView_patientId;
    private EditText editText_patientFullName, editText_department, editText_nurseId,editText_room;
    private Patient currentPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_update_info);

        intent=getIntent();
        String patientId = intent.getStringExtra("patientId");

        patientViewModel=new ViewModelProvider(this).get(PatientViewModel.class);

        textView_patientId=findViewById(R.id.textView_patientId);
        editText_patientFullName=findViewById(R.id.editText_patientFullName);
        editText_department=findViewById(R.id.editText_department);
        editText_nurseId=findViewById(R.id.editText_nurseId);
        editText_room=findViewById(R.id.editText_room);

        getPatientById(Integer.parseInt(patientId));
    }

    /**
     * get patient by patient ID
     * @param patientId
     */
    public void getPatientById(int patientId){
        Patient patient=patientViewModel.getPatientById(patientId);
        currentPatient=patient;

        // fill in patient info
        textView_patientId.setHint(String.valueOf(patient.getPatientId()));
        editText_patientFullName.setHint(patient.getFirstname()+" "+patient.getLastname());
        editText_department.setHint(patient.getDepartment());
        editText_nurseId.setHint(String.valueOf(patient.getNurseId()));
        editText_room.setHint(patient.getRoom());

    }

    /**
     * click to update patient info
     * @param view
     */
    public void updatePatientInfo(View view) {
        String patientFullName=String.valueOf(editText_patientFullName.getText()).trim();

        String department=String.valueOf(editText_department.getText()).trim();
        String nurseIdStr=String.valueOf(editText_nurseId.getText()).trim();
        String room=String.valueOf(editText_room.getText()).trim();


        if(patientFullName.isEmpty()
            || department.isEmpty()
            || nurseIdStr.isEmpty()
            || room.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else if(!patientFullName.contains(" ")){
            Toast.makeText(getApplicationContext(), "Please enter your full name", Toast.LENGTH_SHORT).show();
        }else{
            // update patient info
            String patientFirstName=patientFullName.split(" ")[0];
            String patientLastName=patientFullName.split(" ")[1];
            int nurseId=Integer.parseInt(nurseIdStr);
            Patient updatedPatient=new Patient(patientFirstName, patientLastName,department, nurseId, room);
            updatedPatient.setPatientId(Integer.parseInt(String.valueOf(textView_patientId.getHint())));

            patientViewModel.updatePatient(updatedPatient);
            Toast.makeText(getApplicationContext(), "Modified successfully", Toast.LENGTH_SHORT).show();
        }
    }
}