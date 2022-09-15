/*
 Navicat Premium Data Transfer

 Source Server         : text
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db3

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/09/2022 18:00:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stuid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(3) NOT NULL,
  `gender` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `height` decimal(6, 2) NULL DEFAULT NULL,
  `classID` int(11) NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`stuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, '张三1', 20, '女', 150.00, 1, '2021-02-02 00:00:00');
INSERT INTO `student` VALUES (4, '王小明1', 23, '男', 173.00, 2, '2021-01-04 00:00:00');
INSERT INTO `student` VALUES (5, '陈天明1', 19, '男', 163.20, 2, '2022-05-03 00:00:00');
INSERT INTO `student` VALUES (6, '陆少明', 20, '男', 158.50, 1, '2021-06-21 00:00:00');
INSERT INTO `student` VALUES (7, '陆明1', 20, '男', 158.50, 1, '2021-06-21 00:00:00');
INSERT INTO `student` VALUES (8, '张三', 10, '男', 170.00, 10, '2022-06-15 22:06:15');
INSERT INTO `student` VALUES (12, '张三1', 20, '女', 150.00, 1, '2022-06-15 22:38:31');
INSERT INTO `student` VALUES (14, '张三', 10, '男', 170.00, 10, '2022-06-15 22:47:53');
INSERT INTO `student` VALUES (15, '张三', 10, '男', 170.00, 10, '2022-06-15 22:52:09');
INSERT INTO `student` VALUES (17, '小花', 10, '男', 170.00, 10, '2022-09-04 14:28:45');
INSERT INTO `student` VALUES (19, '张三', 10, '男', 170.00, 10, '2022-09-04 14:35:06');
INSERT INTO `student` VALUES (20, '李四', 10, '男', 170.00, 10, '2022-09-04 14:35:34');
INSERT INTO `student` VALUES (21, '王五', 10, '男', 170.00, 10, '2022-09-04 15:18:36');
INSERT INTO `student` VALUES (29, '赵六', 12, '12', 1.00, 12, '2022-09-05 00:01:33');
INSERT INTO `student` VALUES (38, '小白', 12, '女', 123.00, 1, '2022-09-05 16:16:57');
INSERT INTO `student` VALUES (40, '小李', 19, '女', 170.00, 1, '2022-09-15 17:40:45');

SET FOREIGN_KEY_CHECKS = 1;
