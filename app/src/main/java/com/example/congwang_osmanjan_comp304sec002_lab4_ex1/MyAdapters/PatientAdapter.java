package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.MyAdapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Patient;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.MainActivity;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.PatientUpdateInfoActivity;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.R;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private String TAG="TEST";

    private List<Patient> allPatients=new ArrayList<>();


    public void setAllPatients(List<Patient> allPatients) {
        this.allPatients = allPatients;
    }

    OnItemClickListener listener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position, String id);
    }

    public void setOnItemClick(OnItemClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.cell_patient, parent, false);
        return new PatientViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient patient=allPatients.get(position);
        holder.textViewNumber.setText(String.valueOf(position+1));
        holder.textViewPatientName.setText(patient.getFirstname()+" "+patient.getLastname());
        holder.textViewNurseName.setText(String.valueOf(patient.getNurseId()));
        holder.textViewDepartment.setText(patient.getDepartment());
        holder.textViewRoom.setText(patient.getRoom());

        /**
         * click each item to go to patientUpdateInfo activity
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(v,position, String.valueOf(patient.getPatientId()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allPatients.size();
    }

    static class PatientViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewNumber, textViewPatientName, textViewNurseName, textViewDepartment, textViewRoom;


        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNumber=itemView.findViewById(R.id.textViewNumber);
            textViewPatientName=itemView.findViewById(R.id.textViewPatientFullName);
            textViewNurseName=itemView.findViewById(R.id.textViewNurseFullName);
            textViewDepartment=itemView.findViewById(R.id.textViewDepartment);
            textViewRoom=itemView.findViewById(R.id.textViewRoom);
        }
    }
}
