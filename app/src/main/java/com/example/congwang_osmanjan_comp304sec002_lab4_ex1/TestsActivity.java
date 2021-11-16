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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.TestDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.MyAdapters.PatientAdapter;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.MyAdapters.TestAdapter;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.TestViewModel;

import java.util.List;

public class TestsActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private TestAdapter testAdapter;
    private TestViewModel testViewModel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        testViewModel=new ViewModelProvider(this).get(TestViewModel.class);

        myRecyclerView=findViewById(R.id.test_recyclerView);

        testAdapter=new TestAdapter();

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(testAdapter);

        testViewModel.getAllTestsLive().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                testAdapter.setAllTests(tests);
                testAdapter.notifyDataSetChanged();
            }
        });

        testAdapter.setOnItemClick(new TestAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position, String id) {
                intent=new Intent(getApplicationContext(), ViewTestInfoActivity.class);
                intent.putExtra("testId", id);
                startActivity(intent);
            }
        });

    }

    /**
     * TESTING: click to insert some data
     * @param view
     */
    public void insertTest(View view){
        for (int i = 0; i < 20; i++) {
            int index=testViewModel.getAllTestsLive().getValue().size()+1+i;
            Patient patient=new Patient(
                    "Firstname"+index,
                    "Lastname"+index,
                    "Department"+index,
                    index,
                    "Room"+index);
            Test test=new Test(
                    10,20,
                    "BPL"+index,
                    "BPH"+index,
                    index+"°C"
            );
            testViewModel.insertTests(test);
        }
    }

    /**
     * click to add a test for a patient
     * @param view
     */
    public void goToAddTestActivity(View view) {
        intent=new Intent(getApplicationContext(), AddTestActivity.class);
        startActivity(intent);
    }
}