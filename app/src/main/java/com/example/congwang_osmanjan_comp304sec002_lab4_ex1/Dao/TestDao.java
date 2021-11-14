package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;

import java.util.List;

@Dao
public interface TestDao {

    @Insert
    public void insertTest(Test... tests);

    @Query("SELECT * FROM TEST WHERE PATIENTID = :patientId")
    public Test getTestbyPatientId(int patientId);

    @Query("SELECT * FROM TEST ORDER BY TESTID DESC")
    public LiveData<List<Test>> getALlTestsLive();

}
