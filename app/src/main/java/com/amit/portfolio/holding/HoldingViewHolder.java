package com.amit.portfolio.holding;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amit.portfolio.R;

class HoldingViewHolder extends RecyclerView.ViewHolder {

    TextView holdingItemText;

    HoldingViewHolder(@NonNull View itemView) {
        super(itemView);
        holdingItemText = itemView.findViewById(R.id.holdingItem);
    }
}
