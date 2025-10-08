from datetime import datetime



def horaireOuvrable(func):
    def wrapper():
        res = datetime.now()
        if 8 <= res.hour <= 17 :
            func()
        else :
            print("Vous n'etes pas dans les heures !")


def Engine(func):
    def wrapper():
        print("Moteur mis en place !")

def Horn(func):
    def wrapper():
        print("Tchou tchou j'ai un klaxon")

        