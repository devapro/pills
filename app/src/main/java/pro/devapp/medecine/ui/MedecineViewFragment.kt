package pro.devapp.medecine.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.MedecineViewFragmentBinding
import pro.devapp.medecine.logic.viewModel.MedecineViewViewModel

class MedecineViewFragment : Fragment() {

    var mBinding : MedecineViewFragmentBinding? = null

    companion object {
        fun newInstance() = MedecineViewFragment()
    }

    private lateinit var viewModel: MedecineViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.medecine_view_fragment, container, false)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MedecineViewViewModel::class.java)
        mBinding?.model = viewModel
    }
}
