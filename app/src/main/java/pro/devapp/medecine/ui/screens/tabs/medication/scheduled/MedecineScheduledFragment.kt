package pro.devapp.medecine.ui.screens.tabs.medication.scheduled

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedecineScheduledBinding

class MedecineScheduledFragment : Fragment() {

    private var mBinding : FragmentMedecineScheduledBinding? = null

    companion object {
        fun newInstance() =
            MedecineScheduledFragment()
    }

    private lateinit var viewModel: MedecineScheduledViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_medecine_scheduled, container, false)
        mBinding?.lifecycleOwner = this
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MedecineScheduledViewModel::class.java)
        mBinding?.model = viewModel
    }

}
