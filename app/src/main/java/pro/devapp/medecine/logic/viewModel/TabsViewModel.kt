package pro.devapp.medecine.logic.viewModel

import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import pro.devapp.medecine.MainPagerAdapter
import pro.devapp.medecine.MainScreen
import pro.devapp.medecine.getMainScreenForMenuItem

class TabsViewModel(fm : FragmentManager) : ViewModel() {
    var listener : ActionListener? = null
    var mainPagerAdapter : MainPagerAdapter = MainPagerAdapter(fm)

    init {
        mainPagerAdapter.setItems(arrayListOf(MainScreen.DIARY, MainScreen.MEDICATION, MainScreen.SETTINGS, MainScreen.REPORTS))
    }

    companion object {
        fun createFactory(fm : FragmentManager) : ViewModelProvider.Factory {
            return ViewModelFactory(fm)
        }
    }

    val bottomNavigationListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
            getMainScreenForMenuItem(menuItem.itemId)?.let {
                listener?.onNavigationItemSelected(it)
                return true
            }
            return false
        }
    }

    val pageChangeListener = object : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            val selectedScreen = mainPagerAdapter.getItems()[position]
            listener?.onPageSelected(selectedScreen)
        }
    }

    @Suppress("UNCHECKED_CAST")
    class ViewModelFactory(fm: FragmentManager): ViewModelProvider.NewInstanceFactory() {
        private val fragmentManager = fm
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val viewModel = TabsViewModel(fragmentManager)
            return viewModel as T
        }
    }

    interface ActionListener{
        fun onPageSelected(tab : MainScreen)
        fun onNavigationItemSelected(tab : MainScreen)
    }
}
