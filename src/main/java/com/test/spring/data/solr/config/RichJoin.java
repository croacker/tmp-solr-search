package com.test.spring.data.solr.config;

import java.text.MessageFormat;

import org.springframework.util.Assert;

public class RichJoin{

    private static final String TEMPLATE = "'{'!join from={0} to={1} fromIndex={2}'}'{3}";

    private String from;

    private String to;

    private String fromIndex;

    private String condition;

    public RichJoin() {
    }

    public static RichJoin.Builder from(String from) {
        return new RichJoin.Builder(from);
    }

    public String asString() {
        return MessageFormat.format(TEMPLATE, from, to, fromIndex, condition);
    }

    public static class Builder {
        private RichJoin join;

        public Builder(String from) {
            Assert.notNull(from);
            this.join = new RichJoin();
            this.join.from = from;
        }

        public Builder toField(String to) {
            Assert.notNull(to);
            this.join.to = to;
            return this;
        }

        public Builder fromIndex(String toIndex) {
            Assert.notNull(toIndex);
            this.join.fromIndex = toIndex;
            return this;
        }

        public RichJoin condition(String condition) {
            Assert.notNull(condition);
            this.join.condition = condition;
            return this.join;
        }
    }

}
