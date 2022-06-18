create table category
(
    category_id   varchar not null primary key,
    category_name varchar(255) not null
);

create table question
(
    question_id   serial not null primary key,
    category_id   varchar,
    question_content varchar not null
);

create table answer
(
    answer_id   serial not null primary key,
    category_id   varchar,
    answer_content varchar not null
);

create table question_answer
(
    question_answer_id   serial not null primary key,
    question_content     varchar not null,
    question_answer_asker varchar not null,
    question_answer_asker_email varchar not null,
    answer_content       varchar,
    category_category_id varchar
        constraint fkle1pobdrc8a2uw97gukfmvan4
            references category
);
