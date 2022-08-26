package com.github.akhilsunilkumar.springbootreactivecouchbase.config

import com.github.akhilsunilkumar.springbootreactivecouchbase.listeners.CouchbaseListener
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext

class TestPropertyConfig : ApplicationContextInitializer<ConfigurableApplicationContext> {

    companion object{
        const val REPOSITORY_BUCKET = "IntegrationTestBucket"
        const val REPOSITORY_USERNAME = "username"
        const val REPOSITORY_PASSWORD = "password"
    }

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        TestPropertyValues.of(
            "repository.ip=localhost:${CouchbaseListener.cluster.getMappedPort(11210)}",
            "repositor.bucket=$REPOSITORY_BUCKET",
            "repositor.username=$REPOSITORY_USERNAME",
            "repositor.password=$REPOSITORY_PASSWORD",
          //  "integration.dependentApi.url=http://localhost:${}"
        )
    }

}