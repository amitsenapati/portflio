package com.amit.portfolio.transaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amit.portfolio.R;
import com.amit.portfolio.db.DatabaseHelper;

import java.util.List;

public class TransactionFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DatabaseHelper databaseHelper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        Context context = view.getContext();
        recyclerView = view.findViewById(R.id.fragmentTransaction);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        databaseHelper = new DatabaseHelper(context);
        List<Transaction> transactionList;
        transactionList = databaseHelper.dummyTransactins();
        if (transactionList.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            TransactionAdapter adapter = new TransactionAdapter(context, transactionList);
            recyclerView.setAdapter(adapter);
        } else {
            recyclerView.setVisibility(View.GONE);
        }
        return view;
    }
}
