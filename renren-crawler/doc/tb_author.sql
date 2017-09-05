/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : renren_crawler

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-09-05 17:09:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_author`
-- ----------------------------
DROP TABLE IF EXISTS `tb_author`;
CREATE TABLE `tb_author` (
  `id` int(11) NOT NULL,
  `book_count` int(11) DEFAULT NULL COMMENT '订阅人数',
  `channel_image` varchar(500) DEFAULT NULL COMMENT '头像url',
  `channel_name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `channel_summary` varchar(500) DEFAULT NULL COMMENT '简介',
  `channel_type` varchar(500) DEFAULT NULL COMMENT '父类型',
  `media_domain` varchar(500) DEFAULT NULL COMMENT '子类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_author
-- ----------------------------
INSERT INTO `tb_author` VALUES ('111111', '60', 'http://si1.go2yd.com/get-image/0EdIPKUKBIu', '易途8', '易途8海外中文专车，专为国人境外出行提供中文包车、接机、自驾租车当地玩乐等服务。你和世界的故事，从这里开始！', 'media', '旅游');
INSERT INTO `tb_author` VALUES ('133393', '13', 'http://si1.go2yd.com/get-image/05zKrQOmisy', '程序视界', '聚焦IT人的职场生活、职业选择、适应、发展、转型、技能Get，有料，有趣，有能量。', 'media', '职场');
INSERT INTO `tb_author` VALUES ('133395', '3', 'http://si1.go2yd.com/get-image/062TCCseehM', '开汇国际', '开汇国际提供最新的外汇资讯，平台动态，平台分析，专注于成为您了解外汇行业的领路人。', 'media', '财经');
INSERT INTO `tb_author` VALUES ('133396', '403', 'http://si1.go2yd.com/get-image/05zJ3eRCl72', '众网赢传媒', '以平民化视角报道，以媒体人言论彰显主流。', 'media', '其他');
INSERT INTO `tb_author` VALUES ('133397', '84', 'http://si1.go2yd.com/get-image/05zENatfp9U', '开锐教育', '致力于为在职人员提供高质量，低成本的教育服务', 'media', '教育');
INSERT INTO `tb_author` VALUES ('175161', '18', 'http://si1.go2yd.com/get-image/08i8hsgHPlY', '妈咪娱乐', '网罗最新的轻松好笑的娱乐生活资讯,分享最前沿的信息【新闻、搞笑、娱乐、人生】分享交流经验与文化,生活在指尖上【逗娱逗乐】与你一起成长.', 'media', '育儿');
