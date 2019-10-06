package robin.math;
import java.util.*;
public class testZ100000shuaifa{
	public static void main(String args[]){
		GetDBData g=new GetDBData();
		String sql="select p from prime3yi limit 66";
		List list2=g.get_prime(sql);
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
		int z_array[]=new int[100001];
		for(int i=0;i<=100000;i++){
			z_array[i]=i;
		}
		for(int i=4;i<=100000;i++){
			for(int j=1;j<prime_n;j++){
				if(z_array[i]%prime_array[j]==0){
					z_array[i]=prime_array[j];
					prime_array_static[j]++;
					break;
				}
			}
		}
		for(int i=1;i<100000;i++){
			System.out.println("z_array["+i+"]="+z_array[i]);
		}
		for(int i=1;i<prime_n;i++){
			System.out.println("prime_array_static["+i+"]="+prime_array_static[i]);
		}
	}
}