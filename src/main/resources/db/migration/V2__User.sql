create table users (
    id bigserial primary key not null,
    username varchar (64),
    password varchar(64),
    role varchar(64)
)