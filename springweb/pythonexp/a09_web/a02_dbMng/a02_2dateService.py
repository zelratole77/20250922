import a02_3dateDao as dao

def dateList( schOb ):
    # sql 처리를 위해 요청값 처리  partner_name location
    schOb.partner_name="%"+schOb.partner_name+"%"
    schOb.location="%"+schOb.location+"%"

    return dao.dateList(schOb)

def dateInsert( insOb):
    return dao.dateInsert( insOb)

