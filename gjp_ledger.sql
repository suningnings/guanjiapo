/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : gjp

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-09-12 15:52:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gjp_ledger`
-- ----------------------------
DROP TABLE IF EXISTS `gjp_ledger`;
CREATE TABLE gjp_ledger(
  lid INT PRIMARY KEY AUTO_INCREMENT, -- 账务ID
  parent VARCHAR(100), -- 所属父分类
  money DOUBLE, -- 金额
  sid INT, -- 分类ID
  account VARCHAR(100), -- 账户
  createtime DATE, -- 创建时间
  ldesc VARCHAR(1000) -- 描述
 );

-- ----------------------------
-- Records of gjp_ledger
-- ----------------------------
INSERT INTO
 gjp_ledger(lid,parent,money,sid,account,createtime,ldesc)
 VALUES
(1,'支出',247,2,'交通银行','2017-03-02','家庭聚餐'),
 (2,'收入',12345,5,'现金','2017-03-15','开工资了'),
 (3,'支出',1998,1,'现金','2017-04-02','买衣服'),
 (4,'支出',325,2,'现金','2017-06-18','朋友聚餐'),
 (10,'收入',8000,6,'工商银行','2017-10-28','股票大涨'),
 (11,'收入',5000,6,'工商银行','2017-10-28','股票又大涨'),
 (12,'收入',5000,5,'交通银行','2017-10-28','又开工资了'),
 (13,'支出',5000,7,'现金','2017-10-28','朋友结婚'),
 (14,'支出',1560,8,'现金','2017-10-29','丢钱了'),
 (15,'支出',2300,3,'交通银行','2017-10-29','油价还在涨啊'),
 (16,'支出',1000,2,'工商银行','2017-10-29','又吃饭'),
 (17,'收入',1000,5,'现金','2017-10-30','开资'),
 (18,'支出',2000,3,'现金','2017-10-30','机票好贵'),
 (19,'收入',5000,5,'现金','2017-10-30','又开资');