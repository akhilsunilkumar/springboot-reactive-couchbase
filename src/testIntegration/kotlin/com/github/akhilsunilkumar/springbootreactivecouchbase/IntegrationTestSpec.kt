package com.github.akhilsunilkumar.springbootreactivecouchbase

import com.github.akhilsunilkumar.springbootreactivecouchbase.config.TestPropertyConfig
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.config.RepositoryConfig
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.config.RepositoryModule
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.service.MovieRepository
import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@EnableConfigurationProperties
@ContextConfiguration(
    initializers = [TestPropertyConfig::class/*, ConfigFileApplicationContextInitializer::class*/],
    classes = [
        RepositoryConfig::class,
        RepositoryModule::class,
        MovieRepository::class
    ]
)
@ActiveProfiles("test")
@AutoConfiguration
open class IntegrationTestSpec : BehaviorSpec()