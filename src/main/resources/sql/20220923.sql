ALTER TABLE `wcss_whitelist_setting` ADD `password` VARBINARY(100)   //添加密码字段

ALTER TABLE `wcss_whitelist_setting` MODIFY is_deleted TINYINT(1) DEFAULT 0;
ALTER TABLE `wcss_whitelist_setting` MODIFY is_enabled TINYINT(1) DEFAULT 1;

ALTER TABLE `wcss_batch_setting` MODIFY is_deleted TINYINT(1) DEFAULT 0;


ALTER TABLE `wcss_audit_history` MODIFY is_deleted TINYINT(1) DEFAULT 0;