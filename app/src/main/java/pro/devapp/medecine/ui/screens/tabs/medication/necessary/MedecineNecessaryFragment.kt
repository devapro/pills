package pro.devapp.medecine.ui.screens.tabs.medication.necessary

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedecineNecessaryBinding

class MedecineNecessaryFragment : Fragment() {

    private var mBinding: FragmentMedecineNecessaryBinding? = null

    companion object {
        fun newInstance() =
            MedecineNecessaryFragment()
    }

    private lateinit var viewModel: MedecineNecessaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_medecine_necessary, container, false)
        mBinding?.lifecycleOwner = this
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MedecineNecessaryViewModel::class.java)
        mBinding?.model = viewModel
    }

}
