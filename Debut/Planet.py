class Planet :
    
    def __init__(self, distance, temp, unité = "Kelvin", nom = None):
        self.__distance = distance
        self.__temp = temp
        self.__unité = unité
        self.__nom = nom

    @property
    def Distance(self):
        return self.__distance
    
    @property
    def Temperature(self):
        return self.__temp
    
    @property
    def Unité(self):
        return self.__unité
    
    @property
    def Nom(self):
        return self.__nom
    
    @classmethod
    def tempChange(cls , unite):
        print("Changement en cours kkkkkkkk...")
        if cls.Unité == unite:
            print("Déjà dans cette unité")
        else:
            print("Changement en cours sssssss...")
            if cls.Unité == "Celsius":
                print("Changement en courszdzdzdz ...")
                if unite == 'Kelvin':
                    print("Changement en cours ...")
                    return cls.Unité + 273.15
                if unite == 'Fahrenheit':
                    print("Changement en cours ...")
                    return cls.Unité * 1.8 + 32
            if cls.Unité == 'Fahrenheit':
                print("Changement en coursasasasas ...")
                if unite == 'Celsius':
                    print("Changement en cours ...")
                    return (cls.Unité - 32)/1.8
                if unite == 'Kelvin':
                    print("Changement en cours ...")
                    return (cls.Unité + 459.67)/1.8
            if cls.Unité == 'Kelvin':
                print("Changement en cours bgbgbgb...")
                if unite == 'Celsius':
                    print("Changement en cours ...")
                    return cls.Unité - 273.15
                if unite == 'Fahrenheit':
                    print("Changement en cours ...")
                    return cls.Unité*1.8 - 459.67



m = Planet(125,32,'Celsius')
p = Planet(5, 80, nom = "gg")
nabil = Planet(158,321,"Celsius", 'Nabilou')
print(p.Temperature)
print(nabil.tempChange('Celsius'))