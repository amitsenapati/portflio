package com.amit.portfolio.holding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amit.portfolio.R;
import com.amit.portfolio.db.DatabaseHelper;

import java.util.List;

public class HoldingAdapter extends RecyclerView.Adapter<HoldingViewHolder> {

    private Context context;
    private List<Holding> holdingList;
    private DatabaseHelper databaseHelper;

    HoldingAdapter(Context context, List<Holding> holdingList) {
        this.context = context;
        this.holdingList = holdingList;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public HoldingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holding_frame, parent, false);
        return new HoldingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoldingViewHolder holder, int position) {
        final Holding holding = holdingList.get(position);
        String sb = holding.getInstrument() +
                "-" +
                holding.getMv();
        holder.holdingItemText.setText(sb);
    }

    @Override
    public int getItemCount() {
        return holdingList.size();
    }
}
