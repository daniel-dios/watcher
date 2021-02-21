package link.tennisbooker.watcher.usecase

import java.net.URL

class LegacyService(private val httpHelper: HttpHelper) {

    fun getBookings(date: String?, endpoint: String, paramNameForDate: String): String {
        val htmlResponse = httpHelper.get(getUrl(date))

        return modifyHtmlToPointToNewService(htmlResponse, endpoint, paramNameForDate)
    }

    private fun modifyHtmlToPointToNewService(
        htmlResponse: String,
        endpoint: String,
        paramNameForDate: String
    ): String {
        val domSplitByBody = htmlResponse.split("<body>")
        val bodySplitByEndOfTag = domSplitByBody[1].split("</body>")

        val body = bodySplitByEndOfTag[0]
        val replaced = body
            .replace("reservas_diarias.php", endpoint)
            .replace("?fecha=", "?$paramNameForDate=")

        return domSplitByBody[0] + "<body>" + replaced + "</body>" + bodySplitByEndOfTag[1]
    }

    private fun getUrl(date: String?): URL {
        if (!date.isNullOrEmpty()) {
            return URL("http://www.reservasctp.es/reservas_diarias.php?fecha=$date")
        }
        return URL("http://www.reservasctp.es/reservas_diarias.php")
    }
}
