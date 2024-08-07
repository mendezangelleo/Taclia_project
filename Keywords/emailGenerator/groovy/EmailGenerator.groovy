package emailGenerator.groovy

import java.util.Random
import java.nio.file.Paths
import java.nio.file.StandardOpenOption



class EmailGenerator {
    static String getNextEmail() {
        // Generar cadena aleatoria
        String randomString = generateRandomString(8)
        String email = "amendez+${randomString}@taclia.com"
        return email
    }

    private static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        Random random = new Random()
        StringBuilder sb = new StringBuilder()
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())))
        }
        return sb.toString()
    }
}
