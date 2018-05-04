CREATE TABLE if not exists `picture_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_name` varchar(45) DEFAULT NULL,
  `pic_qury_url` varchar(45) DEFAULT NULL,
  `pic_seq_no` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `encoded_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='图片基础信息表';

CREATE TABLE IF NOT EXISTS `user_info` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `openId` VARCHAR(45) DEFAULT NULL,
    `nickName` VARCHAR(45) DEFAULT NULL,
    `avatarUrl` VARCHAR(45) DEFAULT NULL,
    `gender` VARCHAR(45) DEFAULT NULL,
    `city` VARCHAR(45) DEFAULT NULL,
    `province` VARCHAR(45) DEFAULT NULL,
    `country` VARCHAR(45) DEFAULT NULL,
	`create_time` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=19 DEFAULT CHARSET=UTF8 COMMENT='用户信息表';

create table if not exists `user_session_info` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `openId` VARCHAR(100) DEFAULT NULL,
    `sessionKEY` VARCHAR(100) DEFAULT NULL,
    `status` varchar(2) default 0 ,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=19 DEFAULT CHARSET=UTF8 COMMENT='用户session记录';