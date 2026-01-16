SELECT * FROM MEMBER;
DROP TABLE member03;
CREATE TABLE member03
AS SELECT id, pwd, name, point, auth, 'zelratole@gmail.com' email FROM MEMBER;
SELECT * FROM MEMBER03;

---비번분실시 발송할 email 정보 로딩
SELECT email FROM MEMBER03 WHERE id='himan';
/*
@Select("SELECT email FROM MEMBER03 WHERE id=#{id}")
String getEmailById(@Param("id") String id);
UPDATE MEMBER03
       SET pwd = #{pwd} --- 임시비밀번호로 수정..
 WHERE id = #{id}
@Update("")
int updateTempPass(Member);


 * */
-- 임시비밀번호로 수정 처리
UPDATE MEMBER03
       SET pwd = '9999' --- 임시비밀번호로 수정..
 WHERE id = 'himan';  
/*
UPDATE MEMBER03
       SET pwd = #{pwd} --- 임시비밀번호로 수정..
 WHERE id = #{id}
@Update("")
int updateTempPass(Member);
class Member{
	private String id;
	private String pwd;
	private String name;
	private String auth;
	private int point
	private String email;
	
}
*/


