package pro.devapp.medecine.ui.screens.tabs.medication

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import pro.devapp.medecine.logic.adapters.MedicinePagerAdapter
import pro.devapp.medecine.logic.viewModel.BaseViewModel

class MedicationViewModel(application: Application, fm: FragmentManager) : BaseViewModel(application) {
    var listener : ActionListener? = null
    val medicinePagerAdapter = MedicinePagerAdapter(fm, application)

    val pageChangeListener = object : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            val selectedScreen = medicinePagerAdapter.getItem(position)
            listener?.onPageSelected(selectedScreen)
        }
    }

    @Suppress("UNCHECKED_CAST")
    class ViewModelFactory(private val application: Application, private val fragmentManager: FragmentManager): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val viewModel = MedicationViewModel(application, fragmentManager)
            return viewModel as T
        }
    }

    interface ActionListener{
        fun onPageSelected(f: Fragment)
        fun onTabSelected(f: Fragment)
    }
}
