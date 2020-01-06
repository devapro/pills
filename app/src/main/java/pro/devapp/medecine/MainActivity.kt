package pro.devapp.medecine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import pro.devapp.medecine.databinding.ActivityMainBinding
import pro.devapp.medecine.logic.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setSupportActionBar(mainBinding.toolbar)

    }

    fun setScreenTitle(@StringRes titleStringId: Int){
        mainBinding.toolbar.setTitle(titleStringId)
    }

    fun toggleToolBar(hide : Boolean){
        mainBinding.toolbar.visibility = if (hide) GONE else VISIBLE
    }
}
