CREATE PROCEDURE [dbo].[getdeduction]
AS
BEGIN
	SELECT deduct_description FROM deducttype
END
GO