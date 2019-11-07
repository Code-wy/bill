DROP DATABASE IF EXISTS Bill;
-- -------------------------
--               建库
-- -------------------------
CREATE DATABASE Bill;
USE Bill;

-- -------------------------
--             用户相关表
-- -------------------------
-- 建user表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一id,主键',
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 权限表 role
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 用户<-->权限表 user_role
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_role_id` (`role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 初始数据
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');  -- 插入权限，id 1 为ADMIN用户，id 2 为USER用户
INSERT INTO `role` VALUES ('2', 'ROLE_USER');

INSERT INTO `user` VALUES ('1', 'admin', '123'); -- 创建用户
INSERT INTO `user` VALUES ('2', 'wangy', '123');

INSERT INTO `user_role` VALUES ('1', '1'); -- 为用户admin 授权ADMIN权限 为用户 wangy授权USER权限
INSERT INTO `user_role` VALUES ('2', '2');

-- INSERT INTO `user` (name,password) VALUES('32112' , '123');

-- -------------------------
--             账单相关表
-- -------------------------
-- 
DROP TABLE IF EXISTS `bill_Auth`;
CREATE TABLE `bill_Auth` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账单唯一id,主键',
  `user_id` int(11) NOT NULL  COMMENT '用户id,外键',
  `bill_name` VARCHAR(255) NOT NULL  COMMENT '账单名字',
  `bill_text` TEXT NOT NULL  COMMENT '账单详情',
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`bill_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `bill_Auth`(user_id,bill_name,bill_text) VALUES(2,'123','1234567');
INSERT INTO `bill_Auth`(user_id,bill_name,bill_text) VALUES(1,'abc','abcdefg');

-- CRUD
-- SELECT * FROM `bill_Auth` WHERE user_id=2;
-- DELETE FROM `bill_Auth` WHERE bill_id=7;
-- UPDATE `bill_Auth` SET bill_text='456' WHERE bill_id=8;