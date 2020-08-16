'''Module for week one'''
import colorama
colorama.init()
colors = {'red': '\033[31m', 'green': '\033[32m', 'yellow': '\033[33m',\
     'blue':'\033[34m', 'reset': '\033[0m'}
def get_color():
    '''take input and output a colorized string'''
    color = input("Which do you like better?\nRed, yellow, green or blue? ")
    try:
        print('I love the color ' + colors.get(color.lower())\
 + color + colors.get('reset') + ' too.')
    except TypeError:
        print('Make sure you choose one of the available colors next time!')
get_color()
