package com.example.congwang_osmanjan_comp304sec002_lab4_ex1.MyAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.Entity.Test;
import com.example.congwang_osmanjan_comp304sec002_lab4_ex1.R;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder>{

    private List<Test> allTests=new ArrayList<>();

    public void setAllTests(List<Test> allTests) {
        this.allTests = allTests;
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
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.cell_test, parent, false);
        return new TestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        Test test=allTests.get(position);
        holder.textView_number.setText(String.valueOf(position+1));
        holder.textView_patientFullName.setText(String.valueOf(test.getPatientId()));
        holder.textView_nurseFullName.setText(String.valueOf(test.getNurseId()));

        /**
         * click each item to go to test info activity
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(v,position, String.valueOf(test.getTestId()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allTests.size();
    }

    static class TestViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_number, textView_patientFullName, textView_nurseFullName;
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_number=itemView.findViewById(R.id.textView_number);
            textView_patientFullName=itemView.findViewById(R.id.textView_patientFullName);
            textView_nurseFullName=itemView.findViewById(R.id.textView_nurseFullName);
        }
    }
}
