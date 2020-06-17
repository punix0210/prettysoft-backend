if exists(SELECT *
FROM sys.triggers Where name='Tl_PushCodigoPessoa')
begin
	DROP TRIGGER dbo.Tl_PushCodigoPessoa
end

GO

CREATE TRIGGER dbo.Tl_PushCodigoPessoa 
   ON  dbo.Pessoa
   AFTER INSERT
AS 
BEGIN

	DECLARE @CdChamada char(10)

	SET NOCOUNT ON;

	Select 
	 @CdChamada = REPLICATE('0', 6 - LEN(convert(varchar,idPessoa)))  + CONVERT(varchar,idPessoa)
	From 
	 inserted

    Update
	 P
	set
	 cdChamada = @CdChamada
	From
	 Pessoa P Join
	 inserted I on (P.idPessoa = I.idPessoa)
	
	SET NOCOUNT OFF;

END
GO

/*
UPDATE P SET cdChamada =  replicate('0', 6 - len(convert(char,P.idPessoa))) + convert(char,P.idPessoa) 
from Pessoa P

insert into Pessoa values ('','1197636363','35481220842','teste@gmail.com','TESTE','TESTE COMPLETO','45474386','F')

INSERT INTO PessoaCategoria VALUES (8,3,'S',CONVERT(datetime,'12/06/2020',103))*/




