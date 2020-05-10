package pro.devapp.medecine.ui.screens.tabs.medication

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicationBinding

class MedicationFragment : Fragment() {

    var mBinding : FragmentMedicationBinding? = null

    companion object {
        fun newInstance() =
            MedicationFragment()
    }

    private lateinit var viewModel: MedecicationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_medication, container, false)
        mBinding?.lifecycleOwner = this
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, MedecicationViewModel.createFactory(childFragmentManager, activity!!)).get(
            MedecicationViewModel::class.java)
        mBinding?.model = viewModel
    }

}
