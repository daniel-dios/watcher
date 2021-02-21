package com.tennisbooker.watcher.infra

import com.tennisbooker.watcher.usecase.HttpHelper
import com.tennisbooker.watcher.usecase.LegacyService
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
