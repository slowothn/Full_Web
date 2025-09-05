/*

-- 일련번호 관리 객체
drop sequence seq_member_mem_idx
create sequence seq_member_mem_idx

-- member table
drop table member
create table member
(
	mem_idx int,							-- 회원번호
	mem_name 	varchar2(100) not null,		-- 회원명
	mem_id 		varchar2(100) not null,		-- 아이디
	mem_pwd 	varchar2(100) not null,		-- 비밀번호
	mem_email 	varchar2(100) not null,		-- 이메일
	mem_zipcode	varchar2(10),				-- 우편번호
	mem_addr	varchar2(200),				-- 주소 (open API 사용 예정)
	mem_ip		varchar2(100) not null,		-- ip
	mem_regdate date,						-- 가입일자
	mem_grade	varchar2(100)				-- 회원구분
)




-- 제약조건
-- 기본키
alter table member
add constraint pk_member_mem_idx primary key(mem_idx);

-- unique 제약
alter table member
add constraint unique_member_mem_id unique(mem_id);

-- grade는 일반 아니면 관리자 둘 중 하나만 가능
-- check 제약
alter table member
add constraint ck_member_mem_grade check(mem_grade in('일반','관리자'));


-- sample data
insert into member values( seq_member_mem_idx.nextVal,
							'일회원',
							'one',
							'1234',
							'one@githrd.com',
							'12345',
							'서울시 관악구 남부순환로 111',
							'192.168.111.53',
							sysdate,
							'일반'

);

-- DAO에 사용할 SQL
-- insert into member values( seq_member_mem_idx.nextVal, ?, ?, ?, ?, ?, ?, ?, sysdate, '일반');


insert into member values( seq_member_mem_idx.nextVal,
							'김관리',
							'admin',
							'1234',
							'admin@githrd.com',
							'12345',
							'서울시 관악구 남부순환로 111',
							'192.168.111.11',
							sysdate,
							'관리자'
);

-- 관리자는 특정 회원의 등급을 일반에서 관리자로 변경해주는 방식으로 지정

select * from member


select * from member where mem_idx=1
select * from member where mem_id='admin'



*/