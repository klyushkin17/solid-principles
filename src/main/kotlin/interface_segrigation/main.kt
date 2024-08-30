package interface_segrigation

import java.io.File

// Классы не должны использовать функции интерфейсов, который им не нужны

interface FileLogger {

    fun printLogs(){}

    fun logError(error: String) {
        val file = File("errors.txt")
        file.appendText(
            text = error
        )
    }
}

class CustomFileLogger: FileLogger {
    override fun logError(error: String) {
        val file = File("custom_error_file.txt")
        file.appendText(
            text = error
        )
    }
}