package pro.devapp.medecine.ui.screens.tabs

import android.app.Application
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import pro.devapp.medecine.logic.adapters.MainPagerAdapter
import pro.devapp.medecine.logic.viewModel.BaseViewModel

class TabsViewModel(application: Application, fm : FragmentManager) : BaseViewModel(application) {
    var listener : ActionListener? = null
    val mainPagerAdapter : MainPagerAdapter = MainPagerAdapter(fm)

    init {
        mainPagerAdapter.setItems(arrayListOf(MainScreen.DIARY, MainScreen.MEDICATION, MainScreen.SETTINGS, MainScreen.REPORTS))
    }

    val bottomNavigationListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
            getMainScreenForMenuItem(menuItem.itemId)
                ?.let {
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
    class ViewModelFactory(private val application: Application, private val fragmentManager: FragmentManager): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val viewModel = TabsViewModel(application, fragmentManager)
            return viewModel as T
        }
    }

    interface ActionListener{
        fun onPageSelected(tab : MainScreen)
        fun onNavigationItemSelected(tab : MainScreen)
    }
}
