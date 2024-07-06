package com.queirozzzzzzzzzz.estufasemestufa.ui.environment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.queirozzzzzzzzzz.estufasemestufa.R
import com.queirozzzzzzzzzz.estufasemestufa.databinding.ActivityEnvironmentBinding
import com.queirozzzzzzzzzz.estufasemestufa.repository.EnvironmentRepository
import com.queirozzzzzzzzzz.estufasemestufa.repository.PictureRepository
import com.queirozzzzzzzzzz.estufasemestufa.repository.PlantRepository
import com.queirozzzzzzzzzz.estufasemestufa.repository.TimetableRepository
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments.EnvironmentCreateTaskFragment
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments.EnvironmentEditTaskFragment
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments.EnvironmentGalleryFragment
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments.EnvironmentMainFragment
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments.EnvironmentManageTasksFragment
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments.EnvironmentTasksFragment
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments.EnvironmentTasksHistoryFragment
import com.queirozzzzzzzzzz.estufasemestufa.ui.environments.EnvironmentsActivity
import com.queirozzzzzzzzzz.estufasemestufa.ui.manageEnvironment.ManageEnvironmentActivity
import com.queirozzzzzzzzzz.estufasemestufa.ui.manageEnvironment.ManageEnvironmentViewModel
import com.queirozzzzzzzzzz.estufasemestufa.ui.manageEnvironment.fragments.ManageEnvironmentEditPlantFragment
import kotlinx.coroutines.launch

class EnvironmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnvironmentBinding
    private lateinit var manageEnvironmentViewModel: ManageEnvironmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnvironmentBinding.inflate(layoutInflater)
        val view = binding.root

        manageEnvironmentViewModel =
            ManageEnvironmentViewModel(
                EnvironmentRepository(application),
                PictureRepository(application),
                PlantRepository(application),
                TimetableRepository(application),
            )

        startFragment(EnvironmentMainFragment())

        setContentView(view)
    }

    private fun startFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout, fragment)

        fragmentTransaction.commit()
    }

    fun editEnvironmentActivity(view: View) {
        lifecycleScope.launch {
            manageEnvironmentViewModel.setEditEnvironment()
        }

        val intent = Intent(this, ManageEnvironmentActivity::class.java)
        startActivity(intent)
    }

    fun mainFragment(view: View?) {
        startFragment(EnvironmentMainFragment())
    }

    fun editPlantFragment(view: View) {
        startFragment(ManageEnvironmentEditPlantFragment())
    }

    fun galleryFragment(view: View) {
        startFragment(EnvironmentGalleryFragment())
    }

    fun tasksFragment(view: View) {
        startFragment(EnvironmentTasksFragment())
    }

    fun tasksHistoryFragment(view: View) {
        startFragment(EnvironmentTasksHistoryFragment())
    }

    fun manageTasksFragment(view: View) {
        startFragment(EnvironmentManageTasksFragment())
    }

    fun createTaskFragment(view: View) {
        startFragment(EnvironmentCreateTaskFragment())
    }

    fun editTaskFragment(view: View) {
        startFragment(EnvironmentEditTaskFragment())
    }

    fun deleteEnvironment(view: View) {
        dialogBox()
    }

    private fun deleteEnvironmentAccepted() {
        lifecycleScope.launch {
            manageEnvironmentViewModel.deleteEnvironment {
                deleteEnvironmentActivity()
            }
        }
    }

    private fun dialogBox() {
        val alert: AlertDialog.Builder = AlertDialog.Builder(this)
        alert.setTitle(title)
        alert.setMessage("Você tem certeza que deseja excluir este ambiente?")

        alert.setNegativeButton(
            "Cancelar",
        ) { dialog, whichButton -> }

        alert.setPositiveButton(
            "Sim",
        ) { dialog, whichButton ->
            deleteEnvironmentAccepted()
        }

        alert.show()
    }

    private fun deleteEnvironmentActivity() {
        val intent = Intent(this, EnvironmentsActivity::class.java)
        startActivity(intent)
        finish()
    }
}
