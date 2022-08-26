package com.github.akhilsunilkumar.springbootreactivecouchbase.listeners

import com.github.akhilsunilkumar.springbootreactivecouchbase.config.TestPropertyConfig
import io.kotest.core.listeners.ProjectListener
import org.testcontainers.couchbase.BucketDefinition
import org.testcontainers.couchbase.CouchbaseContainer
import org.testcontainers.couchbase.CouchbaseService

object CouchbaseListener: ProjectListener {

    val cluster by lazy {
        CouchbaseContainer()
            .withBucket(
                BucketDefinition(TestPropertyConfig.REPOSITORY_BUCKET)
                    .withPrimaryIndex(true)
                    .withQuota(100)
            )
            .withCredentials(TestPropertyConfig.REPOSITORY_USERNAME, TestPropertyConfig.REPOSITORY_PASSWORD)
            .withEnabledServices(CouchbaseService.INDEX, CouchbaseService.KV, CouchbaseService.QUERY)
            .withReuse(true)
            .withLabel("application", "springboot-reactive-couchbase")
    }

    override suspend fun beforeProject() {
        cluster.start()
    }

    override suspend fun afterProject() {
        cluster.stop()
    }
}