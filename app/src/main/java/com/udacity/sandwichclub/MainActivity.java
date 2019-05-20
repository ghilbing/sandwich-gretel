package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayAdapter<String> adapter;
    private Parcelable state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);
        adapter = new ArrayAdapter<>(this, R.layout.list_item, sandwiches);


        // Simplification: Using a ListView instead of a RecyclerView
        listView = findViewById(R.id.sandwiches_listview);

        listView.setAdapter(adapter);
        if (state != null){
            Log.d("TRYING", "trying to restore selection");
            listView.onRestoreInstanceState(state);
        }
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
        });
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        Log.i("SAVING", "SAVING STATE");
        state = listView.onSaveInstanceState();
        super.onPause();
    }
}
