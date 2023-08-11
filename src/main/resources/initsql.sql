CREATE TABLE wallet
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE,
    balance DECIMAL(10, 2)
);

CREATE TABLE wallet_transaction
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    user_id    INT,
    amount     DECIMAL(10, 2),
    type       INT COMMENT '1 代表转账，2 代表退款',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES wallet (user_id)
);
