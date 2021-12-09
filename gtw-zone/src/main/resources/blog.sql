DROP DATABASE IF EXISTS blogdb;
CREATE DATABASE blogdb;
USE blogdb;

CREATE TABLE User (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name varchar(50),
    password varchar(50),
    first_name varchar(50),
    last_name varchar(50),
    role varchar(50)
);

INSERT INTO `blogdb`.`user` ( `user_name`, `password`, `first_name`, `last_name`, `role`) VALUES ( 'Andong', 'Admin', 'An', 'Dong', 'Admin');
INSERT INTO `blogdb`.`user` ( `user_name`, `password`, `first_name`, `last_name`, `role`) VALUES ( 'Jeff', 'Admin', 'Jian', 'Feng', 'User');
INSERT INTO `blogdb`.`user` ( `user_name`, `password`, `first_name`, `last_name`, `role`) VALUES ( 'Ilyas', 'Admin', 'Il', 'yas', 'User');

CREATE TABLE Post (
    post_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    subject varchar(50),
    content longtext,
    tag varchar(50),
    isPrivate varchar(50),
    CONSTRAINT FOREIGN KEY (user_id)     REFERENCES User (user_id)
);

INSERT INTO `blogdb`.`post` (`post_id`, `user_id`, `subject`, `content`, `tag`, `isPrivate`) VALUES ('1', '1', 'Hello', 'Hello World', '#Greeting', 'False');
INSERT INTO `blogdb`.`post` (`post_id`, `user_id`, `subject`, `content`, `tag`, `isPrivate`) VALUES ('2', '1', 'Bye', 'ByeBye', '#Goodbye', 'False');
