/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : muti_lan

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-12 11:16:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_lan_basic
-- ----------------------------
DROP TABLE IF EXISTS `sys_lan_basic`;
CREATE TABLE `sys_lan_basic` (
  `id` varchar(36) NOT NULL,
  `table_name` varchar(50) NOT NULL,
  `table_name_desc` varchar(255) DEFAULT NULL,
  `column_name` varchar(50) NOT NULL,
  `column_name_desc` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_lan_basic
-- ----------------------------
INSERT INTO `sys_lan_basic` VALUES ('1', 'sys_org', '组织结构表', 'name', '组织结构名称', '');
INSERT INTO `sys_lan_basic` VALUES ('2', 'sys_user', '用户表', 'resume', '个人简历', '\0');

-- ----------------------------
-- Table structure for sys_lan_define
-- ----------------------------
DROP TABLE IF EXISTS `sys_lan_define`;
CREATE TABLE `sys_lan_define` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `used` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_lan_define
-- ----------------------------
INSERT INTO `sys_lan_define` VALUES ('ar_EG', 'Arabic', '');
INSERT INTO `sys_lan_define` VALUES ('cs_CZ', 'Český', '\0');
INSERT INTO `sys_lan_define` VALUES ('da_DK', 'Dansk', '\0');
INSERT INTO `sys_lan_define` VALUES ('default', '默认', '');
INSERT INTO `sys_lan_define` VALUES ('de_AT', 'Deutsch - Österreich', '\0');
INSERT INTO `sys_lan_define` VALUES ('de_CH', 'Deutsch - Schweiz', '\0');
INSERT INTO `sys_lan_define` VALUES ('de_DE', 'Deutsch - Deutschland', '\0');
INSERT INTO `sys_lan_define` VALUES ('el_GR', 'Greek', '\0');
INSERT INTO `sys_lan_define` VALUES ('en_GB', 'English - United Kingdom', '\0');
INSERT INTO `sys_lan_define` VALUES ('en_US', 'English - United States', '');
INSERT INTO `sys_lan_define` VALUES ('fi_FI', 'Suomi', '\0');
INSERT INTO `sys_lan_define` VALUES ('fr_CA', 'Français - Canada', '\0');
INSERT INTO `sys_lan_define` VALUES ('fr_CH', 'Français - Suisse', '\0');
INSERT INTO `sys_lan_define` VALUES ('fr_FR', 'Français - France', '\0');
INSERT INTO `sys_lan_define` VALUES ('hu_HU', 'Magyar', '\0');
INSERT INTO `sys_lan_define` VALUES ('it_IT', 'Italiano', '\0');
INSERT INTO `sys_lan_define` VALUES ('ja_JP', '日本語', '\0');
INSERT INTO `sys_lan_define` VALUES ('ko_KR', 'Korean', '\0');
INSERT INTO `sys_lan_define` VALUES ('nl_NL', 'Nederlands', '\0');
INSERT INTO `sys_lan_define` VALUES ('ru_RU', 'Russian', '\0');
INSERT INTO `sys_lan_define` VALUES ('zh_CN', '中文 - 中国', '');
INSERT INTO `sys_lan_define` VALUES ('zh_TW', '中文 - 台彎', '\0');

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', '{\r\n	\"Default\": \"互联网部\",\r\n	\"zh-CN\": \"互联网事业部\",\r\n	\"en-US\": \"Internal Deptment\"\r\n}', null);
INSERT INTO `sys_org` VALUES ('2', '{\r\n	\"Default\": \"互联网部1\",\r\n	\"zh-CN\": \"互联网事业部1\",\r\n	\"en-US\": \"Internal Deptment1\"\r\n}', '1');
INSERT INTO `sys_org` VALUES ('3', '{\r\n	\"Default\": \"互联网部2\",\r\n	\"zh-CN\": \"互联网事业部2\",\r\n	\"en-US\": \"Internal Deptment2\"\r\n}', '1');
