/*
														Auteur: Rohdri FRIMAT
														Date: 21/09/2016
*/

/*
 * BD Postgresql
 * */



-- CREATE DATABASE dblogin ;
-- ALTER DATABASE dblogin OWNER TO tom;


/**/
DROP TABLE IF EXISTS utilisateur CASCADE;
DROP TABLE IF EXISTS city CASCADE;


create table utilisateur(
identifiant varchar(40), 
motdepasse varchar(40),
PRIMARY KEY (identifiant)
);


INSERT INTO utilisateur VALUES ('ldurand', '123456789');
INSERT INTO utilisateur VALUES ('dpetitjean', '987654321');
    








