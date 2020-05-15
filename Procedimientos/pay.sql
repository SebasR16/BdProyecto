CREATE  PROCEDURE [dbo].[getMaxPay_no]
AS
BEGIN
	SELECT MAX (payhistory.pay_no) FROM payhistory
END
GO