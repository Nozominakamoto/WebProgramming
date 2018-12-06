package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.UserBeans;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class userDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public UserBeans findByLoginInfo(String LoginId, String password) {
        Connection conn = null;

        //getConnectionメソッドではSQLExceptionが発生する可能性があるため、try-catchで囲む
        try {
            // データベースへ接続(DBManagerのメソッドでコネクションオブジェクトを取得
            conn = DBManeger.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, LoginId);
            pStmt.setString(2, password(password));
            ResultSet rs = pStmt.executeQuery();  //取得メソッド

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new UserBeans(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }


    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<UserBeans> findAll() {
        Connection conn = null;
        List<UserBeans> userList = new ArrayList<UserBeans>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user WHERE id != 1";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {

            	int Id = rs.getInt("id");
                String LoginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                UserBeans user = new UserBeans(Id,LoginId, password, name, birthDate, createDate, updateDate );

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
        	//(データベースに同時に接続できるクライアント数には限りがある為)
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }



        public UserBeans findByDataInfo(String id) {

            Connection conn = null;

            try {
                conn = DBManeger.getConnection();

                String sql = "SELECT id, name, login_id, birth_date, create_date,update_date,password FROM user WHERE id = ?";

                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,id);
                ResultSet rs = pStmt.executeQuery();


                 // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
                if (!rs.next()) {
                    return null;
                }
                String LoginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                String password = rs.getString("password");

                return new UserBeans(LoginId, name, birthDate, createDate, updateDate,password);

	            } catch (SQLException e) {
	                e.printStackTrace();
	                return null;
	            } finally {
	                // データベース切断
	                if (conn != null) {
	                    try {
	                        conn.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                        return null;
	                    }
	                }
	            }
	        }

        public void deleteData(String id) {
            Connection conn = null;

            try {
                // データベースへ接続
                conn = DBManeger.getConnection();

                // SELECT文を準備

                String sql = "DELETE FROM user WHERE id = ?";

                 // SELECTを実行
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, id);
                pStmt.executeUpdate();



            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // データベース切断
            	//(データベースに同時に接続できるクライアント数には限りがある為)
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        public void signUpData(String LoginId,String password,String confirmPass,String name,String birthday) throws SQLException {
            Connection conn = null;

            try {
                conn = DBManeger.getConnection();

                String sql = "INSERT INTO user (login_id,name,birth_date,password,create_date,update_date) VALUES(?,?,?,?,now(),now())";

                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,LoginId);
                pStmt.setString(2,name);
                pStmt.setString(3,birthday);
                pStmt.setString(4,password(password));

                pStmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            } finally {
                // データベース切断
            	//(データベースに同時に接続できるクライアント数には限りがある為)
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void update(String password,String confirmPass,String name,String birthday,String Id) throws SQLException {
            Connection conn = null;

            try {
                conn = DBManeger.getConnection();

                String sql = "UPDATE user SET name = ?, birth_date = ?, password = ?, update_date = now()  WHERE Id = ?";



                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,name);
                pStmt.setString(2,birthday);
                pStmt.setString(3,password(password));
                pStmt.setString(4,Id);

                pStmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            } finally {
                // データベース切断
            	//(データベースに同時に接続できるクライアント数には限りがある為)
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        public void update2(String password,String confirmPass,String name,String birthday,String Id) throws SQLException {
            Connection conn = null;

            try {
                conn = DBManeger.getConnection();

                String sql = "UPDATE user SET name = ?, birth_date = ?, update_date = now()  WHERE Id = ?";



                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,name);
                pStmt.setString(2,birthday);
                pStmt.setString(3,Id);

                pStmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            } finally {
                // データベース切断
            	//(データベースに同時に接続できるクライアント数には限りがある為)
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



       private String password(String password) {
    	   String source = password;
    	 //ハッシュ生成前にバイト配列に置き換える際のCharset
    	 Charset charset = StandardCharsets.UTF_8;
    	 //ハッシュアルゴリズム
    	 String algorithm = "MD5";

    	 //ハッシュ生成処理
    	 byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	 String result = DatatypeConverter.printHexBinary(bytes);
    	 //標準出力
    	 System.out.println(result);

    	 return result;

       }



     public List<UserBeans> search(String Name,String loginId,String date,String day) {
    	   Connection conn = null;
           conn = DBManeger.getConnection();
           List<UserBeans> searchList = new ArrayList<UserBeans>();

       try {
    		   String sql = "SELECT * FROM user WHERE id not in (1) ";

    		   if(!loginId.isEmpty()) {
    			   sql += "AND login_id='"+loginId+"' ";
    		   }
    		   if(!Name.isEmpty()) {
    			   sql += "AND name LIKE '%"+Name+"%' ";
    		   }
    		   if(!date.isEmpty()) {
    			   sql += "AND birth_date >= '"+date+"' ";
    		   }
    		   if(!day.isEmpty()) {
    			   sql += "AND birth_date <= '"+day+"' ";
    		   }

    		   Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery(sql);

               while (rs.next()) {

                      String LoginId = rs.getString("login_id");
                      String name = rs.getString("name");
                      Date birthDate = rs.getDate("birth_date");
                      UserBeans user = new UserBeans(LoginId,name, birthDate);

                      searchList.add(user);
              }

       } catch (SQLException e) {
           e.printStackTrace();
          return null;

       } finally {
           if (conn != null) {
               try {
                   conn.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }
       return searchList;
   }
}

