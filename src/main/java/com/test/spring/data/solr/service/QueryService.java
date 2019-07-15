package com.test.spring.data.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.stereotype.Service;
import com.test.spring.data.solr.config.RichJoin;
import com.test.spring.data.solr.config.RichSolrDataQuery;
import com.test.spring.data.solr.model.CommonDocument;
import com.test.spring.data.solr.repository.CommonDocumentRepository;

@Service
public class QueryService {

    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private CommonDocumentRepository repository;

    public Page<CommonDocument> getByString(String str){
        RichSolrDataQuery query = new RichSolrDataQuery(new SimpleStringCriteria(str));
        query.addSort(new Sort(Sort.Direction.DESC, "reg_date"));
        query.setOffset(0);
        query.setRows(15);

        query.addJoin(RichJoin.from("document_id").toField("object_id").fromIndex("croc_task").condition("user_name:KartSV"));
        query.addJoin(RichJoin.from("document_id").toField("object_id").fromIndex("pretreatment_search").condition("org_id:0c0027d980025da4"));
        return solrTemplate.queryForPage(query, CommonDocument.class);
    }

    public Page<CommonDocument> getFromRepoByString(String str){
        Sort sort = new Sort(Sort.Direction.DESC, "reg_date");
        PageRequest pageRequest = new PageRequest(0, 20, sort);
        Page<CommonDocument> page = repository.findByCustomQuery(str, pageRequest);
        return page;
    }

    public Page<CommonDocument> getFromRepoByString(String str, String filter){
        Sort sort = new Sort(Sort.Direction.DESC, "reg_date");
        PageRequest pageRequest = new PageRequest(0, 20, sort);
        Page<CommonDocument> page = repository.findByCustomQuery(str, filter, pageRequest);
        return page;
    }

    public Page<CommonDocument> getFromRepoByString(String str, String filter, String period){
        Sort sort = new Sort(Sort.Direction.DESC, "reg_date");
        PageRequest pageRequest = new PageRequest(0, 20, sort);
        Page<CommonDocument> page = repository.findByCustomQuery(str, filter, period, pageRequest);
        return page;
    }

    public Page<CommonDocument> findHilghL(String str, String filter, String period){
        Sort sort = new Sort(Sort.Direction.DESC, "reg_date");
        PageRequest pageRequest = new PageRequest(0, 20, sort);
        Page<CommonDocument> page = repository.findHilghL(str, filter, period, pageRequest);
        return page;
    }
}
