USE [employees]
GO

/****** Object:  View [dbo].[empDepartaments]    Script Date: 17/5/2020 18:32:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[empDepartaments]
AS
SELECT        dbo.dept_emp.emp_no, dbo.employees.first_name, dbo.employees.last_name, dbo.departments.dept_name, dbo.dept_emp.from_date, dbo.dept_emp.to_date
FROM            dbo.dept_emp INNER JOIN
                         dbo.employees ON dbo.dept_emp.emp_no = dbo.employees.emp_no INNER JOIN
                         dbo.departments ON dbo.dept_emp.dept_no = dbo.departments.dept_no
GO