from abc import *
from typing import Protocol
from client import Llama

def feed_bread(animal):
    animal.eat_bread()

class EatBread(Protocol):
    def eat_bread(self):
        pass
    
class Duck():
    def eat_bread(self):
        print('A duck is currently eating some bread')

class Pig():
    def eat_bread(self):
        print('A pig is currently eating some bread')

# Main test

P = Pig()
P.feed_bread()

L = Llama()
L.eat_bread()