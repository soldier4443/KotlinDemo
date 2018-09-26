package com.turastory.kotlindemo.kotlin.app

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.turastory.kotlindemo.R

/**
 * ViewHolder - android extensions in ViewHolder
 */
class ResultItemAdapter : RecyclerView.Adapter<ResultItemAdapter.ResultItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemViewHolder {
        return ResultItemViewHolder(parent.inflate(R.layout.common_layout_result_training_score))
    }

    private fun ViewGroup.inflate(@LayoutRes layoutId: Int): View {
        return LayoutInflater.from(context).inflate(layoutId, this, false)
    }

    override fun onBindViewHolder(holder: ResultItemViewHolder, viewType: Int) {
        // stub
        holder.bind(0, "asdf", false)
    }

    override fun getItemCount(): Int {
        // stub
        return 0
    }

    class ResultItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(score: Int, name: String, isBeta: Boolean) {
            with(itemView) {
                score_text.text = context.getString(R.string.result_score_unit, score)
                course_name.text = name

                if (isBeta)
                    beta_icon!!.visibility = View.VISIBLE
                else
                    beta_icon!!.visibility = View.INVISIBLE
            }
        }
    }
}
