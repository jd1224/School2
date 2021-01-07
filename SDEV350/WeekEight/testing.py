import cx_Oracle
import random, sys
from datetime import datetime, timedelta

def gen_datetime(min_year=2019, max_year=2019):
    # generate a datetime in format yyyy-mm-dd hh:mm:ss.000000
    start = datetime(min_year, 1, 1, 00, 00, 00)
    years = max_year - min_year + 1
    end = start + timedelta(days=365 * years)
    return start + (end - start) * random.random()

host_name = 'orcl.cfk3yarma72t.us-east-1.rds.amazonaws.com'
port_number = '1521'
service_named = 'ORCL'
user_name = 'U1WEEK8'
password = 'P@$$W0rd1234!@#$'

dsn_tns = cx_Oracle.makedsn(host_name, port_number, service_name=service_named) # if needed, place an 'r' before any parameter in order to address special characters such as '\'.
conn = cx_Oracle.connect(user=user_name, password=password, dsn=dsn_tns) # if needed, place an 'r' before any parameter in order to address special characters such as '\'. For example, if your user name contains '\', you'll need to place 'r' before the user name: user=r'User Name'
c = conn.cursor()

connection = [conn, c]


def refill_projections(connection)
    connection[1].execute("SELECT CUSTOMERID FROM ADMIN.PROJECTIONS2020")
    projected = []
    for row in connection[1]:
        projected.append(row[0])

    for i in range(1,100):
        if i not in projected:
            id = i
            qpa = random.randint(1,10000)
            qpra = round(qpa/random.randint(2,4), 2)
            confidence = random.randint(1,100)/100
            try:
                #c.execute("INSERT INTO PROJECTIONS2020 (CUSTOMERID, QUARTERLYPURCHASEAMOUNT, QUARTERLYPROFITAMOUNT, CONFIDENCE\
        #VALUES (:id, :qpa, :qpra, :confidence)", id=id, qpa=qpa, qpra=qpra, confidence=confidence)
                connection[1].execute("INSERT INTO admin.PROJECTIONS2020 (CUSTOMERID, QUARTERLYPURCHASEAMOUNT, QUARTERLYPROFITAMOUNT, CONFIDENCE)\
        VALUES (:id, :qpa, :qpra, :confidence)", id=str(id), qpa=str(qpa), qpra=str(qpra), confidence=str(confidence))
                connection[0].commit()
            except Exception as e:
                print(e)
