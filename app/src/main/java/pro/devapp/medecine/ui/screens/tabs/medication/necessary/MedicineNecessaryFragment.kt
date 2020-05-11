package pro.devapp.medecine.ui.screens.tabs.medication.necessary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedecineNecessaryBinding
import pro.devapp.medecine.utils.dataBinding

class MedicineNecessaryFragment : Fragment() {

    companion object {
        fun newInstance() =
            MedicineNecessaryFragment()
    }

    private val mBinding by dataBinding<FragmentMedecineNecessaryBinding>(R.layout.fragment_medecine_necessary)
    private val viewModel by viewModels<MedicineNecessaryViewModel>()

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
