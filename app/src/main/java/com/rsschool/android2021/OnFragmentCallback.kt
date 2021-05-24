package com.rsschool.android2021

interface OnFragmentCallback {
    fun openSecondFragment(min: Int, max: Int)

    fun openFirstFragment(result: Int)
}