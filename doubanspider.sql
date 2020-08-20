/*
 Navicat Premium Data Transfer

 Source Server         : 8.0
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3305
 Source Schema         : doubanspider

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/08/2020 16:26:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movie_info
-- ----------------------------
DROP TABLE IF EXISTS `movie_info`;
CREATE TABLE `movie_info`  (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `movie_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电影名',
  `movie_director` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '导演',
  `movie_scenarist` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '编剧',
  `movie_main_actor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主演',
  `movie_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电影类型',
  `movie_country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '国家',
  `movie_language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '语言',
  `movie_time` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上映日期',
  `movie_length` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '片长',
  `movie_another_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '别名',
  `movie_summary` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '剧情简介',
  `movie_score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电影评分',
  PRIMARY KEY (`movie_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_info
-- ----------------------------
INSERT INTO `movie_info` VALUES (22, '#活着#살아있다', '赵一亨', '赵一亨/马特·奈勒', '刘亚仁/朴信惠', '动作惊悚灾难', '韩国', '韩语', '2020-06-24(韩国)', '98分钟', '独行/얼론/#Saraitda/Alone/#Alive', '\n　　讲述突然被不明病毒感染，并失控扩散的城市中，被孤立的幸存者身上发生的故事。刘亚仁将在片中饰演因与世隔绝而幸存的游戏玩家俊宇一角，朴信惠饰演直面极端情况，寻找新的生存方式的幸存者宥彬一角。\n', '5.6');
INSERT INTO `movie_info` VALUES (23, '釜山行2：半岛부산행2-반도', '延尚昊', '延尚昊', '姜栋元/李贞贤/权海骁/李来/金敏载/具教焕/金度允/李艺媛', '动作惊悚', '韩国', '韩语', '2020-07-15(韩国)', '115分钟', '釜山行2/半岛/尸杀半岛(港)/尸速列车：感染半岛(台)/Peninsula/TraintoBusan2', '\n　　讲述灾难发生的4年后，朝鲜半岛满目疮痍，逃到海外的前士兵Jung-seok奉命回国，意外地遇到了幸存者。\n', '5.6');
INSERT INTO `movie_info` VALUES (24, '灰猎犬号Greyhound', '亚伦·施耐德', '汤姆·汉克斯/C·S·福里斯特', '汤姆·汉克斯/斯蒂芬·格拉汉姆/伊丽莎白·苏/迈克尔·本茨/罗布·摩根/大卫·马尔登那多/吉米·坦顿/马特·赫尔姆/汤姆·布里特尼/曼努埃尔·加西亚-鲁尔福/特拉维斯·普里兹比尔斯基/杰里米·丹尼尔·麦登/戴文·德鲁伊/特拉维斯·昆汀/威尔·普伦/乔什·维金斯/迈克尔·卡罗洛/凯莱布·J·塔格德/格雷森·拉塞尔/杰夫·阿德勒/戴夫·戴维斯/李·诺里斯/切特·汉克斯/卡尔·格洛斯曼/马修·祖克/B·马丁·威廉姆斯/乔恩·多纳休/伊恩·詹姆斯·科里特/马克西米利安·奥辛斯基/托马斯·克莱舒曼', '剧情战争', '美国', '英语', '2020-07-10(美国)', '91分钟', '怒海战舰(台)/雷霆战舰：猎犬号(港)/灰狗', '\n　　影片讲述二战初期，由37支盟军船只组成的护航舰队在欧内斯特·克劳斯（汤姆·汉克斯饰）舰长率领的一艘美国驱逐舰指挥下，穿越险恶的北大西洋，同时还要与德国U型潜艇狼群的周旋。\n', '8.2');
INSERT INTO `movie_info` VALUES (25, '战争幽灵GhostsofWar', '埃里克·布雷斯', '埃里克·布雷斯', '布伦顿·思韦茨/西奥·罗西/凯尔·加尔纳/斯盖拉·阿斯丁/阿兰·里奇森/莱拉·班基/内森·库珀/丽贝卡·弗林·怀特/卡洛延·赫里斯托夫/亚历山大·贝兰·凯什卡/珊农·麦克凯恩/亚尼莎·米哈伊洛娃/马修·瑞斯/肖恩·托布/比利·赞恩', '惊悚恐怖战争', '英国', '英语', '2020-07-17(英国)', '95分钟', '战争中的鬼故事(台)', '\n　　故事以二战末期为背景，讲述五人美军小队奉命守护一座法国古堡。不料城堡除了残余的敌军，一股超自然的邪恶力量也正在蓄势待发。小队众人也面临着比战场上更加残酷的威胁。\n', '6.6');
INSERT INTO `movie_info` VALUES (26, '剧场劇場', '行定勋', '又吉直树/蓬莱龙太', '山崎贤人/松冈茉优/宽一郎/伊藤沙莉/井口理/浅香航大/上川周作/大友律/三浦诚己', '剧情爱情', '日本', '日语', '2020-07-17(日本)', '136分钟', 'Theatre/Theater/ALoveStory', '\n　　永田从高中开始和朋友建立了一个剧团，他兼任编剧和导演，但剧作由于太过前卫收到了很多差评，剧团面临着即将解散的状态。直到一天，永田在路上向穿着同样鞋子的沙希搭话。梦想成为演员的沙希和永田就这么谈起了恋爱。身无分文的永田搬进了沙希的家里，两人开始了同居生活。沙希无条件地支持着永田追逐梦想，永田也渐渐重新拾起对戏剧的热爱。\n', '7.9');
INSERT INTO `movie_info` VALUES (27, '叔·叔', '杨曜恺', '杨曜恺', '太保/袁富华/区嘉雯/卢镇业/胡轶心/林耀声/江图/王晓怡/刘亭君/施魅力/黄国辉/翟紫筠', '剧情同性', '中国香港', '粤语', '2020-05-28(中国香港)/2019-10-04(釜山国际电影节)', '92分钟', 'SukSuk', '\n　　计程车司机柏（太保饰演），以及退休单亲爸爸海（袁富华饰演），即使大半生受尽传统社会的规范与约束，两人仍对多年来努力建立的家庭为荣。不过，两人没料到能在人生的最后这段路上，与彼此邂逅…。\n\n　　柏与清（区嘉雯饰演）结婚45年，育有一子一女，可谓上一代传统香港人眼中「幸福家庭」的典范。海的太太早年离他而去，与儿子永（卢镇业饰演）相依为命。虽然海与儿子一家同居，却无法感受到家的温暖。而柏与海迟来的相遇，也翻搅起两人尘封心底的爱慾。面对「爱情诱惑」与「社会道德价值」的拉扯，以及内心「原始慾望」跟社会传统「幸福家庭」的抉择，两人究竟要回归最原始的自己？还是重返风平浪静的生活，继续守护社会价值观所认可的「美好家庭」呢？\n', '7.7');
INSERT INTO `movie_info` VALUES (28, '征途', '陈德森', '刘奋斗/文宁', '刘宪华/何润东/林辰涵/蒋璐霞/罗仲谦/胡明/许明虎/郑浩南/施诗/张宁江/王延龙/杜晓帆/李熙瑜/李熙蕾', '动作奇幻冒险', '中国大陆', '汉语普通话', '2020-07-24(中国大陆网络)', '110分钟', 'DoubleWorld', '\n　　故事发生在虚构的中原大陆。十国之中，南赵国与北燕国比邻而居。为了防御日益强大的北燕，南赵举办比武大会，选拔将才。消息传到偏僻的清源村，村民东一龙想成为家族的举旗人，代表清源村家族出赛，村民们却质疑他的资格，经过一番努力，一龙终于踏上了与武士楚魂的征途……\n', '5.2');
INSERT INTO `movie_info` VALUES (29, '前哨TheOutpost', '罗德·拉里', '埃瑞克·约翰逊/保罗·塔马西/杰克·塔伯', '斯科特·伊斯特伍德/奥兰多·布鲁姆/卡赖伯·兰德里·琼斯/雅各布·西皮奥/杰克·凯西/米洛·吉布森/阿历克斯·阿诺/塞莱娜·辛顿/泰勒·约翰·史密斯/科里·哈德里克/巴比·洛克伍德/威尔·阿滕伯勒/法希姆·法兹利/詹姆斯·贾格尔/科瓦米·帕特森/阿尔菲·斯图尔特', '剧情历史战争', '保加利亚/美国', '英语', '2020-07-03(美国)', '123分钟', '72小时前哨救援(台)/前哨基地', '\n　　斯科特·伊斯特伍德、卡赖伯·兰德里·琼斯、奥兰多·布鲁姆将主演MillenniumMedia打造的阿富汗战争题材影片[前哨](TheOutpost，暂译)。罗德·拉里执导影片，影片则根据CNN记者JakeTapper著作改编。影片故事将围绕53名美国士兵的真实故事展开，这些士兵与阿富汗东北部约400名敌方武装分子拉开持久的作战。他们所建造的前哨基地位于巴基斯坦边境仅14英里处的三处陡峭山脉底部。基地则面临塔利班恐怖分子的袭击。而驻扎在那里的士兵则面临着巨大威胁。片中斯科特·伊斯特伍德扮演克林特·罗马沙军士，卡赖伯·兰德里·琼斯扮演专业军士TyMichaelCarter，布鲁姆扮演的BenjaminD.Keating在阿富汗战争中不幸丧生。该片预计将在今年8月展开拍摄，影片也将在戛纳电影节寻找买家。\n', '7.1');
INSERT INTO `movie_info` VALUES (30, '翻译疑云LesTraducteurs', '雷吉斯·罗因萨尔', '罗曼·康宁/丹尼尔·普雷斯利/雷吉斯·罗因萨尔', '朗贝尔·维尔森/欧嘉·柯瑞兰寇/里卡多·斯卡马乔/西瑟·巴比特·科努德森/爱德华多·诺列加/埃里克斯·劳瑟/安娜·玛丽亚·斯图姆/弗雷德里克·周/玛丽亚·莱特/马诺利斯·马诺里斯/萨拉·吉罗多/帕特里克·波查/塞尔盖·内斯特连科/米格伦·米切夫/伊琳娜·穆雷勒/凯斯特·洛夫莱斯/雅各布·乌尔里克·罗曼', '悬疑惊悚', '法国/比利时', '意大利语/葡萄牙语/丹麦语/俄语/法语/英语/希腊语/汉语普通话/西班牙语', '2019-11-23(佛朗哥乌兹克电影节)/2020-01-29(法国)', '105分钟', '叛译同谋(港)/TheTranslators', '\n　　知名畅销小说作家的遗作——他生前畅销小说的三部曲最后一集，即将发布。为了能在世界主要地区同时出版这本小说，出版商聘用了9名来自世界各地的翻译员，同时在现场翻译小说。他们被关进了一间豪华但守卫森严的套房，时刻在监视之下。然而，绝密手稿的前十页突然在网上流出，出版商也被勒索巨额赎金。如果不支付五百万欧元，还会继续泄漏内容。除了出版商和这9名翻译，没有人接触过这份手稿。出版商确信，泄密者就在他们9人当中。究竟谁是这一切的幕后操纵者？\n', '7.2');
INSERT INTO `movie_info` VALUES (31, '逃走的女人도망친여자', '洪常秀', '洪常秀', '金敏喜/徐永嬅/宋宣美/李恩美/金玺碧', '剧情', '韩国', '韩语', '2020-02-25(柏林电影节)/2020-09-17(韩国)', '77分钟', '逃亡的女人/逃跑的女人/奔跑的女人/TheWomanWhoRan/DomangchinYeoja', '\n　　当丈夫出差后，Gamhee(金敏喜饰)与她的三个朋友见了面。她先去三位中的两位的各自家中见了面，而第三位则是在电影院偶然碰到。然而当她们像往常一样进行友好交谈时，各自的内心却早已七上八下、暗潮涌动。\n', '7.2');

SET FOREIGN_KEY_CHECKS = 1;
