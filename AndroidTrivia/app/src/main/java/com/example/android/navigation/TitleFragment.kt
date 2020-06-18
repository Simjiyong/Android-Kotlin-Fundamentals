package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
                R.layout.fragment_title, container, false)

        binding.apply {
            playButton.setOnClickListener {view: View->
                setNavigate(view, TitleFragmentDirections.actionTitleFragmentToGameFragment())
            }

            rulesButton.setOnClickListener { view: View->
                setNavigate(view, TitleFragmentDirections.actionTitleFragmentToRulesFragment())
            }

            aboutButton.setOnClickListener { view: View->
                setNavigate(view, TitleFragmentDirections.actionTitleFragmentToAboutFragment())
            }

        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun setNavigate(view: View, navDirections: NavDirections){
        view.findNavController().navigate(navDirections)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        Log.d("1","called : onCreateOptionMenu")
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Log.d("2", "called : onOptionsItemSelected")
        return NavigationUI.onNavDestinationSelected(item!!,
                view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
