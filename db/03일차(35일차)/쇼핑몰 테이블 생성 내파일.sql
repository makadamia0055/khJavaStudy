drop database if exists shoppingmall;
create database if not exists shoppingmall;
use shoppingmall;
create table member(
	id varchar(13) primary key, 
    pw varchar(20) not null,
    name varchar(20) not null,
    certificate boolean default false
);
create table product(
	pNum int primary key auto_increment,
    pName varchar(30) not null,
    pDetail longtext,
    price long not null,
    pSortNum int not null,
    foreign key(pSortNum) references productSort(pSortNum)
);
create table productSort(
	pSortNum int primary key auto_increment,
    pSortName varchar(30) not null
);

create table buyProduct(
	bPNum int primary key auto_increment,
    bPState varchar(10),
    bPAmount int not null, 
    bPTotalPrice long,
    address varchar(100) not null,
    postNum varchar(20) not null,
    id varchar(13), foreign key(id) references member(id),
    pNum int, foreign key(pNum) references product(pNum)
);

create table boardSort(
	bSNum int primary key auto_increment,
    bSName varchar(10) not null
);
create table board(
	bNum int primary key auto_increment,
    bTitle varchar(30) not null,
    bContents longtext,
    bDate timestamp not null,
    bView int default(0),
    bSNum int, foreign key(bSNum) references boardSort(bSNum),
    id varchar(13) not null, foreign key(id) references member(id)
    
);

create table ask(
	aNum int primary key auto_increment,
    aReply varchar(50),
    aState varchar(10),
    aPw varchar(20) not null,
    aContents longtext,
    id varchar(13), foreign key(id) references member(id),
    pNum int, foreign key(pNum) references product(pNum)
);