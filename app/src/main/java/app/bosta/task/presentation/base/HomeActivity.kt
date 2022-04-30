package app.bosta.task.presentation.base

import android.util.Log
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import app.bosta.task.presentation.base.extensions.hide
import app.bosta.task.presentation.base.extensions.show
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var nav: NavController

  override
  fun getLayoutId() = R.layout.activity_home

  override
  fun setUpBottomNavigation() {
    setUpBottomNavigationWithGraphs()
  }

  private  val TAG = "HomeActivity"

  private fun setUpBottomNavigationWithGraphs() {
    val navHostFragment =
      supportFragmentManager.findFragmentById(R.id.fragment_host_container) as NavHostFragment
    nav = navHostFragment.findNavController()
    appBarConfiguration = AppBarConfiguration(nav.graph)

    setSupportActionBar(binding.toolbar)
    setupActionBarWithNavController(nav, appBarConfiguration)
//    NavigationUI.setupActionBarWithNavController(this, nav, appBarConfiguration);

    supportActionBar?.setDisplayHomeAsUpEnabled(true);
    supportActionBar?.setDisplayShowHomeEnabled(true);


    nav.addOnDestinationChangedListener { controller, destination, arguments ->

      when (destination.id) {
        R.id.usersFragment -> {
          binding.toolbar.navigationIcon = null;
        }
        R.id.zoomFragment -> {
          binding.toolbar.hide()
        }
        else -> {
          if (binding.toolbar.navigationIcon != ContextCompat.getDrawable(
              this,
              R.drawable.ic_back_primary
            )
          ) {
            Log.d(TAG, "setUpBottomNavigationWithGraphs: HERE")
            binding.toolbar.navigationIcon =
              ContextCompat.getDrawable(this, R.drawable.ic_back_primary)
          }
          binding.toolbar.show()

        }
      }
    }
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }


}