package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.NurseViewModel;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.PatientViewModel;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.TestViewModel;

public class AddTestActivity extends AppCompatActivity {

    private TestViewModel testViewModel;
    private NurseViewModel nurseViewModel;
    private PatientViewModel patientViewModel;

    private EditText editText_patientId, editText_nurseId, editText_BPL, editText_BPH, editText_temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        editText_patientId=findViewById(R.id.editText_patientId);
        editText_nurseId=findViewById(R.id.editText_nurseId);
        editText_BPL=findViewById(R.id.editText_BPL);
        editText_BPH=findViewById(R.id.editText_BPH);
        editText_temperature=findViewById(R.id.editText_temperature);

        testViewModel=new ViewModelProvider(this).get(TestViewModel.class);
        nurseViewModel=new ViewModelProvider(this).get(NurseViewModel.class);
        patientViewModel=new ViewModelProvider(this).get(PatientViewModel.class);


    }

    /**
     * click to add test
     * @param view
     */
    public void addTest(View view){
        if(String.valueOf(editText_patientId.getText()).trim().isEmpty()
            || String.valueOf(editText_nurseId.getText()).trim().isEmpty()
            || String.valueOf(editText_BPL.getText()).trim().isEmpty()
            || String.valueOf(editText_BPH.getText()).trim().isEmpty()
            || String.valueOf(editText_temperature.getText()).trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        }else{
            int patientId=Integer.parseInt(String.valueOf(editText_patientId.getText()));
            int nurseId=Integer.parseInt(String.valueOf(editText_nurseId.getText()));
            String BPL=String.valueOf(editText_BPL.getText()).trim();
            String BPH=String.valueOf(editText_BPH.getText()).trim();
            String temperature=String.valueOf(editText_temperature.getText()).trim();

            /**
             * take nurseId to see whether the nurse existed in the db
             */
            Nurse nurse = nurseViewModel.getNurseByNurseId(nurseId);
            Patient patient=patientViewModel.getPatientById(patientId);
            Test test= testViewModel.getTestByPatientId(patientId);

            if(nurse == null){
                // the nurse doesn't exist
                Toast.makeText(getApplicationContext(), "The nurse does not exist, please try again.", Toast.LENGTH_SHORT).show();
                editText_nurseId.setText("");
            }else if(patient == null){
                // the patient doesn't exist
                Toast.makeText(getApplicationContext(), "The patient does not exist, please try again.", Toast.LENGTH_SHORT).show();
                editText_patientId.setText("");
            }else if(test != null){
                // the test of this patient exists in db
                Toast.makeText(getApplicationContext(), "The patient has the test already.", Toast.LENGTH_SHORT).show();
            }else{
                // create test for this patient
                Test newTest=new Test(patientId,nurseId,BPL, BPH, temperature);
                testViewModel.insertTests(newTest);
                Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_SHORT).show();
            }
        }

    }
}