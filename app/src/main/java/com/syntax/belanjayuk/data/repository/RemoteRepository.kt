package com.syntax.belanjayuk.data.repository

object RemoteRepository : Repository {

    private val service = Injection.provideBelanjaApi()

    override fun register(firstName: String, lastName: String, email: String, password: String) =
        service.register(firstName, lastName, email, password)

    override fun login(email: String, password: String) = service.login(email, password)
}