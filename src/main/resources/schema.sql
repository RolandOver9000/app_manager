DROP TABLE IF EXISTS app_manager_user;

CREATE TABLE app_manager_user (
                                  id INT PRIMARY KEY,
                                  is_user_family_head BOOLEAN NOT NULL,
                                  username VARCHAR(250) NOT NULL,
                                  password VARCHAR(250) DEFAULT NULL,
                                  user_family_id INT NOT NULL
);

DROP TABLE IF EXISTS family;
CREATE TABLE family (
                                  id INT AUTO_INCREMENT  PRIMARY KEY,
                                  family_head_id INT NOT NULL
);