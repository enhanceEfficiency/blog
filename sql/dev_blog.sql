DROP DATABASE IF EXISTS blog;

CREATE DATABASE blog;

USE blog;

DROP TABLE IF EXISTS blog_article;

DROP TABLE IF EXISTS blog_article_tag;

DROP TABLE IF EXISTS blog_category;

DROP TABLE IF EXISTS blog_comment;

DROP TABLE IF EXISTS blog_memorabilia;

DROP TABLE IF EXISTS blog_request_record;

DROP TABLE IF EXISTS blog_tag;

DROP TABLE IF EXISTS blog_user;

CREATE TABLE blog_article
(
  id               VARCHAR(32)                             NULL,
  views            INT                                     NULL,
  digest           TEXT                                    NULL,
  title            VARCHAR(200)                            NULL,
  content          TEXT                                    NULL,
  publish_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP     NOT NULL,
  user_id          VARCHAR(32)                             NULL,
  create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP     NOT NULL,
  last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP     NOT NULL,
  status           VARCHAR(1)                              NULL,
  category_id      VARCHAR(32)                             NULL,
  picture_url      VARCHAR(200) DEFAULT '/images/timg.jpg' NULL
);

CREATE TABLE blog_article_tag
(
  id         VARCHAR(32) NULL,
  article_id VARCHAR(32) NULL,
  tag_id     VARCHAR(32) NULL
);

CREATE TABLE blog_category
(
  id               VARCHAR(32)                         NULL,
  name             VARCHAR(20)                         NULL,
  create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  status           VARCHAR(1)                          NULL
);

CREATE TABLE blog_comment
(
  id               VARCHAR(32)                         NULL,
  content          TEXT                                NULL,
  publish_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  user_id          VARCHAR(32)                         NULL,
  ip               VARCHAR(32)                         NULL,
  article_id       VARCHAR(32)                         NULL,
  floor            INT                                 NULL,
  create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  status           VARCHAR(1) DEFAULT '0'              NULL
);

CREATE TABLE blog_memorabilia
(
  id                VARCHAR(32)                         NULL,
  event_time        DATE                                NULL,
  event_description TEXT                                NULL,
  status            VARCHAR(1) DEFAULT '0'              NULL,
  create_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  update_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
)
  COMMENT '大事记';

CREATE TABLE blog_request_record
(
  id           VARCHAR(32)                         NULL,
  ip_address   VARCHAR(32)                         NULL,
  url          VARCHAR(200)                        NULL,
  request_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE blog_tag
(
  id               VARCHAR(32)                         NULL,
  name             VARCHAR(20)                         NULL,
  create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  status           VARCHAR(1)                          NULL
);

CREATE TABLE blog_user
(
  id               VARCHAR(32)                         NOT NULL
    PRIMARY KEY,
  username         VARCHAR(32)                         NULL,
  password         VARCHAR(32)                         NULL,
  avatar_url       VARCHAR(200)                        NULL,
  status           VARCHAR(1)                          NULL,
  create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

