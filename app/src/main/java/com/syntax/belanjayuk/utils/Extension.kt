package com.syntax.belanjayuk.utils

import android.support.annotation.LayoutRes
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText


/**
 * this function for inflate your layout
 * */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

/**
 * interface for event listener
 * */
inline fun View.OnClick(crossinline onClickHandler: () -> Unit) {
    setOnClickListener { onClickHandler() }
}

/**
 * reference https://developer.android.com/reference/android/text/TextWatcher
 * */
inline fun EditText.onTextChange(crossinline onTextChangeHandler: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(input: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChangeHandler(input?.toString() ?: "")
        }
    })
}