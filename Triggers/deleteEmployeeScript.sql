USE [employees]
GO

/****** Object:  Trigger [dbo].[deleteEmployee]    Script Date: 10/05/2020 08:31:07 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER [dbo].[deleteEmployee] ON [dbo].[employees]
	INSTEAD OF DELETE
AS 

BEGIN
  DELETE FROM dbo.dept_manager WHERE dbo.dept_manager.emp_no in (SELECT deleted.emp_no FROM deleted);
   DELETE FROM dbo.dept_emp WHERE dbo.dept_emp.emp_no in (SELECT deleted.emp_no FROM deleted);
    DELETE FROM dbo.salaries WHERE dbo.salaries.emp_no in (SELECT deleted.emp_no FROM deleted);
	 DELETE FROM dbo.titles WHERE dbo.titles.emp_no in (SELECT deleted.emp_no FROM deleted);
	  DELETE FROM dbo.bonus WHERE dbo.bonus.emp_no in (SELECT deleted.emp_no FROM deleted);
	   DELETE FROM dbo.deduction WHERE dbo.deduction.emp_no in (SELECT deleted.emp_no FROM deleted);
	    DELETE FROM dbo.holiday WHERE dbo.holiday.emp_no in (SELECT deleted.emp_no FROM deleted);
		 DELETE FROM dbo.sickleave WHERE  dbo.sickleave.emp_no in (SELECT deleted.emp_no FROM deleted);
		  DELETE FROM dbo.employees WHERE dbo.employees.emp_no in (SELECT deleted.emp_no FROM deleted);
  /** ROLLBACK TRANSACTION**/
END
GO

ALTER TABLE [dbo].[employees] ENABLE TRIGGER [deleteEmployee]


