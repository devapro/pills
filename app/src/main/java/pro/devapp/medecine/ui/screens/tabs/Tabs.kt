package pro.devapp.medecine.ui.screens.tabs

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import pro.devapp.medecine.R
import pro.devapp.medecine.ui.screens.tabs.diary.DiaryFragment
import pro.devapp.medecine.ui.screens.tabs.medication.MedicationFragment
import pro.devapp.medecine.ui.screens.tabs.reports.ReportsFragment
import pro.devapp.medecine.ui.screens.tabs.settings.SettingsFragment

enum class MainScreen (@IdRes val menuItemId: Int,
                       @DrawableRes val menuItemIconId: Int,
                       @StringRes val titleStringId: Int
) {
    DIARY(
        R.id.tab_diary,
        R.drawable.ic_diary,
        R.string.bottom_menu_diary
    ),
    MEDICATION(
        R.id.tab_medication,
        R.drawable.ic_medication,
        R.string.bottom_menu_medication
    ),
    SETTINGS(
        R.id.tab_settings,
        R.drawable.ic_settings,
        R.string.bottom_menu_settings
    ),
    REPORTS(
        R.id.tab_reports,
        R.drawable.ic_reports,
        R.string.bottom_menu_reports
    ),
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}