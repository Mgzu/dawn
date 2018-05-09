/*
Navicat MySQL Data Transfer

Source Server         : boot
Source Server Version : 50721
Source Host           : 193.112.63.187:3306
Source Database       : boot

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-08 22:32:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_server
-- ----------------------------
DROP TABLE IF EXISTS `sys_server`;
CREATE TABLE `sys_server` (
  `server_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '服务器id',
  `server_name` varchar(255) DEFAULT NULL COMMENT '服务器名字',
  `server_ip` varchar(255) DEFAULT NULL COMMENT '服务器ip',
  `server_port` varchar(255) DEFAULT NULL COMMENT '服务器端口',
  PRIMARY KEY (`server_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_server
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'aa', 'a123456', 'MAN', 'admin');
INSERT INTO `sys_user` VALUES ('2', 'bb', 'b123456', 'WOMAN', 'root');
INSERT INTO `sys_user` VALUES ('3', 'cc', 'b123456', 'WOMAN', 'user');
INSERT INTO `sys_user` VALUES ('4', '1', '1', '1', null);
INSERT INTO `sys_user` VALUES ('5', 'aa', 'a123456', 'MAN', null);
INSERT INTO `sys_user` VALUES ('6', 'bb', 'b123456', 'WOMAN', null);
INSERT INTO `sys_user` VALUES ('7', 'cc', 'b123456', 'WOMAN', null);
INSERT INTO `sys_user` VALUES ('8', 'aa', 'a123456', 'MAN', null);
