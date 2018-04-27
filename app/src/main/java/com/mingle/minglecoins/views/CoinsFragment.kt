package com.mingle.minglecoins.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mingle.minglecoins.R
import android.view.*
import com.mingle.minglecoins.databinding.FragmentCoinsBinding
import com.mingle.minglecoins.models.Coin
import com.mingle.minglecoins.viewmodels.CoinsViewModel


class CoinsFragment : Fragment() {

//    private var mListener: OnListFragmentInteractionListener? = null
    private lateinit var binding: FragmentCoinsBinding
    private lateinit var adapter: CoinsRecyclerViewAdapter















    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_coins, container, false)
        val coinsViewModel = ViewModelProviders.of(this).get(CoinsViewModel::class.java)
        binding.coinsViewModel  = coinsViewModel
        adapter = CoinsRecyclerViewAdapter(arrayListOf(), Glide.with(this))
        binding.rvCoins.layoutManager = LinearLayoutManager(context)
        binding.rvCoins.adapter = adapter
        binding.rvCoins.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        if (coinsViewModel.loadedCoinList()) {
            coinsViewModel.getPrices()
        } else {
            coinsViewModel.getCoins()
            coinsViewModel.coins.observe(this, Observer <List<Coin>>{
                it?.let {
                    adapter.replaceData(it)
                    adapter.notifyDataSetChanged()
                    coinsViewModel.getPrices()
                }
            })
        }
        
        if (1>0) {}



        return binding.root
    }


//    override fun onAttach(context: Context?) {
//        super.onAttach(context)
//        if (context is OnListFragmentInteractionListener) {
//            mListener = context
//        } else {
//            throw RuntimeException(context!!.toString() + " must implement OnListFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        mListener = null
//    }
//
//    interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: Coin)
//    }
}
