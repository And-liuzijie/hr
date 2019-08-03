/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : Oracle
Source Server Version : 110200
Source Host           : 127.0.0.1:1521
Source Schema         : BRIUP

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-08-03 19:51:56
*/


-- ----------------------------
-- Table structure for ATTENDANCE
-- ----------------------------
DROP TABLE "BRIUP"."ATTENDANCE";
CREATE TABLE "BRIUP"."ATTENDANCE" (
"ID" VARCHAR2(200 BYTE) NOT NULL ,
"ATTEND_TIME" DATE NULL ,
"ATTEND_STATE" NUMBER NULL ,
"EMP_ID" VARCHAR2(200 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of ATTENDANCE
-- ----------------------------
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('19', TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '1');
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('20', TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '2');
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('22', TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '3');
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('16', TO_DATE('2019-07-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '1');
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('18', TO_DATE('2019-07-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '2');
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('21', TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '3');
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('23', TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '4');
INSERT INTO "BRIUP"."ATTENDANCE" VALUES ('24', TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', '5');

-- ----------------------------
-- Table structure for DEPARTMENT
-- ----------------------------
DROP TABLE "BRIUP"."DEPARTMENT";
CREATE TABLE "BRIUP"."DEPARTMENT" (
"ID" VARCHAR2(200 BYTE) NOT NULL ,
"NAME" VARCHAR2(200 BYTE) NULL ,
"DESCRIBE" VARCHAR2(200 BYTE) NULL ,
"EMPCOUNT" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of DEPARTMENT
-- ----------------------------
INSERT INTO "BRIUP"."DEPARTMENT" VALUES ('1', '人事部', '我们是人事行政部。。。。。。负责人员管理，等等等等。。。', '3');
INSERT INTO "BRIUP"."DEPARTMENT" VALUES ('2', '财务部门', '财务部门负责财务统计，结算，报销等各种。', '3');
INSERT INTO "BRIUP"."DEPARTMENT" VALUES ('admin', '公司管理董事层', '该分组是公司所有董事层', '1');
INSERT INTO "BRIUP"."DEPARTMENT" VALUES ('new1', '新部门', '新开的部门', '0');
INSERT INTO "BRIUP"."DEPARTMENT" VALUES ('10', '冯士浩的部门', '好', null);
INSERT INTO "BRIUP"."DEPARTMENT" VALUES ('11', '冯士浩的部门', '好', null);

-- ----------------------------
-- Table structure for EMPLOYEE
-- ----------------------------
DROP TABLE "BRIUP"."EMPLOYEE";
CREATE TABLE "BRIUP"."EMPLOYEE" (
"ID" VARCHAR2(200 BYTE) NOT NULL ,
"NAME" VARCHAR2(200 BYTE) NULL ,
"PASSWORD" VARCHAR2(200 BYTE) NULL ,
"GENDER" VARCHAR2(200 BYTE) NULL ,
"BIRTHDAY" DATE NULL ,
"EMAIL" VARCHAR2(200 BYTE) NULL ,
"DEP_ID" VARCHAR2(200 BYTE) NULL ,
"DEP_NAME" VARCHAR2(200 BYTE) NULL ,
"IMP_ROLE" VARCHAR2(200 BYTE) NULL ,
"SALARY" NUMBER NULL ,
"TEL" VARCHAR2(200 BYTE) NULL ,
"INFO" VARCHAR2(200 BYTE) NULL ,
"IMPLSTATE" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of EMPLOYEE
-- ----------------------------
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('1', '张三', '123', '男', TO_DATE('2017-12-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'zs@briup.com', 'admin', '公司管理董事层', '经理', '20000', '18512341234', '技术很厉害的人', '0');
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('2', '李四', '123', '男', TO_DATE('2017-11-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'ls@briup.com', '1', '人事部', '经理', '10000', '18512341234', 'hr', '0');
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('3', '王五', '123', '男', TO_DATE('2017-10-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'ww@briup.com', '1', '人事部', '员工', '5000', '18512341234', 'hr手下的员工', '0');
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('4', '赵六', '123', '男', TO_DATE('2017-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'zl@briup.com', '1', '人事部', '员工', '5000', '18512341234', 'hr手下的员工', '0');
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('5', '小张', '123', '男', TO_DATE('2013-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'xz@briup.com', '2', '财务部门', '经理', '20000', '18512341234', '财务', '0');
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('6', '小李', '123', '男', TO_DATE('2013-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'xl@briup.com', '2', '财务部门', '员工', '5000', '18512341234', '财务手下员工', '0');
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('7', '小红', '123', '女', TO_DATE('2000-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'xh@briup.com', '2', '财务部门', '员工', '6000', '18512341234', '财务手下女员工', '0');
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('31', '中心城市', '萨达', '男', TO_DATE('2020-11-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'sada', '1', '人事部', '1', '888', '2115656', '撒', null);
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('10', '刘子杰', '123456', '男', null, null, '1', '人事部', '1', null, null, null, null);
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('11', '洁宝宝', '123', '女', TO_DATE('2000-03-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '979038889@qq.com', '1', '人事部', '1', '8888', '15935120508', '老板娘', null);
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('12', '阿拉斯加', '8522', null, TO_DATE('2020-11-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, '1', null, null, null, null);
INSERT INTO "BRIUP"."EMPLOYEE" VALUES ('30', '李振兴', '111111', '男', TO_DATE('2020-11-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '979889@qq.com', '1', '人事部', '1', null, null, '啊阿萨', null);

-- ----------------------------
-- Table structure for EXTRAWORK
-- ----------------------------
DROP TABLE "BRIUP"."EXTRAWORK";
CREATE TABLE "BRIUP"."EXTRAWORK" (
"ID" VARCHAR2(255 BYTE) NOT NULL ,
"EMPID" VARCHAR2(255 BYTE) NULL ,
"STARTTIME" DATE NULL ,
"EDNTIME" DATE NULL ,
"REASON" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of EXTRAWORK
-- ----------------------------
INSERT INTO "BRIUP"."EXTRAWORK" VALUES ('25', '2', TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '周末接待');
INSERT INTO "BRIUP"."EXTRAWORK" VALUES ('12', '2', TO_DATE('2019-07-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '你好');
INSERT INTO "BRIUP"."EXTRAWORK" VALUES ('10', '1', TO_DATE('2019-07-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-07-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "BRIUP"."EXTRAWORK" VALUES ('11', '2', TO_DATE('2019-07-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-07-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for LEAVE
-- ----------------------------
DROP TABLE "BRIUP"."LEAVE";
CREATE TABLE "BRIUP"."LEAVE" (
"ID" VARCHAR2(255 BYTE) NULL ,
"EMPID" VARCHAR2(255 BYTE) NULL ,
"STRATTIME" DATE NULL ,
"ENDTIME" DATE NULL ,
"REASON" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of LEAVE
-- ----------------------------
INSERT INTO "BRIUP"."LEAVE" VALUES ('14', '1', null, null, null);
INSERT INTO "BRIUP"."LEAVE" VALUES ('13', '1', null, null, null);
INSERT INTO "BRIUP"."LEAVE" VALUES ('15', '1', TO_DATE('2019-07-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-07-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '累了');
INSERT INTO "BRIUP"."LEAVE" VALUES ('17', '1', TO_DATE('2019-07-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-07-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '123');

-- ----------------------------
-- Table structure for SALARY
-- ----------------------------
DROP TABLE "BRIUP"."SALARY";
CREATE TABLE "BRIUP"."SALARY" (
"ID" VARCHAR2(255 BYTE) NULL ,
"EMPID" VARCHAR2(255 BYTE) NULL ,
"YEAR" VARCHAR2(255 BYTE) NULL ,
"MON" VARCHAR2(255 BYTE) NULL ,
"BASICSALARY" NUMBER(6) NULL ,
"ETRASALARY" NUMBER(6) NULL ,
"HOLIDAYSALARY" NUMBER(6) NULL ,
"OUTSALARY" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SALARY
-- ----------------------------
INSERT INTO "BRIUP"."SALARY" VALUES ('1', '1', '2019', '3', '20000', '2000', '1000', '1000');
INSERT INTO "BRIUP"."SALARY" VALUES ('2', '2', '2019', '3', '30000', '1000', '521', '200');

-- ----------------------------
-- Sequence structure for ATT_SEQ
-- ----------------------------
DROP SEQUENCE "BRIUP"."ATT_SEQ";
CREATE SEQUENCE "BRIUP"."ATT_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 30
 CACHE 20;

-- ----------------------------
-- Sequence structure for DEP_SEQ
-- ----------------------------
DROP SEQUENCE "BRIUP"."DEP_SEQ";
CREATE SEQUENCE "BRIUP"."DEP_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 30
 CACHE 20;

-- ----------------------------
-- Sequence structure for EMP_SEQ
-- ----------------------------
DROP SEQUENCE "BRIUP"."EMP_SEQ";
CREATE SEQUENCE "BRIUP"."EMP_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 50
 CACHE 20;

-- ----------------------------
-- Indexes structure for table ATTENDANCE
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table ATTENDANCE
-- ----------------------------
ALTER TABLE "BRIUP"."ATTENDANCE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table DEPARTMENT
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table DEPARTMENT
-- ----------------------------
ALTER TABLE "BRIUP"."DEPARTMENT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table EMPLOYEE
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table EMPLOYEE
-- ----------------------------
ALTER TABLE "BRIUP"."EMPLOYEE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table EXTRAWORK
-- ----------------------------

-- ----------------------------
-- Checks structure for table EXTRAWORK
-- ----------------------------
ALTER TABLE "BRIUP"."EXTRAWORK" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table EXTRAWORK
-- ----------------------------
ALTER TABLE "BRIUP"."EXTRAWORK" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Foreign Key structure for table "BRIUP"."EMPLOYEE"
-- ----------------------------
ALTER TABLE "BRIUP"."EMPLOYEE" ADD FOREIGN KEY ("DEP_ID") REFERENCES "BRIUP"."DEPARTMENT" ("ID");
