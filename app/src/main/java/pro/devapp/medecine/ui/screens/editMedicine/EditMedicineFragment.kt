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
import pro.devapp.medecine.utils.dataBinding

class EditMedicineFragment : Fragment() {

    private val viewModel by viewModels<MedicineEditViewModel>()
    private val mBinding by dataBinding<FragmentMedicineEditBinding>(R.layout.fragment_medicine_edit)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
    }
}