package robin.math;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.io.InputStream;
import java.sql.Timestamp;
public class DBbean {
    private static String propertyFileName;
    private static ResourceBundle resourceBundle;	
    
	public java.sql.Connection conn = null; //connection object
	public ResultSet rs = null; //resultset object
	public Statement stmt = null; //statement object
	public PreparedStatement prepstmt = null; //preparedstatement object
	private String drivers = null; //connection parameter:drivers
	private String url = null; //connection parameter:url
	private String user = null; //connection parameter:user
	private String password = null; //connection parameter:password
	private int debug =0;
    //public AppendLog al;
    public static String getConfigString(String key) {
        propertyFileName = "robin/math/SysConfig";
        resourceBundle = ResourceBundle.getBundle(propertyFileName);    	
        if (key == null || key.equals("") || key.equals("null")) {
            return "";
        }
        String result = "";
        try {
            result = resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }
        return result;
    }
	public DBbean(String dbname){
		try{
			//parameter init
			//System.out.println(dbname);
			System.out.println("dbname="+dbname);
			if(dbname.equals("sqlserver")){
				drivers = DBbean.getConfigString("drivers");
				url = DBbean.getConfigString("url");
				user = DBbean.getConfigString("user");
				password = DBbean.getConfigString("password");
			}else{
				if(dbname.equals("postgresql02")){
					drivers = DBbean.getConfigString("pg02_drivers");
					url = DBbean.getConfigString("pg02_url");
					user = DBbean.getConfigString("pg02_user");
					password = DBbean.getConfigString("pg02_password");
				}else{
					drivers = DBbean.getConfigString("pg_drivers");
					url = DBbean.getConfigString("pg_url");
					user = DBbean.getConfigString("pg_user");
					password = DBbean.getConfigString("pg_password");
				}
			}
			debug= Integer.parseInt(DBbean.getConfigString("debug"));
			//jndi_name = CommonParam.getString("jndi_name");
			
			//db connection pool init
			//InitialContext env = new InitialContext();
			//javax.sql.DataSource pool = (javax.sql.DataSource)env.lookup(jndi_name);
			//conn = pool.getConnection();
			
			//db connection init
			//System.out.println("drivers="+drivers);
			Class.forName(drivers);
			conn = DriverManager.getConnection(url,user,password);
			
			//db statement init
			stmt = conn.createStatement();
		}catch(Exception e){
			System.out.println("dbBean: init error!" +e.toString());
		}
	}
	public DBbean(){
		try{
			//parameter init
			drivers = DBbean.getConfigString("drivers");
			url = DBbean.getConfigString("url");
			user = DBbean.getConfigString("user");
			password = DBbean.getConfigString("password");
			//jndi_name = CommonParam.getString("jndi_name");
			
			//db connection pool init
			//InitialContext env = new InitialContext();
			//javax.sql.DataSource pool = (javax.sql.DataSource)env.lookup(jndi_name);
			//conn = pool.getConnection();
			
			//db connection init
			Class.forName(drivers);
			conn = DriverManager.getConnection(url,user,password);
			
			//db statement init
			stmt = conn.createStatement();
		}catch(Exception e){
			System.out.println("dbBean: init error!" +e.toString());
		}
	}


	public void prepareStatement(String sql) throws SQLException {
		prepstmt = conn.prepareStatement(sql);
	}


	public void prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
	throws SQLException {
		prepstmt = conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	public void execute(String sql){
		try{
		if (stmt != null) { 
			stmt.execute(sql);
		} else {
			if(debug==1){
				AppendLog.appendMethodB(getConfigString("error_file"),"stmt is null:"+sql);
			}
			System.out.println("stmt is null");
		}
		}catch(Exception e){
			if(debug==1){
				AppendLog.appendMethodB(getConfigString("error_file"),sql);
			}
			System.out.println(e);
		}
	}
	
	public ResultSet executeQuery(String sql) throws SQLException {
		if (stmt != null) {
			return stmt.executeQuery(sql);
		}else return null;
	}


	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		}else return null;
	}


	public void executeUpdate(String sql) throws SQLException {
		if (stmt != null)
		stmt.executeUpdate(sql);
	}


	public void executeUpdate() throws SQLException {
		if (prepstmt != null)
		prepstmt.executeUpdate();
	}


	public void executeBatch() throws SQLException {
		if (prepstmt != null)
		prepstmt.executeBatch();
	}


	public void addBatch(String value) throws SQLException {
		prepstmt.addBatch(value);
	}


	public void setString(int index,String value) throws SQLException {
		prepstmt.setString(index, value);
	}


	public void setInt(int index,int value) throws SQLException {
		prepstmt.setInt(index,value);
	}


	public void setBoolean(int index,boolean value) throws SQLException {
		prepstmt.setBoolean(index,value);
	}

	public void setDate(int index,Date value) throws SQLException {
		prepstmt.setDate(index,value);
	}


	public void setLong(int index,long value) throws SQLException {
		prepstmt.setLong(index,value);
	}


	public void setFloat(int index,float value) throws SQLException {
		prepstmt.setFloat(index,value);
	}


	public void setBytes(int index,byte[] value) throws SQLException{
		prepstmt.setBytes(index,value);
	}


	public void setBinaryStream(int index,InputStream value,int len) throws SQLException{
		prepstmt.setBinaryStream(index,value,len);
	}


	public void setTimestamp(int index,Timestamp timestamp) throws SQLException {
		prepstmt.setTimestamp(index, timestamp);
	}


	public void setAutoCommit(boolean value) throws SQLException{
		if(this.conn != null)
		this.conn.setAutoCommit(value);
	}


	public void commit() throws SQLException{
		this.conn.commit();
	}


	public void rollback() throws SQLException{
		this.conn.rollback();
	}


	public void close(){
		try{
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}catch(Exception e){
			System.out.println("dbBean close rs error!");
		}finally{
			try{
				if (stmt != null) {
				stmt.close();
				stmt = null;
				}
			}catch(Exception e){
				System.out.println("dbBean close stmt error!");
			}finally{
				try{
					if (prepstmt != null) {
					prepstmt.close();
					prepstmt = null;
					}
				}catch(Exception e){
					System.out.println("dbBean close prepstmt error!");
				}finally{
					try{
						if (conn != null) {
						conn.close();
						conn = null;
						}
					}catch(Exception e){
						System.out.println("dbBean close conn error!");
					}
				}
			}
		}
	}
	public String getDrivers(){
		return drivers;
	}
	
	public static void main(String argsp[]){
		DBbean b=new DBbean("postgres");
		System.out.println(b.getDrivers());
		b.execute("create table employee(account2 varchar(32),password2 varchar(32),desc2 varchar(32))");
		b.execute("insert into employee values('robin','123465','test1')");
		b.close();
	}    
}
