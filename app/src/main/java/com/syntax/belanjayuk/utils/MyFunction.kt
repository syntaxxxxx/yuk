package com.syntax.belanjayuk.utils

import android.app.Activity
import android.content.Context
import android.support.annotation.LayoutRes
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

object MyFunction {

    /**
     * this function use only inside activity
     * don't use this function in fragment or diaglog fragment
     * */
    fun hideSoftKeyboard(activity: Activity?) {
        var view = activity?.currentFocus
        if (view == null) view = View(activity)
        val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * this function use everywhere except from Activity
     * */
    fun View.hideSoftKeyboard(context: Context?) {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

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
}