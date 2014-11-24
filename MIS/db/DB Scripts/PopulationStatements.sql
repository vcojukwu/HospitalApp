use mis_db;

INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Checkup', 'Health Checkup', '20');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Test', 'STI Test', '10');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Test', 'TB Test', '10');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('X-Ray', 'Bone X-ray', '30');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Surgury', 'Heart Transplant', '50000');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Surgury', 'Bypass', '30000');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Physiotherapy', 'Mobility physiotherapy', '1000');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Chemotherapy', 'Type I Chemotherapy', '12000');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Vaccination', 'Travel vaccinations', '120');
INSERT INTO `mis_db`.`procedures` (`ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('Vaccination', 'Flu vaccination', '50');


INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Good');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Weak');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Sick');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Infected');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Excellent');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Immobile');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Injured');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Recovering');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Quarantined');
INSERT INTO `mis_db`.`health_state` (`HealthStateName`) VALUES ('Urgent care');


INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor1@email.com', 'Surgeon');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor2@email.com', 'Physician');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor3@email.com', 'Cariologist');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor4@email.com', 'Surgeon');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor5@email.com', 'Optomotrist');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor6@email.com', 'Physician');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor7@email.com', 'Surgeon');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor8@email.com', 'Radiologist');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('doctor9@email.com', 'Surgeon');


INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient1@email.com', 'doctor1@email.com', '1', '1321483', '382382294', '3', 1, 'This patient has meninjitis.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient2@email.com', 'doctor2@email.com', '3', '6485468', '654961684', '10', 0, 'Cataracs.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient3@email.com', 'doctor5@email.com', '3', '2315657', '616834462', '31', 1, 'Patient is feeling motion sickness.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient4@email.com', 'doctor2@email.com', '3', '4549835', '987844526', '64', 1, 'Prescribing antidote.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient5@email.com', 'doctor4@email.com', '3', '2256432', '132133548', '5', 0, 'Patient deceased.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient6@email.com', 'doctor7@email.com', '3', '6213147', '112121658', '2', 1, 'Patient experiencing symptoms of Alziemers.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient7@email.com', 'doctor1@email.com', '3', '3212554', '416641325', '64', 1, 'Fracture to left ankle.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient8@email.com', 'doctor5@email.com', '3', '9788456', '987654321', '20', 0, 'Stitches.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('patient9@email.com', 'doctor9@email.com', '3', '5416816', '468946138', '16', 0, 'Patient is healthy and in great shape.');

INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('313', 'Spruce', 'Waterloo', 'ON', 'CAN', 'N2L3M6');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('123', 'Bay Street', 'Toronto', 'ON', 'CAN', 'N2L3M7');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('684', 'Wall Street', 'Orange County', 'ON', 'CAN', 'N2L3Q6');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('1', 'Spadina Avenue', 'Toronto', 'ON', 'CAN', 'M2O4F3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('31', 'King Street', 'Waterloo', 'ON', 'CAN', 'D6R2F3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('93', 'Peter Street', 'Toronto', 'ON', 'CAN', 'K8W3S2');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('20', 'McDougall Drive', 'Brampton', 'ON', 'CAN', 'W5E1B3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('994', 'Seagram Drive', 'Mississauga', 'ON', 'CAN', 'D6S8E4');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('4568', 'Everstone Terrace', 'Markham', 'ON', 'CAN', 'A4A8E7');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('2216', 'Erb Street', 'Milton', 'ON', 'CAN', 'N2L3K3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('4', 'Hickory Street', 'Waterloo', 'ON', 'CAN', 'N4L3W6');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('9', 'Sandalwood Parkway', 'Brampton', 'ON', 'CAN', 'L3R1P4');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('3', 'Bayview Avenue', 'Toronto', 'ON', 'CAN', 'M2O4R3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('235', 'Hemlock Street', 'Waterloo', 'ON', 'CAN', 'D3R2F3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('64', 'Front Street', 'Toronto', 'ON', 'CAN', 'K8W3S4');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('2', 'Bramalea Drive', 'Brampton', 'ON', 'CAN', 'W5E1K3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('9', 'Eglinton Drive', 'Mississauga', 'ON', 'CAN', 'D1S8E4');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('45', 'Roundtree Terrace', 'Markham', 'ON', 'CAN', 'A4M8E7');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('22', '10th Line', 'Milton', 'ON', 'CAN', 'M2L3K3');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('43', 'Weber Street', 'Waterloo', 'ON', 'CAN', 'N4L3M6');
INSERT INTO `mis_db`.`address` (`StreetNumber`, `StreetName`, `City`, `Province`, `Country`, `PostalCode`) VALUES ('92', 'Arcanic Drive', 'Brampton', 'ON', 'CAN', 'L3K1P4');

INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('aahaji@waterloo.ca', 'Abbas', 'Haji', 1, '1992-07-06', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '6541236554', '1', 'ASfasdoj', '4598745695');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('vojukwu@waterloo.ca', 'Victor', 'Ojukwu', 1, '1994-03-03', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '9741235468', '2', 'aefaefaeg', '4778456132');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('a88patel@waterloo.ca', 'Anish', 'Patel', 1, '1993-10-30', '3', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '2232452678', '3', 'adfiaufh', '1443456597');

INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient1@email.com', 'Adam', 'Hin', 1, '1959-10-04', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '4', 'emerg1', '321651453');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient2@email.com', 'Zack', 'Palkjo', 1, '1969-12-12', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '5', 'emerg2', '64686886');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient3@email.com', 'Annie', 'Ho', 0, '1992-04-23', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '6', 'emerg3', '648611868');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient4@email.com', 'Harjot', 'Singh', 0, '1984-08-19', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '7', 'emerg4', '84657924');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient5@email.com', 'Christine', 'Wynn', 0, '1974-01-03', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '8', 'emerg5', '1234486');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient6@email.com', 'Carol', 'Lee', 0, '1986-12-09', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '9', 'emerg6', '946721542');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient7@email.com', 'John', 'Smith', 1, '1990-03-10', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '10', 'emerg7', '65452456');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient8@email.com', 'Sim', 'Anderson', 1, '1949-09-28', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '11', 'emerg8', '6489712256');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('patient9@email.com', 'Allison', 'Tomson', 0, '1972-04-30', '1', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '12', 'emerg9', '647894254');

INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor1@email.com', 'Edmond', 'Renser', 1, '1959-10-04', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '13', 'emerg1', '321651453');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor2@email.com', 'Sameer', 'Aloowalia', 1, '1969-12-12', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '14', 'emerg2', '64686886');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor3@email.com', 'Victor', 'Judjia', 1, '1992-04-23', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '15', 'emerg3', '648611868');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor4@email.com', 'Anish', 'Patel', 1, '1984-08-19', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '16', 'emerg4', '84657924');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor5@email.com', 'Jennifer', 'Jens', 0, '1974-01-03', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '17', 'emerg5', '1234486');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor6@email.com', 'Jason', 'Naldt', 1, '1986-12-09', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '18', 'emerg6', '946721542');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor7@email.com', 'Jack', 'Altera', 1, '1990-03-10', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '19', 'emerg7', '65452456');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor8@email.com', 'Dylan', 'Hendrick', 1, '1949-09-28', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '20', 'emerg8', '6489712256');
INSERT INTO `mis_db`.`users` (`UserId`, `FirstName`, `LastName`, `Gender`, `DateOfBirth`, `UserType`, `Password`, `PhoneNumber`, `AddressId`, `EmergencyContactName`, `EmergencyContactPhoneNumber`) VALUES ('doctor9@email.com', 'Harjinder', 'Tatla', 1, '1972-04-30', '2', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '204942304', '21', 'emerg9', '647894254');

