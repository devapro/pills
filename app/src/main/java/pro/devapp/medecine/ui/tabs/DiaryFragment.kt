package pro.devapp.medecine.ui.tabs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.DiaryFragmentBinding
import pro.devapp.medecine.logic.viewModel.DiaryViewModel

class DiaryFragment : Fragment() {

    var mBinding: DiaryFragmentBinding? = null

    companion object {
        fun newInstance() = DiaryFragment()
    }

    private lateinit var viewModel: DiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.diary_fragment, container, false)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DiaryViewModel::class.java)
        mBinding?.model = viewModel
    }

}
