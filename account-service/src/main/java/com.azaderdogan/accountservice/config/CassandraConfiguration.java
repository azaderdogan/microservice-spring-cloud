package com.azaderdogan.accountservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {



    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.port}")
    private int port;
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoint;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpaceName;


    @Value("${spring.data.cassandra.password}")
    private String password;


    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
                .createKeyspace(keySpaceName).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication();
        return Collections.singletonList(specification);
    }

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.azaderdogan.accountservice"};
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;

    }

    @Override
    public CassandraClusterFactoryBean cluster() {

        CassandraClusterFactoryBean cassandraClusterFactoryBean =  super.cluster();
        cassandraClusterFactoryBean.setPassword(password);
        cassandraClusterFactoryBean.setUsername(username);
        return cassandraClusterFactoryBean;
    }
}
