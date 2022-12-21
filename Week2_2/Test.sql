-- T?o b?ng
create table campus
(
    campusID varchar2(5) not null,
    campusName varchar2(100),
    street varchar2(100),
    city varchar2(100),
    state varchar2(100),
    Zip varchar2(100),
    Phone varchar2(100),
    campusDiscount decimal(2,2),
    CONSTRAINT campus_pk Primary key (campusID)
)

create table position
(
    positionID varchar2(5) not null,
    position varchar2(100),
    YearlyMembershipFee DECIMAL (7,2),
    CONSTRAINT position_pk primary key (positionID)
)

create table members
(
    MemberID varchar2(5) not null,
    LastName varchar2(100),
    FirstName varchar2(100),
    CampusAddress varchar2(100),
    CampusPhone varchar2(100),
    CampusID varchar2(5),
    PositionID varchar2(5),
    ContractDuration INTEGER,
    CONSTRAINT members_pk Primary key (MemberID),
    CONSTRAINT fk_campus foreign key (CampusID) REFERENCES campus (CampusID),
    CONSTRAINT fk_position foreign key (PositionID) REFERENCES position (PositionID)
)

create table Prices
(
    FoodItemTypeID number(5) not null,
    MealType varchar2(100),
    MealPrice decimal(7,2),
    constraint prices_pk primary key (FoodItemTypeID)
)

create table FoodItems
(
    FoodItemID varchar2(5) not null,
    FoodItemName varchar2(100),
    FoodItemTypeID number(5),
    constraint fooditems_pk primary key (FoodItemID),
    constraint fk_prices foreign key (FoodItemTypeID) references Prices (FoodItemTypeID)
)

create table Orders
(
    OrderID varchar2(5),
    MemberID varchar2(5),
    OrderDate varchar2(25),
    constraint orders_pk primary key (OrderID),
    constraint fk_members foreign key (MemberID) references Members (MemberID)
)

create table OrderLine
(
    OrderID varchar2(5) not null,
    FoodItemsID varchar2(5) not null,
    Quatity integer,
    constraint orderline_pk primary key (OrderID, FoodItemsID),
    constraint fk_orders foreign key (OrderID) references Orders (OrderID),
    constraint fk_fooditems foreign key (FoodItemsID) references FoodItems (FoodItemID)
);

--T?o Sequence
create sequence Prices_FoodItemTypeID_SEQ
    minvalue 0
    start with 1
    increment by 1
    nocache;
    
drop sequence Prices_FoodItemTypeID_SEQ
    
--Insert d? li?u
--table Campus
insert all 
    into campus values ('1','IUPUI','425 University Blvd.','Indianapolis', 'IN','46202', '317-274-4591',.08)
    into campus values ('2','Indiana University','107 S. Indiana Ave.','Bloomington', 'IN','47405', '812-855-4848',.07)
    into campus values ('3','Purdue University','475 Stadium Mall Drive','West Lafayette', 'IN','47907', '765-494-1776',.06)
select * from dual;

--table Position
insert all 
    into position values ('1','Lecturer', 1050.50)
    into position values ('2','Associate Professor', 900.50)
    into position values ('3','Assistant Professor', 875.50)
    into position values ('4','Professor', 700.75)
    into position values ('5','Full Professor', 500.50)
select * from dual;

--table Member
insert all 
    into members values ('1','Ellen','Monk','009 Purnell', '812-123-1234', '2', '5', 12)
    into members values ('2','Joe','Brady','008 Statford Hall', '765-234-2345', '3', '2', 10)
    into members values ('3','Dave','Davidson','007 Purnell', '812-345-3456', '2', '3', 10)
    into members values ('4','Sebastian','Cole','210 Rutherford Hall', '765-234-2345', '3', '5', 10)
    into members values ('5','Michael','Doo','66C Peobody', '812-548-8956', '2', '1', 10)
    into members values ('6','Jerome','Clark','SL 220', '317-274-9766', '1', '1', 12)
    into members values ('7','Bob','House','ET 329', '317-278-9098', '1', '4', 10)
    into members values ('8','Bridget','Stanley','SI 234', '317-274-5678', '1', '1', 12)
    into members values ('9','Bradley','Wilson','334 Statford Hall', '765-258-2567', '3', '2', 10)
select * from dual;

--table Prices
insert into prices values (Prices_FoodItemTypeID_SEQ.NEXTVAL,'Beer/Wine', 5.50);
insert into prices values (Prices_FoodItemTypeID_SEQ.NEXTVAL,'Dessert', 2.75);
insert into prices values (Prices_FoodItemTypeID_SEQ.NEXTVAL,'Dinner', 15.50);
insert into prices values (Prices_FoodItemTypeID_SEQ.NEXTVAL,'Soft Drink', 2.50);
insert into prices values (Prices_FoodItemTypeID_SEQ.NEXTVAL,'Lunch', 7.25);

--table FoodsItem
insert all 
    into FoodItems values ('10001','Lager', 1)
    into FoodItems values ('10002','Red Wine', 1)
    into FoodItems values ('10003','White Wine', 1)
    into FoodItems values ('10004','Coke', 4)
    into FoodItems values ('10005','Coffee', 4)
    into FoodItems values ('10006','Chicken a la King', 3)
    into FoodItems values ('10007','Rib Steak', 3)
    into FoodItems values ('10008','Fish and Chips', 3)
    into FoodItems values ('10009','Veggie Delight', 3)
    into FoodItems values ('10010','Chocolate Mousse', 2)
    into FoodItems values ('10011','Carrot Cake', 2)
    into FoodItems values ('10012','Fruit Cup', 2)
    into FoodItems values ('10013','Fish and Chips', 5)
    into FoodItems values ('10014','Angus Beef Burger', 5)
    into FoodItems values ('10015','Cobb Salad', 5)
select * from dual;

--table Orders
insert all 
    into Orders values ('1', '9', 'March 5, 2005')
    into Orders values ('2', '8', 'March 5, 2005')
    into Orders values ('3', '7', 'March 5, 2005')
    into Orders values ('4', '6', 'March 7, 2005')
    into Orders values ('5', '5', 'March 7, 2005')
    into Orders values ('6', '4', 'March 10, 2005')
    into Orders values ('7', '3', 'March 11, 2005')
    into Orders values ('8', '2', 'March 12, 2005')
    into Orders values ('9', '1', 'March 13, 2005')
select * from dual;


--table OrderLine
insert into OrderLine values ('1','10001', 1);
insert into OrderLine values ('1','10006', 1);
insert into OrderLine values ('1','10012', 1);
insert into OrderLine values ('2','10004', 2);
insert into OrderLine values ('2','10013', 1);
insert into OrderLine values ('2','10014', 1);
insert into OrderLine values ('3','10005', 1);
insert into OrderLine values ('3','10011', 1);
insert into OrderLine values ('4','10005', 2);
insert into OrderLine values ('4','10004', 2);
insert into OrderLine values ('4','10006', 1);
insert into OrderLine values ('4','10007', 1);
insert into OrderLine values ('4','10010', 2);
insert into OrderLine values ('5','10003', 1);
insert into OrderLine values ('6','10002', 2);
insert into OrderLine values ('7','10005', 2);
insert into OrderLine values ('8','10005', 1);
insert into OrderLine values ('8','10011', 1);
insert into OrderLine values ('9','10001', 1);

--Bài 3: Vi?t l?nh truy v?n theo yêu c?u
--Câu 1: Li?t kê t?t c? constraint trong db
select *
from user_cons_columns;

--Câu 2: Li?t kê t?t c? tên b?ng trong database
select table_name
from user_tables;

--Câu 3: Li?t kê tên t?t c? các sequence trong db
select sequence_name
from all_sequences;

--Câu 4: ...
select m.firstname, m.lastname, c.campusname, (p.YearlyMembershipFee / 12) * m.contractduration as Month_Dues
from members m, position p, campus c
where m.positionID = p.positionID and m.campusid = c.campusid
order by c.campusname DESC, m.lastname ASC





