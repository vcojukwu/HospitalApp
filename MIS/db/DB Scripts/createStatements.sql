DROP SCHEMA IF EXISTS mis_db;

CREATE SCHEMA mis_db;
SELECT DATABASE();
use mis_db; 

CREATE TABLE STAFF
(
	StaffId VARCHAR(25) NOT NULL,
	PRIMARY KEY (StaffId)
);

CREATE TABLE DOCTOR_PERMISSIONS
(
	PatientId VARCHAR(25) NOT NULL,
	DoctorId VARCHAR(25) NOT NULL,
	PRIMARY KEY (PatientId,DoctorId)
);

CREATE TABLE STAFF_DOCTOR
(
	StaffId VARCHAR(25) NOT NULL,
	DoctorId VARCHAR(25) NOT NULL,
	PRIMARY KEY (StaffId,DoctorId)
);

CREATE TABLE HEALTH_STATE
(
	HealthStateId INT NOT NULL AUTO_INCREMENT,
	HealthStateName VARCHAR(50) NOT NULL,
	PRIMARY KEY (HealthStateId)
);

CREATE TABLE PROCEDURES
(
	ProcedureId INT NOT NULL AUTO_INCREMENT,
	ProcedureType VARCHAR(100) NOT NULL,
	ProcedureName VARCHAR(100) NOT NULL,
	ProcedureCost INT NOT NULL,
	PRIMARY KEY (ProcedureId)
);

CREATE TABLE ADDRESS
(
	AddressId INT NOT NULL AUTO_INCREMENT,
	StreetNumber INT NOT NULL,
	StreetName VARCHAR(50) NOT NULL,
	City VARCHAR(50) NOT NULL,
	Province VARCHAR(50) NOT NULL,
	Country VARCHAR(50) NOT NULL,
	PostalCode CHAR(6) NOT NULL,
	PRIMARY KEY (AddressId)
);

CREATE TABLE DOCTORS
(
	DoctorId VARCHAR(25) NOT NULL,
	DoctorType VARCHAR(100) NOT NULL,
	PRIMARY KEY (DoctorId)
);

CREATE TABLE PATIENTS
(
	PatientId VARCHAR(25) NOT NULL,
	DoctorId VARCHAR(25) NOT NULL,
	HealthStateId INT NOT NULL,
	HealthCardNumber INT NOT NULL,
	SocialInsuranceNumber INT NOT NULL,
	NumberOfVisits INT NOT NULL,
	IsActive BIT NOT NULL,
	LastVisitDate DATETIME,
	PatientNotes LONGTEXT,
	PRIMARY KEY (PatientId),
	FOREIGN KEY (HealthStateId) REFERENCES HEALTH_STATE(HealthStateId),
	FOREIGN KEY (DoctorId) REFERENCES DOCTORS(DoctorId)
);

CREATE TABLE VISITATION_RECORDS
(
	RecordId INT NOT NULL AUTO_INCREMENT,
	OriginalRecordId INT,
	ProcedureId INT NOT NULL,
	PatientId VARCHAR(25) NOT NULL,
	DoctorId VARCHAR(25) NOT NULL,
	TimeStarted DATETIME NOT NULL,
	TimeEnded DATETIME NOT NULL,
	Prescriptions LONGTEXT NOT NULL,
	Diagnosis LONGTEXT NOT NULL,
	TreatmentSchedule LONGTEXT NOT NULL,
	Notes LONGTEXT,
	PRIMARY KEY (RecordId),
	FOREIGN KEY (ProcedureId) REFERENCES PROCEDURES(ProcedureId),
	FOREIGN KEY (PatientId) REFERENCES PATIENTS(PatientId),
	FOREIGN KEY (DoctorId) REFERENCES DOCTORS(DoctorId)
);

CREATE TABLE USERS
(
	UserId VARCHAR(25) NOT NULL,
	FirstName VARCHAR(50) NOT NULL,
	LastName VARCHAR(50) NOT NULL,
	Gender BIT NOT NULL,
	DateOfBirth DATE NOT NULL,
	UserType INT NOT NULL,
	Password VARCHAR(64) NOT NULL,
	PhoneNumber VARCHAR(50) NOT NULL,
	AddressId INT NOT NULL,	
	EmergencyContactName VARCHAR(100) NOT NULL,
	EmergencyContactPhoneNumber VARCHAR(50) NOT NULL,
	PRIMARY KEY (UserId),
	FOREIGN KEY (AddressId) REFERENCES ADDRESS(AddressId)
);

CREATE TABLE APPOINTMENTS
(
	AppointmentId INT NOT NULL AUTO_INCREMENT,
	PatientId VARCHAR(25) NOT NULL,
	DoctorId VARCHAR(25) NOT NULL,
	TimeScheduled DATETIME NOT NULL,
	DurationScheduled INT NOT NULL,
	PRIMARY KEY (AppointmentId),
	FOREIGN KEY (PatientId) REFERENCES PATIENTS(PatientId),
	FOREIGN KEY (DoctorId) REFERENCES DOCTORS(DoctorId)
);



