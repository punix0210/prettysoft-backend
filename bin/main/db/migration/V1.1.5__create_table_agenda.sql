create table Agenda(
idAgenda int identity not null,
descricao varchar(255),
data datetime,
horario varchar(8),
status char(1),
observacao varchar(1000),
idPessoa int,
primary key(idAgenda),
foreign key(idPessoa) references Pessoa(idPessoa)
)

go

create table AgendaItem(
idAgendaItem int identity not null,
idAgenda int,
quantidade float,
idProduto int,
primary key(idAgendaItem),
foreign key(idAgenda) references Agenda(idAgenda)
)