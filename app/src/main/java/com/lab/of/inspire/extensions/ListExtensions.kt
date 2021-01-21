package com.lab.of.inspire.extensions

fun <E> MutableList<E>.clearAndAddAll(elements: List<E>) {
    clear()
    addAll(elements)
}

fun <E> MutableList<E>.addIf(item: E, condition: Boolean) {
    if (condition) add(item)
}

fun <E> MutableList<E>.contains(predicate: (E) -> Boolean): Boolean {
    forEach {
        if (predicate(it)) {
            return true
        }
    }
    return false
}