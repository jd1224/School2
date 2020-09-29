import platform
from os import system
import time


def clear_screen():
    '''
    clears the screen after checking which
    system architecture is used.
    used to clean up input and stop it from
    leaving a long string text
    '''
    systems = platform.system()
    if systems == 'Windows':
        _ = system('c:\\windows\\sysnative\\cmd.exe')
    else:
        _ = system('clear')

for i in range(1,5):
    print(i)
    time.sleep(2)
    clear_screen()