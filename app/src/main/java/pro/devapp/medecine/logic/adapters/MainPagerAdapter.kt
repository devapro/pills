package pro.devapp.medecine.logic.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pro.devapp.medecine.ui.screens.tabs.MainScreen
import pro.devapp.medecine.ui.screens.tabs.diary.DiaryFragment
import pro.devapp.medecine.ui.screens.tabs.medication.MedicationFragment
import pro.devapp.medecine.ui.screens.tabs.reports.ReportsFragment
import pro.devapp.medecine.ui.screens.tabs.settings.SettingsFragment

class MainPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val screens = arrayListOf<MainScreen>()

    fun setItems(screens: List<MainScreen>) {
        this.screens.apply {
            clear()
            addAll(screens)
            notifyDataSetChanged()
        }
    }

    fun getItems(): List<MainScreen> {
        return screens
    }

    override fun getItem(position: Int): Fragment {
        return when(screens[position]){
            MainScreen.DIARY -> DiaryFragment.newInstance()
            MainScreen.MEDICATION -> MedicationFragment.newInstance()
            MainScreen.SETTINGS -> SettingsFragment.newInstance()
            MainScreen.REPORTS -> ReportsFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return screens.size
    }

}