package pro.devapp.medecine.ui.screens.viewMedicine


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicineViewBinding

class MedicineViewFragment : Fragment() {

    private lateinit var mBinding : FragmentMedicineViewBinding
    private val viewModel by viewModels<MedicineViewViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_medicine_view, container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
    }
}
