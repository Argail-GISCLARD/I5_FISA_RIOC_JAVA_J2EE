-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
INSERT INTO reservations(id, flight_id, passenger_id)
VALUES(NEXTVAL('flights_sequence'), '1', '1');
INSERT INTO reservations(id, flight_id, passenger_id)
VALUES(NEXTVAL('flights_sequence'), '2', '2');