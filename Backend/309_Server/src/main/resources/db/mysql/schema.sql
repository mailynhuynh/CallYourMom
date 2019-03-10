CREATE TABLE IF NOT EXISTS CallYourMomUsers (
  id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  userName VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  address VARCHAR(255),
  telephone VARCHAR(20),
  friends VARCHAR(20)

  INDEX(last_name)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS CallYourMomEvents(
  id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  time VARCHAR(30) NOT NULL,
  title VARCHAR(30) NOT NULL,
  location VARCHAR(30) NOT NULL,
  friendsInvited VARCHAR(100),
  friendsGoing VARCHAR(100),
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



  







