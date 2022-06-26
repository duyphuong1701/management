create table tb_category
(
    category_id   varchar not null primary key,
    category_name varchar(255)
);

create table tb_group
(
    group_id   varchar      not null primary key,
    group_name varchar(255)
);

create table tb_question
(
    question_id      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    category_id      varchar default null,
    group_id         varchar not null,
    question_content varchar not null
);

create table tb_answer
(
    answer_id      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    category_id    varchar not null,
    answer_content varchar not null
);

create table tb_model
(
    model_id    uuid PRIMARY KEY,
    name        varchar,
    data        varchar,
    score       varchar,
    c_parameter varchar,
    feature     varchar,
    wb          varchar
);

create table tb_model_child
(
    model_child_id uuid PRIMARY KEY,
    model_id       uuid
);

create table tb_model_selection
(
    model_id uuid PRIMARY KEY
);

ALTER TABLE tb_model_child
    ADD CONSTRAINT fk_model_id FOREIGN KEY (model_id) REFERENCES tb_model (model_id);

ALTER TABLE tb_model_selection
    ADD CONSTRAINT fk_model_id_model_selection FOREIGN KEY (model_id) REFERENCES tb_model (model_id);

ALTER TABLE tb_question
    ADD CONSTRAINT fk_category_tb_question FOREIGN KEY (category_id) REFERENCES tb_category (category_id);

ALTER TABLE tb_question
    ADD CONSTRAINT fk_group_tb_question FOREIGN KEY (group_id) REFERENCES tb_group(group_id);

ALTER TABLE tb_answer
    ADD CONSTRAINT fk_category_tb_answer FOREIGN KEY (category_id) REFERENCES tb_category (category_id);
