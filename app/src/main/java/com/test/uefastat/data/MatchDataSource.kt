package com.test.uefastat.data

import com.test.uefastat.R
import com.test.uefastat.model.Match

class MatchDataSource () {
    private val _bestMatches = listOf<Match>(
        Match(R.drawable.atlanta_psg_1_2, R.string.match_a_p_title, R.string.match_a_p),
        Match(R.drawable.barcelona_bavariya_2_8, R.string.match_b_b_title, R.string.match_b_b),
        Match(R.drawable.chelsi_ayaks_4_4, R.string.match_ch_a_title, R.string.match_ch_a),
        Match(R.drawable.dinamo_shakhtar_3_3, R.string.match_d_sh_title, R.string.match_d_sh),
        Match(R.drawable.leipzig_benfica_2_2, R.string.match_r_b_title, R.string.match_r_b),
        Match(R.drawable.liverpool_atletico_2_3, R.string.match_l_a_title, R.string.match_l_a),
        Match(R.drawable.liverpool_salzburg_4_3, R.string.match_l_z_title, R.string.match_l_z),
        Match(R.drawable.valencia_atalanta_3_4, R.string.match_v_a_title, R.string.match_v_a)
    )
    val bestMatches get() = _bestMatches
}