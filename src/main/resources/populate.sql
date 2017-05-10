INSERT INTO `User` (`userId`, `email`, `enabled`, `firstName`, `lastName`, `password`, `username`) VALUES (1, 'bayar.mehdi@gmail.com', b'1', 'Mehdi', 'Bayar', '$2a$10$0aBQojMx1UXILntw3LtYhek2zmYeW3IfWcUmpbEnsequtV0dBnVXi', 'admin');
INSERT INTO `Authority` (`id`, `authority`, `userId`) VALUES (1, 'ROLE_ADMIN', 1);

INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('A', 95, 98);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('A+', 98, 100);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('A-', 90, 94);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('B', 80, 84);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('B+', 85, 89);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('B-', 75, 79);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('C', 65, 69);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('C+', 70, 74);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('C-', 60, 64);
INSERT INTO `Grade` (`name`, `rangeFrom`, `rangeTo`) VALUES ('NC', 0, 59);


INSERT INTO `onlinetest`.`Inventory` (`id`, `name`, `value`) VALUES (NULL, 'test_duration_by_minutes', '120');
INSERT INTO `onlinetest`.`Inventory` (`id`, `name`, `value`) VALUES (NULL, 'test_questions_number_of_choices', '3');
INSERT INTO `onlinetest`.`Inventory` (`id`, `name`, `value`) VALUES (NULL, 'smtp_host', 'smtp.gmail.com');
INSERT INTO `onlinetest`.`Inventory` (`id`, `name`, `value`) VALUES (NULL, 'smtp_port', '25');
INSERT INTO `onlinetest`.`Inventory` (`id`, `name`, `value`) VALUES (NULL, 'smtp_username', 'mumtestlink@gmail.com');
INSERT INTO `onlinetest`.`Inventory` (`id`, `name`, `value`) VALUES (NULL, 'smtp_password', 'MumTestLink12345');
