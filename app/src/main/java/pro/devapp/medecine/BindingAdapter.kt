package pro.devapp.medecine

import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

@BindingAdapter("onPageChangeListener")
fun bindOnPageChangeListener(viewPager : ViewPager, listener : ViewPager.SimpleOnPageChangeListener){
    viewPager.addOnPageChangeListener(listener)
}

@BindingAdapter("adapter")
fun bindAdapter(viewPager : ViewPager, adapter: FragmentStatePagerAdapter){
    viewPager.adapter = adapter
}

@BindingAdapter("onNavigationItemSelectedListener")
fun bindOnPageChangeListener(bottomView : BottomNavigationView, listener : BottomNavigationView.OnNavigationItemSelectedListener){
    bottomView.setOnNavigationItemSelectedListener(listener)
}