package com.test.uefastat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.uefastat.databinding.ItemStatisticBinding
import com.test.uefastat.model.Statistic

class StatisticAdapter : RecyclerView.Adapter<StatisticAdapter.ViewHolder>() {
    private var data: Statistic = Statistic()

    fun updateData(newData: Statistic) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data, position)
    }

    override fun getItemCount() = data.seasons?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStatisticBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder constructor(private val binding: ItemStatisticBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(statistic: Statistic, index: Int) {
            val season = statistic.seasons?.get(index)

            binding.apply {
                column1.text = statistic.name ?: "-"
                column2.text = statistic.areaName ?: "-"

                column3.text = season?.startDate ?: "-"
                column4.text = season?.endDate ?: "-"
                column5.text = season?.winner?.name ?: "-"
            }
        }
    }
}
