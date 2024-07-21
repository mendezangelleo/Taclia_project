package geolocation

import com.kms.katalon.core.annotation.Keyword
import groovy.json.JsonSlurper
import java.net.URL

class Geolocation {
	@Keyword
	static String getCountryByIP() {
		try {
			// Usar una API pública para obtener información de geolocalización
			URL url = new URL("http://ip-api.com/json/")
			def connection = url.openConnection()
			connection.setRequestMethod("GET")
			connection.connect()

			if (connection.responseCode == 200) {
				def responseStream = connection.getInputStream()
				def responseText = responseStream.getText()
				def jsonResponse = new JsonSlurper().parseText(responseText)
				return jsonResponse.country // Retorna el nombre del país
			} else {
				throw new Exception("Error al obtener la información de geolocalización")
			}
		} catch (Exception e) {
			e.printStackTrace()
			return null
		}
	}
}
