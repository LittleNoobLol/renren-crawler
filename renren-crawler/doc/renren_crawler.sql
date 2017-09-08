/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : renren_crawler

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-09-08 15:00:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_cron_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for `qrtz_fired_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_job_details`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', null, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400B67B226A6F624964223A312C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A2274657374222C22706172616D73223A2272656E72656E222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A302C2272656D61726B223A22E69C89E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320312C20323031362031313A31363A343620504D227D7800);
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', null, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400A47B226A6F624964223A322C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A227465737432222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A312C2272656D61726B223A22E697A0E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320332C203230313620323A35353A353620504D227D7800);

-- ----------------------------
-- Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_simple_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_simprop_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', null, '1504582200000', '-1', '5', 'WAITING', 'CRON', '1504581733000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400B67B226A6F624964223A312C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A2274657374222C22706172616D73223A2272656E72656E222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A302C2272656D61726B223A22E69C89E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320312C20323031362031313A31363A343620504D227D7800);
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', null, '1504582200000', '-1', '5', 'PAUSED', 'CRON', '1504581733000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400A47B226A6F624964223A322C226265616E4E616D65223A22746573745461736B222C226D6574686F644E616D65223A227465737432222C2263726F6E45787072657373696F6E223A223020302F3330202A202A202A203F222C22737461747573223A312C2272656D61726B223A22E697A0E58F82E695B0E6B58BE8AF95222C2263726561746554696D65223A2244656320332C203230313620323A35353A353620504D227D7800);

-- ----------------------------
-- Table structure for `schedule_job`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'testTask', 'test', 'renren', '0 0/30 * * * ?', '0', '有参数测试', '2016-12-01 23:16:46');
INSERT INTO `schedule_job` VALUES ('2', 'testTask', 'test2', null, '0 0/30 * * * ?', '1', '无参数测试', '2016-12-03 14:55:56');

-- ----------------------------
-- Table structure for `schedule_job_log`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('1', '1', 'testTask', 'test', 'renren', '0', null, '9', '2017-09-05 11:30:00');
INSERT INTO `schedule_job_log` VALUES ('2', '1', 'testTask', 'test', 'renren', '0', null, '3', '2017-09-05 13:00:00');
INSERT INTO `schedule_job_log` VALUES ('3', '1', 'testTask', 'test', 'renren', '0', null, '2', '2017-09-05 13:30:00');
INSERT INTO `schedule_job_log` VALUES ('4', '1', 'testTask', 'test', 'renren', '0', null, '14', '2017-09-05 14:00:00');
INSERT INTO `schedule_job_log` VALUES ('5', '1', 'testTask', 'test', 'renren', '0', null, '4', '2017-09-05 15:00:00');
INSERT INTO `schedule_job_log` VALUES ('6', '1', 'testTask', 'test', 'renren', '0', null, '13', '2017-09-05 16:00:00');
INSERT INTO `schedule_job_log` VALUES ('7', '1', 'testTask', 'test', 'renren', '0', null, '4', '2017-09-05 16:30:00');
INSERT INTO `schedule_job_log` VALUES ('8', '1', 'testTask', 'test', 'renren', '0', null, '16', '2017-09-05 17:00:00');

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"自媒体数据\",\"type\":0,\"icon\":\"fa fa-newspaper-o\",\"orderNum\":1}', '3', '0:0:0:0:0:0:0:1', '2017-09-05 11:32:00');
INSERT INTO `sys_log` VALUES ('2', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"一点资讯\",\"type\":0,\"icon\":\"fa fa-newspaper-o\",\"orderNum\":2}', '9', '0:0:0:0:0:0:0:1', '2017-09-05 12:53:22');
INSERT INTO `sys_log` VALUES ('3', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '31', '19', '0:0:0:0:0:0:0:1', '2017-09-05 12:53:30');
INSERT INTO `sys_log` VALUES ('4', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":32,\"parentName\":\"一点资讯\",\"name\":\"作者专栏\",\"url\":\"/modules/crawler/ydzx/tbauthor.html\",\"perms\":\"tbauthor:list,tbauthor:info,tbauthor:update,tbauthor:delete\",\"type\":1,\"orderNum\":2}', '7', '0:0:0:0:0:0:0:1', '2017-09-05 12:56:27');
INSERT INTO `sys_log` VALUES ('5', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"parentId\":32,\"parentName\":\"一点资讯\",\"name\":\"文章管理\",\"url\":\"/modules/crawler/ydzx/tbdetails.html\",\"perms\":\"tbdetails:list,tbdetails:info,tbdetails:updatetbdetails:delete,tbdetails:save\",\"type\":1,\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2017-09-05 14:20:32');
INSERT INTO `sys_log` VALUES ('6', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":33,\"parentId\":32,\"parentName\":\"一点资讯\",\"name\":\"作者专栏\",\"url\":\"/modules/crawler/ydzx/tbauthor.html\",\"perms\":\"tbauthor:list,tbauthor:info,tbauthor:update,tbauthor:delete,tbauthor:save\",\"type\":1,\"orderNum\":2}', '7', '0:0:0:0:0:0:0:1', '2017-09-05 14:20:34');
INSERT INTO `sys_log` VALUES ('7', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":34,\"parentId\":32,\"parentName\":\"一点资讯\",\"name\":\"文章管理\",\"url\":\"/modules/crawler/ydzx/tbdetails.html\",\"perms\":\"tbdetails:list,tbdetails:info,tbdetails:update,tbdetails:delete,tbdetails:save\",\"type\":1,\"orderNum\":0}', '6', '0:0:0:0:0:0:0:1', '2017-09-05 14:21:01');
INSERT INTO `sys_log` VALUES ('8', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":34,\"parentId\":32,\"parentName\":\"一点资讯\",\"name\":\"文章管理\",\"url\":\"/modules/crawler/ydzx/tbdetails.html\",\"perms\":\"tbdetails:list,tbdetails:info,tbdetails:update,tbdetails:delete,tbdetails:save\",\"type\":1,\"icon\":\"fa fa-file-text-o\",\"orderNum\":0}', '5', '0:0:0:0:0:0:0:1', '2017-09-05 14:23:33');
INSERT INTO `sys_log` VALUES ('9', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":33,\"parentId\":32,\"parentName\":\"一点资讯\",\"name\":\"作者专栏\",\"url\":\"/modules/crawler/ydzx/tbauthor.html\",\"perms\":\"tbauthor:list,tbauthor:info,tbauthor:update,tbauthor:delete,tbauthor:save\",\"type\":1,\"icon\":\"fa fa-id-card-o\",\"orderNum\":2}', '2', '0:0:0:0:0:0:0:1', '2017-09-05 14:23:41');
INSERT INTO `sys_log` VALUES ('10', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":33,\"parentId\":32,\"parentName\":\"一点资讯\",\"name\":\"作者专栏\",\"url\":\"/modules/crawler/ydzx/tbauthor.html\",\"perms\":\"tbauthor:list,tbauthor:info,tbauthor:update,tbauthor:delete,tbauthor:save,tbauthor:author\",\"type\":1,\"icon\":\"fa fa-id-card-o\",\"orderNum\":2}', '12', '127.0.0.1', '2017-09-05 14:51:35');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'modules/sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('32', '0', '一点资讯', null, null, '0', 'fa fa-newspaper-o', '2');
INSERT INTO `sys_menu` VALUES ('33', '32', '作者专栏', '/modules/crawler/ydzx/tbauthor.html', 'tbauthor:list,tbauthor:info,tbauthor:update,tbauthor:delete,tbauthor:save,tbauthor:author', '1', 'fa fa-id-card-o', '2');
INSERT INTO `sys_menu` VALUES ('34', '32', '文章管理', '/modules/crawler/ydzx/tbdetails.html', 'tbdetails:list,tbdetails:info,tbdetails:update,tbdetails:delete,tbdetails:save', '1', 'fa fa-file-text-o', '0');

-- ----------------------------
-- Table structure for `sys_oss`
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_token`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', 'c70787d66ff4f90805a9cefc49405172', '2017-09-05 23:30:26', '2017-09-05 11:30:26');

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

-- ----------------------------
-- Table structure for `tb_details`
-- ----------------------------
DROP TABLE IF EXISTS `tb_details`;
CREATE TABLE `tb_details` (
  `id` bigint(20) NOT NULL,
  `author_id` int(11) DEFAULT NULL COMMENT '作者id',
  `context_html` text COMMENT '正文内容带html标签',
  `context_text` text COMMENT '正文内容',
  `ctype` varchar(100) DEFAULT NULL COMMENT '分类',
  `date` datetime DEFAULT NULL COMMENT '发布时间',
  `docid` varchar(500) DEFAULT NULL COMMENT '加密后url后缀',
  `dtype` int(11) DEFAULT NULL COMMENT '暂时未知分类',
  `images` text COMMENT '本文所拥有的图片',
  `summary` varchar(500) DEFAULT NULL COMMENT '简介',
  `title` varchar(500) DEFAULT NULL COMMENT '标题',
  `url` varchar(500) DEFAULT NULL COMMENT '未加密的完整url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_details
-- ----------------------------
INSERT INTO `tb_details` VALUES ('6097565', '111111', null, null, 'news', '2016-06-23 15:25:31', '0Dey9Ng7', '3', '0Dey9NU9EV', '最近赴日签证太凶残！小易打听到日本领馆最新情报，日本领馆将开始加大签证审核力度。近期领馆电话审核频繁，一不小心回答错误，签证就可能被终止甚至拒签。', '赴日签证最新情报！回答错误，100%拒签！', 'http://www.yidianzixun.com/mp/content?id=6097565');
INSERT INTO `tb_details` VALUES ('6099314', '111111', null, null, 'news', '2016-06-23 15:53:31', '0DeyGTNf', '3', '0DeyGTCCW1', '天王嫂昆凌曾表示泰国苏梅W酒店是她蜜月最难忘的酒店~~确实，泰国苏梅的W酒店全球仅6家，整个泰国就苏梅1家！能不具有独特魅力嘛~｜1｜最美的Woo Bar全球共有6个「W Retreat」。而苏梅岛的则是泰国唯一的一个。下沉式的特色Woo Bar算其中的「白富', '周杰伦夫妇都痴迷的泰国苏梅W酒店，到底有何魅力？！', 'http://www.yidianzixun.com/mp/content?id=6099314');
INSERT INTO `tb_details` VALUES ('6099385', '111111', null, null, 'news', '2016-06-23 16:21:31', '0DeyGrMz', '1', '0DeyGrhVs1', '总体来说，泰国是一个比较安全、卫生的国家，很少有流行病，而且在出门前我们也会带一些简单的药品。基本上装备有：风油精、创可贴（最好是防水的）、消炎药（头孢）、感冒药、腹泻药、过敏体质建议带上开瑞坦（热带水果和食物易引发过敏）、晕船药（以防出海晕船）。', '泰国旅行必备 假如在泰国生病了怎么办？', 'http://www.yidianzixun.com/mp/content?id=6099385');
INSERT INTO `tb_details` VALUES ('6121905', '111111', null, null, 'news', '2016-06-24 16:21:31', '0DezpN4r', '1', '0DezpNexrf', '最近，不少订阅了易途8接机包车服务的用户跑来问小易，听说美国十年签证变两年了？是不是真的啊？这个政策对自己赴美旅行会带来什么变化？自己规划的行程会不会遇到问题？', '美国十年签证变两年？这里有最全的美签政策详解', 'http://www.yidianzixun.com/mp/content?id=6121905');
INSERT INTO `tb_details` VALUES ('6142429', '111111', null, null, 'news', '2016-06-25 16:21:31', '0Dfdhy0F', '3', '0DfdhySbtm', '每个去首尔旅游的人，做攻略都不忘列一项购物清单。那么去韩国首尔哪里购物，怎么购物才最方便，最划算呢？首尔最好的购物区在哪里？小易精心整理了以下购物攻略，快来一探究竟吧。温馨提示~欢迎使用易途8接机包车服务，让首尔之旅更加便捷愉快~', '首尔购物最强攻略 告诉你去哪里买最方便最划算', 'http://www.yidianzixun.com/mp/content?id=6142429');
INSERT INTO `tb_details` VALUES ('6146563', '111111', null, null, 'news', '2016-06-26 16:21:31', '0DfjCWAQ', '3', '0DfjCWdK7D', '没错，《周杰伦的床边故事》发行啦，这是周杰伦当了父亲以后，出的第一章专辑，《前世情人》、《床边故事》满满的都是对女儿的爱啊。周氏情歌《一点点》、《告白气球》也特别适合单曲循环，还有与天后合作的《不该》，耳朵要怀孕了。', '听完周杰伦2016新专辑，发现杰伦的新歌竟然有这些秘密！', 'http://www.yidianzixun.com/mp/content?id=6146563');
INSERT INTO `tb_details` VALUES ('6196708', '111111', null, null, 'news', '2016-06-28 16:21:31', '0DhTdrPa', '3', '0DhTdrb9wb', '缅甸人很重视新年。Thingyan意为泼水节，在每年的四月份举行。今年的泼水节是4月13日到16日。在这为期四天的新年假期里，银行，餐馆，商店等都将停业。仰光和曼德勒两个地方会举行盛大的泼水活动。泼水狂欢中，人们载歌载舞，相互泼洒。泼水象征着辞旧迎新，祝愿来年', '11项禁忌 去缅甸旅游一定不要碰！', 'http://www.yidianzixun.com/mp/content?id=6196708');
INSERT INTO `tb_details` VALUES ('6203836', '111111', null, null, 'news', '2016-06-29 16:21:31', '0DhP5NG3', '3', '0DhP5NvFif', '24岁的小哥Guirec Soudée带了一只母鸡去旅行，最开始他只是想着每天都可以有鸡蛋吃，然而不知不觉中，这只叫Monique的母鸡竟成了他旅途中的好伙伴，拍起照来也是毫不含糊。', '别人家的鸡都去旅游了，而你还在苦逼的加班!', 'http://www.yidianzixun.com/mp/content?id=6203836');
INSERT INTO `tb_details` VALUES ('6316686', '111111', null, null, 'news', '2016-07-04 16:21:31', '0DmETBCk', '3', '0DmETBr820', '由于那些令人叹为观止的火山地貌，汤加里罗越山步道常被誉为新西兰最棒的日间徒步旅行步道。然而它的魅力不只体现在白天。凌晨在手电筒的探照下开始攀爬，这不但完美地避开了人潮，还能将奇异的火山们当做是你同行的伙伴。最重要的是在登上红色火山口后，看到的日出景象一定让你大', '收藏 | 新西兰旅行最具特色的夜生活玩法', 'http://www.yidianzixun.com/mp/content?id=6316686');
INSERT INTO `tb_details` VALUES ('6333524', '111111', null, null, 'news', '2016-07-05 15:53:31', '0DnxePux', '3', '0DnxePz7DR', '从技术上讲，在这里的公开场合手拉手是违法的。如果你想像08年7月那两个英国旅游者在迪拜海滩上那样做得话，那么你会发现自己已经站在法庭上，成为一场文化战争的中心。', '一个不能手拉手的地方竟然变成旅游圣地！', 'http://www.yidianzixun.com/mp/content?id=6333524');
INSERT INTO `tb_details` VALUES ('6333616', '111111', null, null, 'news', '2016-07-05 16:21:31', '0DnF6Xs2', '3', '0DnF6XVKJk', '欧洲杯已经进行到1/4决赛了，英格兰爆冷出局，罗布森卡努创造威尔士奇迹。日耳曼战车能否打破意大利魔咒也即将揭晓。而C罗能否带领葡萄牙队走上神坛也让小易这样的球迷激动不已。2016欧洲杯近尾声，不如一起回顾52年一路走来的欧洲杯。', '泪崩！52年，欧洲杯历史经典瞬间！', 'http://www.yidianzixun.com/mp/content?id=6333616');
INSERT INTO `tb_details` VALUES ('6410378', '111111', null, null, 'news', '2016-07-09 16:21:31', '0DqMVNsC', '3', '0DqMVNxziM', '《大鱼海棠》讲的大概是一个男孩为了救某个特殊世界的少女椿坠海身亡，椿和自己青梅竹马的湫为了让死掉男孩的灵魂化作鲲而公然和天神作对的故事。当然，如果不怕剧透就继续往下看。', '跳票了12年的《大鱼海棠》，到底值不值得看？', 'http://www.yidianzixun.com/mp/content?id=6410378');
INSERT INTO `tb_details` VALUES ('6454996', '111111', null, null, 'news', '2016-07-12 16:21:31', '0Ds8rJd5', '1', '0Ds8rJVom5', '根据国家旅游局及外交部公布的信息，目前澳大利亚并没有向我国开放免签或落地签，澳方只是向符合条件的中国公民开放自助通关系统。', '澳大利亚免签？自助通关而已，这55个国家才是真的', 'http://www.yidianzixun.com/mp/content?id=6454996');
INSERT INTO `tb_details` VALUES ('6481040', '111111', null, null, 'news', '2016-07-13 16:21:31', '0DtRswdg', '3', '0DtRswNgTk', '前不久，瑞士计划向每个成年人无附加条件地每月给予2500瑞士法郎，约合人民币1.6万元，未成年人则为每月625瑞士法郎。如通过，瑞士将成为首个无条件向所有公民发放补助的国家。', '每人每月白拿1.6万，78%瑞士人竟然拒绝！', 'http://www.yidianzixun.com/mp/content?id=6481040');
INSERT INTO `tb_details` VALUES ('6514692', '111111', null, null, 'news', '2016-07-14 15:53:31', '0DtnLWCr', '1', '0DtnLW5RJi', '2015年在线旅游行业的发展进入瓶颈期，资本寒冬来临，旅游投资频率下降，旅游资本整合开始加速。而在在线旅游行业各自为战，亏损加剧的同时，易途8这家创业公司的迅猛发展夺人眼球。', '易途8，何以在资本寒冬融资生猛？', 'http://www.yidianzixun.com/mp/content?id=6514692');
INSERT INTO `tb_details` VALUES ('6524980', '111111', null, null, 'news', '2016-07-14 16:21:31', '0DuRy8FE', '1', '0DuRy8d3n1', '2015年中国出境人次突破1.2亿人次，比去年同期增长 15.0%。而境外的出行方式，一直是困扰出境者的难题。跟团游因为行程、时间的不自由饱受诟病，更因为购物消费隐患让出境游客避之不及。语言不通，交通不便等问题却成为自由行的痛点。在众多出境游方式的比较之下，包', '易途8包车游，出境游的新时尚！', 'http://www.yidianzixun.com/mp/content?id=6524980');
INSERT INTO `tb_details` VALUES ('6646420', '111111', null, null, 'news', '2016-07-20 16:21:31', '0DwtSAYt', '3', '0DwtSAdA0P', '“火人节”一共为期8天，每年8月底至9月初在美国内华达州黑石沙漠举行。每年这个时间，来自世界各地的人涌入这里，所有的参与者被称作Burner。“Burner”们在节日中会穿着奇装异服甚至全裸，大家会围着观看一个10几米高的木制男雕像燃烧，以此庆祝节日。', '真人版龙母屠城，这里有一座城等你来烧！', 'http://www.yidianzixun.com/mp/content?id=6646420');
INSERT INTO `tb_details` VALUES ('6774323', '111111', null, null, 'news', '2016-07-25 16:21:31', '0DzThoQv', '1', '0DzThoKO97', 'Expedia是全球最大的在线旅游公司，是美国著名的旅游网站，所属WTE公司（Worldwide Travel Exchange）。Expedia提供机票预定、酒店预订、租车、接送机、当地玩乐等旅行服务。其业务量约占全球在线旅游市场的三分之一，现有业务部门遍及', '易途8与Expedia达成战略合作', 'http://www.yidianzixun.com/mp/content?id=6774323');
INSERT INTO `tb_details` VALUES ('6859933', '111111', null, null, 'news', '2016-07-28 15:25:31', '0E2Sq2dv', '3', '0E2Sq2ncXy', '可以想象，坐着易途8的豪华专车，感受着异域风情，满眼的糖果色，有多幸福。', '这里的房子，自带愉悦功能，看得眼睛都饱了！', 'http://www.yidianzixun.com/mp/content?id=6859933');
INSERT INTO `tb_details` VALUES ('6860339', '111111', null, null, 'news', '2016-07-28 15:53:31', '0E2S0lOs', '3', '0E2S0lTqwO', '厄瓜多尔免签了，阿根廷也即将有条件免签了，巴西要办奥运会了....越来越多的目光聚向南美。可你是否觉得为去南美某一个国家就要打24小时长途飞的，好像划不来？', '这个平胸为美的国家，被评为2016年老外最爱度假地!', 'http://www.yidianzixun.com/mp/content?id=6860339');
INSERT INTO `tb_details` VALUES ('6860474', '111111', null, null, 'news', '2016-07-28 16:21:31', '0E2S9ABa', '3', '0E2S9AEgZB', '最近两天，wuli大浙江可以说是“实力炫热”连续五天出现大范围37℃以上的高温天气40个县（市、区）超过38℃，其中29个超过39℃天气信息也是分分钟的头条↓↓↓热到都不想出门看新电影宝宝只想说打败我的不是天真，是天真热！看看微博上热传的段子↓↓↓#一句话说浙', '被热到融化？！这里有高能的免费消暑清凉秘籍', 'http://www.yidianzixun.com/mp/content?id=6860474');
INSERT INTO `tb_details` VALUES ('6895628', '111111', null, null, 'news', '2016-07-29 16:21:31', '0E2jA6Sc', '3', '0E2jA6LAKT', '巴厘岛是印度尼西亚13600多个岛屿中最耀眼的一个岛，也是唯一信奉印度教的地区，是世界旅游圣地之一。巴厘岛地处热带，且受海洋影响，气候温和多雨，土壤肥沃，四季绿水青山。万花烂漫，林木参天。碧海蓝天、水清沙幼、壮美悬崖等各种美景，以及世界顶级的酒店服务，唯美浪漫', '这些婚礼，让黄教主和baby的婚礼黯然失色！', 'http://www.yidianzixun.com/mp/content?id=6895628');
INSERT INTO `tb_details` VALUES ('6914439', '111111', null, null, 'news', '2016-07-30 16:21:31', '0E3BspRb', '3', '0E3BspiVYr', '就在不久前，阿根廷放出一个让旅行者激动的重磅消息，那就是——阿根廷,这个世界上最难签证的国家，要实行有条件“免签”啦！', '史上最难啃的签证开放免签！超惊艳冬夏并存的世界奇景', 'http://www.yidianzixun.com/mp/content?id=6914439');
INSERT INTO `tb_details` VALUES ('6940539', '111111', null, null, 'news', '2016-07-31 16:21:31', '0E3QOtP2', '3', '0E3QOtyOHj', '该酒店已成为一处适合举办私人婚宴的特选场地。目前酒店有四种结婚场地可供新人选择水上婚礼、海滩婚礼、庭园婚礼及教堂婚礼。其中水上婚礼是指将透明礼坛布置在无边泳池中，新人站在圣坛中仿佛与水天相接，而且能将180度的悬崖海景尽收眼底，是最受欢迎的场景。', '霍如明日大婚，胡歌带明星齐聚巴厘岛断涯？！', 'http://www.yidianzixun.com/mp/content?id=6940539');
INSERT INTO `tb_details` VALUES ('7034623', '111111', null, null, 'news', '2016-08-03 16:21:31', '0E4wdGEN', '3', '0E4wdGdvBC', '总有杭州本地人或外地人夸耀杭州美女帅哥，不用特意寻找，走在湖滨就会眼花缭乱，小易话不多说，用照片证明杭州美女帅哥的颜值巅峰！', '辣眼睛！除了天热，让西湖燃烧的理由竟然是……', 'http://www.yidianzixun.com/mp/content?id=7034623');
INSERT INTO `tb_details` VALUES ('7058236', '111111', null, null, 'news', '2016-08-04 16:21:31', '0E5CKGZD', '3', '0E5CKG1TAR', '一个是互联网创业公司联合创人，一个是浙江电台著名女主播，一个小时的深度聊天，会迸发怎样的火花。', '一对陌生男女聊天一小时能聊得有多深？！', 'http://www.yidianzixun.com/mp/content?id=7058236');
INSERT INTO `tb_details` VALUES ('7200484', '111111', null, null, 'news', '2016-08-09 16:21:31', '0E7MMhzW', '3', '0E7MMhAOc9', '央视曾现场直播了东非草原上世界最大规模的动物迁徙，震撼的画面让很多人记住了马赛马拉，知道了肯尼亚。最近无论是在电视、微博、还是朋友圈中，又看到很多人前往非洲去见证地球上最长的一场马拉松，因为现在是去肯尼亚最好的季节。', '这辈子，一定要去看一次动物大迁徙！', 'http://www.yidianzixun.com/mp/content?id=7200484');
INSERT INTO `tb_details` VALUES ('7274681', '111111', null, null, 'news', '2016-08-11 16:21:31', '0E8YHPDy', '3', '0E8YHPCdq0', '7月17日，东北一个旅行团，在台湾8天行程结束去桃园机场坐飞机的时候，大巴车起火，24名陆客遇难，被活活烧死。', '真的，不！要！再！跟！团！游！了！', 'http://www.yidianzixun.com/mp/content?id=7274681');
INSERT INTO `tb_details` VALUES ('7310081', '111111', null, null, 'news', '2016-08-12 15:53:31', '0E99OTcg', '3', '0E99OT7ovc', '七夕只有一天，但只要去对的地方携手旅行，每天都是情人节。在你们境外需要用车的时候，易途8可以为您提供任何服务，带您去到任何地方秀恩爱。', '全世界最浪漫的50件事，一起完成过8件的就嫁了吧~', 'http://www.yidianzixun.com/mp/content?id=7310081');
INSERT INTO `tb_details` VALUES ('7334308', '111111', null, null, 'news', '2016-08-12 16:21:31', '0E9mftI3', '3', '0E9mftJFqB', '泰国，是一个天生的旅行国度。这里有山有水，有浪漫迷人的海滩海岸，有美食和文化。美味的泰国菜、丰富的夜生活，繁华的曼谷、小清新的清迈，几乎能满足你对旅行的一切期待。', '收藏！99%去泰国的人都错过的绝美海岛', 'http://www.yidianzixun.com/mp/content?id=7334308');
INSERT INTO `tb_details` VALUES ('7410902', '111111', null, null, 'news', '2016-08-15 15:53:31', '0EAZTJIY', '3', '0EAZTJD8vE', '厄外交部在一份官方公告中说，考虑到厄瓜多尔和中国之间的紧密友好关系，以及为两国之间日益频繁的人员交流提供便利，厄政府决定从今年3月1日起，赴厄瓜多尔旅游、探亲或从事非营利性活动的中国公民可免签入境、出境、过境厄瓜多尔。从第一次入境日期开始一年之内最多可在厄瓜多', '新免签政策！这个曾经只免签过四个月的绝美国家再度开放啦！', 'http://www.yidianzixun.com/mp/content?id=7410902');
INSERT INTO `tb_details` VALUES ('7419251', '111111', null, null, 'news', '2016-08-15 16:21:31', '0EAlVIUX', '1', '0EAlVI1TNC', '主流在线旅游市场被巨头三分天下的后，境外游作为最火热的细分市场，成为众人争抢的蛋糕。众多创业企业异军突起，行业巨头向未涉及领域极速扩展。然而，境外游市场却陷入混乱，持久的价格战、隐性消费、行规不明等问题引发境外游客的不满，也让境外旅游市场饱受争议。境外游行业的', '境外游市场野蛮成长，亟需制定行业规范', 'http://www.yidianzixun.com/mp/content?id=7419251');
INSERT INTO `tb_details` VALUES ('7443150', '111111', null, null, 'news', '2016-08-16 15:53:31', '0EBvwoeH', '1', '0EBvwoa2Sx', '国人境外出行面临着安全隐患、语言不通、不够便捷与价格高昂等痛点，虽有海外滴滴与优步提供用车服务，但显然不能满足国人境外多样化的出行需求。而如何解决国人境外出行“痛点，使境外出行变得零阻碍，已成为所以出境国人的迫切需求。', '易途8推出新版APP，直击境外出行痛点', 'http://www.yidianzixun.com/mp/content?id=7443150');
INSERT INTO `tb_details` VALUES ('7443215', '111111', null, null, 'news', '2016-08-16 16:21:31', '0EBzppOT', '1', '0EBzppdesu', '近日，境外中文专车平台——易途8推出全新logo与VI体系，并实现了产品的全新优化升级，而易途8的全新定位及其迅猛的发展让其在整个境外旅游行业与专车市场备受瞩目。', '易途8全新品牌升级，深度打造境外中文专车平台', 'http://www.yidianzixun.com/mp/content?id=7443215');
INSERT INTO `tb_details` VALUES ('7660204', '111111', null, null, 'news', '2016-08-23 16:21:31', '0EEw5qNT', '1', 'http://si1.go2yd.com/get-image/06HdSb9XQbw', '奥运装修队选手团入驻奥运村好像还是昨天的事儿，新闻上各种“这可能是最差一届”的负面预测好像还是昨天的事儿。一转眼，16天的奥运，结束了。', '奥运\"会\"落幕，但中国这个\"洪荒大爷\"一直在路上', 'http://www.yidianzixun.com/mp/content?id=7660204');
INSERT INTO `tb_details` VALUES ('7695560', '111111', null, null, 'news', '2016-08-24 16:21:31', '0EFXCZmg', '3', '0EFXCZdtRD', '这些沿途的风景、走过的行程、遇见的人和事、告别的旧时光，或许就是旅行的意义。', '当朋友圈晒的照片都变成“动作片”，美哭了', 'http://www.yidianzixun.com/mp/content?id=7695560');
INSERT INTO `tb_details` VALUES ('7732519', '111111', null, null, 'news', '2016-08-25 16:21:31', '0EGBKrkv', '3', '0EGBKrd1ta', '泰国，2015年中国人出境旅游第一大国。她，几乎能满足你对旅行的一切期待：低廉的物价、美味的泰国菜、丰富的夜生活，友好的泰国人，繁华的曼谷、小清新的清迈。当然，还有水清沙幼、碧海蓝天的海岛。', '2016年泰国最值得去的九大度假海岛，约起~~', 'http://www.yidianzixun.com/mp/content?id=7732519');
INSERT INTO `tb_details` VALUES ('7913815', '111111', null, null, 'news', '2016-08-30 16:21:31', '0EInpfoA', '3', '0EInpfjzmj', '杨洋井柏然，以及你们的老公宁泽涛，他全都拍过！小鲜肉吴磊弟弟和欧阳娜娜也是他男神女神收割机里的一份子！', '这个杨洋李宇春御用摄影师，拍了个视频，让一百万人想去日本！', 'http://www.yidianzixun.com/mp/content?id=7913815');
INSERT INTO `tb_details` VALUES ('7965138', '111111', null, null, 'news', '2016-08-31 15:53:31', '0EJeeMUC', '1', '0EJeeMr1FY', '境外中文专车平台易途8，日前宣布获得1.5亿元的B轮融资。此次融资由三花控股集团领投，中赢集团、顺融资本、华鼎基金、阿里巴巴十八罗汉麻长炜联合投资。截止目前，据公开信息显示，易途8的融资总金额超过2亿元，并将在下个月内启动B+轮融资。', '易途8完成1.5亿B轮融资，领跑境外游专车市场', 'http://www.yidianzixun.com/mp/content?id=7965138');
INSERT INTO `tb_details` VALUES ('7976827', '111111', null, null, 'news', '2016-08-31 16:21:31', '0EJt8eUu', '3', '0EJt8ewEjd', '今天，小易酱给大家分享 微博@污萌少女李小白 的原创视频，她用可爱又魔性的声音，带你真实的去了解日本忍者！喜欢火影忍者的朋友千万不要错过啊！', '魔性解密 | 带你探索即将灭绝的日本忍者！', 'http://www.yidianzixun.com/mp/content?id=7976827');
INSERT INTO `tb_details` VALUES ('8063874', '111111', null, null, 'news', '2016-09-02 16:21:31', '0ELLUhFE', '1', 'http://si1.go2yd.com/get-image/06Zl4W4Mnaq', '在所有邻国中，不丹是唯一一个未与中国建交的国家。不丹实行真正意义上的不结盟国策，与世界上的大部分国家没有外交关系，这包含了联合国的5个常任理事国。这个国家就是这么任性！', '惊呆了！不丹要和中国建交了？', 'http://www.yidianzixun.com/mp/content?id=8063874');
INSERT INTO `tb_details` VALUES ('8097928', '111111', null, null, 'news', '2016-09-03 16:21:31', '0ELmEgng', '3', '0ELmEgL2Zs', '南美，对于热爱旅行的人来说，这个大洲的很多国家可以说是旅行者的终极旅行地。南美洲坐拥非常好的旅游资源，却因为繁杂的签证手续和遥远的距离，让中国旅行者们一次次望而却步。', '阿根廷免签还不够，秘鲁还要来凑个南美游大礼包！', 'http://www.yidianzixun.com/mp/content?id=8097928');
INSERT INTO `tb_details` VALUES ('8139037', '111111', null, null, 'news', '2016-09-05 16:21:31', '0EMLN1H3', '3', '0EMLN1SnpM', '有的人出现，总会有一种让人眼前一亮，惊为天人的感觉。刚遇到二狗到的时候，小乔就是这种感觉：穿着印花沙滩裤，夹脚拖鞋，叼着烟，带着邪魅的笑，站在一群西装革履的同事中，像是清流中的一股泥石流。', '二狗之于小乔，就像清流中的一股泥石流', 'http://www.yidianzixun.com/mp/content?id=8139037');
INSERT INTO `tb_details` VALUES ('8176731', '111111', null, null, 'news', '2016-09-06 16:21:31', '0EMmBOMA', '3', '0EMmBOsyIw', '阿拉伯联合酋长国政府４日宣布，批准给予中国公民落地签证待遇，但未说明执行该措施的具体时间。', '阿联酋对中国开放落地签证！迪拜酋长说：来玩啊！', 'http://www.yidianzixun.com/mp/content?id=8176731');
INSERT INTO `tb_details` VALUES ('8222424', '111111', null, null, 'news', '2016-09-07 16:21:31', '0ENNpok4', '1', 'http://si1.go2yd.com/get-image/06hanAiO0Lg', '1985年的时候，殷洁是北京一家医院的护士长，而周小林是师专的一名学生，课余时间兼职旅行社的导游。', '他们把梦想过成了日子，种菜养花，诗意田园!', 'http://www.yidianzixun.com/mp/content?id=8222424');
INSERT INTO `tb_details` VALUES ('8261955', '111111', null, null, 'news', '2016-09-08 16:21:31', '0EPDfQs4', '1', 'http://si1.go2yd.com/get-image/06jFzKpNiM4', '目前，从国内乘坐国际列车已可通达中国东南西北方向的五个邻国，分别是俄罗斯、蒙古、朝鲜、越南和哈萨克斯坦。只要你办好了签证，就可以坐上火车出发啦，一路都是异国风情！', '在国内，坐火车就能去的五个国家，一路上都是风景！', 'http://www.yidianzixun.com/mp/content?id=8261955');
INSERT INTO `tb_details` VALUES ('8324438', '111111', null, null, 'news', '2016-09-10 15:53:31', '0EPmLQxH', '1', 'http://si1.go2yd.com/get-image/06lXqbRU4hc', '但内心还是非常的喜欢浪，每天都想着有一天赚了大钱出去玩。那时，每天最大的乐趣就是去网上看别人拍的照片，讲述旅行当中遇到的有趣的事情。慢慢的，也给自己定了几个想去的地方。', '一听到说诗和远方，我钱包就开始慌张', 'http://www.yidianzixun.com/mp/content?id=8324438');
INSERT INTO `tb_details` VALUES ('8341669', '111111', null, null, 'news', '2016-09-10 16:21:31', '0EPARog3', '1', 'http://si1.go2yd.com/get-image/06mf1JTl0YC', '前几天 ，小易酱的美国的小伙伴在ins上更新了照片，和图片配的文字是“Thanks，Burner.” 如图▼', '看世界 | 这群人一言不合就放火，还成了艺术', 'http://www.yidianzixun.com/mp/content?id=8341669');
INSERT INTO `tb_details` VALUES ('8391647', '111111', null, null, 'news', '2016-09-12 16:21:31', '0EPlpO0G', '1', 'http://si1.go2yd.com/get-image/06pzRKMnJL6', '二狗马上去看了她的朋友圈，哇，刚去新西兰玩完回来准备开学。随即翻看了好几条朋友圈，她还是那么爱玩，还是那么漂亮。', '老师，您还记得我吗？', 'http://www.yidianzixun.com/mp/content?id=8391647');
INSERT INTO `tb_details` VALUES ('8444299', '111111', null, null, 'news', '2016-09-14 15:53:31', '0EQd9w6O', '1', 'http://si1.go2yd.com/get-image/06s6AJgREBs', '所以，每年，生日、大寿、春节、中秋各种重要的日子都是和家里人过的。小孩子么，啥都不懂，就觉得年年一起过，什么意思都没有。', '朋友们，这个中秋不约了，我要回家看看', 'http://www.yidianzixun.com/mp/content?id=8444299');
INSERT INTO `tb_details` VALUES ('8460296', '111111', null, null, 'news', '2016-09-14 16:21:31', '0EQoOIAv', '1', 'http://si1.go2yd.com/get-image/06t6iTJcFXc', '这里是小易酱设计的人物专栏，以后定期会发掘人物故事，在没有旅行的时间里，希望大家依然能够对生活充满热爱。', '人物 | 这个姑娘，逃离北京，住进山林，过上了世外桃源般的生活', 'http://www.yidianzixun.com/mp/content?id=8460296');
INSERT INTO `tb_details` VALUES ('8602560', '111111', null, null, 'news', '2016-09-19 16:21:31', '0ESrpiSF', '1', '0ESrpigN2h', '西西这么说的时候，二狗有些反胃，甜腻的花香让二狗有些喘不过气来，大概是闻惯北京的雾霾了，这花儿，有点太香了。二狗心里这么想，却只在脸上做出一副难看的表情，像是便秘了好多天，突然有了感觉，却又使不出劲儿。', '比揭伤疤更疼的，是揭你的暗恋', 'http://www.yidianzixun.com/mp/content?id=8602560');
INSERT INTO `tb_details` VALUES ('8638689', '111111', null, null, 'news', '2016-09-20 16:21:31', '0ETQhvOK', '1', 'http://si1.go2yd.com/get-image/073TH1MJkCu', '倪妮这些街拍照，清新自然，百看不厌。在倪妮面前，别人也只能靠边站了。小易酱看了她的微博后，给大家总结出拍照7大要点，秒变拍照达人的秘籍就在此了。', '不是我说，论拍照，我只服倪妮！', 'http://www.yidianzixun.com/mp/content?id=8638689');
INSERT INTO `tb_details` VALUES ('8665214', '111111', null, null, 'news', '2016-09-21 16:21:31', '0EToVxFC', '3', '0EToVxBBzK', '9月12日清晨，一个一如平常忙碌的周一的开始，通勤者们行色匆匆地穿梭于伦敦四通八达的地下铁系统之中，迈着匆忙的脚步在赶往或工作或学习目的地的路上。', '喵！ 这间地铁站被本宝宝承包了喂 ~~', 'http://www.yidianzixun.com/mp/content?id=8665214');
INSERT INTO `tb_details` VALUES ('9601693', '111111', null, null, 'news', '2016-10-20 16:21:31', '0Ei3mnQ4', '1', '0Ei3mnriuv', '易途8作为境外中文专车的领军企业，不断拓展业务合作，易途8初期B端获客，发展至今已经与全球最大的在线旅游公司——Expedia、携程、阿里、途牛、去哪儿、蚂蜂窝等120家优质平台达成战略合作，签约旅行社上千家。', '易途8携手春秋航空，提升国人境外出行体验', 'http://www.yidianzixun.com/mp/content?id=9601693');
INSERT INTO `tb_details` VALUES ('10247941', '111111', null, null, 'news', '2016-11-04 16:21:31', '0EqKTNpx', '0', null, '易途8作为携程境外包车、接送机供应商，以及优质的合作商，近日双方开展了新一轮的合作。易途8在原有接送机与包车的基础上，与携程的创新工场达成深度合作，开展了新的拼车旅行业务。', '易途8牵手携程创新工场，开启境外拼车旅行时代', 'http://www.yidianzixun.com/mp/content?id=10247941');
INSERT INTO `tb_details` VALUES ('11040026', '175161', null, null, 'news', '2016-11-18 14:58:38', '0Ey4VdqC', '1', '0Ey4VdwgbU', '对于刘亦菲大家都不陌生，提到刘亦菲大家都会说我的神仙姐姐。给人留下的印象仙气足足的，不知道为何如今身材走样了，和之前有很大的区别，我们先来看一组先前的照片。', '昔日的窈窕淑女神仙姐姐刘亦菲，如今发福双下巴显露', 'http://www.yidianzixun.com/mp/content?id=11040026');
INSERT INTO `tb_details` VALUES ('11048351', '175161', null, null, 'news', '2016-11-18 15:26:38', '0EyOZhnF', '1', '0EyOZhe4jR', '林丹曾说过17岁的时候就开始迷恋谢杏芳，就在谢杏芳为她 生下孩子的时候，爆料他出轨了，并且出轨的还不止一人，让大家有何感想啊，一个忍受怀孕带来的各种不适的时候，自己的老公确和别人好上了，并且还不止一人，谢杏芳能真的原谅林丹吗？', '林丹出轨的还不止一人，让人还敢相信爱情吗', 'http://www.yidianzixun.com/mp/content?id=11048351');
INSERT INTO `tb_details` VALUES ('11069041', '175161', null, null, 'news', '2016-11-18 15:54:38', '0EyVvXcw', '1', '0EyVvXAvhY', '大家都知道，王宝强自从和马蓉离婚案开始，就很少更新微博了，上次更新微博时间还是上个月开庭的时候，昨天突然更新了一篇文章还是转载的赵薇工作室的，大家都知道这几天网上都在流传的赵薇事件，王宝强作为朋友就支持她，结果引来了骂声一片。', '王宝强因微博支持赵薇，引来骂声一片', 'http://www.yidianzixun.com/mp/content?id=11069041');
INSERT INTO `tb_details` VALUES ('11069659', '175161', null, null, 'news', '2016-11-18 16:22:38', '0EyWGLXA', '3', '0EyWGLJl5a', '大家都知道刘诗诗是一位集美貌，气质，才华于一体的大美人，从演步步惊云开始，真是粉丝一波接着一波，人气暴涨啊，紧接着电视剧一部部的出演，她和吴奇隆四爷的爱情故事也是演绎的美轮美奂哦。', '刘诗诗童年照曝光，真的好美', 'http://www.yidianzixun.com/mp/content?id=11069659');
INSERT INTO `tb_details` VALUES ('11253679', '175161', null, null, 'news', '2016-11-21 14:58:38', '0EzSMGKi', '1', '0EzSMGlo80', '看到葛天甜美的笑容真替她开心，不管生活怎么对你，只要自己做自己就可以了，大家都知道他和刘翔的那段婚姻，婚都离了，大家各自安好，便是晴天是吧，但是并没有因为他们的离婚，而结束他们之间的纠缠，真的不明白为什么，但是葛天也很快走出了那段辛酸的婚姻。就前短时间，刘翔的', '葛天经过与吴莎的互撕风波之后，笑容满面的出席活动', 'http://www.yidianzixun.com/mp/content?id=11253679');
INSERT INTO `tb_details` VALUES ('11254221', '175161', null, null, 'news', '2016-11-21 15:26:38', '0Ezbcpqo', '1', '0EzbcpnCEi', '大家都知道，林志玲本身身材就好，又性感，加上她那甜甜的声音，让人听了都软化了，虽然小编是女生听了她的声音都受不了，刚何况哪些花痴的男人们那，估计看了志玲姐姐的透视装，更是受不了了。', '林志玲穿透视装出席活动简直美翻了', 'http://www.yidianzixun.com/mp/content?id=11254221');
INSERT INTO `tb_details` VALUES ('11266282', '175161', null, null, 'news', '2016-11-21 15:54:38', '0EzZatJQ', '1', '0EzZat4aQB', 'Baby和小明同学的结合是娱乐圈的佳话，俊男靓女啊，小明同学对baby真是疼爱又加啊，特别是老婆怀孕后，小明同学好老公形象报道不断啊，这就是幸福，幸福就是找到那个对的人过一辈子。', 'Baby怀孕后身材发福了，虽胖但很美丽', 'http://www.yidianzixun.com/mp/content?id=11266282');
INSERT INTO `tb_details` VALUES ('11269810', '175161', null, null, 'news', '2016-11-21 16:22:38', '0Ezd0Rg9', '1', '0Ezd0R1qqu', '杨紫是从家有儿女我们熟知的，一个可爱聪明的小女孩子，如今已经出落成一个标志的大美女，最近两年也演了很多大片，像大秧歌还有欢乐颂，备受观众喜爱，但是所谓人红是非多，近期有很多人在网络上炮轰杨紫，之前杨紫都沉默忍受了，人的忍耐也是有限的，一直的攻击，什么人都受不了', '杨紫终于忍受不了网络暴力，对此作出回应', 'http://www.yidianzixun.com/mp/content?id=11269810');
INSERT INTO `tb_details` VALUES ('11344500', '175161', null, null, 'news', '2016-11-22 14:30:38', '0F0UgVEa', '1', '0F0UgVtq5i', '近些年来，很多中国影迷对韩国的明星追崇热涨不断，很多人就连服饰发型都搞成韩星的，追逐的有的失去自我，所以韩国人就很猖狂在中国，他们在自己的国家根本就赚不到这么多，他们很多人来到中国就是为了大把大把的老金，等老满了再回国，这值得我们国人深思，我们的钱为什么非要让', '国家正式实施限韩令，韩星损失严重', 'http://www.yidianzixun.com/mp/content?id=11344500');
INSERT INTO `tb_details` VALUES ('11344871', '175161', null, null, 'news', '2016-11-22 14:58:38', '0F05oCy9', '1', '0F05oC0AQ6', '姚晨微博晒儿子和女儿照片，儿子小土豆睡在妹妹的床里，大家都知道姚晨和现任老公婚后生活幸福甜蜜啊，一儿一女，儿女双全，老公对她也是疼爱又加，真的替姚晨开心，祝福幸福的女人幸福久久。', '姚晨晒儿子女儿照片，幸福满满的', 'http://www.yidianzixun.com/mp/content?id=11344871');
INSERT INTO `tb_details` VALUES ('11350781', '175161', null, null, 'news', '2016-11-22 15:26:38', '0F0JTj74', '1', '0F0JTjD0SX', '看上图两个人还是很甜蜜幸福的，不是相爱的人也不会走到一起是吧，杨幂过生日刘恺威那是第一时间发送祝福和女儿小糯米，还有小糯米亲手制作的生日礼物。', '刘恺威和杨幂的婚姻真的亮红灯了吗？', 'http://www.yidianzixun.com/mp/content?id=11350781');
INSERT INTO `tb_details` VALUES ('11351178', '175161', null, null, 'news', '2016-11-22 15:54:38', '0F0KHbuR', '1', '0F0KHbJEgg', '很多人刚开始都不看好的人鱼夫妇张伦硕钟丽缇两个人已经结婚了，小编为这对新人开心，祝福他们幸福长长久久，早生贵子。他们一路走来经历了很多，但是都没有阻挡他们对爱的追求。', '人鱼夫妇张伦硕钟丽缇，幸福就是这么简单！', 'http://www.yidianzixun.com/mp/content?id=11351178');
INSERT INTO `tb_details` VALUES ('11366161', '175161', null, null, 'news', '2016-11-22 16:22:38', '0F0PuXdj', '1', '0F0PuXGg2E', '大家都知道前段时间王鸥刘恺威出轨门事件，可谓是满城风雨，热搜榜第一都超越了美国大选结果的候选。王鸥的人气也随之增加啊。所以很多综艺节目也开始邀请她参加,湖南卫视也不例外，邀请王鸥参加本期的快乐大本营，节目还没有播出，先发布了预告，被吃瓜群骂声一片，没有办法节目', '王鸥继 出轨门后登快乐大本营遭嫌弃', 'http://www.yidianzixun.com/mp/content?id=11366161');
INSERT INTO `tb_details` VALUES ('11381518', '175161', null, null, 'news', '2016-11-23 14:30:38', '0F0jPN1W', '1', '0F0jPNLW4W', '向佐发布了一条微博加盟爸爸去哪4.担任李亦航的新爸爸，李亦航真的好幸福啊，整个爸爸去哪这季有两个爸爸，真是的各幸福的孩子啊，向佐发布微博之后，爸爸去哪节目组也发布了相关的消息，看来下期的精彩看点不断啊，有新鲜血液注入了。', '爸爸去哪4有爆料新消息，向佐担任李亦航的新爸爸', 'http://www.yidianzixun.com/mp/content?id=11381518');
INSERT INTO `tb_details` VALUES ('11426850', '175161', null, null, 'news', '2016-11-23 14:58:38', '0F0xSIZO', '1', '0F0xSIODsR', '最近限韩令的推出，很多韩国演员在中国的安排都发生了变化，很多电视剧都要叫停了，他们都要回到自己的国家，其实国家这样做是对的，因为近几年韩国明星在中国没有少捞钱，还有旅游韩国也没有少赚中国人的钱，但是他们不知道感恩中国，处处针对中国，所以国家这次也开始打压他们了', '限韩令对中国演员影响最大的张翰了，张翰要哭了', 'http://www.yidianzixun.com/mp/content?id=11426850');
INSERT INTO `tb_details` VALUES ('11437790', '175161', null, null, 'news', '2016-11-23 15:26:38', '0F0wYJoC', '1', '0F0wYJy6d8', '林丹出轨事件其实算已经尾声了，林丹也微博承认错误，回归家庭，林丹老婆谢杏芳也微博原谅了自己的老公，这件事就这样算结束了，也算可以了，但是林丹出轨对象小三赵雅琪又召开媒体见面会，挥泪讲述自己的事情，并且道歉，不知道赵雅琪怎么想的，林丹夫妇也只是微博发声明，你竟然', '林丹出轨事件告一段落，赵雅淇媒体道歉闹哪样？', 'http://www.yidianzixun.com/mp/content?id=11437790');
INSERT INTO `tb_details` VALUES ('11440176', '175161', null, null, 'news', '2016-11-23 15:54:38', '0F0xSocW', '1', '0F0xSo4Ky3', '最近一个微博名叫王美芯baby的微博，在微博上公然挑判古丽扎娜，并且言辞犀利，真是一波不平，又来一波，还爆料了一些古丽扎娜的不为人知的一面，这个王美芯baby到底是何人那，我们来看壹看。在微博的资料显示是草木山川文化传媒有限公司经纪人。我们来看她怎么挑判古丽扎', '古丽扎娜遭黑粉微博公然挑判', 'http://www.yidianzixun.com/mp/content?id=11440176');
INSERT INTO `tb_details` VALUES ('11449495', '175161', null, null, 'news', '2016-11-23 16:22:38', '0F13fOEv', '1', '0F13fOIZOs', '大家都知道佟大为，曾出演多部电视剧的男一号，与其搭档的也都是一线大腕级别的女明星，我们最早知道他的应该是奋斗，那角色演的真是够味。如今儿女双全，也可谓是完美人生。我们来看一下他们家豪宅吧。', '照片暴漏了佟大为的豪宅', 'http://www.yidianzixun.com/mp/content?id=11449495');
INSERT INTO `tb_details` VALUES ('11483922', '175161', null, null, 'news', '2016-11-24 15:26:38', '0F1UwNzL', '1', '0F1UwNKTr2', '大家看了这照片，是不是觉得邓超变化好大啊，不是一般的大，一个是体积丰满硕大，一个身材匀称精神焕发，一个穿着邋遢，一个穿着得体，同样的一个人，不同的两个情景图片，有着鲜明的对比。我们来看一下网友们怎么评论的，真是让吃瓜群又一次评论起来。', '孙俪娘娘微博晒邓超照片，引发网友一片喧哗', 'http://www.yidianzixun.com/mp/content?id=11483922');
INSERT INTO `tb_details` VALUES ('11497223', '175161', null, null, 'news', '2016-11-24 15:54:38', '0F1dXcLu', '1', '0F1dXcy0Ou', '有人在网上爆了一组照片，一个90后的妙龄美女在零下几度的大雪天，穿比基尼在楼顶上大跳钢管舞，虽然画面很美丽，让人也很羡慕美女的妙龄身材和美妙的舞姿，但是有点和当下的天气有点不符，让人捉摸不透，这是在炒作还是真的对舞蹈的热爱，如果是热爱可以家里跳啊，我们来看看美', '大雪天美女穿比基尼楼顶跳钢管舞，佩服！', 'http://www.yidianzixun.com/mp/content?id=11497223');
INSERT INTO `tb_details` VALUES ('11499798', '175161', null, null, 'news', '2016-11-24 16:22:38', '0F1dpBZR', '3', '0F1dpBV9jo', '情深深雨蒙蒙这部电视剧让我们80后一代如痴如迷啊，不仅对电视剧情节痴迷，而且对情深深雨蒙蒙里面的演员也是如痴如醉啊，大家都知道里面的演员几乎都是大家很喜爱的演员，几乎都是饰演小燕子电视剧里面的演员，林心如，苏有朋，赵薇，古巨基，都是大牌明星整容，这次依赵丽颖领', '情深深雨蒙蒙翻版据说赵丽颖饰演女一号', 'http://www.yidianzixun.com/mp/content?id=11499798');
INSERT INTO `tb_details` VALUES ('11571269', '175161', null, null, 'news', '2016-11-25 15:26:38', '0F27aUXZ', '1', '0F27aUX8GQ', '姚笛估计没有人不知道的，最初是因为她演的很多电视剧都很不错，让人喜爱，特别是和文章演的电视剧“裸婚时代”童佳倩这个角色，让她大红大紫了一把，我们简单介绍一下姚笛，姚笛，1982年3月17日出生于浙江省嘉兴市桐乡市、中国内地女演员、毕业于北京电影学院表演系、北京', '姚笛感恩节晒美照和鲜花，引来骂声一片', 'http://www.yidianzixun.com/mp/content?id=11571269');
INSERT INTO `tb_details` VALUES ('11587435', '175161', null, null, 'news', '2016-11-25 15:54:38', '0F2Hxf9O', '1', '0F2HxfsCNn', '昨天有人拍到舒淇在机场的照片，身穿宽松休闲服，脚踩平底鞋，一向摩登女郎的舒淇，之前没有见到过这么休闲的打扮，让人不得不猜疑是不是怀孕了。最让人不可思议的是还素颜。如果怀孕也很正常，年龄也不小了，并且也已经结婚了，只是这个消息还没有得到舒淇本人的证实，难道要学自', '舒淇穿着宽松，莫非是怀孕了？', 'http://www.yidianzixun.com/mp/content?id=11587435');
INSERT INTO `tb_details` VALUES ('11591688', '175161', null, null, 'news', '2016-11-25 16:22:38', '0F2Kd8It', '1', '0F2Kd8fZH6', '大家都知道赵丽颖已经是女总裁了，但是又爆出一个消息她和杨紫合伙开了一家烤鱼店。看来赵丽颖现在真的不不简单，麻雀变凤凰了，只要努力，总会变得美好，赵丽颖刚开始出道的时候因出身低，学历低，被人瞧不起，现在可谓是大红大紫，不仅有演员头脑也有经济头脑，在娱乐圈出了名的', '现在是合伙的年代，赵丽颖和杨紫合伙开店了', 'http://www.yidianzixun.com/mp/content?id=11591688');
INSERT INTO `tb_details` VALUES ('11695501', '175161', null, null, 'news', '2016-11-28 15:26:38', '0F3NzSYS', '1', '0F3NzS86Bs', '王大治这个人大家应该都知晓，虽然长相一般，但是魅力可不一般， 王大治，1977年1月31日出生于西安，演员、歌手。1995年参演了电影《太后吉祥》并由此进入演艺圈；大家应该知道钱今年董洁出轨门事件吧，事件的男主角就是王大治，大家也知道董洁因此事和老公潘粤明离婚', '为什么长相一般的王大治, 会如此吸引美女?', 'http://www.yidianzixun.com/mp/content?id=11695501');
INSERT INTO `tb_details` VALUES ('11695526', '175161', null, null, 'news', '2016-11-28 15:54:38', '0F3O15ga', '1', '0F3O15iQZU', '大家都知道金马奖是怎么回事吧，台湾电影金马奖是台湾地区主办的电影奖项，创办于1962年，当年主要是为了促进台湾地区电影制作事业和表扬对华语电影文化有杰出贡献的电影人前两天的金马奖晚会，11月26日的金马奖颁奖晚会众多明星所盼，大家都在猜测金马奖的得主，在还没有', '金马奖得主不是范冰冰而是后生两美女', 'http://www.yidianzixun.com/mp/content?id=11695526');
INSERT INTO `tb_details` VALUES ('11709874', '175161', null, null, 'news', '2016-11-28 16:22:38', '0F3ZXZev', '1', '0F3ZXZPBBf', '大家都知道陈坤，并且陈坤也是一个比较有实力的演员，多年一来一直都算混的还比较不错在娱乐圈，他的演技是值得肯定，但是大家也应该知道陈坤有个儿子，这是多年的事情了，陈坤儿子也算是个谜吧，所以引起了很多的猜想和悬念，大家也都知道陈坤本人并没有结婚，但是大家都猜陈坤儿', '陈坤儿子生母一直是个迷，黄毅清大爆料陈坤儿子生母', 'http://www.yidianzixun.com/mp/content?id=11709874');
INSERT INTO `tb_details` VALUES ('11716513', '111111', null, null, 'news', '2016-11-29 16:21:31', '0F3vrzBj', '1', '0F3vrzr0EZ', '近日，在倪叔所办公的写字楼的楼宇广告上，倪叔看到一则有些特殊的广告，广告的投放方是一家为境外游顾客，提供中文司机兼导游服务的专车平台：易途8。', '从易途8品牌TVC，剖析这匹境外游行业黑马', 'http://www.yidianzixun.com/mp/content?id=11716513');
INSERT INTO `tb_details` VALUES ('11771951', '175161', null, null, 'news', '2016-11-29 15:54:38', '0F4ncqiO', '1', '0F4ncqtYkh', '王鸥近期热搜不断，但是上热搜的她和别人不一样，先是和刘恺威的四小时，目前又因出席活动着装上热搜，引起了网友的骂声一片，可谓是一波不平又一波，本身可能也是因为她自己的原因，和刘恺威事情后，她不但不避嫌还频繁出席活动参加节目。我们来看一下网友对她这次着装的反映。', '王鸥银穿着暴露引网友热骂', 'http://www.yidianzixun.com/mp/content?id=11771951');
INSERT INTO `tb_details` VALUES ('11772079', '175161', null, null, 'news', '2016-11-29 16:22:38', '0F4MSdvK', '1', '0F4MSdeE4E', '大家都知道欢乐颂第一部拍的比较成功，收视率很不错啊，这部电视剧已播出效果非同凡响啊，大家都喜欢的不得了，特别是对五美女的人生引发了很多都市白领的共鸣，特别是我们生活在一线城市的打工族。这部电视剧特别贴近我们的生活和工作。从他们五个美女身上都能找到我们自己的影子', '《欢乐颂2》剧情会有什么样的大变化那?', 'http://www.yidianzixun.com/mp/content?id=11772079');
INSERT INTO `tb_details` VALUES ('11822715', '175161', null, null, 'news', '2016-11-30 15:54:38', '0F4y6lDV', '1', '0F4y6lqaxc', '大家都知道林心如是一位气质美丽漂亮的大美女，今年和霍建华结婚，让大家很意外也是满满的祝福，俊男靓女，让很多不相信爱情的大龄青年也相信爱情了，大家觉得爱情不分年龄和早晚只要遇到真爱就好，这也是娱乐圈的一大喜事，后来林心如也承认了自己的怀孕消息。', '林心如素颜孕照美丽大方幸福满满!', 'http://www.yidianzixun.com/mp/content?id=11822715');
INSERT INTO `tb_details` VALUES ('11822749', '175161', null, null, 'news', '2016-11-30 16:22:38', '0F4y9ILh', '1', '0F4y9I4tvB', '《奔跑吧兄弟》这个节目一直备受观众欢迎，一是因为节目不错，二也是演员实力表现佳，由于baba怀孕将退出跑男5的录制，安心做一个准妈咪。由于大家都跑男的期待，所以跑男5将注入新鲜血液，那回事baby的替代者那，众说纷纭，据说暂定了郑爽，郑爽今年的人气是比较旺啊，', '《奔跑吧兄弟》注入新鲜血液, 郑爽将替代baby参加', 'http://www.yidianzixun.com/mp/content?id=11822749');
INSERT INTO `tb_details` VALUES ('11879309', '175161', null, null, 'news', '2016-12-01 15:54:38', '0F5jMqn1', '1', '0F5jMqSoaJ', '大家都知道杜海涛和沈梦辰两个人的关系，虽然他们没有亲口承认，但是我们大家都知道两个人是情侣关系，两个人经常一起出行，并且表现亲密，沈梦辰之前是不被人知道的，自从和杜海涛搭上关系，人气一路飙升，现在也成了湖南卫视主持人的当红主持人，看来选对人和选择和谁在一起也很', '杜海涛和沈梦辰要奉子成婚了, 吴昕被推上了热点', 'http://www.yidianzixun.com/mp/content?id=11879309');
INSERT INTO `tb_details` VALUES ('11881234', '175161', null, null, 'news', '2016-12-01 16:22:38', '0F5jpjOB', '1', '0F5jpjScDi', '江一燕大美女温柔典雅的气质形象给人留下深刻的印象，看到她总有一种温暖的感觉，做人特别的小心谨慎，也特别有爱心，指教一做就是几年的时间，能把一件事情坚持做的人都是很不错的人，江一燕做到了，她很少出现在公众面前自从开始了指教生涯，今年和众多明星一起参加的我们来了这', '江一燕出席活动这裙子穿的又透又短啊', 'http://www.yidianzixun.com/mp/content?id=11881234');
INSERT INTO `tb_details` VALUES ('11952444', '175161', null, null, 'news', '2016-12-02 16:22:38', '0F6MRvWz', '1', '0F6MRvI59S', '王思聪京城四少之一，无人不知，一是有个有钱老爸王健林，有万达产业背景，而是王思聪本人口无遮拦，看不惯谁，就喷谁，整个娱乐圈没有被他喷过的明星极少数可以这么说，最近大家又发现他做了一件让人吃惊的事情那就是把当红韩国明星权志龙的奢饰品项链买来当狗圈。我们来看看是什', '王思聪把权志龙的奢饰品项链买来当狗圈', 'http://www.yidianzixun.com/mp/content?id=11952444');
INSERT INTO `tb_details` VALUES ('12262816', '111111', null, null, 'news', '2016-12-06 16:21:31', '0F8EKkon', '1', '0F8EKkhKlj', '在“2016杭州创业活动周”上，“众创十佳“评选结果最终揭晓，全球中文用车平台——易途8的创始人邓元法先生，荣获”十佳创业者“称号。据悉此次的2016杭州众创十佳由杭州市人力资源和社会保障局主办，经过微信公开投票和专家组评审组评分决定。', '易途8被评杭州“众创十佳”，并与春秋航空达成深度合作', 'http://www.yidianzixun.com/mp/content?id=12262816');
INSERT INTO `tb_details` VALUES ('12268649', '175161', null, null, 'news', '2016-12-06 16:22:38', '0F8JExgj', '1', '0F8JEx4CaZ', '大家都知道王宝强离婚的事情，估计全世界的人都知道这件事情，一个辛苦努力赚钱养家的男人，确娶了一个长相不错的老婆，但是老婆确无情的背叛了他和经纪人好上了，并且还卷走了王宝强不少钱，这件事情给王宝强的打击也是非常大的，自己辛苦努力换来的确实背叛，从那之后王宝强就很', '王宝强婚变后首次露出甜蜜的笑容', 'http://www.yidianzixun.com/mp/content?id=12268649');
INSERT INTO `tb_details` VALUES ('12339967', '175161', null, null, 'news', '2016-12-07 16:22:38', '0F8sQWkn', '1', '0F8sQW0tH0', '对于郑爽和古丽扎娜两个人大家熟悉的不能再熟悉了，这两年两个人热搜的次数也比较多，郑爽很多时候是因为自己的演技实力出众上的热搜榜，而古丽扎娜很多时候都是因为张翰这个人上的，郑爽和古丽扎娜一个是张翰的前任一个是现任，只要和张翰相关的话题，都会把两个人一起拉上。大家', '为什么喜欢郑爽的人比古丽扎娜的人多', 'http://www.yidianzixun.com/mp/content?id=12339967');
INSERT INTO `tb_details` VALUES ('12433762', '175161', null, null, 'news', '2016-12-08 16:22:38', '0F9YecX8', '1', '0F9YecWrd3', '最近网上流传了一张照片，是一位公交司机的照片，大家不由得引起了轰动，这个公交司机怎么是王思聪那，其实不是王思聪，像王思聪这样的富家子弟怎么会给大众当司机那，很多人都热议是不是王思聪失散多年的哥哥，开玩笑的怎么可能，如果王思聪真有个哥哥，他也不是现在这个样子，见', '公交司机和王思聪长的神似难道是王思聪长的太大众', 'http://www.yidianzixun.com/mp/content?id=12433762');
INSERT INTO `tb_details` VALUES ('12531306', '175161', null, null, 'news', '2016-12-10 14:58:38', '0FAJFU9U', '1', '0FAJFUhXs6', '佟丽娅大家都知晓，漂亮、气质、优雅，身材完美集一身的美女一个，大家都知道佟丽娅新疆姑娘，总是面带笑容，露出两个小虎牙，甜甜的，也出演了不少电视剧，最早看她的电视剧是古装戏，虽然她不是女一号，觉得她演的挺不错的，就非常喜欢她，到她演的北京爱情故事对她的喜欢更是加', '佟丽娅穿透视装更迷人漂亮', 'http://www.yidianzixun.com/mp/content?id=12531306');
INSERT INTO `tb_details` VALUES ('12531410', '175161', null, null, 'news', '2016-12-10 15:26:38', '0FAJDt5x', '1', '0FAJDtbC67', '范冰冰近些年来一直都比较火，大家也都知道的，人长的漂亮没有办法，在还珠格格里面当时还是给林心如当丫鬟那，现在的名气甚至超过林心如和赵薇，如今也找到自己的另一半，两人微博时不时的秀秀恩爱，经常撒狗粮，把单身汪虐的啊。虽然近40岁的范冰冰还是保持着20多岁少女的容', '范冰冰真得超爱自己的脸, 在路边都不忘记敷面膜', 'http://www.yidianzixun.com/mp/content?id=12531410');
INSERT INTO `tb_details` VALUES ('12531830', '175161', null, null, 'news', '2016-12-10 15:54:38', '0FAJIkrN', '1', '0FAJIkEsZW', '杨幂给小编的印象就是一个很拼的女人，虽然嫁给了刘恺威，但是依然很拼自己的事业，大家都以为杨幂嫁给了刘恺威会在家相夫教子，过着富太太的生活，其实我们看到不是这样的，杨幂嫁给了大十几岁自己的老公刘恺威，按理说刘恺威应该对杨幂疼爱有加，但是事实不是这样的，婚后两个人', '王鸥和杨幂相似点真多, 心疼杨幂', 'http://www.yidianzixun.com/mp/content?id=12531830');
INSERT INTO `tb_details` VALUES ('12532285', '175161', null, null, 'news', '2016-12-10 16:22:38', '0FAJdFMx', '1', '0FAJdFZKBv', '唐嫣这几天热搜是不断啊，唐嫣终于恋爱了，找到了那个正确的人，那就是罗晋，两人也公开承认恋情了，真的是为唐嫣开心，真心祝福她能收获自己的爱情，和罗晋一起幸福永远，罗晋也是很不错的一个人，两个人之前也一起演过几部电视剧，也演过情侣，大家都猜测两个是不是恋爱了，但是', '唐嫣为爱付出的经历让人心疼', 'http://www.yidianzixun.com/mp/content?id=12532285');
INSERT INTO `tb_details` VALUES ('12875190', '175161', null, null, 'news', '2016-12-14 15:54:38', '0FCpcQwz', '1', '0FCpcQrAYf', '刘诗诗一直都是一个零绯闻的女神，不仅人长的漂亮，并且气质也是非常的好，演的电视剧备受大家喜欢，不管什么角色她都能演的非常到位，这也是观众喜欢她的原因，虽然她现在和吴奇隆结婚了，也不减少男粉丝的喜欢。这就是刘诗诗的个人魅力所在。大家都见她出现活动穿的比较常见颜色', '刘诗诗穿绿裙真是美若天仙', 'http://www.yidianzixun.com/mp/content?id=12875190');
INSERT INTO `tb_details` VALUES ('12875251', '175161', null, null, 'news', '2016-12-14 16:22:38', '0FCpmBAa', '1', '0FCpmB7xTa', '大家都知道Selina和前夫张承中是大家比较看好的一对，在Selina受伤期间张承中一直陪伴左右，并没有嫌弃Selina大家都觉得张承中是一个不错的男人值得Selina托福终身的那个人，在Selina康复之后两个人走进了婚姻殿堂，大家都为Selina祝福，祝福', '终于知道Selina离婚的原因了, 原来张承中是这样一个人', 'http://www.yidianzixun.com/mp/content?id=12875251');
INSERT INTO `tb_details` VALUES ('13228900', '175161', null, null, 'news', '2016-12-20 16:22:38', '0FFuYUGd', '1', '0FFuYUZQZR', '大家都记得超级女声那个可爱圆脸的何洁，是多么纯真的一个女孩子，小编记得自己上高三那年何洁参加的超级女声选秀活动，和李宇春张靓颖都是一起的那季，虽然何洁长的不高，但是甜美的笑容总是让人喜欢，在不久的几年里事业还不错，在事业顶峰的事情，何洁宣布结婚了。但是很听奇怪', '何洁深夜发文回应离婚一事', 'http://www.yidianzixun.com/mp/content?id=13228900');
INSERT INTO `tb_details` VALUES ('13866708', '111111', null, null, 'news', '2016-12-28 16:21:31', '0FKVy4ma', '1', 'http://si1.go2yd.com/get-image/09hmKEwktRg', '在不到两年的时间里，易途8已经完成了4轮共计约2亿元的融资，并且正在筹划新一轮融资。而它的创始人邓元法却是个90后海归，还是个连续创业者。在易途8杭州总部的办公室里，邓元法跟记者分享了他的创业经历。', '93年创始人资本寒冬融资2亿, 如今身家数十亿!', 'http://www.yidianzixun.com/mp/content?id=13866708');
INSERT INTO `tb_details` VALUES ('14261397', '111111', null, null, 'news', '2017-01-04 16:21:31', '0FNJnvDG', '1', 'http://si1.go2yd.com/get-image/09rxCCnTTl2', '迪拜，在大多数国人心中已经成为一个名副其实的“土豪国”。这里拥有世界最高楼哈利法塔，世界最大喷泉Dubai Fountai，全球最大的购物中心-Dubaimall，更有5130元人民币冰淇淋，美貌的迪拜王子，遍地的豪车布满灰尘，连当地乞丐都能月入47万。然而褪', '新春去迪拜 | 看易途8美女体验师如何玩转土豪国', 'http://www.yidianzixun.com/mp/content?id=14261397');
INSERT INTO `tb_details` VALUES ('14568372', '111111', null, null, 'news', '2017-01-10 16:21:31', '0FQHmjyk', '1', 'http://si1.go2yd.com/get-image/0A1zAIrNNuy', '9日下午，据网友爆料，曾一度被称为好男人的陈思诚被曝出轨，深夜与两名女子共处一室，并一夜未出酒店。陈思成与佟丽娅定情于《北京爱情故事》，于2014年结婚，并于2016年生子。', '陈思诚被曝出轨，让佟丽娅哭瞎的竟然又是网红？', 'http://www.yidianzixun.com/mp/content?id=14568372');
INSERT INTO `tb_details` VALUES ('14735635', '111111', null, null, 'news', '2017-01-13 15:53:31', '0FRnzzTG', '1', 'http://si1.go2yd.com/get-image/0A6wLTMA8Yq', '黄金迪拜-包车畅浪梦幻岛，你出人我们出钱，年底把自己放出去一次！', '迪拜还能这么玩？！', 'http://www.yidianzixun.com/mp/content?id=14735635');
INSERT INTO `tb_details` VALUES ('14774333', '111111', null, null, 'news', '2017-01-13 16:21:31', '0FS4DSTw', '1', 'http://si1.go2yd.com/get-image/0A8D0aL4wwS', '因为父亲生意失败，邓元法过早地体会到了了世态炎凉，自打记事以后，就再也没有穿过新衣服，穿的永远都是亲戚家哥哥留下的旧衣服。亲戚中、学校里强烈的贫富差距对比一次次刺激着邓元法。', '邓元法：100美金闯美国，2年财富超10亿的90后传奇', 'http://www.yidianzixun.com/mp/content?id=14774333');
INSERT INTO `tb_details` VALUES ('15007443', '111111', null, null, 'news', '2017-01-17 14:57:31', '0FTcl42b', '1', 'http://si1.go2yd.com/get-image/0AEpchCfTXs', '因为父亲生意失败，邓元法过早地体会到了了世态炎凉，自打记事以后，就再也没有穿过新衣服，穿的永远都是亲戚家哥哥留下的旧衣服。亲戚中、学校里强烈的贫富差距对比一次次刺激着邓元法。', '93年农村大男孩，却已坐拥9套房产——邓元法', 'http://www.yidianzixun.com/mp/content?id=15007443');
INSERT INTO `tb_details` VALUES ('15011272', '111111', null, null, 'news', '2017-01-17 14:56:10', '0FTdyX3T', '1', 'http://si1.go2yd.com/get-image/0AEvMZtnvyC', '和马云在西湖边找老外学英语不同，这个90后大男孩竟然坐着公交跟老外学英语，在逐渐熟练英文之后，在美国必胜客，打败所有的竞争对手，成为必胜客的销售冠军，8小时内赚到357美金，创造的小费记录至今无人打破。', '效仿马云？90后邓元法坐公交学英语，竟成美国必胜客销售冠军', 'http://www.yidianzixun.com/mp/content?id=15011272');
INSERT INTO `tb_details` VALUES ('15011676', '111111', null, null, 'news', '2017-01-17 15:24:10', '0FTejGcO', '1', 'http://si1.go2yd.com/get-image/0AEw0y8w6CG', '经过测算，这个中国90后的财富增长率已经远远超过了比尔盖茨，他在2001——2016年里，财富增长率竟然达到了142857000%，从2001年的100美元，增长至2016年底的10亿元，增长率远远超越了比尔盖茨。', '秒杀比尔盖茨，邓元法这个中国90后的财富增长率惊呆众人', 'http://www.yidianzixun.com/mp/content?id=15011676');
INSERT INTO `tb_details` VALUES ('15014943', '111111', null, null, 'news', '2017-01-17 15:52:10', '0FTgIp2Q', '1', '0FTgIpQ4mD', '因为父亲生意失败，邓元法过早地体会到了了世态炎凉，自打记事以后，就再也没有穿过新衣服，穿的永远都是亲戚家哥哥留下的旧衣服。亲戚中、学校里强烈的贫富差距对比一次次刺激着邓元法。', '两年前的春节90后的邓元法流落美国街头，如今已身家10亿', 'http://www.yidianzixun.com/mp/content?id=15014943');
INSERT INTO `tb_details` VALUES ('15395690', '111111', null, null, 'news', '2017-01-23 15:52:10', '0FWLxmIw', '1', 'http://si1.go2yd.com/get-image/0AP4LmWjoci', '杭州的冬天阳光显得特别珍贵，一到这个时节我就想带上两个宝贝去泰国懒懒的晒个太阳。当然还有另外一个原因-----前两年在Anantara一时冲动买下的VIP度假产品。今年这是泰国度假第五年了，对于这个彩色的国度已经再熟悉不过，却没想到今年会那么与众不同，仿佛跌宕', '这个杭州美女去泰国游，竟然遇到了这种事……', 'http://www.yidianzixun.com/mp/content?id=15395690');
INSERT INTO `tb_details` VALUES ('16117363', '111111', null, null, 'news', '2017-02-08 15:52:10', '0FbKXZdt', '1', 'http://si1.go2yd.com/get-image/0ApbIbpZsSe', '他是一个被打上“90后”标签的创业者，2014年底他在美国创立的公司以2000万美金被并购，2015年1月回国创业，公司成立第二年销售额突破4亿，业务覆盖150多个国家、1500多个城市，全世界有20万人在他的平台上为他的客户提供服务，他就是易途吧CEO邓元法', '90后邓元法丨资本寒冬下创业2年销售额破4亿的终极秘密', 'http://www.yidianzixun.com/mp/content?id=16117363');
INSERT INTO `tb_details` VALUES ('16199995', '111111', null, null, 'news', '2017-02-10 15:24:10', '0FbouPYa', '1', 'http://si1.go2yd.com/get-image/0ArVcpbxCVs', '易途8作为全球中文专车的领军企业，不断拓展业务合作，发展至今已经与全球最大的在线旅游公司——Expedia、携程、阿里、途牛、去哪儿、蚂蜂窝等120家优质平台达成战略合作，签约旅行社上千家。B端获客是易途8一直以来的发展战略，也是易途8能够在在线旅游业强烈竞争', '易途8成为中国南方航空战略合作伙伴', 'http://www.yidianzixun.com/mp/content?id=16199995');
INSERT INTO `tb_details` VALUES ('16202566', '111111', null, null, 'news', '2017-02-10 15:52:10', '0Fbp9cnA', '1', 'http://si1.go2yd.com/get-image/0ArXwzYMzPk', '创投圈都把2016年称作资本寒冬，但是有一家创立于2015年的年轻企业，却在2016年完成了A+轮融资与B轮融资，在寒冬中傲雪凌霜，它就是易途8。记者向易途8创始人邓元法了解到，易途8主营目的地专车业务，涵盖接送机、包车游、点对点市内接送等项目。截至目前，其专', '易途8重点布局 境外玩乐与支付业务', 'http://www.yidianzixun.com/mp/content?id=16202566');
INSERT INTO `tb_details` VALUES ('16366114', '111111', null, null, 'news', '2017-02-13 15:52:10', '0Fd7ESVp', '1', 'http://si1.go2yd.com/get-image/0AwShtQoXjc', '2016年的末尾，无意间在朋友圈看到了易途8实现新年愿望出国过年的活动，毫不犹豫地报了名，没想到真的获得了实现愿望的旅游基金！作为易途8新晋小粉丝，马上定了泰国曼谷的接送机和包车。', '我在泰国“红灯区”经历的那些不可描述的', 'http://www.yidianzixun.com/mp/content?id=16366114');
INSERT INTO `tb_details` VALUES ('28584026', '111111', null, null, 'news', '2017-07-07 15:52:10', '0GmsUFnu', '1', 'http://si1.go2yd.com/get-image/0EnCd8S1swa', '携手汤包，开启7.6-7.9青海包车游直播大计，一探萌柴犬如何化身狼族！', '一路包车游青海！柴犬汤包的「西北狼」养成计划！', 'http://www.yidianzixun.com/mp/content?id=28584026');
INSERT INTO `tb_details` VALUES ('28657351', '175161', null, null, 'news', '2017-07-07 15:26:38', '0GnDHvKd', '1', 'http://si1.go2yd.com/get-image/0Eobd3jc8xM', '要和家人统一观念。有时准妈妈想请月嫂，但是家人可能观点不一，存在矛盾之处。月嫂选定后退单或者入户工作后遇到很多困难，得不偿失，所以，和家人观念统一很重要。3、要明确自己的要求。有的准妈妈比较随意，有的则很讲究，对所以首先可以和家政公司进行沟通，阐明要求，以便家', '上海雪绒花母婴护理：上海挑选月嫂主要考虑哪些因素？', 'http://www.yidianzixun.com/mp/content?id=28657351');
INSERT INTO `tb_details` VALUES ('28657901', '175161', null, null, 'news', '2017-07-07 15:54:38', '0GnGrd2k', '1', 'http://si1.go2yd.com/get-image/0EobwiQYYwS', '如今很多月嫂公司都打出了金牌月嫂或者高级月嫂招牌，而且这些月嫂价格各有不同，能差出几千元，这使很多消费者深感疑惑，到底星级月嫂和金牌月嫂有什么区别呢，选择的时候选择哪种类型月嫂比较好呢，下面我们来一起看看。', '上海雪绒花母婴护理中心：上海星级月嫂和金牌月嫂有什么区别', 'http://www.yidianzixun.com/mp/content?id=28657901');
INSERT INTO `tb_details` VALUES ('28658677', '175161', null, null, 'news', '2017-07-07 16:22:38', '0GnGttqi', '1', 'http://si1.go2yd.com/get-image/0EocOVwwAVc', '随着胎儿的不断增长，准妈妈的身体也不变样了，那么，为了能够顺利的生产，应该注意哪些事项呢，同时，孕晚期还会增加各种疾病的发生，正确冷静的应对尤为重要。', '上海雪绒花母婴护理中心：孕晚期疾病有哪些？注意事项有哪些？', 'http://www.yidianzixun.com/mp/content?id=28658677');
INSERT INTO `tb_details` VALUES ('30481959', '111111', null, null, 'news', '2017-07-29 15:52:10', '0GwQmZ4M', '1', 'http://si1.go2yd.com/get-image/0FNp7Bhhcwa', '指点江山，挥斥方遒，这是属于创业者的时代。提到创业，「资本」是个绕不过的话题。资本的助力，不仅可以让你避开生存危机，还能在竞争激烈的市场中快人一步。', '23岁实现4轮融资20亿估值？！ 这个90后凭什么屡获资本青睐？', 'http://www.yidianzixun.com/mp/content?id=30481959');

-- ----------------------------
-- Table structure for `tb_token`
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');