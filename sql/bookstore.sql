/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 127.0.0.1:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 22/07/2021 10:01:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名',
  `price` int(0) NULL DEFAULT NULL COMMENT '图书价格',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书简介',
  `classification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书分类',
  `hot` int(0) NULL DEFAULT NULL COMMENT '图书热度',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书作者',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `total_page` int(0) NULL DEFAULT NULL COMMENT '页数',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `book_id` bigint(0) NULL DEFAULT NULL COMMENT '书目id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '账户id',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `price` int(0) NULL DEFAULT NULL COMMENT '价格',
  `num` int(0) NULL DEFAULT NULL COMMENT '数目',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态(0购物车，1转入结算，2转入订单)',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `book_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下单数目(,间隔)',
  `book_prices` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下单价格(,间隔)',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '下单人',
  `total_price` int(0) NULL DEFAULT NULL COMMENT '总价',
  `order_state` int(0) NULL DEFAULT NULL COMMENT '订单状态(0正在结算，1结算成功待发货，2发货中，3发货成功)',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始结算时间（订单超出30分钟自动取消结算状态）',
  `deal_time` datetime(0) NULL DEFAULT NULL COMMENT '订单确认时间（结算成功起算）',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '订单完成时间',
  `servicer` bigint(0) NULL DEFAULT NULL COMMENT '服务订单人员',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
