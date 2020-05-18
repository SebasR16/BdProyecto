USE [employees]
GO

/****** Object:  View [dbo].[empSalaries]    Script Date: 17/5/2020 18:33:26 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[empSalaries]
AS
SELECT        dbo.salaries.emp_no, dbo.employees.first_name, dbo.employees.last_name, dbo.salaries.salary, dbo.salaries.from_date, dbo.salaries.to_date
FROM            dbo.salaries INNER JOIN
                         dbo.employees ON dbo.salaries.emp_no = dbo.employees.emp_no
GO