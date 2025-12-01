package com.spring.jpa.JPA.Repository;

import com.spring.jpa.JPA.Entity.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PageRepository extends CrudRepository<Page,Long> {
}
