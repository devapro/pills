package pro.devapp.medecine.ui.tabs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.MedecineListFragmentBinding
import pro.devapp.medecine.logic.viewModel.MedecineListViewModel

class MedecineListFragment : Fragment() {

    var mBinding : MedecineListFragmentBinding? = null

    companion object {
        fun newInstance() = MedecineListFragment()
    }

    private lateinit var viewModel: MedecineListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.medecine_list_fragment, container, false)
        mBinding?.lifecycleOwner = this
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, MedecineListViewModel.createFactory(childFragmentManager, activity!!)).get(MedecineListViewModel::class.java)
        mBinding?.model = viewModel
    }

}
