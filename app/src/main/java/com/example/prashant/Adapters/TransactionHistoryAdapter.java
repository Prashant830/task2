package com.example.prashant.Adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prashant.R;
import com.example.prashant.Data.Transaction;

import java.util.ArrayList;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder> {
    private final ArrayList<Transaction> transactionArrayList;

    public TransactionHistoryAdapter(ArrayList<Transaction> list) {
        transactionArrayList = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fromName, toName, amountTransferred;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fromName = itemView.findViewById(R.id.t_from_name);
            toName = itemView.findViewById(R.id.t_to_name);
            amountTransferred = itemView.findViewById(R.id.t_amount);
            cardView = itemView.findViewById(R.id.transaction_card_view);

            itemView.setOnClickListener(view -> {
                // still to be implemented
            });
        }
    }

    @NonNull
    @Override
    public TransactionHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.transaction_history_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(transactionArrayList.get(position));
        viewHolder.fromName.setText(transactionArrayList.get(position).getFromUser());
        viewHolder.toName.setText(transactionArrayList.get(position).getToUser());
        viewHolder.amountTransferred.setText(String.format("%d", transactionArrayList.get(position).getAmountTransferred()));


        if (transactionArrayList.get(position).getStatus() == 1) {
            viewHolder.cardView.setCardBackgroundColor(Color.argb(100, 105, 187, 105));
        }
        else {
            viewHolder.cardView.setCardBackgroundColor(Color.argb(100, 239, 100, 100));
        }
    }

    @Override
    public int getItemCount() {
        return transactionArrayList.size();
    }
}