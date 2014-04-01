package com.orbitz.example.hystrix;

import com.couchbase.client.CouchbaseClient;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactoryBean;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring config.
 */
@Configuration
@EnableSolrRepositories
@EnableCouchbaseRepositories
@ComponentScan({"com.orbitz.example"})
public class SpringConfig extends AbstractCouchbaseConfiguration {

    @Bean
    public EmbeddedSolrServerFactoryBean solrServerFactory() {
        EmbeddedSolrServerFactoryBean factoryBean = new EmbeddedSolrServerFactoryBean();

        factoryBean.setSolrHome("classpath:solr");

        return factoryBean;
    }

    @Bean
    public SolrServer solrServer() throws Exception {
        return solrServerFactory().getObject();
    }

    @Bean
    public SolrTemplate solrTemplate() throws Exception {
        return new SolrTemplate(solrServer());
    }

    @Bean
    public List<URI> hosts() throws URISyntaxException {
        return new ArrayList<URI>() {
            {
                add(new URI("http://rfast-mbp.duncllc.com:8091/pools"));
            }
        };
    }

    @Bean
    @Override
    public CouchbaseClient couchbaseClient() throws Exception {
        return new CouchbaseClient(hosts(), "default", "");
    }
}
