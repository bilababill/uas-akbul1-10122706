package com.example.magribmengaji_10122706

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.magribmengaji_10122706.fragments.HomeFragment
import com.example.magribmengaji_10122706.fragments.AlquranFragment
import com.example.magribmengaji_10122706.fragments.BelajarFragment
import com.example.magribmengaji_10122706.fragments.KomunitasFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Home",R.drawable.ic_menu_home)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Alquran",R.drawable.ic_menu_alquran)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"Belajar",R.drawable.ic_menu_belajar)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(4,"Komunitas",R.drawable.ic_menu_komunitas)
        )

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(AlquranFragment())
                }
                2 -> {
                    replaceFragment(HomeFragment())
                }
                3 -> {
                    replaceFragment(BelajarFragment())
                }
                4 -> {
                    replaceFragment(KomunitasFragment())
                }
            }
        }
        //default bottom
        replaceFragment(HomeFragment())
        bottomNavigation.show(2)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}