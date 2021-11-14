package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Dao.NurseDao;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Database.Assignment04Database;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Nurse;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Repository.NurseRepository;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {
    private LiveData<List<Nurse>> allNursesLive;
    private NurseRepository nurseRepository;

    public LiveData<List<Nurse>> getAllNursesLive() {
        return nurseRepository.getAllNursesLive();
    }

    public NurseViewModel(@NonNull Application application) {
        super(application);
        nurseRepository=new NurseRepository(application);
    }

    public void insertNurse(Nurse... nurses){
        nurseRepository.insertNurses(nurses);
    }

    public Nurse getNurseByNurseIdAndPassword(int nurseId, String password){
        Nurse nurse = nurseRepository.getNurseByNurseIdAndPassword(nurseId, password);
        return  nurse;
    }


}
