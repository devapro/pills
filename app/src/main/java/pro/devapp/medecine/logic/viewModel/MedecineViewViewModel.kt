package pro.devapp.medecine.logic.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class MedecineViewViewModel : ViewModel() {

    var f : Float = 0f

    fun onClockBack(v: View) {

    }

    fun getData() : String {
        return f.toString()
    }
}
