create table dbo.Pessoa (
       idPessoa int identity not null,
        cdChamada varchar(10),
        celular varchar(18),
        cpfCnpj varchar(20),
        email varchar(200),
        nmCurto varchar(50),
        nmPessoa varchar(100),
        telefone varchar(18),
        tpPessoa varchar(1),
        primary key (idPessoa)
)
