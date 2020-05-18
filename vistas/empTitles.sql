USE [employees]
GO

/****** Object:  View [dbo].[empTitles]    Script Date: 17/5/2020 18:34:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[empTitles]
AS
SELECT        dbo.titles.emp_no, dbo.employees.first_name, dbo.employees.last_name, dbo.titles.title, dbo.titles.from_date, dbo.titles.to_date
FROM            dbo.employees INNER JOIN
                         dbo.titles ON dbo.employees.emp_no = dbo.titles.emp_no
GO