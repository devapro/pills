package pro.devapp.medecine.ui.screens.tabs.medication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicationBinding

class MedicationFragment : Fragment() {

    lateinit var mBinding : FragmentMedicationBinding

    companion object {
        fun newInstance() =
            MedicationFragment()
    }

    private val viewModel by viewModels<MedicationViewModel>() {
        MedicationViewModel.ViewModelFactory(requireActivity().application, childFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_medication, container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
    }

}
