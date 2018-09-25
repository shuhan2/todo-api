create table user (
  `id`      int not null auto_increment,
  `name`    varchar(40) not null,
  `password`   varchar(40) not null,
  primary key (id)
)
  engine = InnoDB
  default charset = utf8;

