package com.example.lifecycleandlogging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.lifecycleandlogging.databinding.ActivityMainBinding
import timber.log.Timber

const val KEY_NUMBER_VALUE = "number_key"

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    
    val simpleNumber = SimpleIncrementalNums(this.lifecycle)
    var numLatestValue : Int = 0
    override fun onCreate(savedInstanceState : Bundle?) {
        
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        
        // restore numLatest value from bundle
        if (savedInstanceState != null) {
            
            numLatestValue = savedInstanceState.getInt(KEY_NUMBER_VALUE)
            
            simpleNumber.setNumOnCreate(numLatestValue)
            
            binding.clickableTextView.text = numLatestValue.toString()
        }
        
        binding.clickableTextView.setOnClickListener {
            
            numLatestValue = (simpleNumber.incNumberOneByOne())
            
            binding.clickableTextView.text = numLatestValue.toString()
        }
        
        Timber.i("onCreate called!")
    }
    
    override fun onSaveInstanceState(outState : Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("onSavedInstanceState called!!! ")
        
        outState.putInt(KEY_NUMBER_VALUE , numLatestValue)
        
    }
}
