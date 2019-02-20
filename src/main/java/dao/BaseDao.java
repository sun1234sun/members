package dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by yyx on 2018-11-21.
 */
public class BaseDao {
    private static String driver="";
    private static String url="";
    private static String user="";
    private static String pwd="";
    public Connection conn=null;
    public PreparedStatement pata=null;
    public ResultSet rs=null;
    static{
        try {
            Properties params=new Properties();
            InputStream stream=BaseDao.class.getClassLoader()
                    .getResourceAsStream("database.properties");
            params.load(stream);
            driver=params.getProperty("driver");
            url=params.getProperty("url");
            user=params.getProperty("user");
            pwd=params.getProperty("pwd");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){

            try {
                conn= DriverManager.getConnection(url,user,pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return conn;
    }
    public void close(){
        try {
            if(rs!=null) {
                rs.close();
            }
            if(pata!=null){
                pata.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public int executeUpdate(String sql,Object[] param){
        int num=0;
        conn=getConn();//得到连接
        try {
            pata=conn.prepareStatement(sql);//c创建命令行对象
            if(param!=null){
                for(int i=0;i<param.length;i++){
                    pata.setObject(i+1,param[i]);
                }
                num=pata.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();//关闭
        }
        return num;
    }
}
