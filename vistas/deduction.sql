USE [employees]
GO

/****** Object:  View [dbo].[empDeduction]    Script Date: 17/5/2020 18:31:53 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE VIEW [dbo].[empDeduction]
AS
SELECT        dbo.deduction.emp_no, dbo.employees.first_name, dbo.employees.last_name, dbo.deduction.deduct_date,dbo.deduction.deduct_amount, dbo.deducttype.deduct_description,dbo.deducttype.deduct_type_no
FROM            dbo.deduction INNER JOIN
                         dbo.deducttype ON dbo.deduction.deduct_type_no = dbo.deducttype.deduct_type_no INNER JOIN
                         dbo.employees ON dbo.deduction.emp_no = dbo.employees.emp_no
GO
