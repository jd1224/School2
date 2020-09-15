
class State:
    ''' class to represent a state'''
    def __init__(self, name, capital, population, flower):
        self.name = name
        self.capital = capital
        self.population = population
        self.flower = flower

    def __str__(self):
        return self.name

    def set_population(self, new_pop):
        self.population = new_pop

    def state_dict(self):
        return {'name':self.name, 'capital':self.capital, 'population':self.population, 'flower':self.flower}

alabama = State('alabama', 'montgomery', 250000, 'rose')
alaska = State('alaska', 'juno', 1000, 'snow')

state_list = [alabama, alaska]
pop_list = []
for i in state_list:
    pop_list.append((i.name,i.population))

print(pop_list)

print(sorted(pop_list, key = lambda x : x[0]))
