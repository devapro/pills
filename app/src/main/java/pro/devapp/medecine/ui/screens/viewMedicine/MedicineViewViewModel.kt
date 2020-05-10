package pro.devapp.medecine.ui.screens.viewMedicine

import android.app.Application
import android.view.View
import pro.devapp.medecine.logic.viewModel.BaseViewModel

class MedicineViewViewModel(application: Application) : BaseViewModel(application) {

    var f : Float = 0f

    fun onClockBack(v: View) {

    }

    fun getData() : String {
        return f.toString()
    }
}
