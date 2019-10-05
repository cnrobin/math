package prime;
public class sortPrime
{
	public static void main(String args[]){
		
		int  primeArray[]=new int[10001];

		//int sort_num[]=new int 


		for(int i=0;i<=10000;i++){
			primeArray[i]=i;
		}
		int sort_seed=2;
		int sort_time=10000/sort_seed;
		int index=sort_seed;
		int fu_sort_seed=sort_seed*(-1);
		int sort_num=0;
		while(sort_seed<100){
			while(index<sort_time){
				if(primeArray[sort_seed*index]>0) {primeArray[sort_seed*index]=fu_sort_seed;sort_num++;}
				index++;

			}
			System.out.println("sort_seed:"+sort_seed+"----sort_num:"+sort_num);
			int j=sort_seed+1;
			while(primeArray[j]<0){
				j++;
			}
			sort_seed=primeArray[j];
			sort_time=10001/sort_seed;
			fu_sort_seed=sort_seed*(-1);
			index=sort_seed;

			 sort_num=0;
		}

		for(int i=0;i<=10000;i++){
			System.out.println(i+":"+primeArray[i]);
		}

		oushu=10000;
		ban=oushu/2;
		System.out.println("oushu="+oushu);
		for(int i=1;i<ban;i=i+2){
			
		}
		
	}
}