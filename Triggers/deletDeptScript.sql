USE [ejemplo]
GO

/****** Object:  Trigger [dbo].[deleteDepartament]    Script Date: 10/05/2020 08:33:08 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER [dbo].[deleteDepartament] ON [dbo].[departments]
	INSTEAD OF DELETE
AS 

BEGIN
  DELETE FROM dbo.dept_manager WHERE dbo.dept_manager.dept_no in (SELECT deleted.dept_no FROM deleted);
   DELETE FROM dbo.dept_emp WHERE dbo.dept_emp.dept_no in (SELECT deleted.dept_no FROM deleted);
    
  /** ROLLBACK TRANSACTION**/
END
GO

ALTER TABLE [dbo].[departments] ENABLE TRIGGER [deleteDepartament]
GO

