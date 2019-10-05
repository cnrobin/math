import java.io.*;
public class test10000000sum
{
	public void test2(){
		try{
			DataInputStream in=new DataInputStream(new FileInputStream("test_bin_prime.dat"));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test_txt_prime.txt")));
			int iread;
			while(in.available()>0){
				iread=in.readInt();
				bw.write(iread+"\n");
			}
			bw.close();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void test1(){
		try{
			DataOutputStream out1=new DataOutputStream(new FileOutputStream("test_out1_prime.dat"));
			DataOutputStream out2=new DataOutputStream(new FileOutputStream("test_out2_prime.dat"));
			out1.writeInt(1);
			out1.writeInt(2);
			out1.writeInt(3);
			out1.writeInt(5);
			out1.writeInt(7);
			for(int i=11;i<=10000;i=i+2){
				int iRoot=(int)Math.sqrt(i);
				int j=3;boolean f=true;
				while(j<=iRoot&&f==true){
					if(i%j==0){ f=false;}
					j=j+2;
				}
				if(f==true){
					out1.writeInt(i);
				}
			}
			out1.close();
			out2.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public void test(){
		try{
			int su_array_num=664579;
			int ou_array_num=5000000;
			int ou_max_num=ou_array_num*2;
			int su[]=new int[su_array_num];
			su[0]=2;
			su[1]=3;
			su[2]=5;
			su[3]=7;
			int num=4;
			for(int i=11;i<=ou_max_num;i=i+2){
				int iRoot=(int)Math.sqrt(i);
				int j=3;boolean f=true;
				while(j<=iRoot&&f==true){
					if(i%j==0){ f=false;}
					j=j+2;
				}
				if(f==true){
					//System.out.println(i);
					su[num]=i;
					num++;
				}
			}
			System.out.println("num="+num);
			int oun[]=new int[ou_array_num+1];
			for(int i=0;i<=ou_array_num;i++){
				oun[i]=0;
			}
			int sum=0;
			for(int i=1;i<su_array_num;i++){
				for(int j=i+1;j<su_array_num;j++){
					sum=su[i]+su[j];
					if(sum<=ou_max_num) { oun[sum/2]++;}
				}
			}
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test_10000000_sum.txt")));
			for(int i=0;i<=ou_array_num;i++){
//				System.out.println("oun["+i*2+"]="+oun[i]);
				bw.write(oun[i]+"\n");
				if(oun[i]==0){System.out.println("oun["+i*2+"]="+oun[i]);}
			}
			bw.close();
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public void get_num(int ou_max_num){

			int num=4;
			for(int i=11;i<=ou_max_num;i=i+2){
				int iRoot=(int)Math.sqrt(i);
				int j=3;boolean f=true;
				while(j<=iRoot&&f==true){
					if(i%j==0){ f=false;}
					j=j+2;
				}
				if(f==true){
					num++;
				}
			}
			System.out.println("num="+num);
	}
	public static void main(String args[]){
		test10000000sum t=new test10000000sum();
		//t.test1();
		t.test();
		//t.get_num(10000000);
	}
}
