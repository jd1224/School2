import numpy as np

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
        print(f'You\'re entering numbers for the {matrix}')
        print('This will be a three by three matrix. ')
        print('You must enter three integers separated by spaces')
        print('----------------------------------------------')
        print(error)
        print("Please enter the values in the format 1 2 3.")
        #get a list of three integers from the user
        raw_input = input(f"Values for row {i+1}: ")
        #check_quit(raw_input)
        #split the input on the spaces
        filler = raw_input.split(' ')
        #attempt to cast the string input to an int for use with math operators
        for j in range(0, len(filler)):
            try:
                #cast the strings to ints
                filler[j] = int(filler[j])
            except ValueError:
                if choice_count > 3:
                    choice_count += 1
                    #if a non integer is detected, set this variable to trigger a failure
                    #in the final check of this function
                    non_int = True
                    break
                raise ValueError("You made too many bad choices! GoodBye!")
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
                error = 'You have to include only integers!'
            else:
                raise ValueError("Too many bad choices!")
        #if a 3 element integer array is entered, add it to the array_filler
        else:
            inner_choosing = False
    return filler

print(get_array("One"))