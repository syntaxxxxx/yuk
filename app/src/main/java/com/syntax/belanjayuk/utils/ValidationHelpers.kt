package com.syntax.belanjayuk.utils

import java.util.regex.Pattern

/**
 * this file include function for check input user validation
 * */

const val EMAIL_REGEX =
    "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
const val MIN_CHARACTER_LENGTH = 5

fun isFirstNameValid(firstName: String) = firstName.length >= MIN_CHARACTER_LENGTH
fun isLastNameValid(lastName: String) = lastName.length >= MIN_CHARACTER_LENGTH
fun isEmailValid(email: String) = Pattern.matches(EMAIL_REGEX, email)
fun isPasswordValid(password: String) = password.length >= MIN_CHARACTER_LENGTH
fun isConfirmPassword(password: String, confirmPassword: String) = isPasswordValid(password) && isPasswordValid(confirmPassword) && password == confirmPassword