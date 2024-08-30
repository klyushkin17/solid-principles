package org.example.single_responsibility

import single_responsibility.FileLogger
import java.io.File
import java.lang.Exception

//Должна существовать лишь одна причина для изменения класса
//Классы и функции должны выполнять один единственный функционал


//Проблемы: Функция loginUser выполняет как функционал логирования пользователя
//так и логирование ошибок, что не соответствует принципу S
/*
class MainRepository(
    private val auth: FirebaseAuth
) {
     suspend fun loginUser(email: String, password: String) {
         try {
            auth.signIn(email, password).await()
         } catch (e: Exception) {
             val file = File("errors.txt")
             file.appendText(
                 text = e.message.toString()
             )
         }
     }
}*/

//Решим данную проблему с помощью вывода обработки ошибки в отдельный класс
class MainRepository(
    private val auth: FirebaseAuth
    private val logger: FileLogger
) {
    suspend fun loginUser(email: String, password: String) {
        try {
            auth.signIn(email, password).await()
        } catch (e: Exception) {
            logger.logError(e.message.toString())
        }
   }
}
