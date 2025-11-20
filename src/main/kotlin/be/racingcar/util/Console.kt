package be.racingcar.util

import java.util.Scanner

object Console {

    private var scanner: Scanner? = null

    fun readLine(): String {
        return getInstance().nextLine()
    }

    fun close() {
        scanner?.close()
        scanner = null
    }

    private fun getInstance(): Scanner {
        if (scanner == null) {
            scanner = Scanner(System.`in`)
        }
        return scanner!!
    }

}
