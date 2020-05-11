package pro.devapp.medecine.ui

import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class NavigationFragment: Fragment() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                findNavController().popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun toggleToolBar(hide : Boolean){
        setHasOptionsMenu(!hide)
        (activity as MainActivity).toggleToolBar(hide)
    }

    protected fun setScreenTitle(@StringRes titleStringId: Int){
        (activity as MainActivity).setScreenTitle(titleStringId)
    }

    protected fun displayHome(){
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    protected fun setTitle(title: String){
        (activity as MainActivity).supportActionBar?.title = title
    }

    protected fun back(){
        findNavController().popBackStack()
    }
}