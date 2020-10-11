package com.amit.portfolio.transaction;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amit.portfolio.R;

class TransactionViewHolder extends RecyclerView.ViewHolder {

    TextView TransactionItemText;

    TransactionViewHolder(@NonNull View itemView) {
        super(itemView);
        TransactionItemText = itemView.findViewById(R.id.transactionItem);
    }
}
