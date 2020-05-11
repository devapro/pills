package pro.devapp.medecine.ui.screens.tabs.medication.scheduled


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedecineScheduledBinding
import pro.devapp.medecine.utils.dataBinding

class MedicineScheduledFragment : Fragment() {

    companion object {
        fun newInstance() =
            MedicineScheduledFragment()
    }

    private val mBinding by dataBinding<FragmentMedecineScheduledBinding>(R.layout.fragment_medecine_scheduled)
    private val viewModel by viewModels<MedicineScheduledViewModel>()

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
