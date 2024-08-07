package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import org.openqa.selenium.WebElement


class GeneralUse {
	static void close() {
		WebUI.closeBrowser()
	}

	static void clickOnDayElementWithTextWhite() {
		TestObject dayElementsObject = new TestObject('DayElements')
		dayElementsObject.addProperty('xpath', ConditionType.EQUALS, '//*[contains(@class, \'w-9\') and contains(@class, \'h-9\') and contains(@class, \'text-xs\') and contains(@class, \'text-center\') and contains(@class, \'font-regular\') and contains(@class, \'rounded-full\') and contains(@class, \'flex\') and contains(@class, \'items-center\') and contains(@class, \'justify-center\') and contains(@class, \'hover:bg-primary-100\')]')

		List<WebElement> elements = WebUI.findWebElements(dayElementsObject, 10)
		int indexOfElementWithTextWhite = -1

		for (int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i)

			if (element.getAttribute('class').contains('text-white')) {
				indexOfElementWithTextWhite = i
				break // Optional: Stop the loop once the element is found
			}
		}

		if (indexOfElementWithTextWhite == -1) {
			WebUI.comment('No element with text-white class found.')
			return
		}

		indexOfElementWithTextWhite += 2

		TestObject dayObject = new TestObject('DayObject')
		dayObject.addProperty('xpath', ConditionType.EQUALS, ('//*[@id="block-schedule-modal"]/div/div/div[2]/form/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/button[' + indexOfElementWithTextWhite) + ']')

		WebUI.click(dayObject)
	}
	
}
