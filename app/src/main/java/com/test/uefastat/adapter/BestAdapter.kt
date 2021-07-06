package com.test.uefastat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.uefastat.databinding.ItemBestBinding
import com.test.uefastat.model.Match

class BestAdapter (val context: Context) : RecyclerView.Adapter<BestAdapter.ViewHolder>() {
    private val data = ArrayList<Match>()

    fun updateData(newData: List<Match>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBestBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class ViewHolder constructor(private val binding: ItemBestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(match: Match) {
            binding.apply {
                imgHeader.setImageResource(match.drawableId)
                txtTitle.text = context.getString(match.titleText)
                txtInfo.text = context.getString(match.text)
            }
        }
    }
}

