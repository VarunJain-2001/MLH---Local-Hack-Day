package com.example.don8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {//simplements TransactionAdapter.TransactionClickedListener {
    private String name;
    private String status;
    private String date;
    private int image;
    private List<Transaction> transactions;

    private TextView title;
    private SearchView search;
    private RecyclerView history;
    private TransactionAdapter transactionsAdapter;
    public static final String KEY_TRANSACTIONS = "TRANSACTIONS";

    public static final String KEY_NAME = "NAME";
    public static final String KEY_STATUS = "STATUS";
    public static final String KEY_DATE = "DATE";
    public static final String KEY_IMAGE = "IMAGE";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_history:
                        //startActivity(new Intent(HistoryActivity.this, HistoryActivity.class));
                        break;
                    case R.id.action_data:
                        startActivity(new Intent(HistoryActivity.this, AnalyticsActivity.class));                        break;
                    case R.id.action_donate:
                        startActivity(new Intent(HistoryActivity.this, ConfirmationActivity.class));                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(HistoryActivity.this, ProfileActivity.class));
                        break;
                }
                return true;
            }
        });


        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Transaction one = new Transaction("Donation to Food To You Mobile Food Pantry", "May 25, 2019", "Donation Successful.", R.drawable.rice);
        Transaction two = new Transaction("Donation to Project Soup", "May 23, 2019", "Donation Successful.", R.drawable.casserole);
        Transaction three = new Transaction("Donation to FoodLink", "May 20, 2019", "Donation Successful.", R.drawable.pizza2);
        Transaction four = new Transaction("Donation to Food Bank", "May 18, 2019", "Donation Successful.", R.drawable.lobster);
        Transaction five = new Transaction("Donation to Project Bread", "May 15, 2019", "Donation Successful.", R.drawable.chickenmac);
        Transaction six = new Transaction("Donation to Red Cross", "May 12, 2019", "Donation Successful.", R.drawable.dinner);
        Transaction seven = new Transaction("Donation to St. Christopher's Food Drive", "May 9, 2019", "Donation Successful.", R.drawable.cake2);
        Transaction eight = new Transaction("Donation to The Shelter", "May 3, 2019", "Donation Successful.", R.drawable.pizza);
        Transaction nine = new Transaction("Donation to FoodLink", "May 1, 2019", "Donation Successful.", R.drawable.cake);

        transactions.add(one);
        transactions.add(two);
        transactions.add(three);
        transactions.add(four);
        transactions.add(five);
        transactions.add(six);
        transactions.add(seven);
        transactions.add(eight);
        transactions.add(nine);


        System.out.println(getIntent().getSerializableExtra(KEY_TRANSACTIONS));
        //transactions = (List<Transaction>) getIntent().getSerializableExtra(KEY_TRANSACTIONS);
        System.out.println(transactions);

        title = findViewById(R.id.title);
        history=findViewById(R.id.history);

        System.out.println("title: " + title);
        System.out.println("history: " + history);

        transactionsAdapter = new TransactionAdapter(transactions);//, this);
        history.setLayoutManager(new LinearLayoutManager(this));
        history.setAdapter(transactionsAdapter);

    }

}
