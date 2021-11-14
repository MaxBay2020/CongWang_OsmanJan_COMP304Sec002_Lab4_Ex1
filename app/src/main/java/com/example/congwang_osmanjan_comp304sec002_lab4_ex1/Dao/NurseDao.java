package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;

import java.util.List;

@Dao
public interface NurseDao {
    @Insert
    public void insertNurse(Nurse... nurses);

    @Query("SELECT * FROM NURSE ORDER BY NURSEID DESC")
    public LiveData<List<Nurse>> getAllNursesLive();

    @Query("SELECT * FROM NURSE WHERE NURSEID=:nurseId AND PASSWORD=:password")
    public Nurse getNurseByNurseIdAndPassword(int nurseId, String password);
}
