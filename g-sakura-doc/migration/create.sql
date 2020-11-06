SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- -----------------------------------------------------
-- Table `gsakura`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`m_user`;
CREATE TABLE IF NOT EXISTS `gsakura`.`m_user`
(
    username       varchar(255)  NOT NULL COMMENT '用户名',
    password       varchar(255)  NOT NULL COMMENT '密码',
    version        INT       DEFAULT 1 COMMENT '版本',
    deleted        INT       DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
    create_user_id BIGINT    DEFAULT 1 COMMENT '生成者ID',
    update_user_id BIGINT    DEFAULT 1 COMMENT '更新者ID',
    create_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成時間',
    update_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
    PRIMARY KEY (username)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = UTF8MB4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;
INSERT INTO `gsakura`.`m_user`(username, password)
VALUES ('root', '$2a$10$yGcOz3ekNI6Ya67tqQueS.raxyTOedGsv5jh2BwtRrI5/K9QEIPGq'),
       ('boss', '$2a$10$yGcOz3ekNI6Ya67tqQueS.raxyTOedGsv5jh2BwtRrI5/K9QEIPGq'),
       ('staff', '$2a$10$yGcOz3ekNI6Ya67tqQueS.raxyTOedGsv5jh2BwtRrI5/K9QEIPGq');
-- -----------------------------------------------------
-- Table `gsakura`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`m_role`;
CREATE TABLE `gsakura`.`m_role`
(
    role_id             BIGINT       NOT NULL COMMENT '主键',
    role_name           varchar(255) NOT NULL COMMENT '角色名',
    description    varchar(255) NOT NULL COMMENT '角色描述',
    version        INT       DEFAULT 1 COMMENT '版本',
    deleted        INT       DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
    create_user_id BIGINT    DEFAULT 1 COMMENT '生成者ID',
    update_user_id BIGINT    DEFAULT 1 COMMENT '更新者ID',
    create_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成時間',
    update_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
    PRIMARY KEY (role_id)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = UTF8MB4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;
INSERT INTO `gsakura`.`m_role` (role_id, role_name, description)
VALUES (1, 'ADMIN', '普通管理员'),
       (2, 'DBA', '数据库管理员'),
       (3, 'USER', '普通用户');
-- ----------------------------
-- Table structure for `gsakura`.`user_role`
-- ----------------------------
DROP TABLE IF EXISTS `gsakura`.`r_user_role`;
CREATE TABLE `gsakura`.`r_user_role`
(
    user_id        BIGINT NOT NULL COMMENT '用户主键',
    role_id        BIGINT NOT NULL COMMENT '角色主键',
    version        INT       DEFAULT 1 COMMENT '版本',
    deleted        INT       DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
    create_user_id BIGINT    DEFAULT 1 COMMENT '生成者ID',
    update_user_id BIGINT    DEFAULT 1 COMMENT '更新者ID',
    create_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成時間',
    update_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_id_ref_t_user_info_user_id FOREIGN KEY (user_id) REFERENCES t_user_info (user_id),
    CONSTRAINT fk_role_id_ref_m_role_role_id FOREIGN KEY (role_id) REFERENCES m_role (role_id)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = UTF8MB4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;
INSERT INTO `r_user_role`(user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (2, 2);

-- -----------------------------------------------------
-- Table `gsakura`.`user_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`t_user_info`;
CREATE TABLE IF NOT EXISTS `gsakura`.`t_user_info`
(
    user_id              BIGINT       NOT NULL COMMENT '主键',
    username        varchar(255) NOT NULL COMMENT '用户名',
    salt            VARCHAR(50)  DEFAULT NULL COMMENT '盐值',
    token           VARCHAR(100) DEFAULT NULL COMMENT '钥匙',
    email           VARCHAR(50)  DEFAULT NULL COMMENT '邮箱',
    manager_id      BIGINT       DEFAULT NULL COMMENT '直属上级id',
    first_name      VARCHAR(30)  DEFAULT NULL COMMENT '名',
    last_name       VARCHAR(30)  DEFAULT NULL COMMENT '姓',
    account_expire  DATETIME     DEFAULT NULL COMMENT '账户有效截止时间',
    password_expire DATETIME     DEFAULT NULL COMMENT '密码有效截止时间',
    version         INT          DEFAULT 1 COMMENT '版本',
    deleted         INT          DEFAULT 0 COMMENT '逻辑删除标识(0.未删除,1.已删除)',
    create_user_id  BIGINT       DEFAULT 1 COMMENT '生成者ID',
    update_user_id  BIGINT       DEFAULT 1 COMMENT '更新者ID',
    create_time     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP COMMENT '作成時間',
    update_time     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
    PRIMARY KEY (user_id),
    CONSTRAINT fk_manager_id_ref_t_user_info_user_id FOREIGN KEY (manager_id) REFERENCES t_user_info(user_id),
    CONSTRAINT fk_username_ref_m_user_username FOREIGN KEY (username) REFERENCES m_user (username)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = UTF8MB4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;
INSERT INTO `gsakura`.`t_user_info`(user_id, username)
VALUES (1, 'root'),
       (2, 'boss'),
       (3, 'staff');

SET FOREIGN_KEY_CHECKS = 1;

-- -----------------------------------------------------
-- Table `gsakura`.`clientdetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`ClientDetails`;
CREATE TABLE IF NOT EXISTS `gsakura`.`ClientDetails`
(
    `appId`                  VARCHAR(128)  NOT NULL,
    `resourceIds`            VARCHAR(256)  NULL DEFAULT NULL,
    `appSecret`              VARCHAR(256)  NULL DEFAULT NULL,
    `scope`                  VARCHAR(256)  NULL DEFAULT NULL,
    `grantTypes`             VARCHAR(256)  NULL DEFAULT NULL,
    `redirectUrl`            VARCHAR(256)  NULL DEFAULT NULL,
    `authorities`            VARCHAR(256)  NULL DEFAULT NULL,
    `access_token_validity`  INT           NULL DEFAULT NULL,
    `refresh_token_validity` INT           NULL DEFAULT NULL,
    `additionalInformation`  VARCHAR(4096) NULL DEFAULT NULL,
    `autoApproveScopes`      VARCHAR(256)  NULL DEFAULT NULL,
    `create_time`            DATETIME           DEFAULT NULL COMMENT '作成時間',
    `update_time`            DATETIME           DEFAULT NULL COMMENT '作成時間',
    PRIMARY KEY (`appId`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = UTF8MB4;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_access_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`oauth_access_token`;
CREATE TABLE IF NOT EXISTS `gsakura`.`oauth_access_token`
(
    `token_id`          VARCHAR(256) NULL DEFAULT NULL,
    `token`             BLOB         NULL DEFAULT NULL,
    `authentication_id` VARCHAR(128) NOT NULL,
    `user_name`         VARCHAR(256) NULL DEFAULT NULL,
    `client_id`         VARCHAR(256) NULL DEFAULT NULL,
    `authentication`    BLOB         NULL DEFAULT NULL,
    `refresh_token`     VARCHAR(256) NULL DEFAULT NULL,
    PRIMARY KEY (`authentication_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = UTF8MB4;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_approvals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`oauth_approvals`;
CREATE TABLE IF NOT EXISTS `gsakura`.`oauth_approvals`
(
    `userId`         VARCHAR(256) NULL DEFAULT NULL,
    `clientId`       VARCHAR(256) NULL DEFAULT NULL,
    `scope`          VARCHAR(256) NULL DEFAULT NULL,
    `status`         VARCHAR(10)  NULL DEFAULT NULL,
    `expiresAt`      DATETIME     NULL DEFAULT NULL,
    `lastModifiedAt` DATETIME     NULL DEFAULT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = UTF8MB4;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_client_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`oauth_client_details`;
CREATE TABLE IF NOT EXISTS `gsakura`.`oauth_client_details`
(
    `client_id`               VARCHAR(128)  NOT NULL,
    `resource_ids`            VARCHAR(256)  NULL DEFAULT NULL,
    `client_secret`           VARCHAR(256)  NULL DEFAULT NULL,
    `scope`                   VARCHAR(256)  NULL DEFAULT NULL,
    `authorized_grant_types`  VARCHAR(256)  NULL DEFAULT NULL,
    `web_server_redirect_uri` VARCHAR(256)  NULL DEFAULT NULL,
    `authorities`             VARCHAR(256)  NULL DEFAULT NULL,
    `access_token_validity`   INT           NULL DEFAULT NULL,
    `refresh_token_validity`  INT           NULL DEFAULT NULL,
    `additional_information`  VARCHAR(4096) NULL DEFAULT NULL,
    `autoapprove`             VARCHAR(256)  NULL DEFAULT NULL,
    PRIMARY KEY (`client_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = UTF8MB4;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_client_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`oauth_client_token`;
CREATE TABLE IF NOT EXISTS `gsakura`.`oauth_client_token`
(
    `token_id`          VARCHAR(256) NULL DEFAULT NULL,
    `token`             BLOB         NULL DEFAULT NULL,
    `authentication_id` VARCHAR(128) NOT NULL,
    `user_name`         VARCHAR(256) NULL DEFAULT NULL,
    `client_id`         VARCHAR(256) NULL DEFAULT NULL,
    PRIMARY KEY (`authentication_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = UTF8MB4;

-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_code`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`oauth_code`;
CREATE TABLE IF NOT EXISTS `gsakura`.`oauth_code`
(
    `code`           VARCHAR(256) NULL DEFAULT NULL,
    `authentication` BLOB         NULL DEFAULT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = UTF8MB4;


-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_refresh_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gsakura`.`oauth_refresh_token`;
CREATE TABLE IF NOT EXISTS `gsakura`.`oauth_refresh_token`
(
    `token_id`       VARCHAR(256) NULL DEFAULT NULL,
    `token`          BLOB         NULL DEFAULT NULL,
    `authentication` BLOB         NULL DEFAULT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = UTF8MB4;