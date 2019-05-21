package com.udacity.sandwichclub.recyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.MyApplication;


public class SandwichAdapter extends RecyclerView.Adapter<SandwichAdapter.MyViewHolder> {

    private String[] sandwiches;
    private int index = -1;


    public SandwichAdapter(String[] sandwiches){
        this.sandwiches = sandwiches;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
      myViewHolder.textView.setText(sandwiches[i]);
      myViewHolder.setItemClickListener(new ItemClickListener() {
          @Override
          public void onClick(View view, int position) {
              index = position;
              launchDetailActivity(index);
              notifyDataSetChanged();
          }
      });

      //Set highlight color
        if (index == i) {
            myViewHolder.itemView.setBackgroundColor(Color.parseColor("#03DAC5"));
            myViewHolder.textView.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else{
            myViewHolder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            myViewHolder.textView.setTextColor(Color.parseColor("#000000"));
        }

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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public TextView textView;
        ItemClickListener itemClickListener;

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());

        }
    }

}
