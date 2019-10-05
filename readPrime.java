package prime;
import java.io.*;
public class readPrime{
	public static void main(String args[]){
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
			int primeArray[]=new int[16252326];
			String line;int idx=0;
			primeArray[idx]=1;
			idx++;
			while(((line = br.readLine()) != null)){
				String cols[]=line.split(":");
				primeArray[idx]=Integer.parseInt(cols[1]);
				idx++;
			}
			br.close();

			System.out.println(primeArray[1]);
			System.out.println("finish read prime array[]");
			primeArray[1]=1;

			int plusBorder=150000000;

			int plusResult[]=new int[plusBorder+1];
			for(int i=0;i<=plusBorder;i++){
				plusResult[i]=0;
			}

			int borderPrimeIndex=16252325;int tempidx=0;

			for(int i=1;i<=borderPrimeIndex;i++){

				for(int j=i;j<=borderPrimeIndex;j++){
					tempidx=(primeArray[i]+primeArray[j])/2;
					if(tempidx<=plusBorder) plusResult[tempidx]++;
				}
				
				if(i%1000==0){System.out.println("prime port i="+i);}

			}


			FileOutputStream  fos = new FileOutputStream("3yiplus.dat");
            DataOutputStream  dos = new DataOutputStream(fos);

			for(int i=1;i<=plusBorder;i++){
				//System.out.println(i*2+":"+plusResult[i]);
				dos.writeInt(plusResult[i]);
			}			

			 fos.close();
			 dos.close();

		}catch(Exception e){
			System.out.println(e);
		}

	}

}