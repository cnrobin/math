package prime;
import java.io.*;
public class writePrime10yi{

	public int primeArray[]=new int[3401];

	//caculate_max no more than 1000000000;
	public int caculate_max=1000000000;

	public int half_caculate_max=caculate_max/2;

	public void get_num(int ou_max_num){
			
			primeArray[0]=2;
			primeArray[1]=3;
			primeArray[2]=5;
			primeArray[3]=7;
			int num=4;

			for(int i=11;i<=ou_max_num;i=i+2){
				int iRoot=(int)Math.sqrt(i);
				int j=3;boolean f=true;
				while(j<=iRoot&&f==true){
					if(i%j==0){ f=false;}
					j=j+2;
				}
				if(f==true){
					primeArray[num]=i;
					num++;
					System.out.println(i);
				}
			}
			System.out.println("num="+num);
	}
	public void gen_10yi(){
		try{
			int jiArray[]=new int[half_caculate_max];
			String line;int idx=0;
			for(idx=0;idx<half_caculate_max;idx++){
				jiArray[idx]=0;
			}
			idx=1;
			int k;
			while(idx<3401){
				System.out.println("idx="+idx);
				k=caculate_max/primeArray[idx];
				for(int j=3;j<=k;j=j+2){
					jiArray[(primeArray[idx]*j-1)/2]=primeArray[idx];
				}
				idx++;
			}

			System.out.println("finish caculate!");

			FileOutputStream  fos = new FileOutputStream("prime10yi.dat");
            DataOutputStream  dos = new DataOutputStream(fos);

			for(idx=0;idx<half_caculate_max;idx++){
				if(jiArray[idx]==0){dos.writeInt(idx*2+1);}
			}			

			 fos.close();
			 dos.close();

		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static void main(String args[]){
		writePrime10yi wp=new writePrime10yi();
		wp.get_num(31624);//31624 is the sqrt of 1000000000; init the prime array;
		wp.gen_10yi();
	}

}