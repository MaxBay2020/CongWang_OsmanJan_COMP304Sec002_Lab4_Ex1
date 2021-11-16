package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.NurseViewModel;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.PatientViewModel;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.TestViewModel;

public class ViewTestInfoActivity extends AppCompatActivity {
    private Intent intent;
    private int testId;
    private PatientViewModel patientViewModel;
    private TestViewModel testViewModel;
    private NurseViewModel nurseViewModel;
    private TextView textView_testId, textView_patient, textView_nurse,textView_BPL,textView_BPH,textView_temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_info);

        patientViewModel=new ViewModelProvider(this).get(PatientViewModel.class);
        testViewModel=new ViewModelProvider(this).get(TestViewModel.class);
        nurseViewModel=new ViewModelProvider(this).get(NurseViewModel.class);

        intent=getIntent();
        testId=Integer.parseInt(intent.getStringExtra("testId"));

        // get the test ob
        Test currentTest=getTestById(testId);
        // get the patient by patient ID
        Patient currentPatient=getPatientById(currentTest.getPatientId());
        // get the nurse by nurse ID
        Nurse currentNurse=getNurseById(currentTest.getNurseId());


        // fill all fields
        fillAllFields(currentTest, currentPatient, currentNurse);
    }

    /**
     * fill all fields
     */
    private void fillAllFields(Test currentTest, Patient currentPatient, Nurse currentNurse) {
        textView_testId=findViewById(R.id.textView_testId);
        textView_patient=findViewById(R.id.textView_patient);
        textView_nurse=findViewById(R.id.textView_nurse);
        textView_BPL=findViewById(R.id.textView_BPL);
        textView_BPH=findViewById(R.id.textView_BPH);
        textView_temperature=findViewById(R.id.textView_temperature);

        textView_testId.setText(String.valueOf(currentTest.getTestId()));
        textView_patient.setText(currentPatient.getFirstname()+" "+currentPatient.getLastname());
        textView_nurse.setText(currentNurse.getFirstname()+" "+currentNurse.getLastname());
        textView_BPL.setText(currentTest.getBPL());
        textView_BPH.setText(currentTest.getBPH());
        textView_temperature.setText(currentTest.getTemperature()+" °C");
    }

    /**
     * find test by test ID
     * @param testId
     */
    public Test getTestById(int testId){
        return testViewModel.getTestById(testId);
    }


    /**
     * find patient by patient ID
     * @param patientId
     * @return
     */
    public Patient getPatientById(int patientId){
        return patientViewModel.getPatientById(patientId);
    }

    /**
     * find nurse by nurse ID
     * @param nurseId
     * @return
     */
    public Nurse getNurseById(int nurseId){
        return nurseViewModel.getNurseByNurseId(nurseId);
    }

    public void goBackToTestActivity(View view) {
        intent=new Intent(getApplicationContext(), TestsActivity.class);
        startActivity(intent);
    }
}