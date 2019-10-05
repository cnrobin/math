package prime;
import java.io.*;
public class primeDivident
{
	public 			int plusBorder;		
	public			int primeidx;

	public			long l;

	public			long long_queue[];

	public			int queueidx;

	public	int primeArray[];

	public BufferedWriter bw;

	public primeDivident(){
		
		try{
	        bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\myjava\\3yidivident.txt")));
		}catch(Exception e){
			System.out.println(e);
		}
		long_queue=new long[33];
		for(int i=0;i<33;i++){
			long_queue[i]=0;
		}
		plusBorder	= 10000001;
		primeidx = 664580;
		l=1;
		primeArray=new int[16252326];//16252326
		queueidx=0;
	}
	public void close(){
		try{
	        bw.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void do_something(int p){
		//System.out.println("l="+l);
		l=l*p;
		if ( l > plusBorder)
		{
			l=l/p;
			return ;
		}
		if ( queueidx+1> 32 )	{
			System.out.print("queue is over load.");
			return;
		}

		queueidx++;
		long_queue[queueidx]=p;

		String s=l+"="+p;
//		System.out.print(s);
		for(int i=queueidx;i>1;i--){
			s=s+"*"+long_queue[i-1];
//			System.out.print(s);

		}
		s=s+"\n";
		//System.out.print(s);

		try{
	        bw.write(s);
			bw.flush();
		}catch(Exception e){
			System.out.println(e);
		}


		int start_idx=1;

		for(int i=1;i<=primeidx;i++){
			if(p==primeArray[i]) start_idx=i;
		}

		for(int i=start_idx;i<=primeidx;i++){
			do_something(primeArray[i]);
		}
        l=l/p;
		queueidx--;
	}

	public void start_job(){
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\myjava\\prime\\prime_divident.txt")));

			String line;int idx=0;
			primeArray[idx]=1;
			idx++;
			while(((line = br.readLine()) != null)||(idx<664581)){
				String cols[]=line.split(":");
				primeArray[idx]=Integer.parseInt(cols[1]);
				idx++;
			}
			br.close();

			System.out.println("finish read prime array[]");

			for(int i=1;i<=primeidx;i++){
				System.out.println("first loop.p="+primeArray[i]);
				do_something(primeArray[i]);

			}
	


		}catch(Exception e){
			System.out.println(e);
		}

	}


	public  static void main(String args[]){
		primeDivident pd=new primeDivident();
		pd.start_job();
		pd.close();
	}
}