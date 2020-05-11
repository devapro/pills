package pro.devapp.medecine.ui.screens.editMedicine

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import pro.devapp.medecine.R
import pro.devapp.medecine.databinding.FragmentMedicineEditBinding
import pro.devapp.medecine.ui.NavigationFragment
import pro.devapp.medecine.utils.dataBinding

class EditMedicineFragment : NavigationFragment() {

    private val viewModel by viewModels<MedicineEditViewModel>()
    private val mBinding by dataBinding<FragmentMedicineEditBinding>(R.layout.fragment_medicine_edit)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.model = viewModel
        setTitle(getString(R.string.add_med_title))
        toggleToolBar(false)
        displayHome()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_done){
            back()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_medicine_menu, menu)
    }
}