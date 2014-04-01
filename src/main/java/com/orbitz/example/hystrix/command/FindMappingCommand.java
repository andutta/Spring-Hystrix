package com.orbitz.example.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.orbitz.example.hystrix.model.Mapping;
import com.orbitz.example.hystrix.repository.MappingCouchbaseRepository;
import com.orbitz.example.hystrix.repository.MappingSolrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Hystrix command that retrieves mappings from Couchbase, and
 * reverts to Solr in a failure situation.  Times out after 100ms.
 */
@Component("findMappingCommand")
@Scope("prototype")
public class FindMappingCommand extends HystrixCommand<Mapping> {

    private String id;

    @Autowired
    private MappingSolrRepository mappingSolrRepository;

    @Autowired
    private MappingCouchbaseRepository mappingCouchbaseRepository;

    /**
     * Instantiates the command.
     *
     * @param id The mapping key.
     */
    public FindMappingCommand(String id) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("blah"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionIsolationThreadTimeoutInMilliseconds(100)));
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Mapping run() throws Exception {
        return mappingCouchbaseRepository.findOne(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Mapping getFallback() {
    	return null;
       // return mappingSolrRepository.findOne(id);
    }
}
