package com.parking.fragmentintent

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FragmentA : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    private var adapterList: RecyclerViewAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_fragment_b, container, false)

        val arrayList = ArrayList<String>()
        arrayList.add("One")
        arrayList.add("Two")
        arrayList.add("Three")
        arrayList.add("Four")
        arrayList.add("Five")


        //Bind the recyclerview
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.isNestedScrollingEnabled = false
        //Add a LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapterList = RecyclerViewAdapter(arrayList)
        recyclerView.adapter = adapterList

        adapterList!!.setListener(object : RecyclerViewAdapter.Listener {
            override fun onClick(position: Int) {
                listener!!.openIntent(position)

            }


        })

        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun openIntent(int: Int)

    }

}
