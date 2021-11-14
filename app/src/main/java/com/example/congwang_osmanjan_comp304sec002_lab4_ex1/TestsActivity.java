package com.example.congwang_osmanjan_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.TestDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.MyAdapters.TestAdapter;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel.TestViewModel;

import java.util.List;

public class TestsActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private TestAdapter testAdapter;
    private TestViewModel testViewModel;

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

    }

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
}