package dependency_inversion

import single_responsibility.FileLogger
import java.lang.Exception

// Классы должны зависеть от абстракций, а не от имплементаций

// Ошибка заключается в том, что следующий класс зависит от имплементации FirebaseAuth
/*class MainRepository(
    private val auth: Authenticator,
    private val logger: FileLogger
) {
    suspend fun loginUser(email: String, password: String) {
        try {
            auth.signIn(email, password).await()
        } catch (e: Exception) {
            logger.logError(e.message.toString())
        }
    }
}*/

// Создадим интерфейс (абстракцию)
class MainRepository(
    private val auth: Authenticator,
    private val logger: FileLogger
) {
    suspend fun loginUser(email: String, password: String) {
        try {
            auth.signIn(email, password)
        } catch (e: Exception) {
            logger.logError(e.message.toString())
        }
    }
}

interface Authenticator {

    suspend fun signIn(email: String, password: String)

}

class FirebaseAuthenticator: Authenticator {
    override suspend fun signIn(email: String, password: String) {
        // регистрация
    }
}

class CustomApiAuthenticator: Authenticator {
    override suspend fun signIn(email: String, password: String) {
        // регистрация
    }
}