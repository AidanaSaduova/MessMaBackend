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


# --- !Downs

drop table if exists accesspoints;

drop table if exists gridpoints;

