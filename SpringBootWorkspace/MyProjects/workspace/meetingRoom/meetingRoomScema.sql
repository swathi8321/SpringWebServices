CREATE TABLE `projectdb`.`offices` (
  `officeId` INT NOT NULL,
  `officeName` VARCHAR(45) NULL,
  `floorId` INT NULL,
  PRIMARY KEY (`officeId`));
  
  CREATE TABLE `projectdb`.`floor` (
  `floorId` INT NOT NULL,
  `floorName` VARCHAR(45) NULL,
  `MeetingId` INT NULL,
  PRIMARY KEY (`floorId`));
  
  CREATE TABLE `projectdb`.`meeting` (
  `meetingId` INT NOT NULL,
  `meetingName` VARCHAR(45) NULL,
  `fourSeater` VARCHAR(4) NULL,
  `eightSeater` VARCHAR(4) NULL,
  `startTime` DATETIME NULL,
  `endTime` DATETIME NULL,
  `availability` VARCHAR(45) NULL,
  PRIMARY KEY (`meetingId`));


