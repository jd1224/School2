import pandas as pd

class Housing:

    def __init__(self, path):

        self.path = path
        
        self.frame = pd.read_csv(path)

        self.name = f"Housing Report on {(path.split('/'))[-1]}."

    def __str__(self):

        print(self.frame)
        return(self.name)

