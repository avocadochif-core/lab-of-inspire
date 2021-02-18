package com.lab.of.inspire.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun MutableLiveData<Unit>.execute() {
    this.postValue(Unit)
}

fun MutableLiveData<Unit>.executeIf(condition: Boolean) {
    if (condition) { this.postValue(Unit) }
}

/**
 * Short for of observer(owner, Observer { func })
 */
fun <T: Any?> LiveData<T>.obs(owner: LifecycleOwner, func: (t: T) -> Unit) {
    observe(owner, Observer { func(it) })
}