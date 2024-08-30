package liskov_substitution_princicple

import java.io.File

// Родительские классы должны быть заменяемыми их детишками

// Следующий код ошибочен, так как мы не можем заменить класс родителя на его ребенка не изменив содержимое вызывающего класса
/*
open class FileLogger {

    fun logError(error: String) {
        val file = File("errors.txt")
        file.appendText(
            text = error
        )
    }
}

class CustomFileLogger: FileLogger() {
    fun customLogError(error: String) {
        val file = File("custom_error_file.txt")
        file.appendText(
            text = error
        )
    }
}*/

// Вместо этого унаследуем метод logError:
open class FileLogger {

    fun logError(error: String) {
        val file = File("errors.txt")
        file.appendText(
            text = error
        )
    }
}

class CustomFileLogger: FileLogger() {
    fun customLogError(error: String) {
        val file = File("custom_error_file.txt")
        file.appendText(
            text = error
        )
    }
}

