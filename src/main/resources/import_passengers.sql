-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
INSERT INTO passengers(id, surname, firstname, email_address)
VALUES(NEXTVAL('passengers_sequence'), 'Aladin', 'SALEH','aladin.saleh@etu.unilasalle.fr');
INSERT INTO passengers(id, surname, firstname, email_address)
VALUES(NEXTVAL('passengers_sequence'), 'Lucas', 'FANECH', 'lucas.fanech@etu.unilasalle.fr');