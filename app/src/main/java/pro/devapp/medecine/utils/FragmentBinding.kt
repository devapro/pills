package pro.devapp.medecine.utils

import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentBinding<out T : ViewDataBinding>(
    @LayoutRes private val resId: Int
) : ReadOnlyProperty<Fragment, T> {

    private var binding: T? = null

    override operator fun getValue(
        thisRef: Fragment,
        property: KProperty<*>
    ): T = binding ?: createBinding(thisRef).also { binding = it }

    private fun createBinding(
        fragment: Fragment
    ): T = DataBindingUtil.inflate(LayoutInflater.from(fragment.requireContext()),resId,null,true)
}