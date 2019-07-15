package com.test.spring.data.solr.config;

//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SolrDataQuery;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import com.test.spring.data.solr.service.QueryService;

@Configuration
@EnableSolrRepositories(basePackages = "com.test.spring.data.solr.repository", namedQueriesLocation = "classpath:solr-named-queries.properties", multicoreSupport = true)
@ComponentScan
public class SolrConfig {

    @Bean
    public SolrServer solrServer() {
//        return new HttpSolrServer("http://172.26.29.204:8983/solr/search_common_document_info");
        return new HttpSolrServer("http://172.26.29.204:8983/solr");
    }

    @Bean
    public SolrTemplate solrTemplate(SolrServer server) throws Exception {
        SolrTemplate solrTemplate =  new SolrTemplate(server);
        solrTemplate.registerQueryParser(Query.class, new RichQueryParser());
        return solrTemplate;
    }

    @Bean
    public QueryService getQueryService(){
        return new QueryService();
    }

}
