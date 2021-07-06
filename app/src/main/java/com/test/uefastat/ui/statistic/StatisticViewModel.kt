package com.test.uefastat.ui.statistic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.uefastat.api.FootballServiceImpl
import com.test.uefastat.model.Statistic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StatisticViewModel : ViewModel() {
    private val _statistics = MutableLiveData<Statistic>()
    val statistics: LiveData<Statistic> = _statistics

    init {
        loadMessage()
    }

    private fun loadMessage() {

        viewModelScope.launch {
            val result = async {
                with(Dispatchers.IO) {
                    FootballServiceImpl.provideFootballService().loadStatistic(
                        "2001"
                    )
                }
            }
            val stat = result.await()
            stat.body()?.let {
                _statistics.postValue(it)
            }
        }
    }
}