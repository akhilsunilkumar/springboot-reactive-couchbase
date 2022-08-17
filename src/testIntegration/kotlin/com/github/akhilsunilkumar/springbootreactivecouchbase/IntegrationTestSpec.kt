package com.github.akhilsunilkumar.springbootreactivecouchbase

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.test.context.ActiveProfiles


@ActiveProfiles("test")
@AutoConfiguration
open class IntegrationTestSpec : BehaviorSpec()