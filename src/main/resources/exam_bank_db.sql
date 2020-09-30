CREATE TABLE `user` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `password` varchar(255) NOT NULL
);

CREATE TABLE `user_details` (
  `id` int PRIMARY KEY,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `email` varchar(50),
  `tel_number` varchar(25),
  `birth_date` date NOT NULL
);

CREATE TABLE `account` (
  `iban` varchar(55) PRIMARY KEY,
  `user_id` int,
  `disposable_balance` int NOT NULL,
  `credit` int NOT NULL,
  `account_type` ENUM ('debit_account', 'credit_account'),
  `interest_rate` int NOT NULL,
  `currency` varchar(3) NOT NULL
);

CREATE TABLE `account_transaction` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `account_id` varchar(55),
  `transaction_id` int
);

CREATE TABLE `transaction` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `debtor_acc` varchar(55),
  `creditor_acc` varchar(55),
  `amount` double NOT NULL,
  `execution_date` datetime NOT NULL,
  `transaction_type` ENUM ('withdraw', 'deposit', 'transfer'),
  `currency` varchar(3) NOT NULL
);

ALTER TABLE `user` ADD FOREIGN KEY (`id`) REFERENCES `user_details` (`id`);

ALTER TABLE `account` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `account_transaction` ADD FOREIGN KEY (`account_id`) REFERENCES `account` (`iban`);

ALTER TABLE `account_transaction` ADD FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`);


INSERT INTO `user_details` (`id`,     `name`, `surname`,                     `email`,    `tel_number`, `birth_date`) VALUES
                          (10000,    'Tomas',   'Pimas',    'tomas.pirmas@gmail.com', '+370862210000', '1991-01-01'),
                          (10001, 'Zilvinas',  'Antras', 'zilvinas.antras@gmail.com', '+370862210000', '1992-02-02'),
                          (10002,    'Gedas', 'Trecias',   'gedas.trecias@gmail.com',          'NULL', '1993-03-03');   

INSERT INTO `user` (`id`, `password`) VALUES
                  (10000, '10000'),
                  (10001, '10001'),
                  (10002, '10002');

INSERT INTO `account` (`iban`, `user_id`, `disposable_balance`, `credit`, `account_type`   , `interest_rate`, `currency`) VALUES
      ('LT425365116785299977',    10000 ,                1000 ,   0     , 'debit_account'  ,               0, 'EUR'),

      ('LT254673983369637222',    10001 ,                400  ,   0     , 'debit_account'  ,               0, 'EUR'),
      ('LT512773141867522769',    10001 ,                600  ,   300   , 'credit_account' ,            0.25, 'EUR'), 

      ('LT642164163593527528',    10002 ,                450  ,   0     , 'debit_account'  ,               0, 'EUR'),
      ('LT266646711884723144',    10002 ,                5000 ,   5000  , 'credit_account' ,           0.125, 'EUR');



INSERT INTO `transaction` (`id`,           `debtor_acc`,         `creditor_acc`, `amount`, `execution_date`   , `transaction_type`, `currency`) VALUES
              (   1, 'LT398758772262576546', 'LT425365116785299977',     2000,        '2020-09-27',         'transfer',      'EUR'),
              (   2, 'LT425365116785299977',             'ATM01234',     1000,        '2020-09-27',         'withdraw',      'EUR'),

              (   3, 'LT398758772262576546', 'LT254673983369637222',      200,        '2020-09-27',         'transfer',      'EUR'),
              (   4,                 'NULL', 'LT254673983369637222',      200,        '2020-09-27',          'deposit',      'EUR'),

              (   5,                 'NULL', 'LT512773141867522769',      300,        '2020-09-27',          'deposit',      'EUR'),
                           
              (   6, 'LT398758772262576546', 'LT642164163593527528',      450,        '2020-09-27',         'transfer',      'EUR');


INSERT INTO `account_transaction` (`id`,            `account_id`, `transaction_id`) VALUES
                                     (1, 'LT425365116785299977',                1),
                                     (2, 'LT425365116785299977',                2),
                                     (3, 'LT254673983369637222',                3),
                                     (4, 'LT254673983369637222',                4),
                                     (5, 'LT512773141867522769',                5),
                                     (6, 'LT642164163593527528',                6);






