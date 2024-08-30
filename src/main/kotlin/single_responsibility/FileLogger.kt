package single_responsibility

import java.io.File

class FileLogger {

    fun logError(error: String) {
        val file = File("errors.txt")
        file.appendText(
            text = error
        )
    }
}