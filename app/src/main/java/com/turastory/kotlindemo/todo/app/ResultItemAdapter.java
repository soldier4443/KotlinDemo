package com.turastory.kotlindemo.todo.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.turastory.kotlindemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ViewHolder - android extensions in ViewHolder
 */
public class ResultItemAdapter extends RecyclerView.Adapter<ResultItemAdapter.ResultItemViewHolder> {
    @NonNull
    @Override
    public ResultItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResultItemViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.common_layout_result_training_score, parent, false));
    }
    
    @Override
    public void onBindViewHolder(@NonNull ResultItemViewHolder holder, int viewType) {
        // stub
        holder.bind(0, "asdf", false);
    }
    
    @Override
    public int getItemCount() {
        // stub
        return 0;
    }
    
    static class ResultItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.course_name)
        TextView courseName;
        @BindView(R.id.score_text)
        TextView scoreText;
        @BindView(R.id.beta_icon)
        ImageView betaIcon;
        
        public ResultItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        
        public void bind(int score, String name, boolean isBeta) {
            scoreText.setText(scoreText.getContext().getString(R.string.result_score_unit, score));
            courseName.setText(name);
            
            if (isBeta)
                betaIcon.setVisibility(View.VISIBLE);
            else
                betaIcon.setVisibility(View.INVISIBLE);
        }
    }
}
