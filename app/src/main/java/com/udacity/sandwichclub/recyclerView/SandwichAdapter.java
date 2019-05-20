package com.udacity.sandwichclub.recyclerView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.MyApplication;


public class SandwichAdapter extends RecyclerView.Adapter<SandwichAdapter.MyViewHolder> {

    private final String[] sandwiches;


    public SandwichAdapter(String[] sandwiches){
        this.sandwiches = sandwiches;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        final MyViewHolder vh = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                launchDetailActivity(position);
            }
        });
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
      myViewHolder.textView.setText(sandwiches[i]);

    }


    @Override
    public int getItemCount() {
        return sandwiches.length;
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(MyApplication.getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        MyApplication.getContext().startActivity(intent);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);

        }

    }
}
