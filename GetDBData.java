package robin.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.*;
import robin.math.DBbean;
public class GetDBData {
	public DBbean bean;
	GetDBData(){
		 bean=new DBbean("postgres");
	}
	public  List get_prime(){
		System.out.println("prime3yi");
		List list1=new ArrayList();
		try{								
				ResultSet rs;
	  	 		rs=bean.executeQuery("select p from prime3yi limit 26");
				while(rs.next()){
					//String p=rs.getString(1).trim();
					int p=rs.getInt(1);
					System.out.println(p);
					list1.add(p);
				}
				rs.close();
		}catch(Exception e){
			//System.out.println(err);
			System.out.println(e);
		}
		return list1;
	}
	public void close(){
		bean.close();

	}
	public static void main(String args[]){
		GetDBData g=new GetDBData();
		List list2=g.get_prime();
		g.close();
		System.out.println("list2="+list2);
		int prime_n=list2.size();
		int prime_array[]=new int[prime_n];
		int prime_array_static[]=new int[prime_n];
		for (int i=0;i<prime_n;i++)
		{
			prime_array[i]=(int)list2.get(i);
			prime_array_static[i]=0;
		}
		for( int i=0;i<prime_n;i++){
			System.out.println("prime["+i+"]="+prime_array[i]);
		}
		int z_array[]=new int[10001];
		for(int i=0;i<=10000;i++){
			z_array[i]=i;
		}
		for(int i=4;i<=10000;i++){
			for(int j=1;j<prime_n;j++){
				if(z_array[i]%prime_array[j]==0){
					z_array[i]=prime_array[j];
					prime_array_static[j]++;
					break;
				}
			}
		}
		for(int i=1;i<10000;i++){
			System.out.println("z_array["+i+"]="+z_array[i]);
		}
		for(int i=1;i<prime_n;i++){
			System.out.println("prime_array_static["+i+"]="+prime_array_static[i]);
		}
	}
}