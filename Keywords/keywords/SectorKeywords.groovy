package keywords

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType
import groovy.json.JsonSlurper
import com.kms.katalon.core.annotation.Keyword

class SectorKeywords {
	@Keyword
	static String getRandomSectorId() {
		// Realiza la solicitud al endpoint
		RequestObject request = new RequestObject()
		request.setRestUrl("https://api.taclia.com/api/sectors")
		request.setRestRequestMethod("GET")
		request.setHttpHeaderProperties([
			new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
		])

		ResponseObject response = WS.sendRequest(request)

		// Verificar si la respuesta es un JSON válido
		if (response.getStatusCode() == 200) {
			try {
				def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())
				def sectors = jsonResponse as List

				if (sectors.isEmpty()) {
					println("La lista de sectores está vacía.")
					return null
				}

				// Obtener los _id de los sectores
				def ids = sectors.collect { it._id }.findAll { it != null }

				if (ids.isEmpty()) {
					println("No se encontraron IDs válidos.")
					return null
				}

				def randomId = ids[new Random().nextInt(ids.size())]
				return randomId
			} catch (Exception e) {
				println("Error al parsear la respuesta JSON: " + e.getMessage())
				return null
			}
		} else {
			println("Error en la solicitud: " + response.getStatusCode() + " - " + response.getResponseBodyContent())
			return null
		}
	}
}