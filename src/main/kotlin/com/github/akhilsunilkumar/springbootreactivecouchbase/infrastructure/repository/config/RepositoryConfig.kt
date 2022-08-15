package com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "repository")
data class RepositoryConfig(
    var ip: String? = null,
    var bucket: String? = null,
    var username: String? = null,
    var password: String? = null
)