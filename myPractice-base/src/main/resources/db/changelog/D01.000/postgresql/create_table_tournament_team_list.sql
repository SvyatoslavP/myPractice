create table if not exists tournament_team_list
(
    tournament_persistence_id varchar(255),
    team_list_persistence_id  varchar(255) unique,
    foreign key (tournament_persistence_id)
        references tournament (persistence_id),
    foreign key (team_list_persistence_id)
        references team (persistence_id)
);