package emailGenerator.groovy

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.Random

class EmailGenerator {
	private static String emailListPath = Paths.get(System.getProperty("user.dir"), "EmailsUsed.txt").toString()

	static String getNextEmail() {
		// Generar cadena aleatoria
		String randomString = generateRandomString(8)

		String email = "amendez+${randomString}@taclia.com"

		// Guardar el email generado en el archivo
		saveEmail(email)

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

	private static void saveEmail(String email) {
		try {
			Files.write(Paths.get(emailListPath), (email + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND)
		} catch (IOException e) {
			e.printStackTrace()
		}
	}
}
