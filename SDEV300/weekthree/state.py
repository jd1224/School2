'''module to create state class'''
class State:
    ''' class to represent a state'''
    def __init__(self, name, capital, population, flower):
        self.name = name
        self.capital = capital
        self.population = population
        self.flower = flower

    def __str__(self):
        return str(self.name)

    def get_list(self):
        outlist = []
        outlist.append(self.name)
        outlist.append(self.capital)
        outlist.append(self.population)
        outlist.append(self.flower)
        return outlist
