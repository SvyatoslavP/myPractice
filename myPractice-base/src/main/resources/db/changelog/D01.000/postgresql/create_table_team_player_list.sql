create table if not exists team_player_list
(
    team_persistence_id varchar(255),
    player_list_persistence_id  varchar(255) unique,
    foreign key (team_persistence_id)
        references team (persistence_id),
    foreign key (player_list_persistence_id)
        references player (persistence_id)
);