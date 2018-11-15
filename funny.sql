CREATE DATABASE funny;
USE funny;
DROP TABLE `funny`.`t_user_role`;
CREATE TABLE `funny`.`t_user_role`(
  `id` VARCHAR(20) NOT NULL,
  `userid` VARCHAR(20),
  `roleid` VARCHAR(20),
  PRIMARY KEY (`id`)
);
DROP TABLE `funny`.`t_user`;
CREATE TABLE `funny`.`t_user`(
  `id` VARCHAR(20) NOT NULL,
  `username` VARCHAR(50),
  `realname` VARCHAR(50),
  `password` VARCHAR(100),
  `salt` VARCHAR(50),
  `creator` VARCHAR(50),
  `createtime` TIMESTAMP,
  `updator` VARCHAR(50),
  `updatetime` TIMESTAMP,
  `status` TINYINT(1),
  PRIMARY KEY (`id`)
);
DROP TABLE `funny`.`t_role_permission`;
CREATE TABLE `funny`.`t_role_permission`(
  `id` VARCHAR(20) NOT NULL,
  `roleid` VARCHAR(20),
  `permissionid` VARCHAR(20),
  PRIMARY KEY (`id`)
);
DROP TABLE `funny`.`t_role`;
CREATE TABLE `funny`.`t_role`(
  `id` VARCHAR(20) NOT NULL,
  `rolename` VARCHAR(20),
  `description` VARCHAR(100),
  `creator` VARCHAR(50),
  `createtime` TIMESTAMP,
  `updator` VARCHAR(50),
  `updatetime` TIMESTAMP,
  `status` TINYINT(1),
  PRIMARY KEY (`id`)
);
DROP TABLE `funny`.`t_permission`;
CREATE TABLE `funny`.`t_permission`(
  `id` VARCHAR(20) NOT NULL,
  `menuid` VARCHAR(20),
  `code` VARCHAR(20),
  `description` VARCHAR(100),
  `creator` VARCHAR(50),
  `createtime` TIMESTAMP,
  `updator` VARCHAR(50),
  `updatetime` TIMESTAMP,
  `status` TINYINT(1),
  PRIMARY KEY (`id`)
);
DROP TABLE `funny`.`t_menu`;
CREATE TABLE `funny`.`t_menu`(
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20),
  `code` VARCHAR(20),
  `isleaf` VARCHAR(20),
  `parentid` VARCHAR(20),
  `order` VARCHAR(20),
  `icon` VARCHAR(100),
  `path` VARCHAR(100),
  `creator` VARCHAR(50),
  `createtime` TIMESTAMP,
  `updator` VARCHAR(50),
  `updatetime` TIMESTAMP,
  `status` TINYINT(1),
  PRIMARY KEY (`id`)
);