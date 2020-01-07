package pro.devapp.medecine.ui.tabs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.MedecineNecessaryFragmentBinding
import pro.devapp.medecine.logic.viewModel.MedecineNecessaryViewModel

class MedecineNecessaryFragment : Fragment() {

    private var mBinding: MedecineNecessaryFragmentBinding? = null

    companion object {
        fun newInstance() = MedecineNecessaryFragment()
    }

    private lateinit var viewModel: MedecineNecessaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.medecine_necessary_fragment, container, false)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MedecineNecessaryViewModel::class.java)
        mBinding?.model = viewModel
    }

}
