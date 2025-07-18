package com.example.alemitraining.page.utils

interface Communicator
interface Communicable<T> {
    fun setCommunicator(communicator: T)
}

interface DiscoveryCommunicable : Communicable<PageCommunicator> {

    override fun setCommunicator(communicator: PageCommunicator)
}