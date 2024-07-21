package emailGenerator.groovy

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class EmailGenerator {
	private static String filePath = 'C:\\Users\\mende\\Katalon Studio\\My First Web UI Project\\Incrementor.txt'

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
		return "amendez+automation${number}@taclia.com"
	}
}
