package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.udacity.sandwichclub.recyclerView.SandwichAdapter;

public class MainActivity extends AppCompatActivity {


  //  private ListView listView;
    private RecyclerView recyclerView;
    private LinearLayoutManager layout;
    private SandwichAdapter adapter;
   // private ArrayAdapter<String> adapter;
    private Parcelable state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.sandwiches_recyclerView);

        //to improve performance
        recyclerView.setHasFixedSize(true);

        //use a linear layout manager
        layout = new LinearLayoutManager(this);



        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);
        //adapter = new ArrayAdapter<>(this, R.layout.list_item, sandwiches);

        //set a layout manager
        layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);

        //specify an adapter
        adapter = new SandwichAdapter(sandwiches);
        recyclerView.setAdapter(adapter);


        // Simplification: Using a ListView instead of a RecyclerView
       /* listView = findViewById(R.id.sandwiches_listview);

        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                view.setSelected(true);
                launchDetailActivity(position);
            }
        });*/
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        Log.i("SAVING", "SAVING STATE");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Keep selected item position when scroll or rotate
        super.onSaveInstanceState(outState);

    }
}
