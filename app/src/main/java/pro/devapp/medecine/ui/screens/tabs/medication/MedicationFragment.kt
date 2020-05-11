package pro.devapp.medecine.ui.screens.tabs.medication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicationBinding
import pro.devapp.medecine.utils.dataBinding

class MedicationFragment : Fragment() {

    companion object {
        fun newInstance() =
            MedicationFragment()
    }

    private val mBinding by dataBinding<FragmentMedicationBinding>(R.layout.fragment_medication)
    private val viewModel by viewModels<MedicationViewModel>() {
        MedicationViewModel.ViewModelFactory(requireActivity().application, childFragmentManager)
    }

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

}
