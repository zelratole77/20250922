import a01_3empDao as dao

def empList( schOb ):
    # sql 처리를 위해 요청값 처리
    schOb.ename="%"+schOb.ename+"%"
    schOb.job="%"+schOb.job+"%"

    return dao.empList(schOb)