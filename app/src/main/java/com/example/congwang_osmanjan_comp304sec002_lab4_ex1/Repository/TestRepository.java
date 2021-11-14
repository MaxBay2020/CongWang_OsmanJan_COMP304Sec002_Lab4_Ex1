package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.TestDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;

import java.util.List;

public class TestRepository {
    private LiveData<List<Test>> allTestsLive;
    private Assignment04Database database;
    private TestDao testDao;

    public TestRepository(Context context) {
           database=Assignment04Database.getDatabase(context.getApplicationContext());
           testDao=database.getTestDao();
           allTestsLive=testDao.getALlTestsLive();
    }

    public LiveData<List<Test>> getAllTestsLive() {
        return allTestsLive;
    }

    public void insertTests(Test... tests){
        testDao.insertTest(tests);
    }
}
