create table dbo.PessoaCategoria(
idPessoa int,
idCategoria int,
stAtivo char(1),
dtCadastro datetime,
primary key(idPessoa,idCategoria)

)