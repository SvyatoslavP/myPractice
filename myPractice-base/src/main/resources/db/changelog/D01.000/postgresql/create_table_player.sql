create table if not exists player
(
    persistence_id varchar(255) unique,
    player_name   varchar(255) not null unique,
    primary key (persistence_id)
);