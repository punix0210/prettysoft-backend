
create table dbo.Categoria (
       idCategoria int identity not null,
        cdChamada varchar(10),
        nmCategoria varchar(100),
        primary key (idCategoria)
    )