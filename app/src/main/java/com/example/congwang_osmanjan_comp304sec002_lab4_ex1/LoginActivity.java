package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.NurseDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.NurseViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "TEST";
    private EditText editText_username, editText_password;

    private NurseViewModel nurseViewModel;
    private List<Nurse> allNurses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_username=findViewById(R.id.textView_username);
        editText_password=findViewById(R.id.textView_password);

        nurseViewModel=new ViewModelProvider(this).get(NurseViewModel.class);
        nurseViewModel.getAllNursesLive().observe(this, new Observer<List<Nurse>>() {
            @Override
            public void onChanged(List<Nurse> nurses) {
                allNurses=nurses;
            }
        });
    }

    /**
     * click to register
     * @param view
     */
    public void registerUser(View view) {
        String password=String.valueOf(editText_password.getText());
        if(!password.trim().isEmpty()){
            // insert this user through ViewModel
            nurseViewModel.insertNurse(new Nurse(
                    password
            ));
            String nurseId=String.valueOf(nurseViewModel.getAllNursesLive().getValue().size()+1);
            Toast.makeText(getApplicationContext(), "Your nurseID is "+nurseId+"\r\nYour password is "+password, Toast.LENGTH_LONG).show();
            editText_username.setText(nurseId);
            editText_password.setText(password);
        }else{
            Toast.makeText(getApplicationContext(), "Please setup your password", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * click to login
     * @param view
     */
    public void loginUser(View view) {
        String nurseId=String.valueOf(editText_username.getText());
        String password=String.valueOf(editText_password.getText());
        if(nurseId.trim().isEmpty()||password.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please enter your nurseId and password", Toast.LENGTH_SHORT).show();
        }else{
            // query this user through ViewModel
            Nurse nurse = nurseViewModel.getNurseByNurseIdAndPassword(Integer.valueOf(nurseId), password);
            if(nurse==null){
                // NurseId or password incorrect
                Toast.makeText(getApplicationContext(), "NurseId or password incorrect", Toast.LENGTH_SHORT).show();
            }else{
                // NurseId or password correct
                Toast.makeText(getApplicationContext(), "Login successfully!", Toast.LENGTH_SHORT).show();
                // use shared preferences to store nurseId
                SharedPreferences nurseIdSp=getSharedPreferences("nurseId", MODE_PRIVATE);
                SharedPreferences.Editor editor=nurseIdSp.edit();
                editor.putString("nurseId", nurseId);
                editor.apply();
                Toast.makeText(getApplicationContext(), "NurseId stored successfully!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}