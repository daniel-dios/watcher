package link.tennisbooker.watcher.usecase

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.net.URL

internal class HttpHelperTest {

    @Test
    internal fun shouldReturnHtml() {
        val actual = HttpHelper().get(URL("http://www.google.com"))

        assertThat(actual).contains(
            """
            <!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="es"><head><meta content=
                    """.trimIndent()
        )
    }
}
