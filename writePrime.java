package prime;
import java.io.*;
public class writePrime{
	public static void main(String args[]){
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\myjava\\prime\\prime_divident.txt")));
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

			System.out.println("finish read prime array[]");

			FileOutputStream  fos = new FileOutputStream("3yiprime.dat");
            DataOutputStream  dos = new DataOutputStream(fos);

			for(int i=1;i<=16252325;i++){
				dos.writeInt(primeArray[i]);
			}			

			 fos.close();
			 dos.close();

		}catch(Exception e){
			System.out.println(e);
		}

	}

}