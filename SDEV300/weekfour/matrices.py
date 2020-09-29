'''
This is the matrix application.
Allows a user to define two 3x3 integer matrices and perform
selected operations on them.  Also provides the transpose of
the results of the operation and the mean of the results by
row and column.
'''
import platform
import re
import sys
from os import system
import numpy as np

PHONE_NUMBER = ''
ZIP_CODE = ''
MATRIX_ONE = np.array([])
MATRIX_TWO = np.array([])

def print_head():
    '''
    prints the head of the program
    with instructions on how to exit
    '''
    clear_screen()
    print('**********************************************')
    print('**    Welcome to the Matrix Application     **')
    print('**********************************************')
    print('** You can quit at any time by entering -q  **')
    print('**********************************************')
    print('----------------------------------------------')
    if not len(PHONE_NUMBER) == 0 and not len(ZIP_CODE) == 0:
        print(f'Phone: {PHONE_NUMBER}      zip code: {ZIP_CODE}')
        print('----------------------------------------------')

    if not MATRIX_TWO.size == 0:
        print_arrays(MATRIX_ONE, 'Matrix One')
        print('----------------------------------------------')
        print_arrays(MATRIX_TWO, 'Matrix Two')
        print('----------------------------------------------')

    elif not MATRIX_ONE.size == 0:
        print_arrays(MATRIX_ONE, 'Matrix One')
        print('----------------------------------------------')


def clear_screen():
    '''
    clears the screen after checking which
    system architecture is used.
    used to clean up input and stop it from
    leaving a long string text
    '''
    systems = platform.system()
    if systems == 'Windows':
        _ = system('cls')
    else:
        _ = system('clear')


def leave_program(message):
    '''
    prints the supplied message and
    gracefully exits the program

    parameters:
        message (str): a message strin
    '''
    print_head()
    print(message)
    sys.exit(0)


def check_quit(variable):
    '''
    checks for the quit variable
    calls the leave_program function if found

    parameters:
        variable (str): variable to check
    '''

    if variable == '-q':

        leave_program('You have entered -q to quit. '\
            'Thank you for using my app. Goodbye!')

def check_yes_no(prompt, choices):
    '''
    function to get an ansewer that meets the parameters
    parameters:
        prompt to ask the user a question
        list of suitable choices (must be lower case)
    returns:
        boolean based on yes or no choice
    '''
    choosing = True
    choice_string = ''
    choice_count = 0
    bad_choice = False
    choice = ''
    #read in the supplied list and add them to the choice string
    #this will be used to display in conjunction with the prompt
    for i in choices:
        #if it is the last choice prepend the or and append the :
        if choice_count == len(choices) - 1:
            choice_string += 'or ' + i + ': '
        else:
            choice_string += i+', '
            choice_count += 1
    choice_count = 0
    while choosing:
        #if a bad choice is made, display this error heading
        if bad_choice:
            print_head()
            print("You made an invalid choice. Please try again.")
            print("---------------------------------------------")
            print(prompt)
            choice = input(f'Please choose {choice_string}')
            #check the input for the -q value
            check_quit(choice)
            if choice_count < 3:
                if choice.lower() not in choices:
                    choice_count += 1
                else:
                    choosing = False
            else:
                #leave the program if they cannot make a correct choice
                leave_program("You made too many bad choices! GoodBye!")
        #display this area if it is the first attempt
        else:
            print(prompt)
            choice = input(f'Please choose {choice_string}')
            check_quit(choice)
            #conditional to set the bad_choice and increment the choice_count
            if choice.lower() not in choices:
                choice_count += 1
                bad_choice = True
            else:
                choosing = False
    #return the chosen string after validation
    return choice.lower()

def want_to_play():
    '''
    Function to ask the user if they want to play the matrix game
    uses the helper function check_yes_or_no above
    '''
    choice = check_yes_no("Do you want to play the matrix game?", ['y', 'n'])
    if choice == 'y':
        pass
    else:
        leave_program('Thanks for playing. Goodbye!')

def get_phone():
    '''
    function to prompt the user for their phone number
    validates input based on a regex which accepts the
    most common US phone number formats including
    (123)456-7890;123-456-7890;123.456.7890;1234567890;123 456 7890
    '''
    choice_count = 0
    choosing = True
    global PHONE_NUMBER
    while choosing:
        PHONE_NUMBER = input("Enter your phone number: ")
        check_quit(PHONE_NUMBER)
        #regex to validate a phone number in common formats
        if re.fullmatch(r'[(]?\d{3}[)-.\s]?\d{3}[-.\s]?\d{4}', PHONE_NUMBER):
            choosing = False
        else:
            if choice_count < 3:
                print("Please enter a valid phone number!")
                choice_count += 1
            else:
                leave_program("You made too many bad choices! Goodbye!")
    #strip only the numbers out of any input and format in the common US phone format
    numbers = re.compile(r'\d')
    sep = ''
    PHONE_NUMBER = sep.join(numbers.findall(PHONE_NUMBER))
    PHONE_NUMBER = (f'({PHONE_NUMBER[0:3]}){PHONE_NUMBER[3:6]}-{PHONE_NUMBER[6:]}')

def get_zip():
    '''
    function to prompt the user for their zip code
    validates input based on a regex which accepts
    the most common zip code formats including
    12345;12345-6789;123456789;12345 6789
    '''
    choice_count = 0
    choosing = True
    global ZIP_CODE
    while choosing:
        zip_code = input("Enter your zip code: ")
        check_quit(zip_code)
        #regex to validate a five or nine digit zip with or without a hyphen
        if re.fullmatch(r'\d{5}([-\s])?(\d{4})?', zip_code):
            ZIP_CODE = zip_code
            choosing = False
        else:
            if choice_count < 3:
                print("Please enter a valid zip code!")
                choice_count += 1
            else:
                leave_program("You made too many bad choices! Goodbye!")
    #if a nine digit zip is entered this block formats it to display correctly
    if len(ZIP_CODE) > 5:
        numbers = re.compile(r'\d')
        sep = ''
        ZIP_CODE = sep.join(numbers.findall(ZIP_CODE))
        ZIP_CODE = (f'{ZIP_CODE[:5]}-{ZIP_CODE[5:]}')

def get_array(matrix):
    '''
    function to build a 3x3 ndarray using numpy
    validates input based on type and size and
    will only allow a 3x3 integer ndarray.
    input:
        str matrix which is displayed to show the user
        which matrix they are editing
    '''
    #create the filler array
    array_filler = []
    for i in range(0, 3):
        array_filler.append(get_one_array(matrix, i))
    return np.array([array_filler[0], array_filler[1], array_filler[2]])

def get_one_array(matrix, i):
    '''
    function to take input for a 1x3 array of integers
    input:
        matrix str name to be displayed at prompt
        i str to number of row to be displayed at prompt
    returns:
        filler int array with three elements
    '''
    inner_choosing = True
    error = ''
    choice_count = 0
    #start inner loop to choose one array
    while inner_choosing:
        #variable used to check if a non-integer was entered
        non_int = False
        #supply instructions for this part using the matrix name passed in
        print_head()
        print(f'You\'re entering numbers for the {matrix}')
        print('This will be a three by three matrix. ')
        print('Enter three integers separated by spaces')
        print('----------------------------------------------')
        print(error)
        print("Please enter the values in the format 1 2 3.")
        #get a list of three integers from the user
        raw_input = input(f"Values for row {i+1}: ")
        check_quit(raw_input)
        #check_quit(raw_input)
        #split the input on the spaces
        filler = raw_input.split(' ')
        #attempt to cast the string input to an int for use with math operators
        for j in range(0, len(filler)):
            try:
                #cast the strings to ints
                filler[j] = int(filler[j])
            except ValueError:
                #if a non integer is detected, set this variable to trigger a failure
                #in the final check of this function
                non_int = True
                break
        #if the length of the array is less than three restart the inner choice
        if len(filler) < 3:
            if choice_count < 3:
                choice_count += 1
                error = 'That row was not long enough.'
            else:
                raise ValueError("You made too many bad choices! GoodBye!")
        #if a non-integer is detected restart the inner choice
        elif non_int:
            if choice_count < 3:
                choice_count += 1
                error = 'You have to include only integers!'
            else:
                raise ValueError("You made too many bad choices! GoodBye!")
        #if a 3 element integer array is entered stop and return it
        else:
            inner_choosing = False
    return filler

def print_arrays(matrix, name):
    '''
    function to format and print a single matrix
    '''
    print(f' {name}')
    for i in range(0, 3):
        print('   ', end='')
        for j in matrix[i]:
            print(j, end=' ')
        print('')

def print_both():
    '''
    function to print both base matrices next to each other
    '''
    print(' Matrix One      Matrix Two')
    for i in range(0, 3):
        print('   ', end='')
        for j in MATRIX_ONE[i]:
            print(j, end=' ')
        print('         ', end=' ')
        for k in MATRIX_TWO[i]:
            print(k, end=' ')
        print('')

def print_results(results, choice):
    '''
    function to print the results of the operation
    prints the transpose of the results
    calculates and prints the mean of the rows and columns
    parameters:
        results ndarray calculated in the proper manner
        choice str to display what operation was performed
    '''
    print_head()
    print(f'You chose {choice}.')
    transpose = results.T
    print_arrays(results, 'Results')
    print_arrays(transpose, 'Transpose')
    #calculate and print the row and column means
    print('Row and Column Mean Values: ')
    columns = np.mean(results, axis=0)
    rows = np.mean(results, axis=1)
    #format and print the caluclated means
    print('Rows: ', end='')
    for i in rows:
        print(f'{i:.2f},', end=' ')
    print('')
    print('Columns: ', end='')
    for i in columns:
        print(f'{i:.2f},', end=' ')
    print('')
    check_return()

def menu_screen():
    '''
    function to take the user's choice
    and run that choice through a switch
    to choose which function to run
    '''

    choosing = True
    choice_count = 0
    while choosing:
        print_head()
        print('----------------------------------------------')
        print('What Type of Operation Would You Like to Perform?')

        print('1. Addition')
        print('2. Subtraction')
        print('3. Matrix Multiplication')
        print('4. Element Multiplication')
        print('5. Redefine Matrices')
        print('\n')

        choice = input('Make a choice from the menu above-----> ')
        check_quit(choice)


        if choice == '1':
            print_results(np.add(MATRIX_ONE, MATRIX_TWO), 'Addition')
            choosing = False
        elif choice == '2':
            print_results(np.subtract(MATRIX_ONE, MATRIX_TWO), 'Subtraction')
            choosing = False
        elif choice == '3':
            print_results(np.matmul(MATRIX_ONE, MATRIX_TWO), 'Matrix Multiplication')
            choosing = False
        elif choice == '4':
            print_results(np.multiply(MATRIX_ONE, MATRIX_TWO), 'Element Multiplication')
            choosing = False
        elif choice == '5':
            set_matrices()
            choosing = False
        else:
            if choice_count < 2:
                print("XX-->You made an invalid choice<--XX")
                input("XX-->  Press Enter to continue <--XX")
                choice_count += 1
            else:
                leave_program("You made too many bad choices!")

def check_return():
    '''
    function to ask the user if they want to return to
    the menu or quit the program.
    '''
    print('----------------------------------------------')
    choice_count = 0
    while True:
        choice = input("Would you like to return to the menu? (y/n)")
        check_quit(choice)
        if choice_count < 2:
            if choice.lower() == 'y':
                menu_screen()
            elif choice.lower() == 'n':
                leave_program("Goodbye! Thanks for using my app.")
            else:
                print("You made an unrecognized choice.")
                choice_count += 1
        else:
            leave_program("You made too many bad choices!")

def set_matrices():
    '''
    function used to define the two 3x3
    matrices used in the program
    '''
    global MATRIX_ONE
    global MATRIX_TWO
    try:
        #clear the matrices for use a second time
        MATRIX_ONE = np.array([])
        MATRIX_TWO = np.array([])
        #call the functions to fill the matrices
        MATRIX_ONE = get_array('First Matrix')
        MATRIX_TWO = get_array('Second Matrix')
        menu_screen()
    except ValueError as exception:
        leave_program(exception)

if __name__ == "__main__":
    print_head()
    want_to_play()
    get_phone()
    get_zip()
    set_matrices()
    menu_screen()
