package com.test.spring.data.solr.config;

import org.springframework.data.solr.core.query.*;

import java.util.ArrayList;
import java.util.List;

public class RichSolrDataQuery extends SimpleQuery {

    private List<RichJoin> joins = new ArrayList<RichJoin>();

    public RichSolrDataQuery(Criteria criteria) {
        super(criteria);
    }

    public void addJoin(RichJoin join){
        joins.add(join);
    }

    public List<RichJoin> getJoins() {
        return joins;
    }
}
