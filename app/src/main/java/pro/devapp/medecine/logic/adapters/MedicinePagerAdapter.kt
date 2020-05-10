package pro.devapp.medecine.logic.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pro.devapp.medecine.R
import pro.devapp.medecine.ui.screens.tabs.medication.necessary.MedicineNecessaryFragment
import pro.devapp.medecine.ui.screens.tabs.medication.scheduled.MedicineScheduledFragment

class MedicinePagerAdapter(fm : FragmentManager, private val context: Context) : FragmentPagerAdapter(fm){

    private val NUM_ITEMS = 2

    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MedicineScheduledFragment.newInstance()
            1 -> MedicineNecessaryFragment.newInstance()
            else -> MedicineScheduledFragment.newInstance()
        }
    }

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> context.getString(R.string.tab_medicines_schedule)
            1 -> context.getString(R.string.tab_medicines_necessary)
            else -> context.getString(R.string.tab_medicines_schedule)
        }
    }

}