package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    public List<Member> list() {
// 5개
        // 1. ip (domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스
    	
    	List<Member> memberList = new ArrayList<>();
    	

        String url = "jdbc:mariadb://192.168.0.21:3306/testdb3";
        String dbUserId = "Ogu1208";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제 (close)

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet rs = null;

        // email, kakao, facebook
        // sql injection 공격
        String memberTypeValue = "email";

        try {
            // 2. 커넥션 객체 생성
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            // 3. 스테이트먼트 객체 생성

            // 4. 쿼리 실행
            String sql = "select member_type, user_id, password, name " +
                    " from member2 " +
                    " where member_type = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);   // parameter는 1부터 시작

            rs = preparedStatement.executeQuery();

            // 5. 결과 수행
            while (rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                
                Member member = new Member();
                member.setMemberType(memberType);
                member.setUserId(userId);
                member.setPassword(password);
                member.setName(name);
               
                memberList.add(member);
                
                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제 (close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    ;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return memberList;
        
    }

    
    
    public Member detail(String memberType, String userId) {
    	// 5개
    	        // 1. ip (domain)
    	        // 2. port
    	        // 3. 계정
    	        // 4. 패스워드
    	        // 5. 인스턴스
    	    	
    	    	Member member = null;
    	    	
    	
    	        String url = "jdbc:mariadb://192.168.0.21:3306/testdb3";
    	        String dbUserId = "Ogu1208";
    	        String dbPassword = "zerobase";
    	
    	        // 1. 드라이버 로드
    	        // 2. 커넥션 객체 생성
    	        // 3. 스테이트먼트 객체 생성
    	        // 4. 쿼리 실행
    	        // 5. 결과 수행
    	        // 6. 객체 연결 해제 (close)
    	
    	        // 1. 드라이버 로드
    	        try {
    	            Class.forName("org.mariadb.jdbc.Driver");
    	        } catch (ClassNotFoundException e) {
    	            e.printStackTrace();
    	        }
    	
    	        Connection connection = null;
    	        PreparedStatement preparedStatement = null;
    	        Statement statement = null;
    	        ResultSet rs = null;
    	
    	
    	        try {
    	            // 2. 커넥션 객체 생성
    	            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
    	            // 3. 스테이트먼트 객체 생성
    	
    	            // 4. 쿼리 실행
    	            String sql = " select m.member_type, m.user_id, m.password, m.name "
    	            		+ "    , md.mobile_no "
    	            		+ "    , md.marketing_yn "
    	            		+ "    , md.register_date "
    	            		+ " from member2 m\r\n"
    	            		+ "    left join member_detail md on m.member_type = md.member_type and m.user_id = md.user_id "
    	            		+ " where m.member_type = ? and m.user_id = ? ";
    	
    	            preparedStatement = connection.prepareStatement(sql);
    	            preparedStatement.setString(1, memberType);   // parameter는 1부터 시작
    	            preparedStatement.setString(2, userId);  
    	
    	            rs = preparedStatement.executeQuery();
    	
    	            // 5. 결과 수행
    	            if (rs.next()) {
    	            	member = new Member();
    	                member.setMemberType(rs.getString("member_type"));
    	                member.setUserId(rs.getString("user_id"));
    	                member.setPassword(rs.getString("password"));
    	                member.setName(rs.getString("name"));
    	                member.setMobileNo(rs.getString("mobile_no"));
    	                member.setMarketingYn(rs.getBoolean("marketing_yn"));
    	                member.setRegisterDate(rs.getDate("register_date"));
    	            }
    	
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        } finally {
    	            // 6. 객체 연결 해제 (close)
    	            try {
    	                if (rs != null && !rs.isClosed()) {
    	                    rs.close();
    	                    ;
    	                }
    	            } catch (SQLException e) {
    	                e.printStackTrace();
    	            }
    	
    	            try {
    	                if (preparedStatement != null && !preparedStatement.isClosed()) {
    	                    preparedStatement.close();
    	                }
    	            } catch (SQLException e) {
    	                e.printStackTrace();
    	            }
    	
    	            try {
    	                if (connection != null && !connection.isClosed()) {
    	                    connection.close();
    	                }
    	            } catch (SQLException e) {
    	                e.printStackTrace();
    	            }
    	        }
    	        
    	        return member;
    	        
    	    }

    
    
    
    
    /**
     * 회원 가입 함숫
     * @param member 회원정보
     */
    public void register(Member member) {
// 5개
        // 1. ip (domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://192.168.0.21:3306/testdb3";
        String dbUserId = "Ogu1208";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제 (close)

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet rs = null;

//        String memberTypeValue = "email";
//        String userIdValue = "zerobase@naver.com";
//        String passwordValue = "3333";
//        String nameValue = "제로베이스";

        try {
            // 2. 커넥션 객체 생성
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            // 3. 스테이트먼트 객체 생성

            // 4. 쿼리 실행
            String sql = "insert into member2 (member_type, user_id, password, name)\n" +
                    "values (?, ?, ?, ?);";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());   // parameter는 1부터 시작
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getName());

            int affected = preparedStatement.executeUpdate();

            // 5. 결과 수행
            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제 (close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    ;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void dbUpdate() {
// 5개
        // 1. ip (domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://192.168.0.21:3306/testdb3";
        String dbUserId = "Ogu1208";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제 (close)

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet rs = null;

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        try {
            // 2. 커넥션 객체 생성
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            // 3. 스테이트먼트 객체 생성

            // 4. 쿼리 실행
            String sql = "update member2 set " +
                    " password = ? " +
                    " where member_type = ? and user_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);


            int affected = preparedStatement.executeUpdate();

            // 5. 결과 수행
            if (affected > 0) {
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제 (close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    ;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 회원 탈퇴 함수
     */
    public void withdraw(Member member) {
// 5개
        // 1. ip (domain)
        // 2. port
        // 3. 계정
        // 4. 패스워드
        // 5. 인스턴스

        String url = "jdbc:mariadb://192.168.0.21:3306/testdb3";
        String dbUserId = "Ogu1208";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제 (close)

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            // 2. 커넥션 객체 생성
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            // 3. 스테이트먼트 객체 생성

            // 4. 쿼리 실행
            String sql = "delete from member2 " +
                    " where member_type = ? and user_id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());


            int affected = preparedStatement.executeUpdate();

            // 5. 결과 수행
            if (affected > 0) {
                System.out.println(" 삭제 성공 ");
            } else {
                System.out.println(" 삭제 실패 ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제 (close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    ;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	
}
