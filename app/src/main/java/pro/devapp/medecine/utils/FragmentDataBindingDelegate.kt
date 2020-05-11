package pro.devapp.medecine.utils

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

//  private val mBinding by dataBinding(FragmentMedicineEditBinding::bind)

class FragmentDataBindingDelegate<T : ViewDataBinding>(
    val fragment: Fragment,
    @LayoutRes val resId: Int
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onStop(owner: LifecycleOwner) {
                binding = null
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }

        return createBinding(thisRef).also { it.lifecycleOwner = fragment }.also { this@FragmentDataBindingDelegate.binding = it }
    }

    private fun createBinding(
        fragment: Fragment
    ): T = DataBindingUtil.inflate(LayoutInflater.from(fragment.requireContext()),resId,null,true)
}

fun <T : ViewDataBinding> Fragment.dataBinding(@LayoutRes resId: Int) = FragmentDataBindingDelegate<T>(this, resId)