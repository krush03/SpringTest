CREATE TABLE Otp_tbl
(
	id long(10) NOT NULL AUTO_INCREMENT,
    name varchar(40) DEFAULT NULL,
    mobileno long(15) NOT NULL,
    otpvalue int (6) NOT NULL,
    PRIMARY KEY (id)
);