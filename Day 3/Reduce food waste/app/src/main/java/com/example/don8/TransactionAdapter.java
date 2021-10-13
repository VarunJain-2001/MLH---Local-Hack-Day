package com.example.don8;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.don8.R;


import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {




    /**
     * The list of credit card transactions which will be adapted to the UI.
     */
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * A listener to deliver callbacks to whenever a transaction in the list is clicked.
     */
    //private TransactionClickedListener listener;

    /**
     * Takes in the list of transactions that should be rendered and a listener to receive callbacks
     * if the user clicks on a particular row.
     */
    public TransactionAdapter(List<Transaction> transactions){//, TransactionClickedListener listener) {
        this.transactions = transactions;
        //this.listener = listener;
    }

    /**
     * Called when the UI needs the a new row (at {position}) to be <b>created</b>. In this case,
     * all of our rows look the same, so we just inflate the same layout for all rows.
     * <br>
     * The new row isn't filled with data yet, that's done by
     * {@link TransactionAdapter#onBindViewHolder(ViewHolder, int)}
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_transaction, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Called when the UI needs the next row (at {position}) to be <b>filled with data</b> rendered
     * and passes the {@link ViewHolder} which should be filled with data.
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        // Use the transaction at index {position} to set up the row's UI widgets
        holder.name.setText(transactions.get(position).getName());
        holder.date.setText(transactions.get(position).getDate());
        holder.status.setText(transactions.get(position).getStatus());
        holder.image.setImageResource(transactions.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inform the click listener that this row was clicked and pass the Transaction
                // associated with this row.
                /*if (listener != null) {
                    listener.onTransactionClicked(transactions.get(holder.getAdapterPosition()));
                }*/
            }
        });
    }

    /**
     * Used to determine how many rows the list should be in total.
     */
    @Override
    public int getItemCount() {
        return transactions.size();
    }

    /**
     * Holds the UI widgets which will comprise a single row in the list (to render
     * a {@link Transaction}).
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView name;
        TextView status;
        TextView date;
        ImageView image;

        ViewHolder(View rootView) {
            super(rootView);
            cardView = rootView.findViewById(R.id.card_container);
            name = rootView.findViewById(R.id.name);
            status = rootView.findViewById(R.id.status);
            date = rootView.findViewById(R.id.date);
            image = rootView.findViewById(R.id.foodImage);

        }
    }
}
