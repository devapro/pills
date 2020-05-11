package pro.devapp.medecine.ui.screens.tabs.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentDiaryBinding
import pro.devapp.medecine.ui.screens.tabs.TabsFragmentDirections
import pro.devapp.medecine.utils.dataBinding

class DiaryFragment : Fragment() {

    companion object {
        fun newInstance() = DiaryFragment()
    }

    private val mBinding by dataBinding<FragmentDiaryBinding>(R.layout.fragment_diary)
    private val viewModel by viewModels<DiaryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

    private val listener = object : DiaryViewModel.ActionListener{
        override fun onClickAdd() {
            val action = TabsFragmentDirections.actionTabsFragmentToEditMedicineFragment()
            findNavController().navigate(action)
        }
    }
}
