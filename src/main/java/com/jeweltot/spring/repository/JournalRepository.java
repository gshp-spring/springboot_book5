package com.jeweltot.spring.repository;

import java.util.Date;
import java.util.List;

import com.jeweltot.spring.domain.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "entry", path = "journal")
public interface JournalRepository extends JpaRepository<JournalEntity, Long>
{
    List<JournalEntity> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date);

    List<JournalEntity> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date after
                                            , @Param("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date before);

    List<JournalEntity> findByTitleContaining(@Param("word") String word);

    List<JournalEntity> findBySummaryContaining(@Param("word") String word);
}
