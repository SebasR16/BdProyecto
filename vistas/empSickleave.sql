USE [employees]
GO

/****** Object:  View [dbo].[empSickleave]    Script Date: 17/5/2020 18:34:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE VIEW [dbo].[empSickleave]
AS
SELECT        dbo.sickleave.emp_no, dbo.employees.first_name, dbo.employees.last_name, dbo.sickleave.start_date, dbo.sickleave.end_date,dbo.sickleave.reason
FROM            dbo.sickleave INNER JOIN
                         dbo.employees ON dbo.sickleave.emp_no = dbo.employees.emp_no
GO