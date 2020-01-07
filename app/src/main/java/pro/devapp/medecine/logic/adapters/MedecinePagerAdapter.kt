package pro.devapp.medecine.logic.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pro.devapp.medecine.R
import pro.devapp.medecine.ui.tabs.MedecineNecessaryFragment
import pro.devapp.medecine.ui.tabs.MedecineScheduledFragment

class MedecinePagerAdapter(fm : FragmentManager, c: Context) : FragmentPagerAdapter(fm){

    private val NUM_ITEMS = 2
    private val context = c

    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MedecineScheduledFragment.newInstance()
            1 -> MedecineNecessaryFragment.newInstance()
            else -> MedecineScheduledFragment.newInstance()
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