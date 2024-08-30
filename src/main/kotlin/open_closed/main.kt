package open_closed

import java.io.File

// Классы должны быть доступны для расширения, но закрыты для модификации

// Допустим, нам необходимо изменить название файла, в который будут складываться логги, но
// если изменить название внутри самого класса (модифицировать его). Изменеия затронут все участки кода,
// даже те, где эти изменения не нужны

// Чтобы этого избежать, воспользуемся наседованием
open class FileLogger {

    open fun logError(error: String) {
        val file = File("errors.txt")
        file.appendText(
            text = error
        )
    }
}

// Теперь, если мы вызовем функцию из этого класса, это не повлияет на места, где использовалась функция из класса родителя
class CustomFileLogger: FileLogger() {
    override fun logError(error: String) {
        val file = File("custom_error_file.txt")
        file.appendText(
            text = error
        )
    }
}

