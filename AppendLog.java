package robin.math;
import java.io.*;
public class AppendLog
{
	public static void  main(String args[]){
		AppendLog.appendMethodB("C:\\myjava\\robin\\math\\sql_error.sql","test third line\r\n");
	}
	public static void appendMethodB(String fileName, String content) {
        try {
            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}