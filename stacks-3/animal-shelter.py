"""
Dequeue oldest animals
"""

from abc import ABC
from collections import deque

class AnimalABC(ABC):
    """
    Abstract animal class
    """

    def __init__(self, name):
        self.name = name
        self.order = -1

    def setOrder(self, order):
        if order < 0:
            raise ValueError("Invalid order")
        self.order = order

    def getOrder(self):
        return self.order

    def isGreaterThan(self, other):
        return self.order >= other.order

class Dog(AnimalABC):
    def __init__(self):
        super(Dog, self).__init__("Dog")

class Cat(AnimalABC):
    def __init__(self):
        super(Cat, self).__init__("Cat")

class Shelter(object):
    def __init__(self):
        self.dogs = deque()
        self.cats = deque()

    def __nextOrder__(self):
        order = 0
        if len(self.dogs) == 0 and len(self.cats) == 0:
            order = 0
        elif len(self.dogs) == 0:
            order = 1 + self.cats[-1].order
        elif len(self.cats) == 0:
            order = 1 + self.dogs[-1].order
        else:
            order = 1 + max(self.cats[-1].order, self.dogs[-1].order)
        return order

    def enqueue(self, animal):
        animal.setOrder(self.__nextOrder__())
        if animal.name == "Dog":
            self.dogs.append(animal)
        elif animal.name == "Cat":
            self.cats.append(animal)
        else:
            raise Exception("Only cats and dogs allowed")

    def dequeueDog(self):
        if len(self.dogs) == 0:
            raise Exception("No dogs for adoption")
        return self.dogs.popleft()

    def dequeueCat(self):
        if len(self.cats) == 0:
            raise Exception("No cats for adoption")
        return self.cats.popleft()

    def dequeueAny(self):
        if len(self.dogs) == 0 and len(self.cats) == 0:
            raise Exception("No animals for adoption")
        elif len(self.dogs) == 0:
            return self.cats.popleft()
        elif len(self.cats) == 0:
            return self.dogs.popleft()
        q = None
        if self.dogs[0].isGreaterThan(self.cats[0]):
            q = self.cats
        else:
            q = self.dogs
        return q.popleft()

def main():
    shelter = Shelter()

    shelter.enqueue(Dog())
    shelter.enqueue(Dog())

    shelter.enqueue(Cat())
    shelter.enqueue(Dog())

    shelter.enqueue(Cat())
    shelter.enqueue(Cat())

    print(shelter.dequeueCat().name)
    print(shelter.dequeueAny().name)
    print(shelter.dequeueAny().name)
    print(shelter.dequeueDog().name)

if __name__ == '__main__':
    main()
