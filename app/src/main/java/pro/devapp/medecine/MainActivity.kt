package pro.devapp.medecine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import pro.devapp.medecine.databinding.ActivityMainBinding
import pro.devapp.medecine.logic.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.model = viewModel
        mainBinding.lifecycleOwner = this
        setSupportActionBar(mainBinding.toolbar)

    }

    fun setScreenTitle(@StringRes titleStringId: Int){
        mainBinding.toolbar.setTitle(titleStringId)
    }

    fun toggleToolBar(hide : Boolean){
        mainBinding.toolbar.visibility = if (hide) GONE else VISIBLE
    }
}
