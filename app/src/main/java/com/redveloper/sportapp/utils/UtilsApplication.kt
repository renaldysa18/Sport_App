package com.redveloper.sportapp.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(msg : String){
    Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
}