package pro.devapp.medecine.ui.screens.tabs.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {

    companion object {
        fun newInstance() = DiaryFragment()
    }

    private lateinit var mBinding: FragmentDiaryBinding

    private val viewModel by viewModels<DiaryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_diary, container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
    }

}
