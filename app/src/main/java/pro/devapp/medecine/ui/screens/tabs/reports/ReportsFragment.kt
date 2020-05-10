package pro.devapp.medecine.ui.screens.tabs.reports


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentReportsBinding

class ReportsFragment : Fragment() {

    companion object {
        fun newInstance() = ReportsFragment()
    }

    private val viewModel by viewModels<ReportsViewModel>()
    private lateinit var mBinding: FragmentReportsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reports,  container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
    }

}
