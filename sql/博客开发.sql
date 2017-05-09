drop database if exists seinfeld;

create database seinfeld;

use seinfeld;

drop table if exists addon;

drop table if exists addon_manage;

drop table if exists administrator;

drop table if exists article;

drop table if exists article_manage;

drop table if exists article_type;

drop table if exists article_type_manage;

drop table if exists comment;

drop table if exists comment_manage;

drop table if exists template;

drop table if exists template_manage;

drop table if exists user;

drop table if exists website_info;

drop table if exists website_info_manage;

create table addon
(
   addon_id             varchar(100) not null,
   name                 varchar(20),
   primary key (addon_id)
);

create table addon_manage
(
   user_id              varchar(100) not null,
   addon_id             varchar(100) not null,
   time                 timestamp,
   operation_type       varchar(20),
   primary key (user_id, addon_id)
);

create table administrator
(
   user_id              varchar(100) not null,
   user_account         varchar(20) not null,
   password             varchar(20),
   authority            int,
   point                int,
   level                int,
   mobile_number        varchar(20),
   register_date        timestamp,
   nickname             varchar(20),
   avatar_url           text,
   primary key (user_id)
);

create table article
(
   article_id           varchar(100) not null,
   user_id              varchar(100) not null,
   article_type_id      varchar(100) not null,
   title                varchar(200),
   content              text,
   publish_time         timestamp,
   primary key (article_id)
);

create table article_manage
(
   user_id              varchar(100) not null,
   article_id           varchar(100) not null,
   time                 timestamp,
   reason               text,
   operation_type       varchar(20),
   primary key (user_id, article_id)
);

create table article_type
(
   article_type_id      varchar(100) not null,
   type                 varchar(20),
   primary key (article_type_id)
);

create table article_type_manage
(
   user_id              varchar(100) not null,
   article_type_id      varchar(100) not null,
   time                 timestamp,
   operation_type       varchar(20),
   primary key (user_id, article_type_id)
);

create table comment
(
   comment_id           varchar(100) not null,
   article_id           varchar(100) not null,
   user_id              varchar(100),
   content              text,
   publish_time         timestamp,
   primary key (comment_id)
);

create table comment_manage
(
   user_id              varchar(100) not null,
   comment_id           varchar(100) not null,
   time                 timestamp,
   reason               text,
   operation_type       varchar(20),
   primary key (user_id, comment_id)
);

create table template
(
   template_id          varchar(100) not null,
   name                 varchar(20),
   url                  text,
   primary key (template_id)
);

create table template_manage
(
   user_id              varchar(100) not null,
   template_id          varchar(100) not null,
   time                 timestamp,
   operation_type       varchar(20),
   primary key (user_id, template_id)
);

create table user
(
   user_id              varchar(100) not null,
   user_account         varchar(20) not null,
   password             varchar(20),
   authority            int,
   point                int,
   level                int,
   mobile_number        varchar(20),
   register_date        timestamp,
   nickname             varchar(20),
   avatar_url           text,
   primary key (user_id)
);

create table website_info
(
   website_info_id      varchar(100) not null,
   name                 varchar(20),
   content              text,
   primary key (website_info_id)
);

create table website_info_manage
(
   user_id              varchar(100) not null,
   website_info_id      varchar(100) not null,
   time                 timestamp,
   operation_type       varchar(20),
   primary key (user_id, website_info_id)
);

alter table addon_manage add constraint FK_addon_manage foreign key (user_id)
      references administrator (user_id) on delete restrict on update restrict;

alter table addon_manage add constraint FK_addon_manage2 foreign key (addon_id)
      references addon (addon_id) on delete restrict on update restrict;

alter table administrator add constraint FK_Inheritance foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table article add constraint FK_categorize foreign key (article_type_id)
      references article_type (article_type_id) on delete restrict on update restrict;

alter table article add constraint FK_publish foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table article_manage add constraint FK_article_manage foreign key (user_id)
      references administrator (user_id) on delete restrict on update restrict;

alter table article_manage add constraint FK_article_manage2 foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

alter table article_type_manage add constraint FK_article_type_manage foreign key (user_id)
      references administrator (user_id) on delete restrict on update restrict;

alter table article_type_manage add constraint FK_article_type_manage2 foreign key (article_type_id)
      references article_type (article_type_id) on delete restrict on update restrict;

alter table comment add constraint FK_add foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

alter table comment add constraint FK_commit foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table comment_manage add constraint FK_comment_manage foreign key (user_id)
      references administrator (user_id) on delete restrict on update restrict;

alter table comment_manage add constraint FK_comment_manage2 foreign key (comment_id)
      references comment (comment_id) on delete restrict on update restrict;

alter table template_manage add constraint FK_template_manage foreign key (user_id)
      references administrator (user_id) on delete restrict on update restrict;

alter table template_manage add constraint FK_template_manage2 foreign key (template_id)
      references template (template_id) on delete restrict on update restrict;

alter table website_info_manage add constraint FK_website_info_manage foreign key (user_id)
      references administrator (user_id) on delete restrict on update restrict;

alter table website_info_manage add constraint FK_website_info_manage2 foreign key (website_info_id)
      references website_info (website_info_id) on delete restrict on update restrict;

