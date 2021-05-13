# MovieLibrary

# Netbeans Project

<h1>Overlook:</h1>
<p> </p>
<h2>Logowanie:</h2>
<p> </p>
<div>
  <img src="movielibraary.jpg">
  </div>
  <p> </p>
  <h2>Biblioteka:</h2>
  <p> </p>
<div>
  <img src="moveiawf.jpg">
  </div>
 <p> </p>
<h1>Procedury w SQL:</h1>
<div>
  <h1> Dodawanie Filmu </h1>
```SQL
USE [MovieLibrary]
GO
/****** Object:  StoredProcedure [dbo].[dodajFilm]    Script Date: 13.05.2021 20:40:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[dodajFilm]
@nazwa varchar(50) ,
@rezyser varchar(50),
@gatunek varchar(50),
@dostepny varchar(10)
AS
SET NOCOUNT ON
BEGIN
insert into moviess values 
(@nazwa,@rezyser,@gatunek,@dostepny) 
end
```
<h1>Edycja Filmu</h1>
```sql
USE [MovieLibrary]
GO
/****** Object:  StoredProcedure [dbo].[edytujFilm]    Script Date: 13.05.2021 20:40:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[edytujFilm]
@id int,
@nazwa varchar(50),
@rezyser varchar(50),
@gatunek varchar(50),
@dostepny varchar(50)
as 
begin 
update moviess 
set nazwa=@nazwa, rezyser=@rezyser, gatunek=@gatunek, dostepny=@dostepny
where @id = ID;
end
```
<h1>Procedura Logowania</h1>
```sql
USE [MovieLibrary]
GO
/****** Object:  StoredProcedure [dbo].[logujMnie]    Script Date: 13.05.2021 20:40:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[logujMnie]
@nazwa varchar(50),
@haslo varchar(50)
as
begin
select * from logowanie where @nazwa = nazwa and @haslo=haslo
end
```
<h1>Procedura Pobierania Danych</h1>
```sql
USE [MovieLibrary]
GO
/****** Object:  StoredProcedure [dbo].[pobierzDane]    Script Date: 13.05.2021 20:41:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[pobierzDane]
as
begin
select * from moviess
end
```
<h1>Usuwanie Filmu</h1>
```sql
USE [MovieLibrary]
GO
/****** Object:  StoredProcedure [dbo].[usunFilm]    Script Date: 13.05.2021 20:41:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[usunFilm]
@id int
AS
SET NOCOUNT ON
BEGIN
delete from moviess where
(@id=ID) 
end
```
    </div>
