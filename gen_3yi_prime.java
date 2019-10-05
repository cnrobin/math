package robin.math;
import java.io.*;
public class gen_3yi_prime{
	public void test1(){
		try{
			String outputFile="test_result.txt";				
			//DataOutputStream outputStream=new FileDataOutputStream(outputFile);				
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile));
//			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream( b ) ;
			//int byteRead=2147483646;
			int byteRead=0;
			outputStream.writeInt(byteRead);		
			outputStream.close();				
			return;			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public void test2(){
				// TODO Auto-generated method stub		
		try{
			String inputFile="C:\\Users\\Administrator\\Desktop\\test.pcm";		
			String outputFile="C:\\Users\\Administrator\\Desktop\\test_result.pcm";				
			InputStream inputStream=new FileInputStream(inputFile);		
			OutputStream outputStream=new FileOutputStream(outputFile);				
			int byteRead;		
			while((byteRead=inputStream.read()) != -1){			
				outputStream.write(byteRead);		
			}		
			inputStream.close();		
			outputStream.close();				
			return;			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public void test3(){
		try{
			String outputFile="test_3yi_prime.txt";				
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile));
			int byteRead=1;
			outputStream.writeInt(byteRead);		
			 byteRead=2;
			outputStream.writeInt(byteRead);		
			 byteRead=3;
			outputStream.writeInt(byteRead);		
			 byteRead=5;
			outputStream.writeInt(byteRead);
			 byteRead=7;
			outputStream.writeInt(byteRead);			
	

			for(int i=11;i<=300000000;i=i+2){
				int iRoot=(int)Math.sqrt(i);
				boolean f=true;int j=3;
				while(j<=iRoot&&f==true){
					if(i%j==0){
						f=false;
					}
					j=j+2;
				}
				if(f==true) {
					outputStream.writeInt(byteRead);
				}
			}
			outputStream.close();				
			return;			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public void test5(){
		try{
			String inputFile="test_3yi_prime.txt";				
			String outputFile="test_3yi_prime_txt.txt";				
			DataInputStream inputStream = new DataInputStream(new FileInputStream(inputFile));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
			int byteRead=1;
			while(inputStream.available()>0){
				byteRead=inputStream.readInt();
				bw.write(byteRead+"\n");
			}
			bw.close();
			inputStream.close();
			return;			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public void test4(){
		int iRoot=(int) Math.sqrt(17);
		System.out.println(iRoot);
	}
	public static void main(String[] args) {		
		gen_3yi_prime t=new gen_3yi_prime();
		t.test5();
	}
}


