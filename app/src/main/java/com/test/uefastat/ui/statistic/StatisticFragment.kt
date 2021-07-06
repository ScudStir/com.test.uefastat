package com.test.uefastat.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.uefastat.adapter.StatisticAdapter
import com.test.uefastat.databinding.FragmentStatisticBinding

class StatisticFragment : Fragment() {
    private var _binding: FragmentStatisticBinding? = null
    private val binding get() = _binding!!

    private val statisticViewModel: StatisticViewModel by activityViewModels<StatisticViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val statisticAdapter = StatisticAdapter()

        binding.statistics.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = statisticAdapter
        }

        statisticViewModel.statistics.observe(viewLifecycleOwner, { stat ->
            stat?.let {
                binding.scrollView.visibility = View.VISIBLE
                binding.progress.visibility = View.INVISIBLE
                statisticAdapter.updateData(stat)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
