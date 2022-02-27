package it.wakala.talkrepo.extension

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import it.wakala.talkrepo.R

fun FragmentActivity.getNavController(idNavController: Int = R.id.main_navigation): NavController? {
    val navFragment = supportFragmentManager.findFragmentById(idNavController)
    if (navFragment is NavHostFragment) {
        return navFragment.navController
    }
    return null
}

fun FragmentActivity.setUpNavController(
    navView: BottomNavigationView,
    idNavController: Int = R.id.main_navigation
) {
    getNavController(idNavController)?.let {
        NavigationUI.setupWithNavController(navView, it)
    }
}