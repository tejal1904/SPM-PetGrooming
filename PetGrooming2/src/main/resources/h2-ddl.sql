CREATE TABLE Client (
	ClientID	SMALLINT,
	ClientName	VARCHAR(50)	NOT NULL,
	Address 	CHAR(100),
	Email 	VARCHAR(30),
    Password VARCHAR(20),
    HomePhone VARCHAR(20),
    MobileNo VARCHAR(20),
    WorkNo VARCHAR(20),
	PRIMARY KEY (ClientID)
);

CREATE TABLE ClientDog (
	ClientDogID	SMALLINT,
	ClientID	SMALLINT	NOT NULL,
    Name VARCHAR(20),
    Breed VARCHAR(20),
    DOB DATE,
	PRIMARY KEY (ClientDogID),
    FOREIGN KEY (ClientID) references Client(ClientID)
);

CREATE TABLE GroomingOption (
	GroomingID	SMALLINT,
	GroomingType	VARCHAR(20)	NOT NULL,
	PRIMARY KEY (GroomingID)
);

CREATE TABLE AvailableDog (
	DogID	SMALLINT,
	Breed	VARCHAR(20)	NOT NULL,
	PRIMARY KEY (DogID)
);

CREATE TABLE Days(
	DayID SMALLINT,
    DayName VARCHAR(20)	NOT NULL,
	PRIMARY KEY (DayID)
);

CREATE TABLE TimeSlot(
	TimeSlotID SMALLINT,
    TimeStart SMALLINT,
    PRIMARY KEY (TimeSlotID)
);


CREATE TABLE Appointment (
	AppointmentID	SMALLINT,
	GroomingID	SMALLINT	NOT NULL,
	ClientID	SMALLINT	NOT NULL,
	DayID	SMALLINT	NOT NULL,
    TimeSlotID	SMALLINT	NOT NULL,
    DogID SMALLINT	NOT NULL,
    Comments VARCHAR(100),
    Status BOOLEAN,
	PRIMARY KEY (AppointmentID),
    FOREIGN KEY (ClientID) references Client(ClientID),
    FOREIGN KEY (GroomingID) references GroomingOption(GroomingID),
    FOREIGN KEY (DayID) references Days(DayID),
    FOREIGN KEY (TimeSlotID) references TimeSlot(TimeSlotID),
    FOREIGN KEY (DogID) references AvailableDog(DogID)
);