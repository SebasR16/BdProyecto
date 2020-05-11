USE [ejemplo]
GO

/****** Object:  Trigger [dbo].[insertManager]    Script Date: 10/05/2020 08:33:39 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER [dbo].[insertManager] ON [dbo].[dept_manager]
	After INSERT
AS 

BEGIN
INSERT INTO [dbo].[salaries] ([emp_no],[salary],[from_date],[to_date]) VALUES ((SELECT inserted.emp_no FROM inserted) ,100000,GETDATE(),(SELECT DATEADD(YEAR,4,GETDATE())));
  /** ROLLBACK TRANSACTION**/
END
GO

ALTER TABLE [dbo].[dept_manager] ENABLE TRIGGER [insertManager]
GO

