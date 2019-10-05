package prime;
public class sortPrime2
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

		int jishu_array[]=new int[10000];
		for(int i=0;i<10000;i++){
			jishu_array[i]=0;
		}

		int oushu=10000;
		int ban=oushu/2;

		while(sort_seed<100){
			while(index<=sort_time){
				int now_index=sort_seed*index;
				if(primeArray[now_index]>0) {
					primeArray[now_index]=fu_sort_seed;
					sort_num++;
					if(now_index<ban){ jishu_array[sort_seed]++;}
				}
				index++;

			}
			System.out.println("sort_seed:"+sort_seed+"----sort_num:"+sort_num);

			for(int i=0;i<=200;i++){
				System.out.print(primeArray[i]+";");
			}

			System.out.println("=======================\n");
			

			int j=sort_seed+1;
			while(primeArray[j]<0){
				j++;
			}
			sort_seed=primeArray[j];
			sort_time=10000/sort_seed;
			fu_sort_seed=sort_seed*(-1);
			index=sort_seed;

			 sort_num=0;
		}

		/*for(int i=0;i<=10000;i++){
			System.out.println(i+":"+primeArray[i]);
		}*/


		System.out.println("oushu="+oushu);

		for(int i=ban+1;i<10000;i=i+2){
			if(primeArray[10000-i]>0){
				if(primeArray[i]<0){
					jishu_array[-primeArray[i]]++;
				}
			}
			
		}
		/*for(int i=0;i<10000;i++){
			if(jishu_array[i]>0) System.out.println("jishu_array["+i+"]="+jishu_array[i]);
		}*/
	}
}