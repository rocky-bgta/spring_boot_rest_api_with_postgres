package com.nybsys.tillboxweb.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookDetailsRepository extends JpaRepository<BookDetails,Long> {
}
