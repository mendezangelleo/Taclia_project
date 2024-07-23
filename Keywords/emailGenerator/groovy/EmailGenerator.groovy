package emailGenerator.groovy

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class EmailGenerator {
	private static String filePath = Paths.get(System.getProperty("user.dir"), "Incrementor.txt").toString()

	static String getNextEmail() {
		int number = 0
		if (Files.exists(Paths.get(filePath))) {
			List<String> lines = Files.readAllLines(Paths.get(filePath))
			if (!lines.isEmpty()) {
				number = Integer.parseInt(lines.get(0))
			}
		}
		number++
		Files.write(Paths.get(filePath), String.valueOf(number).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
		return "amendez+utomation${number}@taclia.com"
	}
}