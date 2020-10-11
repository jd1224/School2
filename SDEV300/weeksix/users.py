'''Module to create a user object
which is used to validate input and
authenticate users
'''
import csv
import string
import re
from passlib.context import CryptContext

class UserMethods:
    '''
    main class of the method used
    as a user object in the main app
    '''
    def __init__(self, user, email, password):
        self.user = user.lower()
        self.email = email.lower()
        self.password = password

    CONTEXT = CryptContext(
        schemes=['bcrypt_sha256'],
        bcrypt_sha256__default_rounds=13
        )

    def change_password(self, new_pass):
        '''
        function to change the password of a
        registered user
        parameters:
            new_pass str new password for user
        '''
        #create a users list and populate with dicts
        users = []
        with open('users.csv') as userfile:
            reader = csv.DictReader(userfile)
            for i in reader:
                users.append(i)
        #find the user in the list and replace the password hash
        for i in users:
            if i.get('username') == self.user:
                #print(i)
                i['password_hash'] = self.hash_password(new_pass)
        #create the headers for the user csv based on the user objects
        keys = users[0].keys()
        columns = []
        for i in keys:
            columns.append(i)
        #open the users csv and write the new dict with the changed user
        with open('users.csv', 'w', newline='', encoding='utf8') as outfile:
            writer = csv.DictWriter(outfile, fieldnames=columns)
            writer.writeheader()
            for user in users:
                writer.writerow(user)

    def authenticate_user(self):
        '''
        method to authenticate the user
        based on the object's user and
        email properties
        '''
        #load the users from the database to a list
        users = []
        with open('users.csv') as userfile:
            reader = csv.DictReader(userfile)
            for i in reader:
                users.append(i)
        #breakout the usernames and passwords
        usernames = []
        passwords = []
        for i in users:
            usernames.append(i.get('username'))
            passwords.append(i.get('password_hash'))
        #check for the matching user and password
        for i in range(0, len(usernames)):
            if self.user == usernames[i] and self.verify_password(passwords[i]):
                return True
        #raise an error if the login is bad
        raise ValueError("Bad username or password!")

    def check_email_registered(self):
        '''
        function to check if the email
        property is already registered
        raise an error if it is registered
        '''
        users = []
        with open('users.csv') as userfile:
            reader = csv.DictReader(userfile)
            for i in reader:
                users.append(i)
        emails = []
        for i in users:
            emails.append(i.get('email'))
        return self.email in emails

    def check_user_registered(self):
        '''
        function to check if a user is
        already registered.
        '''
        users = []
        with open('users.csv') as userfile:
            reader = csv.DictReader(userfile)
            for i in reader:
                users.append(i)
        usernames = []
        for i in users:
            usernames.append(i.get('username'))

        return self.user in usernames

    def create_users(self):
        '''
        Function to register a new
        user and save the user to
        the database.
        '''
        #check password complexity and email validity
        try:
            self.password_validate()
            self.email_validate()
        except ValueError as exception:
            raise ValueError(exception)
        #check to see if the username or email is already registered
        if not self.check_email_registered() and not self.check_user_registered():
            #hash the password using a pbkdf2
            hashed_password = self.hash_password()
            data = [self.user, self.email, hashed_password]
            #store the user information in the flat database
            with open('users.csv', 'a+', newline='') as outfile:
                writer = csv.writer(outfile)
                writer.writerow(data)
        else:
            raise ValueError("User Already Exists!")

    def pass_too_common(self):
        '''
        method to check if the password is
        in the list of common passwords
        '''
        #create and populate a list from the common passwords file
        commons = []
        with open('CommonPassword.txt', 'r') as infile:
            for i in infile:
                commons.append(i.rstrip())
        #check to see if the password is in the file
        return self.password in commons

    def password_validate(self, word=False):
        '''
        function to validate the password
        complexity rules are met by the
        user input
        '''
        if not word:
            word = self.password

        if len(word) < 12:
            raise ValueError("Insufficient Length")
        if not any(char in string.ascii_lowercase for char in word):
            raise ValueError("Must contain a lowercase letter")
        if not any(char in string.ascii_uppercase for char in word):
            raise ValueError("Must contain an uppercase letter")
        if not any(char in string.digits for char in word):
            raise ValueError("Must contain a number")
        if not any(char in string.punctuation for char in word):
            raise ValueError("Must contain a special character")
        if self.pass_too_common():
            raise ValueError("Password is too common")

    def email_validate(self):
        '''
        function to check the user input
        against a regec for email patterns
        '''
        regex = r'^[a-z0-9]+[\._]?[a-z0-9]+[@](\w+[.]){1,4}\w{2,3}$'
        if re.search(regex, self.email):
            return True
        raise ValueError("Incorrectly formatted email.")

    def hash_password(self, password=False):
        '''
        Function to hash the password
        '''
        if not password:
            password = self.password
        return self.CONTEXT.hash(password)

    def verify_password(self, hashed):
        '''
        function to verify a hashed password
        '''
        return self.CONTEXT.verify(self.password, hashed)
