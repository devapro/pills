package pro.devapp.medecine.ui.screens.viewMedicine


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicineViewBinding
import pro.devapp.medecine.utils.dataBinding

class MedicineViewFragment : Fragment() {

    private val mBinding by dataBinding<FragmentMedicineViewBinding>(R.layout.fragment_medicine_view)
    private val viewModel by viewModels<MedicineViewViewModel> ()

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
