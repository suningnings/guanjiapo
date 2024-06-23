/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : gjp

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-09-12 12:16:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gjp_sort`
-- ----------------------------
DROP TABLE IF EXISTS `gjp_sort`;
CREATE TABLE gjp_sort(
  sid INT PRIMARY KEY AUTO_INCREMENT, -- 分类ID
  sname VARCHAR(100), -- 分类名称
  parent VARCHAR(100), -- 所属父分类
  sdesc VARCHAR(10000) -- 描述
);

-- ----------------------------
-- Records of gjp_sort
-- ----------------------------
INSERT INTO
gjp_sort(sid,sname,parent,sdesc)
VALUES
(1,'服装支出','支出','买衣服'),
(2,'吃饭支出','支出',''),
(3,'交通支出','支出',''),
(4,'住房支出','支出',''),
(5,'工资收入','收入','fda'),
(6,'股票收入','收入',''),
(7,'礼金支出','支出',''),
(8,'其它支出','支出','');
