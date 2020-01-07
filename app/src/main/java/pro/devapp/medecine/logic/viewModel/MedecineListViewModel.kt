package pro.devapp.medecine.logic.viewModel

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import pro.devapp.medecine.logic.adapters.MedecinePagerAdapter

class MedecineListViewModel(fm: FragmentManager, c: Context) : ViewModel() {
    var listener : ActionListener? = null
    val medecinePagerAdapter = MedecinePagerAdapter(fm, c)

    companion object {
        fun createFactory(fm : FragmentManager, c: Context) : ViewModelProvider.Factory {
            return ViewModelFactory(fm, c)
        }
    }

    val pageChangeListener = object : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            val selectedScreen = medecinePagerAdapter.getItem(position)
            listener?.onPageSelected(selectedScreen)
        }
    }

    @Suppress("UNCHECKED_CAST")
    class ViewModelFactory(fm: FragmentManager, c: Context): ViewModelProvider.NewInstanceFactory() {
        private val fragmentManager = fm
        private val context = c
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val viewModel = MedecineListViewModel(fragmentManager, context)
            return viewModel as T
        }
    }

    interface ActionListener{
        fun onPageSelected(f: Fragment)
        fun onTabSelected(f: Fragment)
    }
}
