-- USER ROLE
INSERT INTO USER_ROLES (user_role_id, ROLE) VALUES (1, 'ADMIN');
INSERT INTO USER_ROLES (user_role_id, ROLE) VALUES (2, 'CONSULT');
INSERT INTO USER_ROLES (user_role_id, ROLE) VALUES (3, 'EDITION');

-- USERS
INSERT INTO USERS (USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ENABLED, user_role_id) VALUES ('seb',  'fistnameSeb',  'lastnameSeb',  'seb',  true, 1);
INSERT INTO USERS (USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ENABLED, user_role_id) VALUES ('bibi', 'fistnameBibi', 'lastnameBibi', 'bibi', true, 1);
INSERT INTO USERS (USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ENABLED, user_role_id) VALUES ('aze',  'fistnameAze',  'lastnameAze',  'aze',  false, 2);
INSERT INTO USERS (USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ENABLED, user_role_id) VALUES ('edit', 'fistnameedit', 'lastnameedit', 'edit', true, 3);


-- APPLICABILITY
INSERT INTO APPLICABILITY VALUES (1, 'Applicability 5');
INSERT INTO APPLICABILITY VALUES (2, 'Applicability 4');
INSERT INTO APPLICABILITY VALUES (3, 'Applicability 2');
INSERT INTO APPLICABILITY VALUES (4, 'Applicability 1');
INSERT INTO APPLICABILITY VALUES (5, 'Applicability 3');

-- LINK
INSERT INTO LINK VALUES (1, 'Link 1');
INSERT INTO LINK VALUES (2, 'Link 2');
INSERT INTO LINK VALUES (3, 'Link 3');
INSERT INTO LINK VALUES (4, 'Link 4');
INSERT INTO LINK VALUES (5, 'Link 5');

-- CRITICALITY
INSERT INTO CRITICALITY VALUES (1, 'Criticality 1');
INSERT INTO CRITICALITY VALUES (2, 'Criticality 2');
INSERT INTO CRITICALITY VALUES (3, 'Criticality 3');

-- MATURITY
INSERT INTO MATURITY VALUES (1, 'Maturity 1');
INSERT INTO MATURITY VALUES (2, 'Maturity 2');
INSERT INTO MATURITY VALUES (3, 'Maturity 3');

-- WORK
INSERT INTO WORK VALUES (1, 'Work 1');
INSERT INTO WORK VALUES (2, 'Work 2');
INSERT INTO WORK VALUES (3, 'Work 3');

-- REQUIREMENT TYPE
INSERT INTO REQUIREMENTTYPE VALUES (1, 'Req Type 1');
INSERT INTO REQUIREMENTTYPE VALUES (2, 'Req Type 2');
INSERT INTO REQUIREMENTTYPE VALUES (3, 'Req Type 3');
INSERT INTO REQUIREMENTTYPE VALUES (4, 'Req Type 4');

-- CONTROL TYPE
INSERT INTO CONTROLTYPE VALUES (1, 'Control Type 1');
INSERT INTO CONTROLTYPE VALUES (2, 'Control Type 2');
INSERT INTO CONTROLTYPE VALUES (3, 'Control Type 3');
INSERT INTO CONTROLTYPE VALUES (4, 'Control Type 4');

-- UNIT
INSERT INTO UNIT VALUES (1, 'Unit 1');
INSERT INTO UNIT VALUES (2, 'Unit 2');
INSERT INTO UNIT VALUES (3, 'Unit 3');


-- RELATED TABLE
-- PROJECTS
INSERT INTO PROJECT VALUES (1,  'C''est une description très longue qui ve surment déborder du champ et je ne sais pas ce que cela va donner. Mais on verra bien. J''espère bien qu''il y aura un retour à la ligne', 'Projet 1');
INSERT INTO PROJECT VALUES (2,  'C''est le projet deux',   'Projet 2');
INSERT INTO PROJECT VALUES (3,  'C''est le projet trois',  'Projet 3');
INSERT INTO PROJECT VALUES (4,  'C''est le projet quatre', 'Projet 4');
INSERT INTO PROJECT VALUES (5,  'C''est le projet cinq',   'Projet 5');
INSERT INTO PROJECT VALUES (6,  'C''est le projet six',    'Projet 6');
INSERT INTO PROJECT VALUES (7,  'C''est le projet sept',   'Projet 7');
INSERT INTO PROJECT VALUES (8,  'C''est le projet huit',   'Projet 8');
INSERT INTO PROJECT VALUES (9,  'C''est le projet neuf',   'Projet 9');
INSERT INTO PROJECT VALUES (10, 'C''est le projet dix',    'Projet 10');
INSERT INTO PROJECT VALUES (11, 'C''est le projet onze',   'Projet 11');

-- BUILDING
INSERT INTO BUILDING VALUES (1, 'Building 1', 1);
INSERT INTO BUILDING VALUES (2, 'Building 2', 1);

-- TFE 
INSERT INTO TFE VALUES (1, 'TFE 1', 1);
INSERT INTO TFE VALUES (2, 'TFE 2', 1);
INSERT INTO TFE VALUES (3, 'TFE 3', 1);
INSERT INTO TFE VALUES (4, 'TFE 1', 2);
INSERT INTO TFE VALUES (5, 'TFE 2', 2);

-- FLOOR
INSERT INTO FLOOR VALUES (1, 'Floor 1 - B1', 1);
INSERT INTO FLOOR VALUES (2, 'Floor 2 - B1', 1);
INSERT INTO FLOOR VALUES (3, 'Floor 3 - B1', 1);
INSERT INTO FLOOR VALUES (4, 'Floor 1 - B2', 2);
INSERT INTO FLOOR VALUES (5, 'Floor 2 - B2', 2);

-- ROOM
INSERT INTO ROOM VALUES (1, 'Room 1 - B1 -F1', 1);
INSERT INTO ROOM VALUES (2, 'Room 2 - B1 -F1', 1);
INSERT INTO ROOM VALUES (3, 'Room 3 - B1 -F2', 2);
INSERT INTO ROOM VALUES (4, 'Room 4 - B1 -F3', 3);
INSERT INTO ROOM VALUES (5, 'Room 1 - B2 -F1', 4);
INSERT INTO ROOM VALUES (6, 'Room 2 - B2 -F1', 4);
INSERT INTO ROOM VALUES (7, 'Room 3 - B2 -F1', 4);
INSERT INTO ROOM VALUES (8, 'Room 4 - B2 -F2', 5);

-- REQUIREMENT
INSERT INTO REQUIREMENT VALUES (1,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '7.5', 'justifbuild', 'justifDesign', '1.5',  'nameEx1',  '1',  'planeref', 'ref link 1',  '1', 'tolerance', '2015-04-18', '5',  1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (2,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx2',  '2',  'planeref', 'ref link 2',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (3,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx3',  '3',  'planeref', 'ref link 3',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (4,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx4',  '4',  'planeref', 'ref link 4',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (5,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx5',  '5',  'planeref', 'ref link 5',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (6,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx6',  '6',  'planeref', 'ref link 6',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (7,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx7',  '7',  'planeref', 'ref link 7',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (8,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx8',  '8',  'planeref', 'ref link 8',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (9,  'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx9',  '9',  'planeref', 'ref link 9',  '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (10, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx10', '10', 'planeref', 'ref link 10', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (11, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx11', '11', 'planeref', 'ref link 11', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (12, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx12', '12', 'planeref', 'ref link 12', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (13, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx13', '13', 'planeref', 'ref link 13', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (14, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx14', '14', 'planeref', 'ref link 14', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (15, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx15', '15', 'planeref', 'ref link 15', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (16, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx16', '16', 'planeref', 'ref link 16', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (17, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx17', '17', 'planeref', 'ref link 17', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (18, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx18', '18', 'planeref', 'ref link 18', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (19, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx19', '19', 'planeref', 'ref link 19', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (20, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx20', '20', 'planeref', 'ref link 20', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (21, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx21', '21', 'planeref', 'ref link 21', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (22, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx22', '22', 'planeref', 'ref link 22', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (23, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx23', '23', 'planeref', 'ref link 23', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (24, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx24', '24', 'planeref', 'ref link 24', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (25, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx25', '25', 'planeref', 'ref link 25', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (26, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '20',  'justifbuild', 'justifDesign', '2',    'nameEx26', '26', 'planeref', 'ref link 26', '1', 'tolerance', '2015-04-18', '10', 1, 'walver', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'seb', 1);
INSERT INTO REQUIREMENT VALUES (27, 'ADS', 'comment', true, true, false, 'feedback', 'field1', 'field2', 'field3', 'field4', '2.5', 'justifbuild', 'justifDesign', '1.25', 'nameEx27', '27', 'planeref', 'ref link 27', '1', 'tolerance', '2015-04-18', '2',  1, 'walver', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 'seb', 2);

