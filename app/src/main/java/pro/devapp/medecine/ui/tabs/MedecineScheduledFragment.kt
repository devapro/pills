package pro.devapp.medecine.ui.tabs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.MedecineScheduledFragmentBinding
import pro.devapp.medecine.logic.viewModel.MedecineScheduledViewModel

class MedecineScheduledFragment : Fragment() {

    private var mBinding : MedecineScheduledFragmentBinding? = null

    companion object {
        fun newInstance() = MedecineScheduledFragment()
    }

    private lateinit var viewModel: MedecineScheduledViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.medecine_scheduled_fragment, container, false)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MedecineScheduledViewModel::class.java)
        mBinding?.model = viewModel
    }

}
