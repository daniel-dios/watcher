package com.tennisbooker.watcher.usecase

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

open class HttpHelper {
    open fun get(url: URL): String {
        val con = url.openConnection() as HttpURLConnection
        con.instanceFollowRedirects = false

        val `in` = BufferedReader(InputStreamReader(con.inputStream))
        val htmlCode = StringBuffer()
        var inputLine: String?

        while (`in`.readLine().also { inputLine = it } != null) {
            htmlCode.append(inputLine)
        }
        return htmlCode.toString()
    }
}