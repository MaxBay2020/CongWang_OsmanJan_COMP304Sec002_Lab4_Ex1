package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.NurseDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.PatientDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.TestDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;

@Database(entities = {Patient.class, Test.class, Nurse.class}, version = 1, exportSchema = false)
public abstract class Assignment04Database extends RoomDatabase {
    private static Assignment04Database _instance;
    public synchronized static Assignment04Database getDatabase(Context context){
        if(_instance==null){
            _instance= Room.databaseBuilder(
                    context.getApplicationContext(),
                    Assignment04Database.class,
                    "Assignment04_database")
                    .allowMainThreadQueries().build();
        }
        return _instance;
    }

    public abstract PatientDao getPatientDao();
    public abstract TestDao getTestDao();
    public abstract NurseDao getNurseDao();

}
