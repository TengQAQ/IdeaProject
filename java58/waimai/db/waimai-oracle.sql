/*
 Navicat Premium Data Transfer

 Source Server         : oracle-wy
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Schema         : WY

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 24/04/2023 14:52:51
*/


-- ----------------------------
-- Table structure for ADDRESS_BOOK
-- ----------------------------
DROP TABLE "WY"."ADDRESS_BOOK";
CREATE TABLE "WY"."ADDRESS_BOOK" (
  "ID" NUMBER(20) NOT NULL ,
  "USER_ID" NUMBER(20) NOT NULL ,
  "CONSIGNEE" VARCHAR2(50 BYTE) NOT NULL ,
  "SEX" NUMBER(4) NOT NULL ,
  "PHONE" VARCHAR2(11 BYTE) NOT NULL ,
  "PROVINCE_CODE" VARCHAR2(12 BYTE) ,
  "PROVINCE_NAME" VARCHAR2(32 BYTE) ,
  "CITY_CODE" VARCHAR2(12 BYTE) ,
  "CITY_NAME" VARCHAR2(32 BYTE) ,
  "DISTRICT_CODE" VARCHAR2(12 BYTE) ,
  "DISTRICT_NAME" VARCHAR2(32 BYTE) ,
  "DETAIL" VARCHAR2(200 BYTE) ,
  "LABEL" VARCHAR2(100 BYTE) ,
  "IS_DEFAULT" NUMBER(1) DEFAULT 0     NOT NULL ,
  "CREATE_TIME" DATE NOT NULL ,
  "UPDATE_TIME" DATE ,
  "CREATE_BY" NUMBER(20) NOT NULL ,
  "UPDATE_BY" NUMBER(20) ,
  "IS_DELETED" NUMBER(11) NOT NULL 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."ID" IS '主键';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."USER_ID" IS '用户id';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."CONSIGNEE" IS '收货人';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."SEX" IS '性别 0 女 1 男';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."PHONE" IS '手机号';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."PROVINCE_CODE" IS '省级区划编号';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."PROVINCE_NAME" IS '省级名称';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."CITY_CODE" IS '市级区划编号';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."CITY_NAME" IS '市级名称';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."DISTRICT_CODE" IS '区级区划编号';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."DISTRICT_NAME" IS '区级名称';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."DETAIL" IS '详细地址';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."LABEL" IS '标签';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."IS_DEFAULT" IS '默认 0 否 1是';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."UPDATE_TIME" IS '更新时间';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."UPDATE_BY" IS '修改人';
COMMENT ON COLUMN "WY"."ADDRESS_BOOK"."IS_DELETED" IS '是否删除';
COMMENT ON TABLE "WY"."ADDRESS_BOOK" IS '前端用户收货地址';

-- ----------------------------
-- Table structure for CONTAMER
-- ----------------------------
DROP TABLE "WY"."CONTAMER";
CREATE TABLE "WY"."CONTAMER" (
  "ID" NUMBER(11) NOT NULL ,
  "LOGINID" VARCHAR2(255 BYTE) NOT NULL ,
  "PASSWOLD" VARCHAR2(255 BYTE) NOT NULL ,
  "USER_NAME" VARCHAR2(255 BYTE) NOT NULL ,
  "GENDER" NUMBER(4) NOT NULL ,
  "PORTRAIT" VARCHAR2(255 BYTE) NOT NULL ,
  "STATUS" NUMBER(10) NOT NULL ,
  "CREATE_TIME" DATE ,
  "CREATE_BY" VARCHAR2(50 BYTE) ,
  "UPDATE_TIME" DATE ,
  "UPDATE_BY" VARCHAR2(50 BYTE) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."CONTAMER"."ID" IS '主键';
COMMENT ON COLUMN "WY"."CONTAMER"."LOGINID" IS '账号';
COMMENT ON COLUMN "WY"."CONTAMER"."PASSWOLD" IS '密码加密';
COMMENT ON COLUMN "WY"."CONTAMER"."USER_NAME" IS '昵称';
COMMENT ON COLUMN "WY"."CONTAMER"."GENDER" IS '性别(0 女 1 男)';
COMMENT ON COLUMN "WY"."CONTAMER"."PORTRAIT" IS '头像';
COMMENT ON COLUMN "WY"."CONTAMER"."STATUS" IS '状态1：停用0：正常';
COMMENT ON COLUMN "WY"."CONTAMER"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "WY"."CONTAMER"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "WY"."CONTAMER"."UPDATE_TIME" IS '修改时间';
COMMENT ON COLUMN "WY"."CONTAMER"."UPDATE_BY" IS '修改人';
COMMENT ON TABLE "WY"."CONTAMER" IS '前端用户';

-- ----------------------------
-- Table structure for DISH_FLAVOR
-- ----------------------------
DROP TABLE "WY"."DISH_FLAVOR";
CREATE TABLE "WY"."DISH_FLAVOR" (
  "ID" NUMBER(20) NOT NULL ,
  "DISH_ID" NUMBER(20) NOT NULL ,
  "NAME" VARCHAR2(80 BYTE) NOT NULL ,
  "VALUE" VARCHAR2(500 BYTE) ,
  "IS_DELETED" NUMBER(11) NOT NULL ,
  "CREATE_BY" VARCHAR2(80 BYTE) NOT NULL ,
  "CREATE_TIME" DATE NOT NULL ,
  "UPDATE_TIME" DATE ,
  "UPDATE_BY" VARCHAR2(80 BYTE) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."ID" IS '主键';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."DISH_ID" IS '菜品';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."NAME" IS '口味名称';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."VALUE" IS '口味数据list';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."IS_DELETED" IS '是否删除';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."UPDATE_TIME" IS '更新时间';
COMMENT ON COLUMN "WY"."DISH_FLAVOR"."UPDATE_BY" IS '修改人';
COMMENT ON TABLE "WY"."DISH_FLAVOR" IS '菜品口味关系表';

-- ----------------------------
-- Records of DISH_FLAVOR
-- ----------------------------
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('2', '10001', '温度', '[{"value": "正常冰","price": 0},{"value": "少冰","price": 1},{"value": "常温","price": 0},{"value": "温热","price": 0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-21 15:01:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('3', '10001', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":2},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-21 15:02:14', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('24', '10028', '温度', '[{"value":"正常冰","price":1},{"value":"少冰","price":0},{"value":"常温","price":0},{"value":"温热","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-23 18:27:23', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('25', '10028', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":1}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-23 18:27:23', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('26', '10029', '温度', '[{"value":"正常冰","price":0},{"value":"少冰","price":0},{"value":"常温","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:04:46', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('27', '10029', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:04:46', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('28', '10030', '温度', '[{"value":"正常冰","price":0},{"value":"少冰","price":0},{"value":"常温","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:14:58', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('29', '10030', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:14:58', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('30', '10031', '规格', '[{"value":"标准3杯","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:20:34', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('31', '10031', '饮品温度', '[{"value":"正常冰","price":0},{"value":"少冰","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:20:34', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('32', '10031', '饮品糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:20:34', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('33', '10032', '规格', '[{"value":"标准(3杯)","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:27:03', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('34', '10032', '饮品温度', '[{"value":"正常冰","price":0},{"value":"少冰","price":0},{"value":"常温","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:27:03', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('35', '10032', '饮品糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:27:03', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('36', '10033', '规格', '[{"value":"杯准(1杯)","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:31:19', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('37', '10033', '温度', '[{"value":"热","price":0},{"value":"少冰","price":0},{"value":"正常冰","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:31:19', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('38', '10033', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:31:19', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('39', '10034', '规格', '[{"value":"标准(1杯 )","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:35:36', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('40', '10034', '温度', '[{"value":"正常冰","price":0},{"value":"少冰","price":0},{"value":"热","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:35:36', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('41', '10034', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:35:36', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('42', '10035', '规格', '[{"value":"标准(1杯)","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:38:15', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('43', '10035', '温度', '[{"value":"热","price":0},{"value":"少冰","price":0},{"value":"正常冰","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:38:15', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('44', '10035', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0},{"value":"无糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:38:15', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('45', '10037', '规格', '[{"value":"标准(1杯)","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:45:21', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('46', '10037', '温度', '[{"value":"正常冰","price":0},{"value":"热","price":0},{"value":"常温","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:45:21', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('47', '10037', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:45:21', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('48', '10038', '规格', '[{"value":"标准(1杯)","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:49:41', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('49', '10038', '温度', '[{"value":"少冰","price":0},{"value":"正常冰","price":0},{"value":"常温","price":0},{"value":"热","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:49:41', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO "WY"."DISH_FLAVOR" VALUES ('50', '10038', '糖度', '[{"value":"正常糖","price":0},{"value":"七分糖","price":0},{"value":"五分糖","price":0},{"value":"无糖","price":0}]', '0', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-24 14:49:41', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- ----------------------------
-- Table structure for EMPLOYEE
-- ----------------------------
DROP TABLE "WY"."EMPLOYEE";
CREATE TABLE "WY"."EMPLOYEE" (
  "ID" NUMBER(20) NOT NULL ,
  "LOGIN_NAME" VARCHAR2(50 BYTE) NOT NULL ,
  "LOGIN_PWD" VARCHAR2(80 BYTE) NOT NULL ,
  "GENDER" NUMBER(4) NOT NULL ,
  "STATUS" NUMBER(4) NOT NULL ,
  "AVATAR" VARCHAR2(500 BYTE) ,
  "CREATE_TIME" DATE NOT NULL ,
  "CREATE_BY" VARCHAR2(50 BYTE) NOT NULL ,
  "UPDATE_TIME" DATE ,
  "UPDATE_BY" VARCHAR2(50 BYTE) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."EMPLOYEE"."ID" IS '主键';
COMMENT ON COLUMN "WY"."EMPLOYEE"."LOGIN_NAME" IS '登录账户';
COMMENT ON COLUMN "WY"."EMPLOYEE"."LOGIN_PWD" IS '登录密码';
COMMENT ON COLUMN "WY"."EMPLOYEE"."GENDER" IS '性别(0 女 1 男)';
COMMENT ON COLUMN "WY"."EMPLOYEE"."STATUS" IS '状态（1停用，0正常）';
COMMENT ON COLUMN "WY"."EMPLOYEE"."AVATAR" IS '头像';
COMMENT ON COLUMN "WY"."EMPLOYEE"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "WY"."EMPLOYEE"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "WY"."EMPLOYEE"."UPDATE_TIME" IS '修改时间';
COMMENT ON COLUMN "WY"."EMPLOYEE"."UPDATE_BY" IS '修改人';
COMMENT ON TABLE "WY"."EMPLOYEE" IS '后台管理员表';

-- ----------------------------
-- Records of EMPLOYEE
-- ----------------------------
INSERT INTO "WY"."EMPLOYEE" VALUES ('1001', 'admin', '$2a$10$bl7V/MIXIPWQJW1YQbPfw.IBfLoA3UqksCJp84zeMjcIighWttjxa', '1', '0', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/cb39c7ac-69d3-455f-8532-01bed1f0156f.png', TO_DATE('2023-04-03 17:44:34', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2023-04-15 11:54:10', 'SYYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO "WY"."EMPLOYEE" VALUES ('82', 'test002', '$2a$10$VbRFHTOJcJDTvgdjGWjjROh.x8hcBiv2ZDv71x9k7UcrHpUt7WE6G', '1', '0', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/3bf4c1bf-1866-4a46-96a3-c4d9ffd9efe1.png', TO_DATE('2023-04-15 11:52:45', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2023-04-17 18:41:53', 'SYYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO "WY"."EMPLOYEE" VALUES ('81', 'test', '$2a$10$2M1JHm3p8Ygk0KD7S9N/1ODhet/xgO.xXT1EOnzfwJB6u9mgNHAvC', '0', '0', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/168e72d8-f6da-444b-94a2-dc2a084f2148.png', TO_DATE('2023-04-15 10:35:40', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2023-04-15 16:12:48', 'SYYYY-MM-DD HH24:MI:SS'), 'admin');

-- ----------------------------
-- Table structure for ENTERPRISE_PROCESS
-- ----------------------------
DROP TABLE "WY"."ENTERPRISE_PROCESS";
CREATE TABLE "WY"."ENTERPRISE_PROCESS" (
  "ID" NUMBER(11) NOT NULL ,
  "TENANT_ID" NUMBER(20) NOT NULL ,
  "STATUS" NUMBER(4) NOT NULL ,
  "DESCRIPTION" VARCHAR2(500 BYTE) NOT NULL ,
  "CREATE_BY" VARCHAR2(50 BYTE) NOT NULL ,
  "CREATE_TIME" DATE 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."ENTERPRISE_PROCESS"."ID" IS '编号';
COMMENT ON COLUMN "WY"."ENTERPRISE_PROCESS"."TENANT_ID" IS '商家ID';
COMMENT ON COLUMN "WY"."ENTERPRISE_PROCESS"."STATUS" IS '审核状态(0-通过，1-不通过)';
COMMENT ON COLUMN "WY"."ENTERPRISE_PROCESS"."DESCRIPTION" IS '原因描述';
COMMENT ON COLUMN "WY"."ENTERPRISE_PROCESS"."CREATE_BY" IS '审核人';
COMMENT ON COLUMN "WY"."ENTERPRISE_PROCESS"."CREATE_TIME" IS '审核时间';
COMMENT ON TABLE "WY"."ENTERPRISE_PROCESS" IS '商家审核记录表';

-- ----------------------------
-- Records of ENTERPRISE_PROCESS
-- ----------------------------
INSERT INTO "WY"."ENTERPRISE_PROCESS" VALUES ('5', '1001', '0', '通过', 'admin', TO_DATE('2023-04-20 17:16:17', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "WY"."ENTERPRISE_PROCESS" VALUES ('4', '1001', '2', '图片不符合要求', 'admin', TO_DATE('2023-04-20 17:02:10', 'SYYYY-MM-DD HH24:MI:SS'));
INSERT INTO "WY"."ENTERPRISE_PROCESS" VALUES ('2', '1001', '2', '名称和地址不同', 'admin', TO_DATE('2023-04-19 16:48:19', 'SYYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for MERCHANDISE
-- ----------------------------
DROP TABLE "WY"."MERCHANDISE";
CREATE TABLE "WY"."MERCHANDISE" (
  "ID" NUMBER(20) NOT NULL ,
  "NAME" VARCHAR2(100 BYTE) NOT NULL ,
  "PRICE" NUMBER(10,2) NOT NULL ,
  "PICTURE" VARCHAR2(200 BYTE) ,
  "DESCRIPTION" VARCHAR2(500 BYTE) ,
  "SCORE" NUMBER(10) ,
  "B_ID" NUMBER(20) NOT NULL ,
  "M_ID" NUMBER(20) NOT NULL ,
  "ISGROUNDING" NUMBER(11) ,
  "CREATE_TIME" DATE NOT NULL ,
  "CREATE_BY" VARCHAR2(255 BYTE) NOT NULL ,
  "UPDATE_TIME" DATE ,
  "UPDATE_BY" VARCHAR2(255 BYTE) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."MERCHANDISE"."ID" IS '主键';
COMMENT ON COLUMN "WY"."MERCHANDISE"."NAME" IS '商品名称';
COMMENT ON COLUMN "WY"."MERCHANDISE"."PRICE" IS '商品价格';
COMMENT ON COLUMN "WY"."MERCHANDISE"."PICTURE" IS '商品图片';
COMMENT ON COLUMN "WY"."MERCHANDISE"."DESCRIPTION" IS '商品描述';
COMMENT ON COLUMN "WY"."MERCHANDISE"."SCORE" IS '商品综合评分';
COMMENT ON COLUMN "WY"."MERCHANDISE"."B_ID" IS '商家id';
COMMENT ON COLUMN "WY"."MERCHANDISE"."M_ID" IS '商品分类';
COMMENT ON COLUMN "WY"."MERCHANDISE"."ISGROUNDING" IS '是否上架 1：上架 ，0：没上架';
COMMENT ON COLUMN "WY"."MERCHANDISE"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "WY"."MERCHANDISE"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "WY"."MERCHANDISE"."UPDATE_TIME" IS '修改时间';
COMMENT ON COLUMN "WY"."MERCHANDISE"."UPDATE_BY" IS '修改人';
COMMENT ON TABLE "WY"."MERCHANDISE" IS '商品信息';

-- ----------------------------
-- Records of MERCHANDISE
-- ----------------------------
INSERT INTO "WY"."MERCHANDISE" VALUES ('10001', '冰鲜柠檬水', '8', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/1695fb68-0242-4786-8d34-a2b9f22f534f.jpg', '大片柠檬看得见', '0', '1001', '104', '0', TO_DATE('2023-04-21 12:01:03', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10028', '桃喜芒芒', '8', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/00d437e1-9dd8-4271-b8ce-1cfccef13a09.png', '雪王好芒，芒果好香![杯型:大杯]主辅料:冷冻芒果浆、绿茶.黄桃果酱提示语:产品可能出现芒果纤维悬浮现象,请放心饮用本产品含有芒果,对芒果过敏者慎食。', '0', '1001', '104', '0', TO_DATE('2023-04-23 18:05:40', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-23 18:27:22', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)');
INSERT INTO "WY"."MERCHANDISE" VALUES ('10029', '冰鲜柠檬水', '5', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/cb715da3-2d5b-40fe-ba6d-604cc26f05c7.png', '大片柠檬看得见', '0', '1001', '105', '0', TO_DATE('2023-04-24 14:04:46', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10030', '港式杨枝甘露(芋圆版)', '11', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/1b36e9dd-5c16-45a5-b793-6785ccdba80a.png', '港式筛选食材，食材新鲜升级
重新筛选食材，口感外形双升级，新鲜红西柚，甜甜芒果酱，更新鲜的杨枝甘露！', '0', '1001', '105', '1', TO_DATE('2023-04-24 14:14:58', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10031', '经典不过时-3杯装', '19', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/e5275c11-fc89-4765-bbe6-74a04af8e4d0.png', '套餐包含：冰鲜柠檬水+珍珠奶茶(中杯)+草莓雪王大圣代
主辅料：
冰鲜柠檬水：柠檬片
珍珠奶茶(中杯)：珍珠、浓缩奶茶(红茶叶、奶茶粉)
草莓雪王大圣代：冰淇淋、草莓果酱', '0', '1001', '106', '1', TO_DATE('2023-04-24 14:20:34', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10032', '"美"好春光套餐', '21', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/bccfbe99-6497-4b02-afa8-4abbf80c468c.png', '套餐包含：芒果雪王大圣代+草雪王大圣代+蜜桃四季春
【杯型：圣代为U型杯，蜜桃四季春为大杯容量600ml】', '0', '1001', '106', '1', TO_DATE('2023-04-24 14:27:03', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10033', '三拼霸霸奶茶(布丁版)', '9', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/bb66c005-e962-482e-b9a0-b72ce3500a74.png', '三拼霸霸嚼嚼嚼,珍珠椰果鸡蛋布丁[杯型:大杯]
原仙草冻更改为鸡蛋布丁
主辅料:珍珠、椰果、鸡蛋布丁、浓缩奶茶(红茶叶、奶茶粉)', '0', '1001', '107', '1', TO_DATE('2023-04-24 14:31:19', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10034', '拿铁咖啡', '7', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/94c48084-0712-4a94-9ce5-feef5683b2cf.png', '鲜萃云南豆,国货好咖啡(杯型: 12盎司纸杯)', '0', '1001', '108', '1', TO_DATE('2023-04-24 14:35:36', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10035', '美式咖啡', '5', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/27b836ea-e0f0-4a18-a43d-ea7bfbad4c8a.png', '鲜萃云南豆，国货好咖啡[杯型:中杯,热饮:中杯纸杯]', '0', '1001', '108', '1', TO_DATE('2023-04-24 14:38:15', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10037', '芝士奶盖四季春', '11', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/2e520865-8fc3-4d0c-935c-aaf199428a40.png', '芝士奶盖家族,新晋白月光!
绵绵咸芝士,现泡鲜茶汤,透亮口感爽, 一口喝到底!
两种喝法任你选,
网红新喝法，喝前摇-摇,小奶小甜,秒变白月光
一口芝士一口茶,奶香融茶香,一口很上头!
[杯型:大杯]主料:四季春茶]
[奶盖系列满杯出餐，配送过程易与茶底混合消融,敬请谅解]
', '0', '1001', '109', '1', TO_DATE('2023-04-24 14:45:21', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE" VALUES ('10038', '茉莉绿茶', '5', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/ee4f7593-0530-4df2-a6cc-aaf0c6b5f1ca.png', '茉莉绿茶，原叶好茶~
每日现煮原叶茶,每3小时一煮-泡清新茉莉花香，淡雅怡人，清香扑鼻，提升醒脑!
花香茶香，双倍清香一[杯型:大杯]主料:绿茶', '0', '1001', '109', '1', TO_DATE('2023-04-24 14:49:41', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);

-- ----------------------------
-- Table structure for MERCHANDISE_CLASS
-- ----------------------------
DROP TABLE "WY"."MERCHANDISE_CLASS";
CREATE TABLE "WY"."MERCHANDISE_CLASS" (
  "ID" NUMBER(11) NOT NULL ,
  "M_ID" NUMBER(20) NOT NULL ,
  "NAME" VARCHAR2(100 BYTE) NOT NULL ,
  "PICTURE" VARCHAR2(255 BYTE) ,
  "CREATE_TIME" DATE NOT NULL ,
  "CREATE_BY" VARCHAR2(255 BYTE) NOT NULL ,
  "UPDATE_TIME" DATE ,
  "UPDATE_BY" VARCHAR2(255 BYTE) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."ID" IS '主键';
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."M_ID" IS '商家id';
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."NAME" IS '类别名称';
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."PICTURE" IS '类别图片';
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."UPDATE_TIME" IS '更新时间';
COMMENT ON COLUMN "WY"."MERCHANDISE_CLASS"."UPDATE_BY" IS '更新人';
COMMENT ON TABLE "WY"."MERCHANDISE_CLASS" IS '商品分类表';

-- ----------------------------
-- Records of MERCHANDISE_CLASS
-- ----------------------------
INSERT INTO "WY"."MERCHANDISE_CLASS" VALUES ('104', '1001', '雪王新品', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/a70090c6-51ff-4a07-bfc1-2722eafdb4f5.png', TO_DATE('2023-04-21 10:20:02', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-21 10:24:27', 'SYYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO "WY"."MERCHANDISE_CLASS" VALUES ('105', '1001', '真爽果茶', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/02a25885-f89e-42c5-9ab7-0eec157f64b8.png', TO_DATE('2023-04-21 10:20:42', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE_CLASS" VALUES ('106', '1001', '鲜冰琪淋', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/76b9ebe4-4a5b-4608-ab49-a7c970d86787.png', TO_DATE('2023-04-21 10:22:00', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE_CLASS" VALUES ('107', '1001', '现煮奶茶', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/17b0b986-6315-4939-9bae-6054e92ad393.png', TO_DATE('2023-04-21 10:22:53', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE_CLASS" VALUES ('108', '1001', '现萃咖啡', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/f8bedcf3-24ce-4b53-8535-905401469704.png', TO_DATE('2023-04-21 10:23:45', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', NULL, NULL);
INSERT INTO "WY"."MERCHANDISE_CLASS" VALUES ('109', '1001', '奶盖纯茶', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/e7491bcf-0ace-4f60-9c70-294d7525627b.png', TO_DATE('2023-04-21 10:25:29', 'SYYYY-MM-DD HH24:MI:SS'), '蜜雪冰城(重庆大竹林金科乐方购物中心店)', TO_DATE('2023-04-21 10:25:37', 'SYYYY-MM-DD HH24:MI:SS'), NULL);

-- ----------------------------
-- Table structure for MERCHANDISER
-- ----------------------------
DROP TABLE "WY"."MERCHANDISER";
CREATE TABLE "WY"."MERCHANDISER" (
  "ID" NUMBER(20) NOT NULL ,
  "NAME" VARCHAR2(255 BYTE) ,
  "ADDRESS" VARCHAR2(255 BYTE) ,
  "PHONE" VARCHAR2(255 BYTE) ,
  "PICTURE" VARCHAR2(255 BYTE) ,
  "LONGITUDE" NUMBER(10,6) ,
  "LATITUDE" NUMBER(10,6) ,
  "CREATE_TIME" DATE ,
  "CREATE_BY" VARCHAR2(50 BYTE) ,
  "UPDATE_TIME" DATE ,
  "UPDATE_BY" VARCHAR2(50 BYTE) ,
  "LOGIN_NAME" VARCHAR2(50 BYTE) NOT NULL ,
  "LOGIN_PWD" VARCHAR2(80 BYTE) NOT NULL ,
  "STATUS" NUMBER(4) DEFAULT 1  

 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."MERCHANDISER"."ID" IS '主键';
COMMENT ON COLUMN "WY"."MERCHANDISER"."NAME" IS '商家名称';
COMMENT ON COLUMN "WY"."MERCHANDISER"."ADDRESS" IS '商家地址';
COMMENT ON COLUMN "WY"."MERCHANDISER"."PHONE" IS '联系电话';
COMMENT ON COLUMN "WY"."MERCHANDISER"."PICTURE" IS '商家图片';
COMMENT ON COLUMN "WY"."MERCHANDISER"."LONGITUDE" IS '商家位置经度';
COMMENT ON COLUMN "WY"."MERCHANDISER"."LATITUDE" IS '商家位置纬度';
COMMENT ON COLUMN "WY"."MERCHANDISER"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "WY"."MERCHANDISER"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "WY"."MERCHANDISER"."UPDATE_TIME" IS '修改时间';
COMMENT ON COLUMN "WY"."MERCHANDISER"."UPDATE_BY" IS '修改人';
COMMENT ON COLUMN "WY"."MERCHANDISER"."LOGIN_NAME" IS '商家账户';
COMMENT ON COLUMN "WY"."MERCHANDISER"."LOGIN_PWD" IS '商家密码';
COMMENT ON COLUMN "WY"."MERCHANDISER"."STATUS" IS '审核状态（0审核通过，1未审核, 2审核不通过）';
COMMENT ON TABLE "WY"."MERCHANDISER" IS '商家信息';

-- ----------------------------
-- Records of MERCHANDISER
-- ----------------------------
INSERT INTO "WY"."MERCHANDISER" VALUES ('1001', '蜜雪冰城(重庆大竹林金科乐方购物中心店)', '重庆市渝北区斑竹路19号重庆大竹林金科乐方购物中心F2蜜雪冰城(重庆大竹林金科乐方购物中心店)', '13608368217', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/706dde5f-1a5b-4716-a7eb-274f1e1373f6.png', '106.481946', '29.626997', TO_DATE('2023-04-18 15:38:45', 'SYYYY-MM-DD HH24:MI:SS'), '13608368217', TO_DATE('2023-04-20 17:16:17', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', '13608368217', '$2a$10$bl7V/MIXIPWQJW1YQbPfw.IBfLoA3UqksCJp84zeMjcIighWttjxa', '0');
INSERT INTO "WY"."MERCHANDISER" VALUES ('1', '秦明', '重庆市重庆市江北区建新东路4号附4号', '17623876031', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/a59f5033-105f-4233-afc5-220ba73a026c.png', '106.540818', '29.57853', TO_DATE('2023-04-19 14:23:10', 'SYYYY-MM-DD HH24:MI:SS'), '17623876031', NULL, NULL, '17623876031', '$2a$10$bl7V/MIXIPWQJW1YQbPfw.IBfLoA3UqksCJp84zeMjcIighWttjxa', '1');
INSERT INTO "WY"."MERCHANDISER" VALUES ('2', '滴滴滴', '重庆市重庆市渝中区人民支路49号', '17623876032', 'https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/72e2f71b-be22-4750-9f8f-b6c3a6aa5db3.png', '106.558219', '29.569939', TO_DATE('2023-04-20 15:29:29', 'SYYYY-MM-DD HH24:MI:SS'), '17623876032', NULL, NULL, '17623876032', '$2a$10$GQ0zY5HRFNUhVhdgsBFF6OXjzTJwA3dvNp6hhLH6GVDTii28RHJrO', '1');

-- ----------------------------
-- Table structure for ORDER_DETAIL
-- ----------------------------
DROP TABLE "WY"."ORDER_DETAIL";
CREATE TABLE "WY"."ORDER_DETAIL" (
  "ID" NUMBER(20) NOT NULL ,
  "NAME" VARCHAR2(50 BYTE) ,
  "IMAGE" VARCHAR2(100 BYTE) ,
  "ORDER_ID" NUMBER(20) NOT NULL ,
  "DISH_ID" NUMBER(20) ,
  "M_ID" NUMBER(20) ,
  "DISH_FLAVOR" VARCHAR2(50 BYTE) ,
  "QUANTITY" NUMBER(11) NOT NULL ,
  "AMOUNT" NUMBER(10,2) NOT NULL 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."ID" IS '主键';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."NAME" IS '商品名称';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."IMAGE" IS '商品图片';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."ORDER_ID" IS '订单id';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."DISH_ID" IS '菜品id';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."M_ID" IS '商家ID';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."DISH_FLAVOR" IS '口味';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."QUANTITY" IS '数量';
COMMENT ON COLUMN "WY"."ORDER_DETAIL"."AMOUNT" IS '金额';
COMMENT ON TABLE "WY"."ORDER_DETAIL" IS '订单明细表';

-- ----------------------------
-- Table structure for ORDERS
-- ----------------------------
DROP TABLE "WY"."ORDERS";
CREATE TABLE "WY"."ORDERS" (
  "ID" NUMBER(20) NOT NULL ,
  "ORDER_NUMBER" VARCHAR2(50 BYTE) ,
  "STATUS" NUMBER(11) DEFAULT 1    NOT NULL ,
  "USER_ID" NUMBER(20) NOT NULL ,
  "M_ID" NUMBER(20) ,
  "ADDRESS_BOOK_ID" NUMBER(20) NOT NULL ,
  "ORDER_TIME" DATE NOT NULL ,
  "CHECKOUT_TIME" DATE ,
  "PAY_METHOD" NUMBER(11) ,
  "AMOUNT" NUMBER(10,2) ,
  "REMARK" VARCHAR2(100 BYTE) ,
  "PHONE" VARCHAR2(255 BYTE) ,
  "ADDRESS" VARCHAR2(255 BYTE) ,
  "USER_NAME" VARCHAR2(255 BYTE) ,
  "CONSIGNEE" VARCHAR2(255 BYTE) 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."ORDERS"."ID" IS '主键';
COMMENT ON COLUMN "WY"."ORDERS"."ORDER_NUMBER" IS '订单号';
COMMENT ON COLUMN "WY"."ORDERS"."STATUS" IS '订单状态 1待付款，2待派送，3已派送，4已完成，5已取消';
COMMENT ON COLUMN "WY"."ORDERS"."USER_ID" IS '下单用户id';
COMMENT ON COLUMN "WY"."ORDERS"."M_ID" IS '商家ID';
COMMENT ON COLUMN "WY"."ORDERS"."ADDRESS_BOOK_ID" IS '地址id';
COMMENT ON COLUMN "WY"."ORDERS"."ORDER_TIME" IS '下单时间';
COMMENT ON COLUMN "WY"."ORDERS"."CHECKOUT_TIME" IS '结账时间';
COMMENT ON COLUMN "WY"."ORDERS"."PAY_METHOD" IS '支付方式 1微信,2支付宝';
COMMENT ON COLUMN "WY"."ORDERS"."AMOUNT" IS '实收金额';
COMMENT ON COLUMN "WY"."ORDERS"."REMARK" IS '备注';
COMMENT ON COLUMN "WY"."ORDERS"."PHONE" IS '收货人电话';
COMMENT ON COLUMN "WY"."ORDERS"."ADDRESS" IS '收货地址';
COMMENT ON COLUMN "WY"."ORDERS"."USER_NAME" IS '收货人用户名';
COMMENT ON COLUMN "WY"."ORDERS"."CONSIGNEE" IS '收货人姓名';
COMMENT ON TABLE "WY"."ORDERS" IS '订单表';

-- ----------------------------
-- Table structure for SHOPPING_CART
-- ----------------------------
DROP TABLE "WY"."SHOPPING_CART";
CREATE TABLE "WY"."SHOPPING_CART" (
  "ID" NUMBER(20) NOT NULL ,
  "NAME" VARCHAR2(50 BYTE) ,
  "IMAGE" VARCHAR2(100 BYTE) ,
  "USER_ID" NUMBER(20) NOT NULL ,
  "ENTERPRISE_ID" NUMBER(20) ,
  "DISH_ID" NUMBER(20) ,
  "SETMEAL_ID" NUMBER(20) ,
  "DISH_FLAVOR" VARCHAR2(50 BYTE) ,
  "QUANTITY" NUMBER(11) NOT NULL ,
  "AMOUNT" NUMBER(10,2) NOT NULL ,
  "CREATE_TIME" DATE 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."SHOPPING_CART"."NAME" IS '商品名称';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."IMAGE" IS '商品图片';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."USER_ID" IS '用户id';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."ENTERPRISE_ID" IS '商家id';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."DISH_ID" IS '菜品id';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."SETMEAL_ID" IS '套餐id';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."DISH_FLAVOR" IS '口味';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."QUANTITY" IS '数量';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."AMOUNT" IS '金额';
COMMENT ON COLUMN "WY"."SHOPPING_CART"."CREATE_TIME" IS '创建时间';
COMMENT ON TABLE "WY"."SHOPPING_CART" IS '购物车';

-- ----------------------------
-- Table structure for TPL_AUTOCOLUMN
-- ----------------------------
DROP TABLE "WY"."TPL_AUTOCOLUMN";
CREATE TABLE "WY"."TPL_AUTOCOLUMN" (
  "ID" NUMBER(11) NOT NULL ,
  "NUM" NUMBER(11) NOT NULL ,
  "COLUMN_NAME" VARCHAR2(80 BYTE) NOT NULL ,
  "DATA_TYPE" VARCHAR2(50 BYTE) NOT NULL ,
  "DATA_LENGTH" NUMBER(22) NOT NULL ,
  "COMMENTS" VARCHAR2(100 BYTE) NOT NULL ,
  "JAVA_FIELD" VARCHAR2(100 BYTE) NOT NULL ,
  "JAVA_DATA_TYPE" VARCHAR2(100 BYTE) NOT NULL ,
  "VUE_TYPE" NUMBER(10) NOT NULL ,
  "CONVERT_VALUE" VARCHAR2(100 BYTE) ,
  "SEARCH_FIELD" NUMBER(1) ,
  "TABLE_FIELD" NUMBER(1) ,
  "TABLE_NAME" VARCHAR2(100 BYTE) NOT NULL 
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "WY"."TPL_AUTOCOLUMN"."ID" IS '主键';

-- ----------------------------
-- Records of TPL_AUTOCOLUMN
-- ----------------------------
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('103', '1', 'ID', 'NUMBER', '20', '编号', 'id', 'BigDecimal', '1', NULL, NULL, '1', 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('104', '2', 'NAME', 'VARCHAR2', '255', '商家名称', 'name', 'String', '1', NULL, '1', '1', 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('105', '3', 'ADDRESS', 'VARCHAR2', '255', '商家地址', 'address', 'String', '1', NULL, NULL, '1', 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('106', '4', 'PHONE', 'VARCHAR2', '255', '联系电话', 'phone', 'String', '1', NULL, NULL, '1', 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('107', '5', 'PICTURE', 'VARCHAR2', '255', '商家图片', 'picture', 'String', '2', NULL, NULL, '1', 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('108', '6', 'LONGITUDE', 'NUMBER', '10', '商家位置经度', 'longitude', 'Long', '1', NULL, NULL, NULL, 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('109', '7', 'LATITUDE', 'NUMBER', '10', '商家位置纬度', 'latitude', 'Long', '1', NULL, NULL, NULL, 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('110', '8', 'CREATE_TIME', 'DATE', '7', '创建时间', 'createTime', 'Date', '1', NULL, NULL, '1', 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('111', '9', 'CREATE_BY', 'VARCHAR2', '50', '创建人', 'createBy', 'String', '1', NULL, NULL, NULL, 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('112', '10', 'UPDATE_TIME', 'DATE', '7', '修改时间', 'updateTime', 'Date', '1', NULL, NULL, NULL, 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('113', '11', 'UPDATE_BY', 'VARCHAR2', '50', '修改人', 'updateBy', 'String', '1', NULL, NULL, NULL, 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('114', '12', 'LOGIN_NAME', 'VARCHAR2', '50', '商家账户', 'loginName', 'String', '1', NULL, NULL, NULL, 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('115', '13', 'LOGIN_PWD', 'VARCHAR2', '80', '商家密码', 'loginPwd', 'String', '1', NULL, NULL, NULL, 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('116', '14', 'STATUS', 'NUMBER', '4', '审核状态（0已审核，1未审核）', 'status', 'Short', '1', NULL, NULL, '1', 'MERCHANDISER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('129', '1', 'ID', 'NUMBER', '11', '编号', 'id', 'Long', '1', NULL, NULL, '1', 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('130', '2', 'M_ID', 'NUMBER', '20', '商家编号', 'mId', 'BigDecimal', '1', NULL, '1', '1', 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('131', '3', 'NAME', 'VARCHAR2', '100', '类别名称', 'name', 'String', '1', NULL, '1', '1', 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('132', '4', 'PICTURE', 'VARCHAR2', '255', '类别图片', 'picture', 'String', '2', NULL, NULL, '1', 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('133', '5', 'CREATE_TIME', 'DATE', '7', '创建时间', 'createTime', 'Date', '1', NULL, NULL, '1', 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('134', '6', 'CREATE_BY', 'VARCHAR2', '50', '创建人', 'createBy', 'String', '1', NULL, NULL, NULL, 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('135', '7', 'UPDATE_TIME', 'DATE', '7', '更新时间', 'updateTime', 'Date', '1', NULL, NULL, NULL, 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('136', '8', 'UPDATE_BY', 'VARCHAR2', '50', '更新人', 'updateBy', 'String', '1', NULL, NULL, NULL, 'MERCHANDISE_CLASS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('52', '1', 'ID', 'NUMBER', '11', '主键', 'id', 'Long', '1', NULL, NULL, '1', 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('53', '2', 'LOGINID', 'VARCHAR2', '255', '账号', 'loginid', 'String', '1', NULL, '1', '1', 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('54', '3', 'PASSWOLD', 'VARCHAR2', '255', '密码加密', 'passwold', 'String', '1', NULL, NULL, NULL, 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('55', '4', 'USER_NAME', 'VARCHAR2', '255', '昵称', 'userName', 'String', '1', NULL, '1', '1', 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('56', '5', 'GENDER', 'NUMBER', '4', '性别(0 女 1 男)', 'gender', 'Short', '3', '0=女:1=男', '0', '1', 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('57', '6', 'PORTRAIT', 'VARCHAR2', '255', '头像', 'portrait', 'String', '2', NULL, NULL, '1', 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('58', '7', 'STATUS', 'NUMBER', '10', '状态1：停用0：正常', 'status', 'Long', '1', NULL, NULL, '1', 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('59', '8', 'CREATE_TIME', 'DATE', '7', '创建时间', 'createTime', 'Date', '1', NULL, NULL, '1', 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('60', '9', 'CREATE_BY', 'VARCHAR2', '50', '创建人', 'createBy', 'String', '1', NULL, NULL, NULL, 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('61', '10', 'UPDATE_TIME', 'DATE', '7', '修改时间', 'updateTime', 'Date', '1', NULL, NULL, NULL, 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('62', '11', 'UPDATE_BY', 'VARCHAR2', '50', '修改人', 'updateBy', 'String', '1', NULL, NULL, NULL, 'CONTAMER');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('137', '1', 'ID', 'NUMBER', '20', '商品编号', 'id', 'BigDecimal', '1', NULL, NULL, '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('138', '2', 'NAME', 'VARCHAR2', '100', '商品名称', 'name', 'String', '1', NULL, '1', '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('139', '3', 'PRICE', 'NUMBER', '10', '商品价格', 'price', 'Long', '1', NULL, NULL, '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('140', '4', 'PICTURE', 'VARCHAR2', '200', '商品图片', 'picture', 'String', '2', NULL, NULL, '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('141', '5', 'DESCRIPTION', 'VARCHAR2', '255', '商品描述', 'description', 'String', '1', NULL, NULL, NULL, 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('142', '6', 'SCORE', 'NUMBER', '10', '商品综合评分', 'score', 'Long', '1', NULL, NULL, '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('143', '7', 'B_ID', 'NUMBER', '20', '商家id', 'bId', 'BigDecimal', '1', NULL, NULL, '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('144', '8', 'M_ID', 'NUMBER', '20', '商品分类', 'mId', 'BigDecimal', '1', NULL, NULL, '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('145', '9', 'ISGROUNDING', 'NUMBER', '11', '是否上架 1：上架 ，0：没上架', 'isgrounding', 'Long', '1', NULL, '1', '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('146', '10', 'CREATE_TIME', 'DATE', '7', '创建时间', 'createTime', 'Date', '1', NULL, NULL, '1', 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('147', '11', 'CREATE_BY', 'VARCHAR2', '50', '创建人', 'createBy', 'String', '1', NULL, NULL, NULL, 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('148', '12', 'UPDATE_TIME', 'DATE', '7', '修改时间', 'updateTime', 'Date', '1', NULL, NULL, NULL, 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('149', '13', 'UPDATE_BY', 'VARCHAR2', '50', '修改人', 'updateBy', 'String', '1', NULL, NULL, NULL, 'MERCHANDISE');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('1', '1', 'ID', 'NUMBER', '11', '编号', 'id', 'Long', '1', NULL, NULL, NULL, 'ENTERPRISE_PROCESS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('2', '2', 'TENANT_ID', 'NUMBER', '20', '商家ID', 'tenantId', 'BigDecimal', '1', NULL, NULL, '1', 'ENTERPRISE_PROCESS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('3', '3', 'STATUS', 'NUMBER', '4', '审核状态(0-通过，1-不通过)', 'status', 'Short', '1', NULL, NULL, '1', 'ENTERPRISE_PROCESS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('4', '4', 'DESCRIPTION', 'VARCHAR2', '500', '原因描述', 'description', 'String', '1', NULL, NULL, '1', 'ENTERPRISE_PROCESS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('5', '5', 'CREATE_BY', 'VARCHAR2', '50', '审核人', 'createBy', 'String', '1', NULL, NULL, '1', 'ENTERPRISE_PROCESS');
INSERT INTO "WY"."TPL_AUTOCOLUMN" VALUES ('6', '6', 'CREATE_TIME', 'DATE', '7', '审核时间', 'createTime', 'Date', '1', NULL, NULL, '1', 'ENTERPRISE_PROCESS');

-- ----------------------------
-- Primary Key structure for table ADDRESS_BOOK
-- ----------------------------
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038440" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table ADDRESS_BOOK
-- ----------------------------
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038431" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038432" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038433" CHECK ("CONSIGNEE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038434" CHECK ("SEX" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038435" CHECK ("PHONE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038436" CHECK ("IS_DEFAULT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038437" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038438" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0038439" CHECK ("IS_DELETED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040443" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040444" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040445" CHECK ("CONSIGNEE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040446" CHECK ("SEX" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040447" CHECK ("PHONE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040448" CHECK ("IS_DEFAULT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040449" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040450" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0040451" CHECK ("IS_DELETED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041500" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041501" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041502" CHECK ("CONSIGNEE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041503" CHECK ("SEX" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041504" CHECK ("PHONE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041505" CHECK ("IS_DEFAULT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041506" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041507" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0041508" CHECK ("IS_DELETED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045921" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045922" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045923" CHECK ("CONSIGNEE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045924" CHECK ("SEX" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045925" CHECK ("PHONE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045926" CHECK ("IS_DEFAULT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045927" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045928" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ADDRESS_BOOK" ADD CONSTRAINT "SYS_C0045929" CHECK ("IS_DELETED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table CONTAMER
-- ----------------------------
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038459" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table CONTAMER
-- ----------------------------
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038452" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038453" CHECK ("LOGINID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038454" CHECK ("PASSWOLD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038455" CHECK ("USER_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038456" CHECK ("GENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038457" CHECK ("PORTRAIT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0038458" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0041509" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0041510" CHECK ("LOGINID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0041511" CHECK ("PASSWOLD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0041512" CHECK ("USER_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0041513" CHECK ("GENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0041514" CHECK ("PORTRAIT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0041515" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0045930" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0045931" CHECK ("LOGINID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0045932" CHECK ("PASSWOLD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0045933" CHECK ("USER_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0045934" CHECK ("GENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0045935" CHECK ("PORTRAIT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."CONTAMER" ADD CONSTRAINT "SYS_C0045936" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table DISH_FLAVOR
-- ----------------------------
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0038466" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table DISH_FLAVOR
-- ----------------------------
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0038460" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0038461" CHECK ("DISH_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0038462" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0038463" CHECK ("IS_DELETED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0038464" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0038465" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0041516" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0041517" CHECK ("DISH_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0041518" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0041519" CHECK ("IS_DELETED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0041520" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0041521" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0045937" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0045938" CHECK ("DISH_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0045939" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0045940" CHECK ("IS_DELETED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0045941" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."DISH_FLAVOR" ADD CONSTRAINT "SYS_C0045942" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table EMPLOYEE
-- ----------------------------
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038474" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table EMPLOYEE
-- ----------------------------
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038467" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038468" CHECK ("LOGIN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038469" CHECK ("LOGIN_PWD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038470" CHECK ("GENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038471" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038472" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0038473" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0041522" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0041523" CHECK ("LOGIN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0041524" CHECK ("LOGIN_PWD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0041525" CHECK ("GENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0041526" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0041527" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0041528" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0045943" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0045944" CHECK ("LOGIN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0045945" CHECK ("LOGIN_PWD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0045946" CHECK ("GENDER" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0045947" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0045948" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."EMPLOYEE" ADD CONSTRAINT "SYS_C0045949" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table ENTERPRISE_PROCESS
-- ----------------------------
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045607" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045608" CHECK ("TENANT_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045609" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045610" CHECK ("DESCRIPTION" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045611" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045950" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045951" CHECK ("TENANT_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045952" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045953" CHECK ("DESCRIPTION" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ENTERPRISE_PROCESS" ADD CONSTRAINT "SYS_C0045954" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table MERCHANDISE
-- ----------------------------
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038493" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table MERCHANDISE
-- ----------------------------
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038486" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038487" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038488" CHECK ("PRICE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038489" CHECK ("B_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038490" CHECK ("M_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038491" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0038492" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0041529" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0041530" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0041531" CHECK ("PRICE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0041532" CHECK ("B_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0041533" CHECK ("M_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0041534" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0041535" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0045955" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0045956" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0045957" CHECK ("PRICE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0045958" CHECK ("B_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0045959" CHECK ("M_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0045960" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE" ADD CONSTRAINT "SYS_C0045961" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table MERCHANDISE_CLASS
-- ----------------------------
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0038517" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table MERCHANDISE_CLASS
-- ----------------------------
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0038512" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0038513" CHECK ("M_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0038514" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0038515" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0038516" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0041539" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0041540" CHECK ("M_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0041541" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0041542" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0041543" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0045965" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0045966" CHECK ("M_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0045967" CHECK ("NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0045968" CHECK ("CREATE_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISE_CLASS" ADD CONSTRAINT "SYS_C0045969" CHECK ("CREATE_BY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table MERCHANDISER
-- ----------------------------
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0038549" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table MERCHANDISER
-- ----------------------------
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0038546" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0038547" CHECK ("LOGIN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0038548" CHECK ("LOGIN_PWD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0041536" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0041537" CHECK ("LOGIN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0041538" CHECK ("LOGIN_PWD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0045962" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0045963" CHECK ("LOGIN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."MERCHANDISER" ADD CONSTRAINT "SYS_C0045964" CHECK ("LOGIN_PWD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table ORDER_DETAIL
-- ----------------------------
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0038564" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table ORDER_DETAIL
-- ----------------------------
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0038560" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0038561" CHECK ("ORDER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0038562" CHECK ("QUANTITY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0038563" CHECK ("AMOUNT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0041549" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0041550" CHECK ("ORDER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0041551" CHECK ("QUANTITY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0041552" CHECK ("AMOUNT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0045975" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0045976" CHECK ("ORDER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0045977" CHECK ("QUANTITY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDER_DETAIL" ADD CONSTRAINT "SYS_C0045978" CHECK ("AMOUNT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table ORDERS
-- ----------------------------
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0038625" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table ORDERS
-- ----------------------------
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0038620" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0038621" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0038622" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0038623" CHECK ("ADDRESS_BOOK_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0038624" CHECK ("ORDER_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0041544" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0041545" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0041546" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0041547" CHECK ("ADDRESS_BOOK_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0041548" CHECK ("ORDER_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0045970" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0045971" CHECK ("STATUS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0045972" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0045973" CHECK ("ADDRESS_BOOK_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."ORDERS" ADD CONSTRAINT "SYS_C0045974" CHECK ("ORDER_TIME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table SHOPPING_CART
-- ----------------------------
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0038649" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table SHOPPING_CART
-- ----------------------------
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0038645" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0038646" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0038647" CHECK ("QUANTITY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0038648" CHECK ("AMOUNT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0041553" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0041554" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0041555" CHECK ("QUANTITY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0041556" CHECK ("AMOUNT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0045979" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0045980" CHECK ("USER_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0045981" CHECK ("QUANTITY" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."SHOPPING_CART" ADD CONSTRAINT "SYS_C0045982" CHECK ("AMOUNT" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table TPL_AUTOCOLUMN
-- ----------------------------
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045091" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045092" CHECK ("NUM" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045093" CHECK ("COLUMN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045094" CHECK ("DATA_TYPE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045095" CHECK ("DATA_LENGTH" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045096" CHECK ("COMMENTS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045097" CHECK ("JAVA_FIELD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045098" CHECK ("JAVA_DATA_TYPE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045099" CHECK ("VUE_TYPE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045100" CHECK ("TABLE_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045983" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045984" CHECK ("NUM" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045985" CHECK ("COLUMN_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045986" CHECK ("DATA_TYPE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045987" CHECK ("DATA_LENGTH" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045988" CHECK ("COMMENTS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045989" CHECK ("JAVA_FIELD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045990" CHECK ("JAVA_DATA_TYPE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045991" CHECK ("VUE_TYPE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "WY"."TPL_AUTOCOLUMN" ADD CONSTRAINT "SYS_C0045992" CHECK ("TABLE_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
