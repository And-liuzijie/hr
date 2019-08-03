package com.briup.bean;

import java.util.ArrayList;
import java.util.List;

public class SalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalaryExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNull() {
            addCriterion("EMPID is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("EMPID is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(String value) {
            addCriterion("EMPID =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(String value) {
            addCriterion("EMPID <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(String value) {
            addCriterion("EMPID >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(String value) {
            addCriterion("EMPID >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(String value) {
            addCriterion("EMPID <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(String value) {
            addCriterion("EMPID <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLike(String value) {
            addCriterion("EMPID like", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotLike(String value) {
            addCriterion("EMPID not like", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<String> values) {
            addCriterion("EMPID in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<String> values) {
            addCriterion("EMPID not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(String value1, String value2) {
            addCriterion("EMPID between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(String value1, String value2) {
            addCriterion("EMPID not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("YEAR is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("YEAR =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("YEAR <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("YEAR >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("YEAR >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("YEAR <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("YEAR <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("YEAR like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("YEAR not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("YEAR in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("YEAR not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("YEAR between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("YEAR not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonIsNull() {
            addCriterion("MON is null");
            return (Criteria) this;
        }

        public Criteria andMonIsNotNull() {
            addCriterion("MON is not null");
            return (Criteria) this;
        }

        public Criteria andMonEqualTo(String value) {
            addCriterion("MON =", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotEqualTo(String value) {
            addCriterion("MON <>", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonGreaterThan(String value) {
            addCriterion("MON >", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonGreaterThanOrEqualTo(String value) {
            addCriterion("MON >=", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonLessThan(String value) {
            addCriterion("MON <", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonLessThanOrEqualTo(String value) {
            addCriterion("MON <=", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonLike(String value) {
            addCriterion("MON like", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotLike(String value) {
            addCriterion("MON not like", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonIn(List<String> values) {
            addCriterion("MON in", values, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotIn(List<String> values) {
            addCriterion("MON not in", values, "mon");
            return (Criteria) this;
        }

        public Criteria andMonBetween(String value1, String value2) {
            addCriterion("MON between", value1, value2, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotBetween(String value1, String value2) {
            addCriterion("MON not between", value1, value2, "mon");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIsNull() {
            addCriterion("BASICSALARY is null");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIsNotNull() {
            addCriterion("BASICSALARY is not null");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryEqualTo(Integer value) {
            addCriterion("BASICSALARY =", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotEqualTo(Integer value) {
            addCriterion("BASICSALARY <>", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryGreaterThan(Integer value) {
            addCriterion("BASICSALARY >", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("BASICSALARY >=", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryLessThan(Integer value) {
            addCriterion("BASICSALARY <", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryLessThanOrEqualTo(Integer value) {
            addCriterion("BASICSALARY <=", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIn(List<Integer> values) {
            addCriterion("BASICSALARY in", values, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotIn(List<Integer> values) {
            addCriterion("BASICSALARY not in", values, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryBetween(Integer value1, Integer value2) {
            addCriterion("BASICSALARY between", value1, value2, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("BASICSALARY not between", value1, value2, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryIsNull() {
            addCriterion("ETRASALARY is null");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryIsNotNull() {
            addCriterion("ETRASALARY is not null");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryEqualTo(Integer value) {
            addCriterion("ETRASALARY =", value, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryNotEqualTo(Integer value) {
            addCriterion("ETRASALARY <>", value, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryGreaterThan(Integer value) {
            addCriterion("ETRASALARY >", value, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("ETRASALARY >=", value, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryLessThan(Integer value) {
            addCriterion("ETRASALARY <", value, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryLessThanOrEqualTo(Integer value) {
            addCriterion("ETRASALARY <=", value, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryIn(List<Integer> values) {
            addCriterion("ETRASALARY in", values, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryNotIn(List<Integer> values) {
            addCriterion("ETRASALARY not in", values, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryBetween(Integer value1, Integer value2) {
            addCriterion("ETRASALARY between", value1, value2, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andEtrasalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("ETRASALARY not between", value1, value2, "etrasalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryIsNull() {
            addCriterion("HOLIDAYSALARY is null");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryIsNotNull() {
            addCriterion("HOLIDAYSALARY is not null");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryEqualTo(Integer value) {
            addCriterion("HOLIDAYSALARY =", value, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryNotEqualTo(Integer value) {
            addCriterion("HOLIDAYSALARY <>", value, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryGreaterThan(Integer value) {
            addCriterion("HOLIDAYSALARY >", value, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("HOLIDAYSALARY >=", value, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryLessThan(Integer value) {
            addCriterion("HOLIDAYSALARY <", value, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryLessThanOrEqualTo(Integer value) {
            addCriterion("HOLIDAYSALARY <=", value, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryIn(List<Integer> values) {
            addCriterion("HOLIDAYSALARY in", values, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryNotIn(List<Integer> values) {
            addCriterion("HOLIDAYSALARY not in", values, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryBetween(Integer value1, Integer value2) {
            addCriterion("HOLIDAYSALARY between", value1, value2, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andHolidaysalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("HOLIDAYSALARY not between", value1, value2, "holidaysalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryIsNull() {
            addCriterion("OUTSALARY is null");
            return (Criteria) this;
        }

        public Criteria andOutsalaryIsNotNull() {
            addCriterion("OUTSALARY is not null");
            return (Criteria) this;
        }

        public Criteria andOutsalaryEqualTo(Integer value) {
            addCriterion("OUTSALARY =", value, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryNotEqualTo(Integer value) {
            addCriterion("OUTSALARY <>", value, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryGreaterThan(Integer value) {
            addCriterion("OUTSALARY >", value, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("OUTSALARY >=", value, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryLessThan(Integer value) {
            addCriterion("OUTSALARY <", value, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryLessThanOrEqualTo(Integer value) {
            addCriterion("OUTSALARY <=", value, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryIn(List<Integer> values) {
            addCriterion("OUTSALARY in", values, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryNotIn(List<Integer> values) {
            addCriterion("OUTSALARY not in", values, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryBetween(Integer value1, Integer value2) {
            addCriterion("OUTSALARY between", value1, value2, "outsalary");
            return (Criteria) this;
        }

        public Criteria andOutsalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("OUTSALARY not between", value1, value2, "outsalary");
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