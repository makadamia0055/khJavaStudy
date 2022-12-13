drop database if exists newshoppingmall;
Create database if not exists newshoppingmall;
use newshoppingmall;
Create table if not exists member(ME_ID varchar(15) primary key, ME_PW varchar(15) not null, ME_name varchar(10) not null, ME_birth date not null, ME_authority varchar(6) default('MEMBER'), me_point int not null default(0));

Create table if not exists product_topsort(pts_num int auto_increment primary key, pts_name varchar(20) not null);
Create table if not exists product_middlesort(pms_num int auto_increment primary key, pms_name varchar(20) not null, pms_pts_num int not null, constraint fk_pms_pts_num foreign key(pms_pts_num) references product_topsort(pts_num));

Create table if not exists product(pd_Num int auto_increment primary key, pd_name varchar(30) not null, pd_detail longtext, pd_amount int not null, pd_price int not null, pd_pms_num int not null, 
constraint fk_pd_pms_num foreign key(pd_pms_num) references product_middlesort(pms_num));

create table if not exists product_option(po_num int auto_increment primary key, po_name varchar(30) not null, po_amount int not null, po_pd_num int not null, 
constraint fk_po_pd_num foreign key(po_pd_num) references product(pd_num));

create table if not exists address(ad_num int auto_increment primary key, ad_name varchar(20) not null, ad_ad1 varchar(100) not null, ad_ad2 varchar(100) not null, ad_postnum varchar(10) not null, ad_me_id varchar(15) not null,
constraint fk_ad_me_id foreign key(ad_me_id) references member(me_id));

create table if not exists buy(bu_num int primary key, bu_state varchar(10) not null, bu_totalprice int not null, bu_InPoint int not null default(bu_totalprice/10), bu_OutPoint int default(0), bu_rstPrice int default(bu_totalprice - bu_OutPoint), bu_me_id varchar(15) not null, bu_ad_num int not null,
constraint fk_bu_me_id foreign key(bu_me_id) references member(me_id),
constraint fk_bu_ad_num foreign key(bu_ad_num) references address(ad_num)); 

create table if not exists buy_list(bl_num int primary key auto_increment, bl_amount int not null, bl_price int not null, bl_bu_num int not null, bl_po_num int not null,
constraint fk_bl_bu_num foreign key(bl_bu_num) references buy(bu_num),
constraint fk_bl_po_num foreign key(bl_po_num) references product_option(po_num)); 

create table if not exists cart(ct_num int primary key auto_increment, ct_amount int not null, ct_po_num int not null, ct_me_id varchar(15) not null,
constraint fk_ct_me_id foreign key(ct_me_id) references member(me_id),
constraint fk_ct_po_num foreign key(ct_po_num) references product_option(po_num)); 

create table if not exists product_ask(pa_num int primary key auto_increment, pa_reply int, pa_state varchar(10) not null default('대기중'), pa_pw varchar(15) not null, pa_contents longtext not null, pa_me_id varchar(15) not null, pa_pd_num int not null,
constraint fk_pa_me_id foreign key(pa_me_id) references member(me_id),
constraint fk_pa_pd_num foreign key(pa_pd_num) references product(pd_num)); 

