--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

INSERT INTO "volunteer0" (id,name,email,password,availability,origin,delete) VALUES 
(3,'Brody','brody@gmail.com','Nullam','False','volunteer0','False'),
(6,'Lunea','lunea@gmail.com','ut,','True','volunteer0','False'),
(9,'Ingrid','ingrid@gmail.com','dui','True','volunteer0','False'),
(12,'Imani','imani@yahoo.com','et','True','volunteer0','False'),
(15,'Judah','judah@yahoo.com','ridiculus','False','volunteer0','False'),
(18,'Charde','charde@yahoo.com','Phasellus','False','volunteer0','False'),
(21,'Autumn','autumn@hotmail.com','accumsan','True','volunteer0','False'),
(24,'Irene','irene@hotmail.com','vulputate','True','volunteer0','False'),
(27,'Vera','vera@hotmail.com','risus.','False','volunteer0','False'),
(30,'Ruth','ruth@hotmail.com','dolor','False','volunteer0','False');

INSERT INTO "volunteer1" (id,name,email,password,availability,origin,delete) VALUES 
(1,'Jeremy','jeremy@gmail.com','rutrum','False','volunteer1','False'),
(4,'Hashim','hashim@gmail.com','malesuada','False','volunteer1','False'),
(7,'Norman','norman@gmail.com','eget,','True','volunteer1','False'),
(10,'Akeem','akeem@gmail.com','velit','False','volunteer1','False'),
(13,'Nero','nero@yahoo.com','semper','True','volunteer1','False'),
(16,'Cheyenne','cheyenne@yahoo.com','congue,','False','volunteer1','False'),
(19,'Dominique','dominique@yahoo.com','dui','False','volunteer1','False'),
(22,'Erin','erin@hotmail.com','justo','False','volunteer1','False'),
(25,'Lani','lani@hotmail.com','aliquam','False','volunteer1','False'),
(28,'Sybill','sybill@hotmail.com','in','False','volunteer1','False');


INSERT INTO "volunteer2" (id,name,email,password,availability,origin,delete) VALUES 
(2,'Evan','evan@gmail.com','ornare.','False','volunteer2','False'),
(5,'Dale','dale@gmail.com','quam','True','volunteer2','False'),
(8,'Beck','beck@gmail.com','erat','True','volunteer2','False'),
(11,'Rigel','rigel@yahoo.com','Praesent','False','volunteer2','False'),
(14,'Sawyer','sawyer@yahoo.com','tortor','True','volunteer2','False'),
(17,'Mari','mari@yahoo.com','diam.','False','volunteer2','False'),
(20,'Hector','hector@yahoo.com','senectus','False','volunteer2','False'),
(23,'Ronan','ronan@hotmail.com','amet','False','volunteer2','False'),
(26,'Isadora','isadora@hotmail.com','Praesent','False','volunteer2','False'),
(29,'Hoyt','hoyt@hotmail.com','Mauris','True','volunteer2','False');

--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

INSERT INTO "skill" (id,name,description,delete) VALUES 
(1,'Talar arboles','Utiliza implementos de seguridad adecuados para talar arboles','False'),
(2,'Trepar muros','Trepa muros de más de 5m de altura','False'),
(3,'Cocinar','Hace la mejor cazuela','False'),
(4,'Pintar','Pinta fachadas','False'),
(5,'RCP','Tiene certificado en RCP','False'),
(6,'Construccion','Utiliza herramientas de construccion pesadas','False'),
(7,'Constructor','Utiliza herramientas de construcción livianas','False'),
(8,'Psicologo','Ayuda a personas en momentos de crisis','False'),
(9,'TENS','Presta ayuda a equipo medico','False'),
(10,'Enfermera','Monitorea a pacientes','False'),
(11,'Operario de grua','Opera maquinaria pesada para mover grandes objetos','False'),
(12,'Equipo antibombas','Desactivan bombas','False'),
(13,'Chaman','Habilidades espirituales','False'),
(14,'Cura','Realiza exorcismos','False'),
(15,'Pequeño','Puede entrar por lugares estrechos','False'),
(16,'Cirujano','Capaz de operar en situaciones de riesgo','False'),
(17,'Médico','Conocimientos completos en medicina para situaciones de emergencia','False'),
(18,'Kinesiólogo','tratamientos que trabajen sobre articulaciones, músculos, huesos, entre otros componentes del movimiento humano','False'),
(19,'Bombero','Entrenado para actuar en incendios y rescates','False'),
(20,'Primeros auxilios','Reanimación, curación de heridas, detener sangrado, etc','False');

--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

INSERT INTO "volunteer_skill0" (id,id_volunteer,id_skill,origin,delete) VALUES 
(3,3,3,'volunteer_skill0','False'),
(6,6,6,'volunteer_skill0','False'),
(9,9,9,'volunteer_skill0','False'),
(12,12,12,'volunteer_skill0','False'),
(15,15,15,'volunteer_skill0','False'),
(18,18,18,'volunteer_skill0','False'),
(21,21,20,'volunteer_skill0','False'),
(24,24,4,'volunteer_skill0','False'),
(27,27,18,'volunteer_skill0','False'),
(30,30,12,'volunteer_skill0','False');

INSERT INTO "volunteer_skill1" (id,id_volunteer,id_skill,origin,delete) VALUES 
(1,1,1,'volunteer_skill1','False'),
(4,4,4,'volunteer_skill1','False'),
(7,7,7,'volunteer_skill1','False'),
(10,10,10,'volunteer_skill1','False'),
(13,13,13,'volunteer_skill1','False'),
(16,16,16,'volunteer_skill1','False'),
(19,19,19,'volunteer_skill1','False'),
(22,22,13,'volunteer_skill1','False'),
(25,25,15,'volunteer_skill1','False'),
(28,28,11,'volunteer_skill1','False');

INSERT INTO "volunteer_skill2" (id,id_volunteer,id_skill,origin,delete) VALUES 
(2,2,2,'volunteer_skill2','False'),
(5,5,5,'volunteer_skill2','False'),
(8,8,8,'volunteer_skill2','False'),
(11,11,11,'volunteer_skill2','False'),
(14,14,14,'volunteer_skill2','False'),
(17,17,17,'volunteer_skill2','False'),
(20,20,20,'volunteer_skill2','False'),
(23,23,11,'volunteer_skill2','False'),
(26,26,16,'volunteer_skill2','False'),
(29,29,1,'volunteer_skill2','False');
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
