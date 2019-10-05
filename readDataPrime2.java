package prime;
import java.io.*;
public class readDataPrime2{
	public static void main(String args[]){
		try{

			DBbean bean=new DBbean("postgres");
			//BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("3yiplus_asci.txt")));
			FileInputStream  fos = new FileInputStream("3yiplus.dat");
            DataInputStream  dos = new DataInputStream(fos);
			int p=0;int i=1;String sql="";
			//for(int i=1;i<=100;i++){
			while(dos.available()>0){
				p=dos.readInt();
				sql="insert into threeyi_plus values("+i*2+","+p+")";
				bean.execute(sql);
				//System.out.println(i*2+":"+p);				
			//	bw.write(i*2+":"+p+"\n");
				if(i%1000==0) System.out.println("now i is:"+i);
				i++;
				
			}			

			 fos.close();
			 dos.close();
			// bw.close();
			bean.close();
		}catch(Exception e){
			System.out.println(e);
		}

	}

}