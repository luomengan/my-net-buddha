/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : lma-codegenerator1

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-12-29 16:35:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_data_column
-- ----------------------------
DROP TABLE IF EXISTS `t_data_column`;
CREATE TABLE `t_data_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `is_display_in_table` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `do_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqr3ldcdy6tye8ely3f6itd2mf` (`do_id`),
  CONSTRAINT `FKqr3ldcdy6tye8ely3f6itd2mf` FOREIGN KEY (`do_id`) REFERENCES `t_data_object` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data_column
-- ----------------------------
INSERT INTO `t_data_column` VALUES ('1', '姓名', '', 'name', '1', '1');
INSERT INTO `t_data_column` VALUES ('2', '用户名', '', 'username', '1', '1');
INSERT INTO `t_data_column` VALUES ('3', '密码', '\0', 'password', '1', '1');
INSERT INTO `t_data_column` VALUES ('4', '排序', '', 'sortNum', '2', '1');
INSERT INTO `t_data_column` VALUES ('5', '创建时间', '\0', 'createdTime', '6', '1');
INSERT INTO `t_data_column` VALUES ('6', '更新时间', '\0', 'updatedTime', '6', '1');
INSERT INTO `t_data_column` VALUES ('7', '是否启用', '', 'isEnable', '5', '1');
INSERT INTO `t_data_column` VALUES ('8', '名称', '', 'name', '1', '2');
INSERT INTO `t_data_column` VALUES ('9', '排序', '', 'sortNum', '2', '2');
INSERT INTO `t_data_column` VALUES ('10', '上级栏目', '\0', 'parent', '8', '2');
INSERT INTO `t_data_column` VALUES ('11', '姓名', '', 'name', '1', '5');
INSERT INTO `t_data_column` VALUES ('12', '手机号', '', 'phone', '1', '5');
INSERT INTO `t_data_column` VALUES ('13', '密码', '\0', 'password', '1', '5');
INSERT INTO `t_data_column` VALUES ('14', '性别', '', 'gender', '2', '5');
INSERT INTO `t_data_column` VALUES ('15', '生日', '', 'birthday', '1', '5');
INSERT INTO `t_data_column` VALUES ('16', '城市地址', '', 'address', '1', '5');
INSERT INTO `t_data_column` VALUES ('17', '注册时间', '', 'creatTime', '6', '5');
INSERT INTO `t_data_column` VALUES ('18', '标题', '', 'title', '1', '6');
INSERT INTO `t_data_column` VALUES ('19', '类型', '', 'type', '2', '6');
INSERT INTO `t_data_column` VALUES ('20', '图片链接', '\0', 'link', '1', '6');
INSERT INTO `t_data_column` VALUES ('21', '内容链接', '', 'contentLink', '1', '6');
INSERT INTO `t_data_column` VALUES ('22', '排序', '', 'sortNum', '2', '6');
INSERT INTO `t_data_column` VALUES ('23', '名称', '', 'name', '1', '7');
INSERT INTO `t_data_column` VALUES ('24', '描述', '', 'txtDescription', '1', '7');
INSERT INTO `t_data_column` VALUES ('25', '层级', '', 'level', '2', '7');
INSERT INTO `t_data_column` VALUES ('26', '是否推荐', '', 'isRecommend', '5', '7');
INSERT INTO `t_data_column` VALUES ('27', '排序', '', 'sortNum', '2', '7');
INSERT INTO `t_data_column` VALUES ('28', '父级类别id', '\0', 'parentId', '2', '7');
INSERT INTO `t_data_column` VALUES ('29', '父级类别名称', '', 'parentName', '1', '7');
INSERT INTO `t_data_column` VALUES ('30', '歌名', '', 'name', '1', '8');
INSERT INTO `t_data_column` VALUES ('31', '作者', '', 'author', '1', '8');
INSERT INTO `t_data_column` VALUES ('32', '资源链接', '', 'link', '1', '8');
INSERT INTO `t_data_column` VALUES ('33', '是否推荐', '', 'isRecommend', '5', '8');
INSERT INTO `t_data_column` VALUES ('34', '排序', '', 'sortNum', '2', '8');
INSERT INTO `t_data_column` VALUES ('35', '类别id', '\0', 'categoryId', '2', '8');
INSERT INTO `t_data_column` VALUES ('36', '签诗', '', 'poem', '1', '10');
INSERT INTO `t_data_column` VALUES ('37', '解签', '', 'solution', '1', '10');
INSERT INTO `t_data_column` VALUES ('38', '类型', '', 'type', '2', '10');
INSERT INTO `t_data_column` VALUES ('39', '引用', '', 'reference', '1', '10');
INSERT INTO `t_data_column` VALUES ('40', '概述', '', 'summarize', '1', '10');
INSERT INTO `t_data_column` VALUES ('41', '签语', '', 'sketch', '1', '10');
INSERT INTO `t_data_column` VALUES ('42', '解签消耗的功德', '', 'meritValue', '2', '10');
INSERT INTO `t_data_column` VALUES ('43', '佛名称', '', 'buddhaName', '1', '11');
INSERT INTO `t_data_column` VALUES ('44', '图片链接', '\0', 'link', '1', '11');
INSERT INTO `t_data_column` VALUES ('45', '佛介绍', '', 'introduction', '1', '11');
INSERT INTO `t_data_column` VALUES ('46', '标题', '', 'title', '1', '12');
INSERT INTO `t_data_column` VALUES ('47', '摘要', '', 'summary', '1', '12');
INSERT INTO `t_data_column` VALUES ('48', '类型', '', 'type', '2', '12');
INSERT INTO `t_data_column` VALUES ('49', '缩略图链接', '\0', 'link', '1', '12');
INSERT INTO `t_data_column` VALUES ('50', '内容', '', 'context', '1', '12');
INSERT INTO `t_data_column` VALUES ('51', '创建时间', '', 'createTime', '6', '12');
INSERT INTO `t_data_column` VALUES ('52', '排序', '', 'sortNum', '2', '12');
INSERT INTO `t_data_column` VALUES ('53', '供品名称', '', 'designation', '1', '13');
INSERT INTO `t_data_column` VALUES ('54', '供品类型', '', 'type', '2', '13');
INSERT INTO `t_data_column` VALUES ('55', '需消耗功德数', '', 'meritValue', '2', '13');
INSERT INTO `t_data_column` VALUES ('56', '供品寓意', '', 'paraphrase', '1', '13');
INSERT INTO `t_data_column` VALUES ('57', '图片链接', '\0', 'link', '1', '13');
INSERT INTO `t_data_column` VALUES ('58', '小图链接', '\0', 'smallLink', '1', '13');
INSERT INTO `t_data_column` VALUES ('59', '符文名称', '', 'symbol', '1', '14');
INSERT INTO `t_data_column` VALUES ('60', '功效', '', 'effect', '1', '14');
INSERT INTO `t_data_column` VALUES ('61', '适用', '', 'apply', '1', '14');
INSERT INTO `t_data_column` VALUES ('62', '图片链接', '\0', 'link', '1', '14');
INSERT INTO `t_data_column` VALUES ('63', '需消耗功德数', '', 'meritValue', '2', '14');
INSERT INTO `t_data_column` VALUES ('64', '标题', '', 'title', '1', '15');
INSERT INTO `t_data_column` VALUES ('65', '摘要', '', 'summary', '1', '15');
INSERT INTO `t_data_column` VALUES ('66', '图片链接', '', 'link', '1', '15');
INSERT INTO `t_data_column` VALUES ('67', '经书内容链接', '', 'contentLink', '1', '15');
INSERT INTO `t_data_column` VALUES ('68', '采集的数据源链接', '', 'collectSourceLink', '1', '15');
INSERT INTO `t_data_column` VALUES ('69', '是否可用', '', 'isEnable', '5', '15');
INSERT INTO `t_data_column` VALUES ('70', '敏感词', '', 'word', '1', '22');
INSERT INTO `t_data_column` VALUES ('71', '是否启用', '', 'isEnable', '5', '22');
INSERT INTO `t_data_column` VALUES ('72', '名称', '', 'name', '1', '23');
INSERT INTO `t_data_column` VALUES ('73', '图片链接', '', 'link', '1', '23');
INSERT INTO `t_data_column` VALUES ('74', '消耗功德值', '', 'meritValue', '2', '23');
INSERT INTO `t_data_column` VALUES ('75', '素材名称', '', 'name', '1', '27');
INSERT INTO `t_data_column` VALUES ('76', '素材链接', '', 'link', '1', '27');
INSERT INTO `t_data_column` VALUES ('77', '素材缩略图链接', '', 'smallLink', '1', '27');
INSERT INTO `t_data_column` VALUES ('78', '素材类型', '', 'type', '2', '27');
INSERT INTO `t_data_column` VALUES ('79', '标题', '', 'title', '1', '24');
INSERT INTO `t_data_column` VALUES ('80', '主题详情', '', 'topicDetail', '1', '24');
INSERT INTO `t_data_column` VALUES ('81', '图片链接', '', 'link', '1', '24');
INSERT INTO `t_data_column` VALUES ('82', '缩略图链接', '', 'smallLink', '1', '24');
INSERT INTO `t_data_column` VALUES ('83', '开始时间', '', 'startTime', '6', '24');
INSERT INTO `t_data_column` VALUES ('84', '结束时间', '', 'endTime', '6', '24');
INSERT INTO `t_data_column` VALUES ('85', '主题时间', '', 'topicTime', '6', '24');
INSERT INTO `t_data_column` VALUES ('86', '状态', '', 'status', '2', '24');
INSERT INTO `t_data_column` VALUES ('87', '是否启用', '', 'isEnable', '5', '24');
INSERT INTO `t_data_column` VALUES ('88', '用户id', '', 'userId', '2', '31');
INSERT INTO `t_data_column` VALUES ('89', '背景音乐对应的素材id', '', 'bgMusicMaterialResourceId', '2', '31');
INSERT INTO `t_data_column` VALUES ('90', '用户id', '', 'userId', '6', '32');
INSERT INTO `t_data_column` VALUES ('91', '禅修开始时间', '', 'startTime', '6', '32');
INSERT INTO `t_data_column` VALUES ('92', '禅修结束时间', '', 'endTime', '6', '32');
INSERT INTO `t_data_column` VALUES ('93', '采集关键字', '', 'keyword', '1', '33');
INSERT INTO `t_data_column` VALUES ('94', '采集时间', '', 'collectTime', '6', '33');
INSERT INTO `t_data_column` VALUES ('95', '采集站点', '', 'website', '1', '33');
INSERT INTO `t_data_column` VALUES ('96', '采集数据条数', '', 'dataCount', '5', '33');
INSERT INTO `t_data_column` VALUES ('97', '采集结果下载地址', '', 'downloadUrl', '1', '33');
INSERT INTO `t_data_column` VALUES ('98', '采集城市', '', 'city', '1', '33');
INSERT INTO `t_data_column` VALUES ('99', '姓名', '', 'name', '1', '34');
INSERT INTO `t_data_column` VALUES ('100', '分组', '', 'groupIndex', '2', '34');
INSERT INTO `t_data_column` VALUES ('101', '名称', '', 'name', '1', '36');
INSERT INTO `t_data_column` VALUES ('102', '作者', '', 'author', '1', '36');
INSERT INTO `t_data_column` VALUES ('103', '资源链接', '', 'link', '1', '36');
INSERT INTO `t_data_column` VALUES ('104', '是否首页顶部推荐', '', 'isHomeTop', '5', '36');
INSERT INTO `t_data_column` VALUES ('105', '首页顶部推荐排序', '', 'homeTopSortNum', '2', '36');
INSERT INTO `t_data_column` VALUES ('106', '是否推荐', '', 'isRecommend', '5', '36');
INSERT INTO `t_data_column` VALUES ('107', '排序', '', 'sortNum', '2', '36');
INSERT INTO `t_data_column` VALUES ('108', '所属类别', '', 'categoryId', '2', '36');
INSERT INTO `t_data_column` VALUES ('109', '播放次数', '', 'playTimes', '2', '36');
INSERT INTO `t_data_column` VALUES ('110', '音乐时长', '', 'duration', '2', '36');
INSERT INTO `t_data_column` VALUES ('111', '名称', '', 'name', '1', '35');
INSERT INTO `t_data_column` VALUES ('112', '作者', '', 'author', '1', '35');
INSERT INTO `t_data_column` VALUES ('113', '描述', '', 'txtDescription', '1', '35');
INSERT INTO `t_data_column` VALUES ('114', '层级', '', 'level', '2', '35');
INSERT INTO `t_data_column` VALUES ('115', '是否首页顶部推荐', '', 'isHomeTop', '5', '35');
INSERT INTO `t_data_column` VALUES ('116', '首页顶部推荐排序', '', 'homeTopSortNum', '2', '35');
INSERT INTO `t_data_column` VALUES ('117', '是否推荐', '', 'isRecommend', '5', '35');
INSERT INTO `t_data_column` VALUES ('118', '排序', '', 'sortNum', '2', '35');
INSERT INTO `t_data_column` VALUES ('119', '父级类别', '', 'parentId', '2', '35');
INSERT INTO `t_data_column` VALUES ('121', '播放次数', '', 'playTimes', '2', '35');
INSERT INTO `t_data_column` VALUES ('122', '项目名称', '', 'name', '1', '37');
INSERT INTO `t_data_column` VALUES ('123', '项目主包', '', 'basePackage', '1', '37');
INSERT INTO `t_data_column` VALUES ('124', '项目描述', '', 'description', '1', '37');
INSERT INTO `t_data_column` VALUES ('125', 'mavenGroupId', '', 'mavenGroupId', '1', '37');
INSERT INTO `t_data_column` VALUES ('126', 'mavenArtifactId', '', 'mavenArtifactId', '1', '37');
INSERT INTO `t_data_column` VALUES ('127', 'mavenVersion', '', 'mavenVersion', '1', '37');
INSERT INTO `t_data_column` VALUES ('128', '后台管理界面标题', '', 'adminWebTitle', '1', '37');
INSERT INTO `t_data_column` VALUES ('129', '后台管理界面网页描述Meta信息', '', 'adminWebMetaDescription', '1', '37');
INSERT INTO `t_data_column` VALUES ('130', '名称', '', 'name', '1', '38');
INSERT INTO `t_data_column` VALUES ('131', '描述', '', 'description', '1', '38');
INSERT INTO `t_data_column` VALUES ('132', '数据管理类型', '', 'manageType', '2', '38');
INSERT INTO `t_data_column` VALUES ('133', '数据管理图标', '', 'manageIcon', '1', '38');
INSERT INTO `t_data_column` VALUES ('134', '对应的项目ID', '', 'projectId', '2', '38');
INSERT INTO `t_data_column` VALUES ('136', '名称', '', 'name', '1', '39');
INSERT INTO `t_data_column` VALUES ('137', '类型', '', 'type', '2', '39');
INSERT INTO `t_data_column` VALUES ('138', '描述', '', 'description', '1', '39');
INSERT INTO `t_data_column` VALUES ('139', '是否在管理表格中显示', '', 'isDisplayInTable', '5', '39');
INSERT INTO `t_data_column` VALUES ('140', '对应的数据对象ID', '', 'dataObjectId', '2', '39');
INSERT INTO `t_data_column` VALUES ('141', '这是测试数据列', '', 'testDataColumn', '1', '40');
INSERT INTO `t_data_column` VALUES ('142', '这是测试数据列2', '', 'testDataColumn2', '1', '40');
INSERT INTO `t_data_column` VALUES ('143', '姓名', '', 'name', '1', '41');
INSERT INTO `t_data_column` VALUES ('144', '手机号码', '', 'phone', '1', '41');
INSERT INTO `t_data_column` VALUES ('145', '密码', '', 'password', '1', '41');
INSERT INTO `t_data_column` VALUES ('146', '性别', '', 'gender', '2', '41');
INSERT INTO `t_data_column` VALUES ('147', '生日', '', 'birthday', '1', '41');
INSERT INTO `t_data_column` VALUES ('148', '头像', '', 'headPortraitLink', '1', '41');
INSERT INTO `t_data_column` VALUES ('149', '地区', '', 'region', '1', '41');
INSERT INTO `t_data_column` VALUES ('150', '创建时间', '', 'createTime', '6', '41');
INSERT INTO `t_data_column` VALUES ('151', '更新时间', '', 'updateTime', '6', '41');
INSERT INTO `t_data_column` VALUES ('152', '是否测试用户', '', 'isTest', '5', '41');
INSERT INTO `t_data_column` VALUES ('153', '是否匿名用户', '', 'isAnonymous', '5', '41');
INSERT INTO `t_data_column` VALUES ('154', '用户ID', '', 'userId', '2', '42');
INSERT INTO `t_data_column` VALUES ('155', '收藏资源ID', '', 'resourceId', '2', '42');
INSERT INTO `t_data_column` VALUES ('156', '收藏类型', '', 'favouriteType', '2', '42');
INSERT INTO `t_data_column` VALUES ('157', '收藏时间', '', 'favouriteTime', '6', '42');
INSERT INTO `t_data_column` VALUES ('158', '用户ID', '', 'userId', '2', '43');
INSERT INTO `t_data_column` VALUES ('159', '收藏资源ID', '', 'resourceId', '2', '43');
INSERT INTO `t_data_column` VALUES ('160', '评分类型', '', 'ratingType', '2', '43');
INSERT INTO `t_data_column` VALUES ('161', '评分时间', '', 'ratingTime', '6', '43');
INSERT INTO `t_data_column` VALUES ('162', '评分', '', 'rating', '4', '43');
INSERT INTO `t_data_column` VALUES ('163', '姓名', '', 'name', '1', '44');
INSERT INTO `t_data_column` VALUES ('164', '用户名', '', 'username', '1', '44');
INSERT INTO `t_data_column` VALUES ('165', '密码', '', 'password', '1', '44');
INSERT INTO `t_data_column` VALUES ('166', '用户ID', '', 'userId', '2', '45');
INSERT INTO `t_data_column` VALUES ('167', '功德数', '', 'meritValue', '2', '45');
INSERT INTO `t_data_column` VALUES ('168', '更新时间', '', 'updateTime', '6', '45');
INSERT INTO `t_data_column` VALUES ('169', '流水号', '', 'flowNo', '1', '46');
INSERT INTO `t_data_column` VALUES ('170', '流水类型', '', 'flowType', '2', '46');
INSERT INTO `t_data_column` VALUES ('171', '功德数', '', 'meritValue', '2', '46');
INSERT INTO `t_data_column` VALUES ('172', '创建时间', '', 'createTime', '6', '46');
INSERT INTO `t_data_column` VALUES ('173', '标题', '', 'title', '1', '3');
INSERT INTO `t_data_column` VALUES ('174', '内容', '', 'content', '1', '3');
INSERT INTO `t_data_column` VALUES ('175', '创建时间', '', 'createTime', '6', '3');
INSERT INTO `t_data_column` VALUES ('176', '更新时间', '', 'updatedTime', '6', '3');
INSERT INTO `t_data_column` VALUES ('177', '所属栏目ID', '', 'channelId', '2', '3');
INSERT INTO `t_data_column` VALUES ('178', '是否启用', '', 'isEnable', '5', '3');
INSERT INTO `t_data_column` VALUES ('179', '层级', '', 'level', '2', '2');
INSERT INTO `t_data_column` VALUES ('180', '是否启用', '', 'isEnable', '5', '2');
INSERT INTO `t_data_column` VALUES ('181', '公历（格式为yyyyMMdd）', '', 'gregorianCalendar', '1', '47');
INSERT INTO `t_data_column` VALUES ('182', '农历', '', 'lunarCalendar', '1', '47');
INSERT INTO `t_data_column` VALUES ('183', '岁次', '', 'yearName', '1', '47');
INSERT INTO `t_data_column` VALUES ('184', '每日胎神占方', '', 'taishenSide', '1', '47');
INSERT INTO `t_data_column` VALUES ('185', '五行', '', 'fiveElements', '1', '47');
INSERT INTO `t_data_column` VALUES ('186', '冲', '', 'punching', '1', '47');
INSERT INTO `t_data_column` VALUES ('187', '彭祖百忌', '', 'pengzuBogey', '1', '47');
INSERT INTO `t_data_column` VALUES ('188', '吉神宜趋', '', 'jishenShouldTrend', '1', '47');
INSERT INTO `t_data_column` VALUES ('189', '凶神宜忌', '', 'xiongshenShouldBogey', '1', '47');
INSERT INTO `t_data_column` VALUES ('190', '宜', '', 'should', '1', '47');
INSERT INTO `t_data_column` VALUES ('191', '忌', '', 'bogey', '1', '47');
INSERT INTO `t_data_column` VALUES ('192', '佛历', '', 'buddhistCalendar', '1', '47');
INSERT INTO `t_data_column` VALUES ('193', '总览', '', 'overview', '1', '47');
INSERT INTO `t_data_column` VALUES ('194', '名称', '', 'name', '1', '48');
INSERT INTO `t_data_column` VALUES ('195', '图片链接', '', 'link', '1', '48');
INSERT INTO `t_data_column` VALUES ('196', '图片链接缩略图', '', 'smallLink', '1', '48');
INSERT INTO `t_data_column` VALUES ('197', '寓意', '', 'meaning', '1', '48');
INSERT INTO `t_data_column` VALUES ('198', '功效', '', 'effect', '1', '48');
INSERT INTO `t_data_column` VALUES ('199', '灯油描述', '', 'oilDesc', '1', '49');
INSERT INTO `t_data_column` VALUES ('200', '灯油可燃烧天数', '', 'flameDays', '2', '49');
INSERT INTO `t_data_column` VALUES ('201', '需消耗的功德数', '', 'meritValue', '2', '49');
INSERT INTO `t_data_column` VALUES ('202', '用户id', '', 'userId', '2', '50');
INSERT INTO `t_data_column` VALUES ('203', '签到时间', '', 'checkinTime', '6', '50');
INSERT INTO `t_data_column` VALUES ('204', '签到奖励的功德数', '', 'meritValue', '2', '50');
INSERT INTO `t_data_column` VALUES ('205', '名称', '', 'name', '1', '51');
INSERT INTO `t_data_column` VALUES ('206', '图片链接', '', 'link', '1', '51');
INSERT INTO `t_data_column` VALUES ('207', '消耗功德值', '', 'meritValue', '2', '51');
INSERT INTO `t_data_column` VALUES ('208', '是否可用', '', 'enable', '5', '51');
INSERT INTO `t_data_column` VALUES ('209', '排序', '', 'sortNum', '2', '51');
INSERT INTO `t_data_column` VALUES ('210', '签诗', '', 'poem', '1', '52');
INSERT INTO `t_data_column` VALUES ('211', '解签', '', 'solution', '1', '52');
INSERT INTO `t_data_column` VALUES ('212', '类型', '', 'type', '2', '52');
INSERT INTO `t_data_column` VALUES ('213', '引用', '', 'reference', '1', '52');
INSERT INTO `t_data_column` VALUES ('214', '概述', '', 'summarize', '1', '52');
INSERT INTO `t_data_column` VALUES ('215', '签语', '', 'sketch', '1', '52');
INSERT INTO `t_data_column` VALUES ('216', '解签消耗的功德', '', 'meritValue', '2', '52');
INSERT INTO `t_data_column` VALUES ('217', '名称', '', 'buddhaName', '1', '53');
INSERT INTO `t_data_column` VALUES ('218', '链接', '', 'link', '1', '53');
INSERT INTO `t_data_column` VALUES ('219', '描述', '', 'txtDescription', '1', '53');
INSERT INTO `t_data_column` VALUES ('220', '名称', '', 'name', '1', '54');
INSERT INTO `t_data_column` VALUES ('221', '类型', '', 'type', '2', '54');
INSERT INTO `t_data_column` VALUES ('222', '需消耗的功德', '', 'meritValue', '2', '54');
INSERT INTO `t_data_column` VALUES ('223', '寓意', '', 'meaning', '1', '54');
INSERT INTO `t_data_column` VALUES ('224', '供品图链接', '', 'link', '1', '54');
INSERT INTO `t_data_column` VALUES ('225', '供品小图链接', '', 'smallLink', '1', '54');
INSERT INTO `t_data_column` VALUES ('226', '名称', '', 'name', '1', '55');
INSERT INTO `t_data_column` VALUES ('227', '功效', '', 'effect', '1', '55');
INSERT INTO `t_data_column` VALUES ('228', '适用', '', 'apply', '1', '55');
INSERT INTO `t_data_column` VALUES ('229', '符图片链接', '', 'link', '1', '55');
INSERT INTO `t_data_column` VALUES ('230', '消耗功德数', '', 'meritValue', '2', '55');

-- ----------------------------
-- Table structure for t_data_object
-- ----------------------------
DROP TABLE IF EXISTS `t_data_object`;
CREATE TABLE `t_data_object` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `manage_icon` varchar(255) DEFAULT NULL,
  `manage_type` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkv1nxnxa4vac1vi7cp0al8uet` (`p_id`),
  CONSTRAINT `FKkv1nxnxa4vac1vi7cp0al8uet` FOREIGN KEY (`p_id`) REFERENCES `t_project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data_object
-- ----------------------------
INSERT INTO `t_data_object` VALUES ('1', '管理用户', 'glyphicon glyphicon-tag icon', '1', 'AdminUser', '1');
INSERT INTO `t_data_object` VALUES ('2', '栏目', 'glyphicon glyphicon-tag icon', '2', 'Channel', '1');
INSERT INTO `t_data_object` VALUES ('3', '文章', 'glyphicon glyphicon-tag icon', '3', 'Article', '1');
INSERT INTO `t_data_object` VALUES ('4', '统计', 'glyphicon glyphicon-tag icon', '1', 'Sta', '2');
INSERT INTO `t_data_object` VALUES ('5', '用户', 'icon-user', '1', 'User', '3');
INSERT INTO `t_data_object` VALUES ('6', '佛学banner图', 'icon-picture', '1', 'Banner', '3');
INSERT INTO `t_data_object` VALUES ('7', '佛音类别', 'icon-playlist icon', '1', 'BuddhistMusicCategory', '3');
INSERT INTO `t_data_object` VALUES ('8', '佛音', 'icon-music-tone-alt', '1', 'BuddhistMusic', '3');
INSERT INTO `t_data_object` VALUES ('10', '签', 'glyphicon glyphicon-tag icon', '1', 'Divination', '3');
INSERT INTO `t_data_object` VALUES ('11', '佛', 'fa fa-life-saver', '1', 'Joss', '3');
INSERT INTO `t_data_object` VALUES ('12', '佛学知识', 'icon-book-open', '1', 'Knowledge', '3');
INSERT INTO `t_data_object` VALUES ('13', '供品', 'fa fa-leaf', '1', 'Offerings', '3');
INSERT INTO `t_data_object` VALUES ('14', '符文', 'fa fa-pagelines', '1', 'Rune', '3');
INSERT INTO `t_data_object` VALUES ('15', '经书', 'icon-notebook', '1', 'Sutra', '3');
INSERT INTO `t_data_object` VALUES ('16', '用户设置', 'icon-notebook', '1', 'UserSetting', '3');
INSERT INTO `t_data_object` VALUES ('17', '用户绑定', 'icon-notebook', '1', 'UserBinding', '3');
INSERT INTO `t_data_object` VALUES ('18', '用户消息', 'icon-notebook', '1', 'UserMessage', '3');
INSERT INTO `t_data_object` VALUES ('19', '全局设置', 'icon-notebook', '1', 'GlobalSetting', '3');
INSERT INTO `t_data_object` VALUES ('20', '用户登录日志', 'icon-notebook', '1', 'UserLoginLog', '3');
INSERT INTO `t_data_object` VALUES ('21', '后台管理用户', 'icon-notebook', '1', 'AdminUser', '3');
INSERT INTO `t_data_object` VALUES ('22', '敏感词', 'icon-notebook', '1', 'SensitiveWord', '3');
INSERT INTO `t_data_object` VALUES ('23', '生灵', 'icon-notebook', '1', 'Creatures', '3');
INSERT INTO `t_data_object` VALUES ('24', '修行主题', 'icon-notebook', '1', 'BuddhistTopic', '3');
INSERT INTO `t_data_object` VALUES ('25', '用户点赞', 'icon-notebook', '1', 'UserLike', '3');
INSERT INTO `t_data_object` VALUES ('26', '用户评论', 'icon-notebook', '1', 'UserComment', '3');
INSERT INTO `t_data_object` VALUES ('27', '素材资源', 'icon-notebook', '1', 'MaterialResource', '3');
INSERT INTO `t_data_object` VALUES ('28', '祈福明灯', 'icon-notebook', '1', 'BlessingLamp', '3');
INSERT INTO `t_data_object` VALUES ('29', '灯油', 'icon-notebook', '1', 'BlessingLampOil', '3');
INSERT INTO `t_data_object` VALUES ('30', '用户点灯', 'icon-notebook', '1', 'UserLightLamp', '3');
INSERT INTO `t_data_object` VALUES ('31', '用户禅修设置', 'icon-notebook', '1', 'UserMeditationSetting', '3');
INSERT INTO `t_data_object` VALUES ('32', '用户禅修记录', 'icon-notebook', '1', 'UserMeditationRecord', '3');
INSERT INTO `t_data_object` VALUES ('33', '抓取记录', 'icon-notebook', '1', 'DataCollectRecord', '4');
INSERT INTO `t_data_object` VALUES ('34', '分组记录', 'icon-notebook', '1', 'GroupRecord', '5');
INSERT INTO `t_data_object` VALUES ('35', '佛音类别', 'icon-notebook', '1', 'MusicCategory', '6');
INSERT INTO `t_data_object` VALUES ('36', '佛音', 'icon-notebook', '1', 'Music', '6');
INSERT INTO `t_data_object` VALUES ('37', '项目', 'icon-notebook', '1', 'Project', '7');
INSERT INTO `t_data_object` VALUES ('38', '数据对象', 'icon-notebook', '1', 'DataObject', '7');
INSERT INTO `t_data_object` VALUES ('39', '数据列', 'icon-notebook', '1', 'DataColumn', '7');
INSERT INTO `t_data_object` VALUES ('40', '这是一个测试数据对象', 'icon-notebook', '1', 'TestDataObject', '8');
INSERT INTO `t_data_object` VALUES ('41', '终端用户', 'icon-notebook', '1', 'EndUser', '6');
INSERT INTO `t_data_object` VALUES ('42', '用户收藏', 'icon-notebook', '1', 'UserFavourite', '6');
INSERT INTO `t_data_object` VALUES ('43', '用户评分', 'icon-notebook', '1', 'UserRating', '6');
INSERT INTO `t_data_object` VALUES ('44', '管理用户', 'icon-notebook', '1', 'AdminUser', '6');
INSERT INTO `t_data_object` VALUES ('45', '用户功德钱包', 'icon-notebook', '1', 'UserMeritWallet', '6');
INSERT INTO `t_data_object` VALUES ('46', '用户功德流水', 'icon-notebook', '1', 'UserMeritFlow', '6');
INSERT INTO `t_data_object` VALUES ('47', '黄历+佛历', 'icon-notebook', '1', 'Almanac', '6');
INSERT INTO `t_data_object` VALUES ('48', '祈福明灯', 'icon-notebook', '1', 'BlessingLamp', '6');
INSERT INTO `t_data_object` VALUES ('49', '灯油', 'icon-notebook', '1', 'BlessingLampOil', '6');
INSERT INTO `t_data_object` VALUES ('50', '签到', 'icon-notebook', '1', 'Checkin', '6');
INSERT INTO `t_data_object` VALUES ('51', '生灵', 'icon-notebook', '1', 'Creature', '6');
INSERT INTO `t_data_object` VALUES ('52', '灵签', 'icon-notebook', '1', 'Divination', '6');
INSERT INTO `t_data_object` VALUES ('53', '佛像', 'icon-notebook', '1', 'Joss', '6');
INSERT INTO `t_data_object` VALUES ('54', '供品', 'icon-notebook', '1', 'Offering', '6');
INSERT INTO `t_data_object` VALUES ('55', '符文', 'icon-notebook', '1', 'Rune', '6');

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_web_meta_description` varchar(255) DEFAULT NULL,
  `admin_web_title` varchar(255) DEFAULT NULL,
  `base_package` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `maven_artifact_id` varchar(255) DEFAULT NULL,
  `maven_group_id` varchar(255) DEFAULT NULL,
  `maven_version` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES ('1', '罗梦安, 学习空间, 罗梦安的个人学习空间, 后台, 后台管理, 后台系统', '罗梦安的个人学习空间 | 后台管理', 'com.luomengan', '罗梦安的个人学习空间', 'lma-admin', 'com.luomengan', '0.0.1-SNAPSHOT', 'lma-admin');
INSERT INTO `t_project` VALUES ('2', '吉万财富维权信息统计', '吉万财富维权信息统计', 'com.luomengan', '吉万财富维权信息统计', 'sta', 'com.luomengan', '0.0.1-SNAPSHOT', 'sta');
INSERT INTO `t_project` VALUES ('3', '华人佛教后台管理系统', '华人佛教后台管理系统', 'com.wangbei', '华人佛教后台管理系统', 'lma-buddha', 'com.wangbei', '0.0.1-SNAPSHOT', 'lma-buddha');
INSERT INTO `t_project` VALUES ('4', '数据抓取', '数据抓取', 'com.luomengan', '数据抓取', 'lma-datacollect', 'com.luomengan', '0.0.1-SNAPSHOT', 'lma-datacollect');
INSERT INTO `t_project` VALUES ('5', '翰宇摇一摇分组', '翰宇摇一摇分组', 'com.luomengan', '翰宇摇一摇分组', 'hybio', 'com.luomengan', '0.0.1-SNAPSHOT', 'hybio');
INSERT INTO `t_project` VALUES ('6', '网佛寺，一花一世界一叶一菩提', '网佛寺，一花一世界一叶一菩提', 'com.luomengan', '网佛寺', 'net-buddha', 'com.luomengan', '0.0.1-SNAPSHOT', 'net-buddha');
INSERT INTO `t_project` VALUES ('7', '代码生成器', '代码生成器', 'com.luomengan', '代码生成器', 'code-generator1', 'com.luomengan', '0.0.1-SNAPSHOT', 'code-generator1');
INSERT INTO `t_project` VALUES ('8', '这是一个测试项目', '这是一个测试项目', 'com.luomengan', '这是一个测试项目', 'test-project', 'com.luomengan', '0.0.1-SNAPSHOT', 'test-project');
