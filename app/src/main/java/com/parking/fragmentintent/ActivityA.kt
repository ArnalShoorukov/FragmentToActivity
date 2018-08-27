package com.parking.fragmentintent

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityA : AppCompatActivity(),
        FragmentA.OnFragmentInteractionListener{


    override fun openIntent(int: Int) {
        val i = Intent(this, ActivityB::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment()
    }

    private fun startFragment() {

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, FragmentA())
        ft.commit()
    }

}
