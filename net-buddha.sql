/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : net-buddha

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-12-29 16:36:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_user`;
CREATE TABLE `t_admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_end_user
-- ----------------------------
DROP TABLE IF EXISTS `t_end_user`;
CREATE TABLE `t_end_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `head_portrait_link` varchar(255) DEFAULT NULL,
  `is_anonymous` bit(1) DEFAULT NULL,
  `is_test` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_end_user
-- ----------------------------
INSERT INTO `t_end_user` VALUES ('1', null, '2017-10-20 14:40:10', '1', 'http://10.0.0.99:9090/net-buddha/headPortrait/1509004341972.png', null, null, '罗梦安', '123456', '13928952254', null, null, '\0');
INSERT INTO `t_end_user` VALUES ('2', null, '2017-10-20 14:40:40', '1', null, null, null, '张三', '123456', '12345678911', null, null, '\0');
INSERT INTO `t_end_user` VALUES ('3', null, '2017-10-20 14:40:45', '2', null, null, null, '王五', '123456', '12345678922', null, null, '');
INSERT INTO `t_end_user` VALUES ('4', null, '2017-10-25 11:20:11', '2', null, null, null, '娜美', '123456', '12345678933', null, null, '');
INSERT INTO `t_end_user` VALUES ('5', null, null, '1', null, null, null, null, '123456', '12345678944', null, null, null);

-- ----------------------------
-- Table structure for t_music
-- ----------------------------
DROP TABLE IF EXISTS `t_music`;
CREATE TABLE `t_music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `home_top_sort_num` int(11) DEFAULT NULL,
  `is_home_top` bit(1) DEFAULT NULL,
  `is_recommend` bit(1) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `play_times` int(11) DEFAULT NULL,
  `sort_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_music
-- ----------------------------

-- ----------------------------
-- Table structure for t_music_category
-- ----------------------------
DROP TABLE IF EXISTS `t_music_category`;
CREATE TABLE `t_music_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `home_top_sort_num` int(11) DEFAULT NULL,
  `is_home_top` bit(1) DEFAULT NULL,
  `is_recommend` bit(1) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `play_times` int(11) DEFAULT NULL,
  `sort_num` int(11) DEFAULT NULL,
  `txt_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_music_category
-- ----------------------------
INSERT INTO `t_music_category` VALUES ('1', null, null, null, null, '1', '清音', null, null, '4', null);
INSERT INTO `t_music_category` VALUES ('2', null, null, null, null, '1', '凡歌', null, null, '3', null);
INSERT INTO `t_music_category` VALUES ('3', null, null, null, null, '1', '禅乐', null, null, '2', null);
INSERT INTO `t_music_category` VALUES ('4', null, null, null, null, '1', '诵唱', null, null, '1', null);
INSERT INTO `t_music_category` VALUES ('5', '王俊雄', null, null, null, '2', '西方莲', '1', '0', '1', '西方莲啊西方，我向往的地方，晶莹无垢无染，十方三界共体瞻。清净庄严，花开见佛，预大法筵，西方莲啊西方，你已深植我心田');
INSERT INTO `t_music_category` VALUES ('6', '佛教音乐', null, null, null, '2', '菩提树下', '1', '0', '2', '菩提树下，佛陀成道。八万四千法门，慈悲度化无量无边不同根基的众生。音乐是世界共同的语言，能净化心灵，美化生活；佛陀是无上的智慧，能让您破迷开悟回归本我，离苦得乐。');
INSERT INTO `t_music_category` VALUES ('7', '赵家珍、张维良', null, null, null, '2', '琴箫佛曲', '1', '0', '3', '淡远虚静 以琴箫奏梵呗 轻舒典雅 以梵呗伴琴箫 佛教音乐的最新演绎 殿堂唱诵的最佳移植 远离尘嚣的最高境界 驱除烦恼的最好药方 《琴箫佛曲》是一张非常好的环境音乐CD。 无论在古寺、在禅堂、在佛殿、茶室、书房、病榻 和在一切需要清静的地方以及需要驱除烦恼、放松心情的时候播放它， 它一定会让你安静下来。 这声音像一双慈悲的手轻轻抚摸着你疲惫甚至受了伤的心灵， 让你的心灵得到慰藉。');
INSERT INTO `t_music_category` VALUES ('8', '佛教功课系列', null, null, null, '2', '清音佛教功课系列专辑', '1', '0', '4', '欢迎聆听佛教功课系列专辑！');
INSERT INTO `t_music_category` VALUES ('9', '慧普法师', null, null, null, '2', '吉祥莲花专辑-慧普法师', '1', '0', '5', '这是一张比丘的原创专辑，在佛音的论坛中，我们听到了音乐链接，这张专辑的曲调优美，经过沙门慧普（顿慈法师）的真诚演绎，更显得悠远而沉静，在查找歌词的过程中，我们又惊喜的发现了此张专辑中《空谷禅韵》及《吉祥莲花》的词作者，一个自称艺僧，现居苏州灵岩山的广行法师，这两首歌曲改编自他的《五月诗集》，惊喜让我们不能不将这张专辑奉献给大家共同分享，并且我们将两位法师的博客地址公布于此，感谢并期待两位法师有更多的作品早日与大家见面。');
INSERT INTO `t_music_category` VALUES ('10', '纳兰', null, null, null, '2', '新古典主义妙音善境', '1', '0', '6', '一直以来都想从音乐中寻觅一种静的、净的、暖的、善良的、可以与自己与他人的灵魂相依的感动。创作并演唱一张能给人净心的有关佛韵的音乐是我从大学时起萌生的心愿，经过两年的努力，很开心这张《新古典主义妙音善境》专辑终于能与大家一起分享了！');
INSERT INTO `t_music_category` VALUES ('11', '无量光明', null, null, null, '2', '东方冥想音乐系列-观想专辑', '1', '0', '7', '本辑巧妙地将「嗡?阿?吽」及消灾祈福的「百字明咒」等咒语融合在优美的音乐及自然声响中，为天人相应谱出了最美的音乐桥梁。');

-- ----------------------------
-- Table structure for t_user_favourite
-- ----------------------------
DROP TABLE IF EXISTS `t_user_favourite`;
CREATE TABLE `t_user_favourite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `favourite_time` datetime DEFAULT NULL,
  `favourite_type` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_favourite
-- ----------------------------
INSERT INTO `t_user_favourite` VALUES ('1', '2017-10-20 13:55:12', '2', '5', '1');
INSERT INTO `t_user_favourite` VALUES ('2', '2017-10-20 13:55:37', '2', '5', '2');
INSERT INTO `t_user_favourite` VALUES ('3', '2017-10-20 13:55:40', '2', '5', '3');
INSERT INTO `t_user_favourite` VALUES ('4', '2017-10-20 13:56:14', '2', '6', '1');

-- ----------------------------
-- Table structure for t_user_merit_flow
-- ----------------------------
DROP TABLE IF EXISTS `t_user_merit_flow`;
CREATE TABLE `t_user_merit_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `flow_no` varchar(255) DEFAULT NULL,
  `flow_type` int(11) DEFAULT NULL,
  `merit_value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_merit_flow
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_merit_wallet
-- ----------------------------
DROP TABLE IF EXISTS `t_user_merit_wallet`;
CREATE TABLE `t_user_merit_wallet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merit_value` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_merit_wallet
-- ----------------------------
INSERT INTO `t_user_merit_wallet` VALUES ('1', '0', '2017-10-27 11:47:34', '5');
INSERT INTO `t_user_merit_wallet` VALUES ('2', '0', '2017-10-27 11:49:02', '1');

-- ----------------------------
-- Table structure for t_user_rating
-- ----------------------------
DROP TABLE IF EXISTS `t_user_rating`;
CREATE TABLE `t_user_rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rating` double DEFAULT NULL,
  `rating_time` datetime DEFAULT NULL,
  `rating_type` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_rating
-- ----------------------------
INSERT INTO `t_user_rating` VALUES ('1', '8.5', '2017-10-20 14:22:51', '2', '5', '1');
INSERT INTO `t_user_rating` VALUES ('2', '3.5', '2017-10-20 14:22:53', '2', '5', '2');
