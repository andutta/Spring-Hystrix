package com.orbitz.example.hystrix.repository;

import com.orbitz.example.hystrix.model.Mapping;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Solr repository for Flex Mappings.
 */
@Repository
public interface MappingSolrRepository extends SolrCrudRepository<Mapping, String> {

}
