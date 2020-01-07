package pro.devapp.medecine

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import pro.devapp.medecine.ui.tabs.DiaryFragment
import pro.devapp.medecine.ui.tabs.MedecineListFragment
import pro.devapp.medecine.ui.tabs.ReportsFragment
import pro.devapp.medecine.ui.tabs.SettingsFragment

enum class MainScreen (@IdRes val menuItemId: Int,
                       @DrawableRes val menuItemIconId: Int,
                       @StringRes val titleStringId: Int,
                       val fragment: Fragment
) {
    DIARY(R.id.tab_diary, R.drawable.ic_diary, R.string.bottom_menu_diary, DiaryFragment.newInstance()),
    MEDICATION(R.id.tab_medication, R.drawable.ic_medication, R.string.bottom_menu_medication, MedecineListFragment.newInstance()),
    SETTINGS(R.id.tab_settings, R.drawable.ic_settings, R.string.bottom_menu_settings, SettingsFragment.newInstance()),
    REPORTS(R.id.tab_reports, R.drawable.ic_reports, R.string.bottom_menu_reports, ReportsFragment.newInstance()),
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}