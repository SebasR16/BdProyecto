USE [employees]
GO

/****** Object:  View [dbo].[managerDepartments]    Script Date: 17/5/2020 18:35:23 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[managerDepartments]
AS
SELECT        dbo.employees.emp_no, dbo.employees.first_name, dbo.employees.last_name, dbo.departments.dept_name, dbo.dept_manager.from_date, dbo.dept_manager.to_date
FROM            dbo.employees INNER JOIN
                         dbo.dept_manager ON dbo.employees.emp_no = dbo.dept_manager.emp_no INNER JOIN
                         dbo.departments ON dbo.dept_manager.dept_no = dbo.departments.dept_no
GO


