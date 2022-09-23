package com.system.po;

import java.util.ArrayList;
import java.util.List;

public class DatiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStuidIsNull() {
            addCriterion("stuid is null");
            return (Criteria) this;
        }

        public Criteria andStuidIsNotNull() {
            addCriterion("stuid is not null");
            return (Criteria) this;
        }

        public Criteria andStuidEqualTo(Integer value) {
            addCriterion("stuid =", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotEqualTo(Integer value) {
            addCriterion("stuid <>", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThan(Integer value) {
            addCriterion("stuid >", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stuid >=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThan(Integer value) {
            addCriterion("stuid <", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThanOrEqualTo(Integer value) {
            addCriterion("stuid <=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidIn(List<Integer> values) {
            addCriterion("stuid in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotIn(List<Integer> values) {
            addCriterion("stuid not in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidBetween(Integer value1, Integer value2) {
            addCriterion("stuid between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotBetween(Integer value1, Integer value2) {
            addCriterion("stuid not between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidIsNull() {
            addCriterion("zuoyeid is null");
            return (Criteria) this;
        }

        public Criteria andZuoyeidIsNotNull() {
            addCriterion("zuoyeid is not null");
            return (Criteria) this;
        }

        public Criteria andZuoyeidEqualTo(Integer value) {
            addCriterion("zuoyeid =", value, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidNotEqualTo(Integer value) {
            addCriterion("zuoyeid <>", value, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidGreaterThan(Integer value) {
            addCriterion("zuoyeid >", value, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zuoyeid >=", value, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidLessThan(Integer value) {
            addCriterion("zuoyeid <", value, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidLessThanOrEqualTo(Integer value) {
            addCriterion("zuoyeid <=", value, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidIn(List<Integer> values) {
            addCriterion("zuoyeid in", values, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidNotIn(List<Integer> values) {
            addCriterion("zuoyeid not in", values, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidBetween(Integer value1, Integer value2) {
            addCriterion("zuoyeid between", value1, value2, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andZuoyeidNotBetween(Integer value1, Integer value2) {
            addCriterion("zuoyeid not between", value1, value2, "zuoyeid");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFenIsNull() {
            addCriterion("fen is null");
            return (Criteria) this;
        }

        public Criteria andFenIsNotNull() {
            addCriterion("fen is not null");
            return (Criteria) this;
        }

        public Criteria andFenEqualTo(Integer value) {
            addCriterion("fen =", value, "fen");
            return (Criteria) this;
        }

        public Criteria andFenNotEqualTo(Integer value) {
            addCriterion("fen <>", value, "fen");
            return (Criteria) this;
        }

        public Criteria andFenGreaterThan(Integer value) {
            addCriterion("fen >", value, "fen");
            return (Criteria) this;
        }

        public Criteria andFenGreaterThanOrEqualTo(Integer value) {
            addCriterion("fen >=", value, "fen");
            return (Criteria) this;
        }

        public Criteria andFenLessThan(Integer value) {
            addCriterion("fen <", value, "fen");
            return (Criteria) this;
        }

        public Criteria andFenLessThanOrEqualTo(Integer value) {
            addCriterion("fen <=", value, "fen");
            return (Criteria) this;
        }

        public Criteria andFenIn(List<Integer> values) {
            addCriterion("fen in", values, "fen");
            return (Criteria) this;
        }

        public Criteria andFenNotIn(List<Integer> values) {
            addCriterion("fen not in", values, "fen");
            return (Criteria) this;
        }

        public Criteria andFenBetween(Integer value1, Integer value2) {
            addCriterion("fen between", value1, value2, "fen");
            return (Criteria) this;
        }

        public Criteria andFenNotBetween(Integer value1, Integer value2) {
            addCriterion("fen not between", value1, value2, "fen");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNull() {
            addCriterion("riqi is null");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNotNull() {
            addCriterion("riqi is not null");
            return (Criteria) this;
        }

        public Criteria andRiqiEqualTo(String value) {
            addCriterion("riqi =", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotEqualTo(String value) {
            addCriterion("riqi <>", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThan(String value) {
            addCriterion("riqi >", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThanOrEqualTo(String value) {
            addCriterion("riqi >=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThan(String value) {
            addCriterion("riqi <", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThanOrEqualTo(String value) {
            addCriterion("riqi <=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLike(String value) {
            addCriterion("riqi like", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotLike(String value) {
            addCriterion("riqi not like", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiIn(List<String> values) {
            addCriterion("riqi in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotIn(List<String> values) {
            addCriterion("riqi not in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiBetween(String value1, String value2) {
            addCriterion("riqi between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotBetween(String value1, String value2) {
            addCriterion("riqi not between", value1, value2, "riqi");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}