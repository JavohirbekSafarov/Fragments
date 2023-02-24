package com.javohirbekcoder.fragments
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.javohirbekcoder.fragments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        laodFragment(Home_Fragment())

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    laodFragment(Home_Fragment())
                    true
                }
                R.id.search-> {
                    laodFragment(Search_Fragment())
                    true
                }
                R.id.add -> {
                    laodFragment(Add_Fragment())
                    true
                }
                R.id.like -> {
                    laodFragment(Like_Fragment())
                    true
                }
                R.id.account -> {
                    laodFragment(AccountFragment())
                    true
                }
                else -> {
                    laodFragment(Home_Fragment())
                    true
                }
            }
        }
    }

    private fun laodFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in,
            R.anim.slide_out,
            R.anim.slide_in,
            R.anim.slide_out
        )
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}

