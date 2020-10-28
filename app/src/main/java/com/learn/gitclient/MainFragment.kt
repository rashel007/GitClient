package com.learn.gitclient

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.learn.gitclient.network.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*


@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainViewModel.getData()

        mainViewModel.publicRepoList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataState.LOADING -> {
                    // show progress bar
                    Log.d("MainFragment-loading", "Loading")
                }

                is DataState.SUCCESS -> {
                    Toast.makeText(requireContext(), it.data.get(0).name, Toast.LENGTH_LONG).show()
                    Log.d("MainFragment-success", it.data.get(0).name)
                }

                is DataState.FAILURE -> {
                    Log.d("MainFragment-failure", "${it.error} - ${it.code}")
                }

                is DataState.EXCEPTION -> {
                    Log.d("MainFragment-exception", it.error)
                }
            }
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDetails.setOnClickListener {
            val details =  "Passing Details to naother fragment using SafeArgs"
            val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(details = details)
            findNavController().navigate(action)
        }
    }
}