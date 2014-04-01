package com.orbitz.example.hystrix.repository;

import com.orbitz.example.hystrix.model.Mapping;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Couchbase repository for Flex Mappings.
 */
@Repository
public interface MappingCouchbaseRepository extends CouchbaseRepository<Mapping, String> {

}