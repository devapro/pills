package pro.devapp.medecine.ui

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import pro.devapp.medecine.MainActivity
import pro.devapp.medecine.MainScreen

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.TabsFragmentBinding
import pro.devapp.medecine.logic.viewModel.TabsViewModel

class TabsFragment : Fragment() {

    private var mBinding : TabsFragmentBinding? = null
    private lateinit var viewModel: TabsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.tabs_fragment, container, false)
        mBinding?.lifecycleOwner = this
        val defaultScreen = MainScreen.DIARY
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        setScreenTitle(defaultScreen)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(mBinding?.model == null){
            viewModel = ViewModelProviders.of(this, TabsViewModel.createFactory(activity!!.supportFragmentManager)).get(TabsViewModel::class.java)
            mBinding?.model = viewModel
            mBinding?.model?.listener = listener
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mBinding?.model?.listener = listener
    }

    override fun onDetach() {
        super.onDetach()
        mBinding?.model?.listener = null
    }

    /**
     * Scrolls `ViewPager` to show the provided screen.
     */
    private fun scrollToScreen(mainScreen: MainScreen) {
        val screenPosition = mBinding?.model?.mainPagerAdapter?.getItems()?.indexOf(mainScreen) ?: 0
        if (screenPosition != mBinding?.viewPager?.currentItem) {
            mBinding?.viewPager?.currentItem = screenPosition
        }
    }

    /**
     * Set screen toolbar visibility and title
     */
    private fun setScreenTitle(mainScreen: MainScreen){
        if(activity != null) {
            val mainActivity = activity as MainActivity
            mainActivity.setScreenTitle(mainScreen.titleStringId)
            mainActivity.toggleToolBar(true)
        }
    }

    /**
     * Selects the specified item in the bottom navigation view.
     */
    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        mBinding?.bottomNavView?.selectedItemId = menuItemId
    }

    private val listener = object : TabsViewModel.ActionListener{
        override fun onPageSelected(tab: MainScreen) {
            selectBottomNavigationViewMenuItem(tab.menuItemId)
            setScreenTitle(tab)
        }

        override fun onNavigationItemSelected(tab: MainScreen) {
            scrollToScreen(tab)
            setScreenTitle(tab)
        }
    }
}
