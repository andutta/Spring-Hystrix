package com.orbitz.example.hystrix;

import com.orbitz.example.hystrix.command.FindMappingCommand;
import com.orbitz.example.hystrix.model.Mapping;
import com.orbitz.example.hystrix.repository.MappingCouchbaseRepository;
import com.orbitz.example.hystrix.repository.MappingSolrRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service facade for finding Flex Mappings.
 */
@Service
public class MappingService implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Autowired
    private MappingSolrRepository solrRepository;

    @Autowired
    private MappingCouchbaseRepository couchbaseRepository;

    /**
     * Find mapping by its key.
     *
     * @param id The key to find a mapping for.
     * @return The Flex Mapping.
     */
    public Mapping findMappingById(String id) {
        FindMappingCommand command = (FindMappingCommand) beanFactory
                .getBean("findMappingCommand", id);

        return command.execute();
    }

    /**
     * Inserts a mapping into Solr and Couchbase.
     *
     * @param mapping The Flex Mapping.
     */
    public void insertMapping(Mapping mapping) {
       // solrRepository.save(mapping);
        couchbaseRepository.save(mapping);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}