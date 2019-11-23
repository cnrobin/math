package prime;
public class Test_insert_db{
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