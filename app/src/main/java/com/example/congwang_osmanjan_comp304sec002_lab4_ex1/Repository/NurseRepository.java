package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.NurseDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;

import java.util.List;

public class NurseRepository {
    private LiveData<List<Nurse>> allNursesLive;
    private Assignment04Database database;
    private NurseDao nurseDao;

    public NurseRepository(Context context) {
        database=Assignment04Database.getDatabase(context.getApplicationContext());
        nurseDao=database.getNurseDao();
        allNursesLive= nurseDao.getAllNursesLive();
    }

    public LiveData<List<Nurse>> getAllNursesLive() {
        return allNursesLive;
    }

    public void insertNurses(Nurse... nurses){
        nurseDao.insertNurse(nurses);
    }

    public Nurse getNurseByNurseIdAndPassword(int nurseId, String password){
        Nurse nurse = nurseDao.getNurseByNurseIdAndPassword(nurseId, password);
        return nurse;
    }

}
