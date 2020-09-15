import numpy as np

class Matrix:

    def __init__(self, name):
        array_filler = []
        choice_count = 0
        choosing = True
        error = ''
        print(f'You entering numbers for the {name}')
        print('This will be a three by three matrix. ')
        print('----------------------------------------------')
        print("Please enter the values in the format 1 2 3.")
        while choosing:
            array_filler = []
            for i in range(0, 3):
                inner_choosing = True
                error = ''
                while inner_choosing:
                    #print_head()
                    non_int = False
                    print(error)
                    raw_input = input(f"Values for row: ")
                    filler = raw_input.split(' ')
                    print(filler)
                    for i in filler:
                        try:
                            i = int(i)
                        except Exception:
                            if choice_count < 3:
                                choice_count += 1
                                non_int = True
                                break
                            else:
                                raise ValueError("Too many bad choices!")

                    if len(filler) < 3:
                        if choice_count < 3:
                            choice_count += 1
                            error = 'That row was not long enough.'
                        else:
                            raise ValueError("Too many bad choices!")
                    elif non_int:
                        if choice_count < 3:
                            choice_count += 1
                            error = 'You have to include only integers!'
                        else:
                            raise ValueError("Too many bad choices!")
                    else:
                        array_filler.append(filler)
                        inner_choosing = False
            choosing = False

        self = np.array([array_filler[0], array_filler[1], array_filler[2]])

    def printer(self):
        print(self)