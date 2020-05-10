package pro.devapp.medecine.ui.screens.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.viewModels
import pro.devapp.medecine.MainActivity
import pro.devapp.medecine.databinding.FragmentTabsBinding

class TabsFragment : Fragment() {

    private lateinit var mBinding : FragmentTabsBinding
    private val viewModel by viewModels<TabsViewModel> {
        TabsViewModel.ViewModelFactory(requireActivity().application, childFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTabsBinding.inflate(inflater, container, false)
        mBinding.lifecycleOwner = this
        val defaultScreen = MainScreen.DIARY
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        setScreenTitle(defaultScreen)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.listener = listener
        mBinding.model = viewModel
    }

    override fun onStart() {
        super.onStart()
        mBinding.model?.listener = listener
    }

    override fun onStop() {
        super.onStop()
        mBinding.model?.listener = null
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
            mainActivity.setScreenTitle(mainScreen.titleStringId)
            mainActivity.toggleToolBar(true)
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
