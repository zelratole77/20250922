
			
create table chart01(
				no number,
				type varchar2(50),
				data number,
				label varchar2(50)
			);
			
			create sequence chart01_seq;
			insert into chart01 values(chart01_seq.nextval,'area',50,'1월');
			insert into chart01 values(chart01_seq.nextval,'area',70,'2월');
			insert into chart01 values(chart01_seq.nextval,'area',70,'3월');
			insert into chart01 values(chart01_seq.nextval,'area',80,'4월');
			insert into chart01 values(chart01_seq.nextval,'area',90,'5월');
			insert into chart01 values(chart01_seq.nextval,'area',100,'6월');
			
			insert into chart01 values(chart01_seq.nextval,'area',80,'7월');
			insert into chart01 values(chart01_seq.nextval,'area',110,'8월');
			insert into chart01 values(chart01_seq.nextval,'area',120,'9월');
			insert into chart01 values(chart01_seq.nextval,'area',90,'10월');
			insert into chart01 values(chart01_seq.nextval,'area',100,'11월');
			insert into chart01 values(chart01_seq.nextval,'area',110,'12월');
			
			insert into chart01 values(chart01_seq.nextval,'bar',45,'1월');
			insert into chart01 values(chart01_seq.nextval,'bar',53,'2월');
			insert into chart01 values(chart01_seq.nextval,'bar',62,'3월');
			insert into chart01 values(chart01_seq.nextval,'bar',78,'4월');
			insert into chart01 values(chart01_seq.nextval,'bar',98,'5월');
			insert into chart01 values(chart01_seq.nextval,'bar',149,'6월');
			insert into chart01 values(chart01_seq.nextval,'bar',109,'7월');
			insert into chart01 values(chart01_seq.nextval,'bar',119,'8월');
			insert into chart01 values(chart01_seq.nextval,'bar',129,'9월');
			insert into chart01 values(chart01_seq.nextval,'bar',119,'10월');
			insert into chart01 values(chart01_seq.nextval,'bar',109,'11월');
			insert into chart01 values(chart01_seq.nextval,'bar',298,'12월');
			
			insert into chart01 values(chart01_seq.nextval,'pie',30,'직접방문');
			insert into chart01 values(chart01_seq.nextval,'pie',50,'추천방문');
			insert into chart01 values(chart01_seq.nextval,'pie',20,'SNS통한방문');
			
			
			
			
			