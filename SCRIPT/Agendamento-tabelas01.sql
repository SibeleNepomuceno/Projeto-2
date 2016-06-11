DROP TABLE IF EXISTS CLIENTE;
CREATE TABLE CLIENTE(
     ID_CLIENTE INTEGER NOT NULL,
	
     NOME_CLIENTE VARCHAR(200),
     CPF VARCHAR(11) UNIQUE,
	 RG VARCHAR(20) UNIQUE,
	TELEFONE VARCHAR(10),
	 CELULAR VARCHAR(11),
   PRIMARY KEY (ID_CLIENTE)
);

INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2001','Fabiola','12312312310','25127214X','1156217854','11932589942');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2002','Maria','12312312311','54123968H','1163259874','1195217761');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2003','Josefa','12312312312','24871226X','1155668516','11966124788');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2004','Mariana','12312312313','45448745X','1155254115','119855412');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2005','Renan','12312312314','25147179J','1185692513','11955625114');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2006','Helena','12312312315','37310498D','1184561145','11966781455');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2007','Flavia','12312312316','52147953D','1155287614','11946752315');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2008','Selena','12315552316','52741953D','1155289654','11948582315');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2009','Norberto','52415896547','475821586','1158742698','1194556556');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2010','Anabella','89078967865','789087866','1177888988','1198760097');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2011','Otaviano','76778765676','98123454E','1145454432','11932431222');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2012','Cintia','98009866654','90098090X','1165676445','11944325412');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2013','Sonia','88899943444','67567123R','1190879065','11934321121');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2014','Antonieta','12343212456','761234356','1134542331','11955653211');
INSERT INTO CLIENTE(ID_CLIENTE,NOME_CLIENTE,CPF,RG,TELEFONE,CELULAR) VALUES('2015','Leideane','11232443212','34454432Q','1134435445','11945438887');
SELECT * FROM  CLIENTE;


DROP TABLE IF EXISTS UNIDADE;
CREATE TABLE UNIDADE(
       ID_UNIDADE INTEGER NOT NULL,
	   DESCRICAO_UNID CHAR(111),
        PRIMARY KEY (ID_UNIDADE)
);
INSERT INTO UNIDADE(ID_UNIDADE,DESCRICAO_UNID) VALUES(1,'Morumbi');
INSERT INTO UNIDADE(ID_UNIDADE,DESCRICAO_UNID) VALUES(2,'Diadema');
INSERT INTO UNIDADE(ID_UNIDADE,DESCRICAO_UNID) VALUES(3,'Santo amaro');
INSERT INTO UNIDADE(ID_UNIDADE,DESCRICAO_UNID) VALUES(4,'Interlagos');

SELECT * from UNIDADE;


DROP TABLE IF EXISTS FUNCIONARIO;
CREATE TABLE FUNCIONARIO(
     
     ID_FUNCIONARIO INTEGER NOT NULL,
	 ID_UNIDADE INTEGER,
     NOME_FUNCIO VARCHAR(200),
     CPF VARCHAR(11) UNIQUE,
	 RG VARCHAR(10) UNIQUE,
	 CARGO VARCHAR(50),
     PRIMARY KEY(ID_FUNCIONARIO),
	 FOREIGN KEY (ID_UNIDADE) REFERENCES UNIDADE(ID_UNIDADE)
	
);

INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('9004','Amélia',1,'24566312566','395903336','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1005','Beatriz',2,'58463214569','475869985','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1106','Caroliina',3,'45878962145','584236957','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1207','Daniela',4,'46598532145','859637416','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1308','Elaine',1,'56912345698','693251259','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1409','Fabia',2,'56954198899','551473692','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1501','Gabriela',3,'14520102568','303001532','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1602','Hilda',4,'36525401499','879878947','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1703','Ingrid',1,'60693202254','885882588','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1805','Jessica',2,'55566625632','336663259','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('1906','Karina',3,'24566312556','395908746','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2060','Lais',4,'58463252569','475841985','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2061','Marina',1,'45878112145','584746957','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2062','Nilma',2,'46598533145','887637416','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2063','Patricia',3,'56852345698','695524259','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2064','Raissa',4,'56910198899','551963692','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2065','Sandra',1,'14520022568','663001532','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2066','Hilda',2,'36574856499','879988547','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2067','Tatiane',3,'60693369654','885742588','Especialista - Pé e Mão');
INSERT INTO FUNCIONARIO(ID_FUNCIONARIO,NOME_FUNCIO,ID_UNIDADE,CPF,RG,CARGO) VALUES('2068','Vania',4,'55584425632','336663987','Especialista - Pé e Mão');

SELECT * FROM FUNCIONARIO;


DROP TABLE IF EXISTS STATUS;
CREATE TABLE STATUS(
       ID_STATUS INTEGER NOT NULL,
	   DESCRICAO_STATUS VARCHAR(20),
       PRIMARY KEY (ID_STATUS)
);

INSERT INTO STATUS(ID_STATUS,DESCRICAO_STATUS) VALUES('505','Disponivel');
INSERT INTO STATUS(ID_STATUS,DESCRICAO_STATUS) VALUES('506','Reservado');
INSERT INTO STATUS(ID_STATUS,DESCRICAO_STATUS) VALUES('507','Cancelado');
INSERT INTO STATUS(ID_STATUS,DESCRICAO_STATUS) VALUES('508','Realizado');

SELECT * from STATUS;


DROP TABLE IF EXISTS SERVICO;
CREATE TABLE SERVICO(
       ID_SERVICO INTEGER NOT NULL,
	   DESCRICAO_SERV VARCHAR(20),
	   VALOR DECIMAL (60),
	   PRIMARY KEY (ID_SERVICO)
);
INSERT INTO SERVICO(ID_SERVICO,DESCRICAO_SERV,VALOR) VALUES('7001','Mão','15.00');
INSERT INTO SERVICO(ID_SERVICO,DESCRICAO_SERV,VALOR) VALUES('7010','Pé','20.00');
INSERT INTO SERVICO(ID_SERVICO,DESCRICAO_SERV,VALOR) VALUES('7020','Pé e Mão','35.00');

SELECT * from SERVICO;


SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS AGENDAMENTO;
CREATE TABLE AGENDAMENTO (
    ID_CLIENTE INTEGER NOT NULL,
    ID_FUNCIONARIO INTEGER NOT NULL,
    ID_SERVICO INTEGER NOT NULL,
    ID_STATUS INTEGER NOT NULL,
    ID_UNIDADE INTEGER NOT NULL,
    ID_AGENDAMENTO INTEGER PRIMARY KEY AUTO_INCREMENT,
    HORARIO_INICIAL TIME NOT NULL,
    HORARIO_FINAL TIME NOT NULL,
    FILA_ESPERA TINYINT(1),
    PROMOCAO TINYINT(1),
    DATA_AGEN DATE NOT NULL,
    FOREIGN KEY (ID_CLIENTE)
        REFERENCES CLIENTE (ID_CLIENTE),
    FOREIGN KEY (ID_FUNCIONARIO)
        REFERENCES FUNCIONARIO (ID_FUNCIONARIO),
    FOREIGN KEY (ID_SERVICO)
        REFERENCES SERVICO (ID_SERVICO),
    FOREIGN KEY (ID_STATUS)
        REFERENCES STATUS (ID_STATUS),
    FOREIGN KEY (ID_UNIDADE)
        REFERENCES UNIDADE (ID_UNIDADE)
)auto_increment=70601;

INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,FILA_ESPERA,DATA_AGEN)value('2001',4,'1602','7001','507','11:00','11:30',1,'2016-07-22');
INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,FILA_ESPERA,DATA_AGEN)value('2003',2,'1409','7001','508','15:00','15:30',1,'2016-06-22');
INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,PROMOCAO,DATA_AGEN)value('2003',1,'9004','7020','508','11:00','12:30',1,'2016-06-04');
INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,PROMOCAO,DATA_AGEN)value('2004',1,'1501','7010','507','11:00','11:30',1,'2016-06-01');
INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,PROMOCAO,DATA_AGEN)value('2005',4,'1106','7001','508','11:00','11:30',1,'2016-06-13');
INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,FILA_ESPERA,PROMOCAO,DATA_AGEN)value('2008',2,'1409','7020','508','11:00','11:30',1,1,'2016-06-14');
INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,FILA_ESPERA,DATA_AGEN)value('2009',3,'2067','7001','507','17:30','18:00',1,'2016-06-12');

INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,PROMOCAO,DATA_AGEN)value('2012',2,'2062','7001','506','10:30','11:00',1,'2015-10-01');
INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,HORARIO_INICIAL,HORARIO_FINAL,DATA_AGEN)value('2015',3,'2061','7020','508','14:30','15:30','2016-02-29');

SELECT * FROM AGENDAMENTO;





