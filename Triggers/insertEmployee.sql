USE [ejemplo]
GO

/****** Object:  Trigger [dbo].[insertEmployee]    Script Date: 17/05/2020 04:28:03 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER [dbo].[insertEmployee] ON [dbo].[employees]
	After INSERT
AS 

BEGIN
INSERT INTO [dbo].[salaries] ([emp_no],[salary],[from_date],[to_date]) VALUES ((SELECT inserted.emp_no FROM inserted) ,40000,GETDATE(),(SELECT DATEADD(YEAR,4,GETDATE())));
  /** ROLLBACK TRANSACTION**/
END
GO

ALTER TABLE [dbo].[employees] ENABLE TRIGGER [insertEmployee]
GO

