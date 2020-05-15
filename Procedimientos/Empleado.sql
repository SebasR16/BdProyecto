CREATE PROCEDURE [dbo].[getMaxEmp]
AS
BEGIN
	SELECT MAX (employees.emp_no) FROM  employees
END
GO