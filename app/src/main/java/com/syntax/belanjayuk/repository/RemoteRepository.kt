package com.syntax.belanjayuk.repository

object RemoteRepository : Repository {

    private val api = Injection.provideBelanjaApi()

    override fun register(firstName: String, lastName: String, email: String, password: String) =
        api.register(firstName, lastName, email, password)

    override fun login(email: String, password: String) = api.login(email, password)
}