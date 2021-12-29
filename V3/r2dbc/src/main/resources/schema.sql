-- changed the schema to Mark's form
drop table account if exists;
-- changed the columns to id, account number, owner name, and balance, changed the data type of balance to long
create table account (ID bigint identity PRIMARY KEY, NUMBER varchar(9),
                        NAME varchar(50) not null, BALANCE long(255));
                        
ALTER TABLE account ALTER COLUMN BALANCE SET DEFAULT 0.0;