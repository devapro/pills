package pro.devapp.medecine.logic.viewModel

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel (application: Application) : AndroidViewModel(application){
    fun getStringRes(@StringRes resId: Int): String{
        return getApplication<Application>().resources.getString(resId)
    }
}