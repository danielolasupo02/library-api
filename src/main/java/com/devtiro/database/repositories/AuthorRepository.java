package com.devtiro.database.repositories;

import com.devtiro.database.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    @Query("SELECT a FROM AuthorEntity a WHERE a.age < :age")
    Iterable<AuthorEntity> ageLesThan(@Param("age")int age);

    @Query("SELECT a FROM AuthorEntity a WHERE a.age > :age")
    Iterable<AuthorEntity> findAuthorsWithAgeGreaterThan(int age);
}
