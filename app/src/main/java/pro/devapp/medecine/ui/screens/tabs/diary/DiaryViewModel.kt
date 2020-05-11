package pro.devapp.medecine.ui.screens.tabs.diary

import android.app.Application
import android.view.View
import pro.devapp.medecine.logic.viewModel.BaseViewModel

class DiaryViewModel(application: Application) : BaseViewModel(application) {

    var listener: ActionListener? = null

    fun onClickAdd(v: View){
        listener?.onClickAdd()
    }

    interface ActionListener {
        fun onClickAdd()
    }
}
