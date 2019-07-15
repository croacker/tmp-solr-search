package com.test.spring.data.solr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.data.solr.model.CommonDocument;

public interface CommonDocumentRepository extends SolrCrudRepository<CommonDocument, String> {

    List<CommonDocument> findByObjectId(String name);

    @Query(value="?0", filters = {"object_type:(?1)", "reg_date:[?2]"})
    @Highlight(prefix = "<span class=\"search-item-document-description-highlight\">", postfix = "</span>", fields = {"*"})
    HighlightPage<CommonDocument> findHilghL(String searchTerm, String identifiers, String period, Pageable pageable);

    @Query(value="?0", filters = {"object_type:(?1)", "reg_date:[?2]"})
    Page<CommonDocument> findByCustomQuery(String searchTerm, String identifiers, String period, Pageable pageable);

    //identifier:(233678 224269)
    @Query(value="?0", filters = {"object_type:(?1)"})
    Page<CommonDocument> findByCustomQuery(String searchTerm, String identifiers, Pageable pageable);

    @Query("?0")
    Page<CommonDocument> findByCustomQuery(String searchTerm, Pageable pageable);

    @Query("?0")
    Page<CommonDocument> findByCustomString(String searchTerm, Pageable pageable);

    @Query(name = "Product.findByNamedQuery")
    Page<CommonDocument> findByNamedQuery(String searchTerm, Pageable pageable);

}
