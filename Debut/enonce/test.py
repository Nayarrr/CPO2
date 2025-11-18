from abc import ABC, abstractmethod

class Polygon(ABC):
    @abstractmethod
    def no_of_sides(self):
        pass

class Triangle(Polygon):
    # overriding abstract method
    def no_of_sides(self):
        print("I have 3 sides")

class Pentagon(Polygon):
    # overriding abstract method
    def no_of_sides(self):
        print("I have 5 sides")


#Main prog

R = Triangle()
R.no_of_sides()
R = Pentagon()
R.no_of_sides()

class Animal(ABC):
    @abstractmethod
    def cri(self):
        pass

class Loup(Animal):
    def cri(self):
        print("Ahouuuu")

class Vache(Animal):
    def cri(self):
        print("Meuuuuuh")

#Main 

A = Loup()
A.cri()
A = Vache()
A.cri()

print(isinstance(A, Loup))