CREATE TABLE "team" (
    id int primary key,
    name varchar not null
);

CREATE TABLE "play_against" (
    id int primary key,
    datetime timestamp not null,
    stadium varchar not null,
    team1_id int references team(id),
    team2_id int references team(id)
)

CREATE TABLE "player" (
    id int primary key,
    name varchar not null,
    number int not null ,
    team_id int references team(id)
);

CREATE TABLE "sponsor" (
    id int primary key,
    name varchar not null
);

CREATE TABLE "have" (
    id int primary key,
    team_id int references team(id),
    sponsor_id int references sponsor(id)
);