create table TABELA01
(
	ID        int identity primary key,
	NOME      varchar(50) NULL,
	DATA_NASC datetime NULL,
	IDADE     int NULL,
	ALTURA    numeric(3,2) NULL,
	PESO      numeric(5,2) NULL
)

select * from TABELA01