drop view report1;
create view report1 as 
  SELECT ROWNUM as rownumber, ctmr.first_name||' '||last_name as name, ctmr.passport_number,
    opr.sender_account_number, opr.recipient_account_number, 
    opr.amount, opr.payment_purpose, opr.operation_date, 0 as sert
  FROM
    customers ctmr 
    JOIN contracts ctr ON ctmr.id_customer=ctr.id_customer
    JOIN accounts acnt ON acnt.contract_number=ctr.contract_number
    JOIN operations opr ON opr.sender_account_number=acnt.account_number
  WHERE
    opr.amount > 3500000 AND
    opr.payment_purpose='Real estate';


select * from report1;