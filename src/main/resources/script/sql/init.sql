create table account(
    account_id int primary key auto_increment,
    acc_name varchar(75) not null,
    acc_password varchar(255) not null,
    is_enabled int
);