package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class GeneralUse {
    static void close() {
        WebUI.closeBrowser()
    }
}
