package robin.math;
import java.io.*;
public class AppendLog
{
	public static void  main(String args[]){
		AppendLog.appendMethodB("C:\\myjava\\robin\\math\\sql_error.sql","test third line\r\n");
	}
	public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}