import re

email1 = 'joshua.coe11@yahoo.com'
email2 = 'jcoe9@student.umgc.edu'

regex = r'^[a-z0-9]+[\._]?[a-z0-9]+[@](\w+[.]){1,4}\w{2,3}$'

def check_email(email):
    if(re.search(regex, email)):
        return True
    return False

print(check_email(email1))
print(check_email(email2))