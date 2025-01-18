package com.shashank.day7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shashank.day7.databinding.ActivityMainBinding
import com.shashank.day7.sharedPref.SharedPrefViewModel
import com.shashank.day7.sharedPref.SharedPrefViewModelFactory

class MainActivity : AppCompatActivity() {
    private var mainBinding  :ActivityMainBinding? = null
    private val mViewModel : MyViewModel by viewModels()
    private val mSharedPrefViewModel : SharedPrefViewModel by viewModels {
        SharedPrefViewModelFactory(getSharedPreferences("my_pref", MODE_PRIVATE))
    }
//    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)
        //viewModelCounter()


      mainBinding?.apply {
          tvUsername.setText(mSharedPrefViewModel.getUserName())
          etUsername.setText(mSharedPrefViewModel.getUserName())
          button.setOnClickListener {
              val username = etUsername.text.toString()
              mSharedPrefViewModel.saveUserName(username)
          }
      }
    }

//    @SuppressLint("SetTextI18n")
//    fun normalCounter(){
//        mainBinding?.apply {
//            tvCount.text = counter.toString()
//            button.setOnClickListener {
//                counter++
//                tvCount.text = counter.toString()
//            }
//        }
//    }

    @SuppressLint("SetTextI18n")
    fun viewModelCounter(){
        mViewModel.counter.observe(this){
            mainBinding?.tvCount?.text = it.toString()
        }
        mainBinding?.button?.setOnClickListener {
            mViewModel.incrementCounter()
        }
    }
}