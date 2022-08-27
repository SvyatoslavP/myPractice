create table if not exists team
(
    persistence_id varchar(255) unique,
    team_name   varchar(255) not null unique,
    primary key (persistence_id)
);