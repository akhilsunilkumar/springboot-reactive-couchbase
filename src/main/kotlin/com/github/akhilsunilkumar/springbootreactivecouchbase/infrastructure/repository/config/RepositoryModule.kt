package com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.config

import com.couchbase.client.java.Cluster
import com.couchbase.client.java.ReactiveCluster
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Repository

@Repository
class RepositoryModule(
    private val repositoryConfig: RepositoryConfig
) {

    @Bean
    fun cluster(): ReactiveCluster {
        val cluster: Cluster = Cluster.connect(repositoryConfig.ip, repositoryConfig.username, repositoryConfig.password)
        return cluster.reactive()
    }
}