package pro.devapp.medecine.ui.screens.editMedicine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicineEditBinding

class EditMedicineFragment : Fragment() {

    private val viewModel by viewModels<MedicineEditViewModel>()
    private lateinit var mBinding: FragmentMedicineEditBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_medecine_necessary, container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
    }
}