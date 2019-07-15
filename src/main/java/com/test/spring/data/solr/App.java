package com.test.spring.data.solr;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.test.spring.data.solr.config.SolrConfig;
import com.test.spring.data.solr.model.CommonDocument;
import com.test.spring.data.solr.service.QueryService;

public class App {

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static final String PERIOD_TEMPLATE = "{0} TO {1}";

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SolrConfig.class);

        Calendar myCalendar = new GregorianCalendar(2018, 9-1, 27);
        Date from = myCalendar.getTime();

        myCalendar = new GregorianCalendar(2018, 10-1, 9);
        Date to = myCalendar .getTime();

        String period = MessageFormat.format(PERIOD_TEMPLATE,
                format.format(from),
                format.format(to));

        QueryService service = ctx.getBean(QueryService.class);
        for (CommonDocument product : service.findHilghL("Сибур",
                "incoming internal contract", period)) {
            System.out.println(product);
        }
    }

}
