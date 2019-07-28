package com.syntax.belanjayuk.model

import com.syntax.belanjayuk.utils.isConfirmPassword
import com.syntax.belanjayuk.utils.isEmailValid
import com.syntax.belanjayuk.utils.isFirstNameValid
import com.syntax.belanjayuk.utils.isLastNameValid

data class Inputan(
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
) {

    fun isValid(): Boolean =
        isFirstNameValid(firstName)
                && isLastNameValid(lastName)
                && isEmailValid(email)
                && isConfirmPassword(password, confirmPassword)
}