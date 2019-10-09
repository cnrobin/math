package robin.math;
import java.util.*;

public class test_plus_10000{

	public int prime_n;
	public int prime_array[];
	public int prime_array_static[];
	public int prime_array_static2[];
	public int z_array[];
	public int z_length;

	public void init_data(){
		GetDBData g=new GetDBData();
		String sql="select p from prime3yi limit 26";
		List list2=g.get_prime(sql);
		g.close();
		System.out.println("list2="+list2);
		prime_n=list2.size();
		prime_array=new int[prime_n];
		prime_array_static=new int[prime_n];
		prime_array_static2=new int[prime_n];

		for (int i=0;i<prime_n;i++)
		{
			prime_array[i]=(int)list2.get(i);
			prime_array_static[i]=0;
			prime_array_static2[i]=0;
		}

		z_length=10000+1;
		z_array=new int[z_length];
		for(int i=0;i<z_length;i++){
			z_array[i]=i;
		}

		for(int i=4;i<z_length;i++){
			for(int j=1;j<prime_n;j++){
				if(z_array[i]%prime_array[j]==0){
					z_array[i]=prime_array[j];
					prime_array_static[j]++;
					break;
				}
			}
		}

/*check code
		for(int i=1;i<100000;i++){
			System.out.println("z_array["+i+"]="+z_array[i]);
		}

*/
		for(int i=1;i<prime_n;i++){
			System.out.println("prime_array_static["+i+"]="+prime_array[i]+":"+prime_array_static[i]);
		}
	}

	public void check_n(int n){
		if((n<=z_length)&&(n>=2)){
			int half_n=n/2;
			int count=0;
			for(int i=1;i<=half_n;i=i+2){
				if ((z_array[i]+z_array[n-i])==n)
				{
					//System.out.println(z_array[i]+"+"+z_array[n-i]+"="+n);
					count++;
				}else{
					if(z_array[i]!=i){
						int k=1;
						while(prime_array[k]!=z_array[i]) k++;
						prime_array_static2[k]++;
						//System.out.println(z_array[i]+"+"+z_array[n-i]+"!="+n+",cause by "+z_array[i]);
					}else{
						int k=1;
						int temp=n-i;
						while(prime_array[k]!=z_array[temp]) k++;
						prime_array_static2[k]++;
						//System.out.println(z_array[i]+"+"+z_array[n-i]+"!="+n+",cause by "+z_array[temp]);
					}

				}

			}

			System.out.println("The counter is "+count);


			prime_array_static2[1]=n/4;

			int n_sqrt=(int)Math.sqrt(n);

			for(int i=1;i<prime_n;i++){

				//System.out.println("prime_array_static2["+i+"]="+prime_array[i]+":"+prime_array_static2[i]);
				if(prime_array[i]<=n_sqrt){
					System.out.println("--:"+n+":"+prime_array[i]+":"+prime_array_static2[i]);
	//				prime_array_static2[i]=0£»
				}else{
					break;
				}

			}
			System.out.print("e:"+n+":"+n/2);
			int check_int=n/2;

			for (int i=1;i<prime_n;i++)
			{
				if(prime_array[i]<=n_sqrt){
					System.out.print("-"+prime_array_static2[i]);
					check_int=check_int-prime_array_static2[i];
					prime_array_static2[i]=0;
				}else{
					break;
				}

			}
			System.out.println("="+check_int);
			if(check_int==count){
				System.out.println("check_int = count");
			}else{
				System.out.println("check_int <> count");
			}
		}else{

			System.out.println("n is not correct.");

		}

	}


	public static void main(String args[]){

		test_plus_10000 t=new test_plus_10000();
		t.init_data();
		//t.check_n(432);
		for (int i=2;i<=10000;i=i+2 )
		{
			t.check_n(i);
		}

	}



}