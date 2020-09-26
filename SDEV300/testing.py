import datetime
from datetime import time
from datetime import timedelta

txdelta = timedelta(hours=1)
format = "%H:%M:%S"
today = datetime.datetime.today()
then = datetime.datetime.strptime("2020-10-23", "%Y-%m-%d")
print((then - today).days)
