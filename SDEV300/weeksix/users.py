from passlib.context import CryptContext
import csv

class User_methods:
    
    def __init__(self, user, email, password):
        self.user = user
        self.email = email
        self.password = password

    CONTEXT = CryptContext(
            schemes=['pbkdf2_sha256'],
            default = 'pbkdf2_sha256',
            pbkdf2_sha256__default_rounds = 5000
        )

    def authenticate_user(self):
        users = []
        with open('users.csv') as userfile:
            reader = csv.DictReader(userfile)
            for i in reader:
                users.append(i)
        usernames = []
        passwords = []
        for i in users:
            usernames.append(i.get('username'))
            passwords.append(i.get('password_hash'))
        for i in range(0,len(usernames)):
            if self.user == usernames[i] and self.verify_password(passwords[i]):
                return True
        raise Exception("Bad username or password!")

    def check_email_registered(self):
        users = []
        with open('users.csv') as userfile:
            reader = csv.DictReader(userfile)
            for i in reader:
                users.append(i)
        emails = []
        for i in users:
            emails.append(i.get('email'))
        return(self.email in emails)

    def check_user_registered(self):
        users = []
        with open('users.csv') as userfile:
            reader = csv.DictReader(userfile)
            for i in reader:
                users.append(i)
        usernames = []
        for i in users:
            usernames.append(i.get('username'))

        return(self.user in usernames)

    def create_users(self):
        print(self.check_email_registered())
        print(self.check_user_registered())
        if not self.check_email_registered() and not self.check_user_registered():
            hashed_password = self.hash_password()
            data = [self.user,self.email,hashed_password]
            with open('users.csv', 'a+', newline='') as outfile:
                writer = csv.writer(outfile)
                writer.writerow(data)
        else:
            raise Exception("User Already Exists!")
        

    def hash_password(self):

        return self.CONTEXT.hash(self.password)

    def verify_password(self, hashed):

        return self.CONTEXT.verify(self.password, hashed)
try:
    user1 = User_methods('doug','d@d.com','pas')
    user1.create_users()
except Exception as e:
    print(e)

print(user1.authenticate_user())