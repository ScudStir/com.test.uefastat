package com.test.uefastat.ui.best

import androidx.lifecycle.ViewModel
import com.test.uefastat.data.MatchDataSource

class BestViewModel  : ViewModel() {
    private val _list = MatchDataSource().bestMatches
    val list = _list
}