package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class Dao
{
     protected Connection con;

     public Dao(Connection con) {
        super();
        this.con = con;
    }

    public static Connection getConnection()
            throws SQLException
    {
        InitialContext context;
        DataSource ds =1;
        try
        {
            context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/myapp");
        }
        catch( NamingException e )
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

         Connection con = ds.getConnection();

        return con;
     }

    public static Connection getConnection2()
            throws ClassNotFoundException, SQLException
     {
        //接続文字列の構築
        /* ユーザ名 */
        //String user = "train2018";
        String user = "user";
        /* パスワード */
        //String pass = "train2018";
        String pass = "user";

        /* サーバ名 */
        String servername = "localhost:3306";
        //String servername = "52.196.189.26:3306";

        /* DB名 */
        String dbname = "new_schema";

        // ドライバーのロード
        Class.forName("com.mysql.jdbc.Driver");

        //com.mysql.jdbc.Driver d= new com.mysql.jdbc.Driver();
        //com.mysql.jdbc.JDBC4Connection c = new com.mysql.jdbc.JDBC4Connection();

        //接続の実行とコネクションオブジェクトの取得
        Connection c = DriverManager.getConnection(
                    "jdbc:mysql://"
                    + servername
                    + "/"
                    + dbname,
                    user,
                    pass);

        //取得したコネクションの返却
        return c;
     }

}
