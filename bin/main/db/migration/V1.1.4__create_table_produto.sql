create table Empresa(
cdEmpresa int identity not null,
nmEmpresa varchar(100),
cdCGC varchar(18),
stAtivo bit,
primary key(cdEmpresa)
)

create table Produto(
idProduto int identity not null,
cdChamada varchar(20),
nmProduto varchar(255),
nmProdutoCurto varchar(50),
stAtivo bit,
tpServico char(1),
alComissao float,
vlUnitario float,
tempo int,
primary key(idProduto)
)

create table ProdutoEmpresa(
idproduto int,
cdEmpresa int,
primary key(idproduto,cdEmpresa)
)