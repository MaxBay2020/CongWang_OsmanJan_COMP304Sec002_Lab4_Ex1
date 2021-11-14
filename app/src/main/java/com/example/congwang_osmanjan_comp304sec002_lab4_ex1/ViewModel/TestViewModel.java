package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.TestDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Repository.TestRepository;

import java.util.List;

public class TestViewModel extends AndroidViewModel {

    private LiveData<List<Test>> allTestsLive;
    private TestRepository testRepository;

    public LiveData<List<Test>> getAllTestsLive() {
        return testRepository.getAllTestsLive();
    }

    public TestViewModel(@NonNull Application application) {
        super(application);

        testRepository=new TestRepository(application);
    }

    public void insertTests(Test... tests){
        testRepository.insertTests(tests);
    }
}
