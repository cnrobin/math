package prime;
public class Test{
	public static DBbean bean;
	public static void main(String args[]){
		bean=new DBbean("postgres");
		//bean.execute("create table prime_num2(numid serial primary key,num int)");
		int index=1;
		for(int i=2;i<=100000;i++){
			int flag=0;
			for(int j=2;j<i;j++){
				if(i%j==0){ flag=1;}
			}
			if(flag==0){ 
				System.out.println(index+":"+i);
				index++;
				bean.execute("insert into prime_num(num) values("+i+")");
			}
		}
		bean.close();
	}

}

/*

--create table prime_num( num  int);

--select * from prime_num;

select * from prime_num limit 100;

update prime_num set num=1 where num=2;

select * into prime_num2 from prime_num

select prime_num.num as a1,prime_num2.num as a2 into prime_plus from prime_num,prime_num2

select * from prime_plus limit 100; 
alter table prime_plus add plus int;
update prime_plus set plus=a1+a2;
select * from prime_plus where plus = 10;
create index idx_prime_plus_01 on prime_plus(plus)

select * from prime_plus where plus = 14;

select * into prime_plus2 from prime_plus where a1<=a2

create index idx_prime_plus2_01 on prime_plus2 limit 1000(plus)
select * from prime_plus2 limit 1000

select * from prime_plus2 where plus=14 limit 1000

select plus,count(*) as cnt  into prime_plus_statics  from prime_plus2 group by plus order by plus asc

select * from prime_plus_statics limit 1000;

select * from prime_plus_statics where plus=1980

select * from prime_plus2 where plus=1980


*/