package pro.devapp.medecine.ui.screens.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.viewModels
import pro.devapp.medecine.ui.MainActivity
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentTabsBinding
import pro.devapp.medecine.ui.NavigationFragment
import pro.devapp.medecine.utils.dataBinding

class TabsFragment : NavigationFragment() {

    private val mBinding by dataBinding<FragmentTabsBinding>(R.layout.fragment_tabs)
    private val viewModel by viewModels<TabsViewModel> {
        TabsViewModel.ViewModelFactory(requireActivity().application, childFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val defaultScreen = MainScreen.DIARY
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        setScreenTitle(defaultScreen)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
    }

    override fun onStart() {
        super.onStart()
        viewModel.listener = listener
    }

    override fun onStop() {
        super.onStop()
        viewModel.listener = null
    }

    /**
     * Scrolls `ViewPager` to show the provided screen.
     */
    private fun scrollToScreen(mainScreen: MainScreen) {
        val screenPosition = mBinding.model?.mainPagerAdapter?.getItems()?.indexOf(mainScreen) ?: 0
        if (screenPosition != mBinding.viewPager.currentItem) {
            mBinding.viewPager.currentItem = screenPosition
        }
    }

    /**
     * Set screen toolbar visibility and title
     */
    private fun setScreenTitle(mainScreen: MainScreen){
        if(activity != null) {
            val mainActivity = activity as MainActivity
            setScreenTitle(mainScreen.titleStringId)
            toggleToolBar(true)
        }
    }

    /**
     * Selects the specified item in the bottom navigation view.
     */
    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        mBinding.bottomNavView.selectedItemId = menuItemId
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
