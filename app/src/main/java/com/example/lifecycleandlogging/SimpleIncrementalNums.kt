package com.example.lifecycleandlogging

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

class SimpleIncrementalNums(lifecycle : Lifecycle) : LifecycleObserver {
    init {
        // connect the lifecycle object passed in from the owner (the activity) to this class (the observer)
        lifecycle.addObserver(this)
    }
    
    var number = 0
        private set
    
    
    fun setNumOnCreate(newNum : Int) {
        number = newNum
        
    }
    
    fun incNumberOneByOne() : Int {
        return ++number
    }
    
    
}