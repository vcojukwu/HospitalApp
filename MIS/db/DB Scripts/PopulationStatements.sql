use mis_db;

INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('0', 'Checkup', 'Health Checkup', '20');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('1', 'Test', 'STI Test', '10');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('2', 'Test', 'TB Test', '10');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('3', 'X-Ray', 'Bone X-ray', '30');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('4', 'Surgury', 'Heart Transplant', '50000');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('5', 'Surgury', 'Bypass', '30000');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('6', 'Physiotherapy', 'Mobility physiotherapy', '1000');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('7', 'Chemotherapy', 'Type I Chemotherapy', '12000');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('8', 'Vaccination', 'Flu vaccination', '50');
INSERT INTO `mis_db`.`procedures` (`ProcedureId`, `ProcedureType`, `ProcedureName`, `ProcedureCost`) VALUES ('9', 'Vaccination', 'Travel vaccinations', '120');


INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('1', 'Good');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('2', 'Weak');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('3', 'Sick');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('4', 'Infected');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('5', 'Excellent');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('6', 'Immobile');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('7', 'Injured');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('8', 'Recovering');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('9', 'Quarantined');
INSERT INTO `mis_db`.`health_state` (`HealthStateId`, `HealthStateName`) VALUES ('10', 'Urgent care');


INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('1', '1');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('2', '3');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('3', '5');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('4', '5');
INSERT INTO `mis_db`.`doctors` (`DoctorId`, `DoctorType`) VALUES ('5', '2');


INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('1', '1', '1', '1321483', '382382294', '3', 1, 'This patient has meninjitis.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('2', '2', '3', '6485468', '654961684', '10', 0, 'Cataracs.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('3', '3', '3', '2315657', '616834462', '31', 1, 'Patient is feeling motion sickness.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('4', '4', '3', '4549835', '987844526', '64', 1, 'Prescribing antidote.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('5', '5', '3', '2256432', '132133548', '5', 0, 'Patient deceased.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('6', '2', '3', '6213147', '112121658', '2', 1, 'Patient experiencing symptoms of Alziemers.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('7', '4', '3', '3212554', '416641325', '64', 1, 'Fracture to left ankle.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('8', '3', '3', '9788456', '987654321', '20', 0, 'Stitches.');
INSERT INTO `mis_db`.`patients` (`PatientId`, `DoctorId`, `HealthStateId`, `HealthCardNumber`, `SocialInsuranceNumber`, `NumberOfVisits`, `IsActive`, `PatientNotes`) VALUES ('9', '1', '3', '5416816', '468946138', '16', 0, 'Patient is healthy and in great shape.');
