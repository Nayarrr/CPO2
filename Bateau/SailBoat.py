import Boat
from Decorateur import *

class SailBoat(Boat):

    @Horn
    def avancer(self):
        print("Vous avancez avec une voile")


res = SailBoat(Boat)
res.avancer()

    