package com.test.spring.data.solr.config;

import java.lang.reflect.Field;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.data.solr.core.DefaultQueryParser;
import org.springframework.data.solr.core.query.AbstractQueryDecorator;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SolrDataQuery;

public class RichQueryParser extends DefaultQueryParser {

    public SolrQuery constructSolrQuery(SolrDataQuery query) {
        SolrQuery solrQuery = this.doConstructSolrQuery(query);
        Query originalQuery = getOriginalQuery(query);
        if (originalQuery instanceof RichSolrDataQuery) {
            appendJoins(solrQuery, (RichSolrDataQuery)originalQuery);
        }
        return solrQuery;
    }

    private void appendJoins(SolrQuery solrQuery, RichSolrDataQuery query) {
        String[] strJoins = new String[query.getJoins().size()];
        for(int i = 0;  i < query.getJoins().size(); i++){
            RichJoin join = query.getJoins().get(i);
            strJoins[i] = join.asString();
        }
        if(strJoins.length != 0) {
            solrQuery.setParam("fq", strJoins);
        }
    }

    private Query getOriginalQuery(SolrDataQuery query){
        Query result = null;
        try {
            Field field = AbstractQueryDecorator.class.getDeclaredField("query");
            field.setAccessible(true);
            result = (Query) field.get(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
