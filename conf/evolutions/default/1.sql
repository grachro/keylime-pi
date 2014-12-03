# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table line (
  datetime                  varchar(255) not null,
  temperature               decimal(38) not null,
  create_date               timestamp not null,
  constraint pk_line primary key (datetime))
;

create sequence line_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists line;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists line_seq;

