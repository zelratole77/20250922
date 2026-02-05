import a01_3empDao as dao

def empList( schOb ):
    # sql 처리를 위해 요청값 처리
    schOb.ename="%"+schOb.ename+"%"
    schOb.job="%"+schOb.job+"%"

    return dao.empList(schOb)
def empInsert( insOb):
    # 입력된 날짜형 데이터를 dB 등록하기 위해서 문자열형식으로 변경 처리
    #insOb.hiredate_s = insOb.hiredate.strftime("%Y-%m-%d")
    return dao.empInsert( insOb)
