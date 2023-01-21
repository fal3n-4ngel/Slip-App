package com.example.slipapp.slips

import androidx.annotation.StringRes
import com.example.slipapp.R

data class Slip(
    @StringRes val title: Int,
    @StringRes val date: Int,
    @StringRes val grantedBy: Int,
    @StringRes val status: Int,
    val statusValue: Int
) {

}

val slips= mutableListOf(
    Slip(title = R.string.slip_1_title, date = R.string.slip_1_date, grantedBy = R.string.slip_1_granted_by, status = R.string.slip_status_accepted, 0),
    Slip(title = R.string.slip_2_title, date = R.string.slip_2_date, grantedBy = R.string.slip_2_granted_by, status = R.string.slip_status_accepted, 0),
    Slip(title = R.string.slip_3_title, date = R.string.slip_3_date, grantedBy = R.string.slip_granted_by, status = R.string.slip_status, 1)
)