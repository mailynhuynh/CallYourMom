

CREATE TABLE IF NOT EXISTS CallMyMomUsers (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  user_name VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  fb_account VARCHAR(30),
  address VARCHAR(255),
  phone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;
