package pro.devapp.medecine.ui.screens.viewMedicine

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicineViewBinding

class MedicineViewFragment : Fragment() {

    var mBinding : FragmentMedicineViewBinding? = null

    companion object {
        fun newInstance() =
            MedicineViewFragment()
    }

    private lateinit var viewModel: MedecineViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_medicine_view, container, false)
        mBinding?.lifecycleOwner = this
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MedecineViewViewModel::class.java)
        mBinding?.model = viewModel
    }
}
