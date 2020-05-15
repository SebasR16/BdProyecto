CREATE PROCEDURE [dbo].[getMaxCheck]
AS
BEGIN
	SELECT MAX (payhistory.check_number) FROM payhistory
END
GO