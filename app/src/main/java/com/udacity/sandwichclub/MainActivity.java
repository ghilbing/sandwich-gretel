package com.udacity.sandwichclub;


import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.udacity.sandwichclub.recyclerView.SandwichAdapter;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private LinearLayoutManager layout;
    private SandwichAdapter adapter;
    private Bundle mBundleRecyclerViewState;
    private Parcelable mListState = null;

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
        adapter.notifyDataSetChanged();


    }


    @Override
    protected void onPause() {
        super.onPause();
        //This is used to store the state of the recyclerview
        mBundleRecyclerViewState = new Bundle();
        mListState = recyclerView.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(getResources().getString(R.string.recycler_scroll_position_key), mListState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //When orientation is changed
        if (mBundleRecyclerViewState != null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mListState = mBundleRecyclerViewState.getParcelable(getResources().getString(R.string.recycler_scroll_position_key));
                    recyclerView.getLayoutManager().onRestoreInstanceState(mListState);
                }
            }, 50);
        }
        recyclerView.setLayoutManager(layout);
    }
}
