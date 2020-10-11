package com.amit.portfolio.transaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amit.portfolio.R;
import com.amit.portfolio.db.DatabaseHelper;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder> {

    private Context context;
    private List<Transaction> transactionList;
    private DatabaseHelper databaseHelper;

    TransactionAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_frame, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        final Transaction transaction = transactionList.get(position);
        String sb = transaction.getInstrument() +
                "-" +
                transaction.getMv();
        holder.TransactionItemText.setText(sb);
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }
}
