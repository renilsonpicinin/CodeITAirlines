-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.

CREATE DATABASE AIRLINE;

CREATE TABLE PASSAGEIRO (
PAS_NOME VARCHAR(50),
PAS_CPF VARCHAR(15),
PAS_ID SERIAL PRIMARY KEY
);

CREATE TABLE VOO (
VOO_ID SERIAL PRIMARY KEY,
VOO_DATA VARCHAR(12),
VOO_HORA VARCHAR(10),
AER_ID_OR INTEGER,
AER_ID_DT INTEGER,
AVI_ID INTEGER
);

CREATE TABLE AVIAO (
AVI_CAPACIDADE INTEGER,
AVI_ID SERIAL PRIMARY KEY,
AVI_MODELO VARCHAR(20),
EMP_ID INTEGER
);

CREATE TABLE Cargo (
CARG_ID SERIAL PRIMARY KEY,
CARG_DESCRICAO VARCHAR(20)
);

CREATE TABLE AEROPORTO (
AER_ID SERIAL PRIMARY KEY,
AER_NOME VARCHAR(50),
AER_SIGLA VARCHAR(10)
);

CREATE TABLE TRIPULANTE (
TRIP_ID SERIAL PRIMARY KEY,
TRIP_NOME VARCHAR(50),
CARG_ID INTEGER,
FOREIGN KEY(CARG_ID) REFERENCES Cargo (CARG_ID)
);

CREATE TABLE EMPRESA (
EMP_ID SERIAL PRIMARY KEY,
EMP_NOME VARCHAR(50)
);

CREATE TABLE TRIPULACAO (
TRIP_ID INTEGER,
VOO_ID INTEGER,
FOREIGN KEY(TRIP_ID) REFERENCES TRIPULANTE (TRIP_ID),
FOREIGN KEY(VOO_ID) REFERENCES VOO (VOO_ID)
);

CREATE TABLE VOO_PAS (
VOO_ID INTEGER,
PAS_ID INTEGER,
FOREIGN KEY(VOO_ID) REFERENCES VOO (VOO_ID),
FOREIGN KEY(PAS_ID) REFERENCES PASSAGEIRO (PAS_ID)
);

ALTER TABLE VOO ADD FOREIGN KEY(AER_ID_OR) REFERENCES AEROPORTO (AER_ID);
ALTER TABLE VOO ADD FOREIGN KEY(AER_ID_DT) REFERENCES AEROPORTO (AER_ID);
ALTER TABLE VOO ADD FOREIGN KEY(AVI_ID) REFERENCES AVIAO (AVI_ID);
ALTER TABLE AVIAO ADD FOREIGN KEY(EMP_ID) REFERENCES EMPRESA (EMP_ID);

insert into empresa (emp_nome) values ('Singapore Airlines'),
('Malaysia Airlines'),
('LATAM Airlines Brasil'),
('Asiana Airlines'),
('Qatar Airways'),
('Gol Linhas Aéreas Inteligentes'),
('Singapore Airlines');

insert into aviao (avi_modelo,avi_capacidade,emp_id) values
('Airbus A380',845,1),
('Boeing 767',624,4),
('Boeing 787',594,6),
('Boeing 737',610,5),
('Boeing 777',600,3),
('Boeing 747',585,2);

insert into cargo (carg_descricao) values
('Piloto'),
('Oficial'),
('Chefe de Serviço'),
('Comissário(a)');

insert into aeroporto (aer_nome,aer_sigla) values
('Aeroporto Regional De Maringa','MGF'),
('Aeroporto Internacional de Quebec','YQB'),
('Aeroporto Internacional de Los Angeles','LAX'),
('Aeroporto Internacional de Cancún','CUN'),
('Aeroporto Internacional Humberto Delgado','LIS'),
('Aeroporto Internacional de Orly','ORY'),
('Aeroporto Internacional de Heathrow','LHR');
