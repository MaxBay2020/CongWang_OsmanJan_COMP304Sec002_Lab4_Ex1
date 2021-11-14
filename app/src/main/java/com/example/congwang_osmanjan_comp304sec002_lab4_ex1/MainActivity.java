package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * click to visit login activity
     * @param view
     */
    public void gotoLoginActivity(View view) {
        intent=new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    /**
     * click to visit patients activity
     * @param view
     */
    public void gotoPatientsActivity(View view) {
        intent=new Intent(getApplicationContext(), PatientsActivity.class);
        startActivity(intent);
    }
}