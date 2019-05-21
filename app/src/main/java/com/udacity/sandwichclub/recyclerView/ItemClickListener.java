package com.udacity.sandwichclub.recyclerView;

import android.view.View;

public interface ItemClickListener {
    //using interface to implement click on item in RecyclerView
    void onClick(View view, int position);
}
