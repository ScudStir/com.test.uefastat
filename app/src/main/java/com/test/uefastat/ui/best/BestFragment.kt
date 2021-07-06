package com.test.uefastat.ui.best

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.test.uefastat.adapter.BestAdapter
import com.test.uefastat.databinding.FragmentBestBinding

class BestFragment : Fragment() {
    private var _binding: FragmentBestBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BestViewModel by activityViewModels<BestViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBestBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bestAdapter = BestAdapter(requireContext())

        binding.viewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = bestAdapter
        }
        bestAdapter.updateData(viewModel.list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}