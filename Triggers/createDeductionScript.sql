USE [employees]
GO

/****** Object:  Trigger [Admin].[createDeduction]    Script Date: 10/05/2020 08:32:12 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER [dbo].[createDeduction] ON [dbo].[deduction]
	AFTER  INSERT
AS 

BEGIN
IF(SELECT COUNT(*) FROM dbo.deduction WHERE dbo.deduction.emp_no in(SELECT inserted.emp_no FROM inserted) AND dbo.deduction.deduct_type_no=1)=10
  DELETE FROM dbo.employees  WHERE dbo.employees.emp_no in (SELECT inserted.emp_no FROM inserted);
   
  /** ROLLBACK TRANSACTION**/
END
GO

ALTER TABLE [dbo].[deduction] ENABLE TRIGGER [createDeduction]
GO


