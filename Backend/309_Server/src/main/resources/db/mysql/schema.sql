

CREATE TABLE IF NOT EXISTS CallYourMomUsers (
  id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  user_name VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  fb_account VARCHAR(30),
  address VARCHAR(255),
  phone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS CallYourMomEvents(
  id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  time VARCHAR(30) NOT NULL,
  title VARCHAR(30) NOT NULL,
  location VARCHAR(30) NOT NULL,
  friends_invited VARCHAR(100),
  friends_going VARCHAR(100),
  description VARCHAR(300)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS CallYourMomReminders(
id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  time VARCHAR(30) NOT NULL,
  title VARCHAR(30) NOT NULL,
  location VARCHAR(30) NOT NULL
) engine=InnoDB;
  
  
CREATE TABLE IF NOT EXISTS CallYourMomSettings(
id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
theme boolean NOT NULL,
notification boolean NOT NULL,
sharing VARCHAR(30)

)



  







