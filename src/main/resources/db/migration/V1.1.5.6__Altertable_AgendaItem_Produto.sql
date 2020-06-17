alter table AgendaItem add vlUnitario float;

alter table AgendaItem add vlItem float;

alter table AgendaItem add alComissao float;

EXEC sp_rename 'dbo.Produto.vlUnitario', 'vlPreco', 'COLUMN';

EXEC sp_rename 'dbo.Produto.alComissao', 'alRepasse', 'COLUMN';

alter table Produto add vlCusto float;



