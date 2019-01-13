# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table accesspoints (
  _id_mac                       varchar(255) not null,
  type                          integer,
  activity                      tinyint(1) default 0,
  constraint pk_accesspoints primary key (_id_mac)
);

create table gridpoints (
  _id_grid_point                integer auto_increment not null,
  pos_x                         integer not null,
  pos_y                         integer not null,
  constraint pk_gridpoints primary key (_id_grid_point)
);

create table stands (
  _id_stand                     integer auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  logo                          varchar(255),
  constraint pk_stands primary key (_id_stand)
);

alter table gridpoints add constraint fk_gridpoints__id_grid_point foreign key (_id_grid_point) references stands (_id_stand) on delete restrict on update restrict;


# --- !Downs

alter table gridpoints drop foreign key fk_gridpoints__id_grid_point;

drop table if exists accesspoints;

drop table if exists gridpoints;

drop table if exists stands;

