USE [employees]
GO

/****** Object:  View [dbo].[empBonus]    Script Date: 17/5/2020 18:31:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE VIEW [dbo].[empBonus]
AS
SELECT        [dbo].bonus.emp_no, dbo.employees.first_name, dbo.employees.last_name, dbo.bonus.bonus_date,dbo.bonus.bonus_amount, [dbo].bonustype.bonus_description, [dbo].bonus.bonus_type_no
FROM            [dbo].bonus INNER JOIN
                         dbo.employees ON [dbo].bonus.emp_no = dbo.employees.emp_no INNER JOIN
                         [dbo].bonustype ON [dbo].bonus.bonus_type_no = [dbo].bonustype.bonus_type_no
GO

