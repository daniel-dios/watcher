package link.tennisbooker.watcher.infra

import link.tennisbooker.watcher.usecase.HttpHelper
import link.tennisbooker.watcher.usecase.LegacyService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan
@Configuration
class ApplicationConfiguration {

    @Bean
    fun legacyService(): LegacyService {
        return LegacyService(HttpHelper())
    }
}
