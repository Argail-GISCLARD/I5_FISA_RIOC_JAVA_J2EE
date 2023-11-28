-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
INSERT INTO flights(id, number, origin, destination, departure_date, departure_time, arrival_date, arrival_time, plane_id)
VALUES(NEXTVAL('flights_sequence'), '1', 'Paris','Malaisie', '2012-10-28','08:02:32','2012-10-28','16:02:32',1);
INSERT INTO flights(id, number, origin, destination, departure_date, departure_time, arrival_date, arrival_time, plane_id)
VALUES(NEXTVAL('flights_sequence'), '2', 'Rabat', 'New-York', '2001-09-11','08:02:32','2011-09-11','16:02:32',2);