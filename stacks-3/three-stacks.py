"""
Implement three stacks, with fixed capacities in an array
"""

class Stacks(object):
    def __init__(self, capacity, count):
        self.stackCapacity = capacity
        self.array = [0 for _ in range(count * capacity)]
        self.top = [-1 for _ in range(count)]
        self.count = count

    def __absIndex__(self, stackIdx, offset):
        if stackIdx < 0 or stackIdx >= self.count:
            raise ValueError("Invalid stack index")

        if offset < 0 or offset >= self.stackCapacity:
            raise ValueError("Invalid offset within stack")
        
        return (self.stackCapacity * stackIdx) + offset

    def __isValidStack__(self, stackIdx):
        return stackIdx >=0 and stackIdx < self.count

    def isEmpty(self, stackIdx):
        if not self.__isValidStack__(stackIdx):
            raise Exception("Invalid stack")
        return self.top[stackIdx] == -1

    def isFull(self, stackIdx):
        if not self.__isValidStack__(stackIdx):
            raise Exception("Invalid stack")
        return self.top[stackIdx] == self.stackCapacity - 1

    def push(self, stackIdx, data):
        if not self.__isValidStack__(stackIdx):
            raise Exception("Invalid stack")

        if self.isFull(stackIdx):
            raise Exception("Stack %d is full" % stackIdx)

        self.top[stackIdx] += 1
        absIndex = self.__absIndex__(stackIdx, self.top[stackIdx])

        self.array[absIndex] = data

    def pop(self, stackIdx):
        if not self.__isValidStack__(stackIdx):
            raise Exception("Invalid stack")

        if self.isEmpty(stackIdx):
            raise Exception("Stack %d empty !" % stackIdx)

        absIndex = self.__absIndex__(stackIdx, self.top[stackIdx])
        value = self.array[absIndex]
        self.top[stackIdx] -= 1
    
        return value

    def peek(self, stackIdx):
        if not self.__isValidStack__(stackIdx):
            raise Exception("Invalid stack")

        if self.isEmpty(stackIdx):
            raise Exception("Stack Empty")

        absIndex = self.__absIndex__(stackIdx, self.top[stackIdx])
        return self.array[absIndex]


def main():
    stacks = Stacks(3, 3)

    print('Empty check')
    for i in range(3):
        print(stacks.isEmpty(i))

    print('Fill stacks')
    for i in range(3):
        for j in range(3):
            stacks.push(i, j)

    print('Force push on full stack')
    try:
        stacks.push(0, 3)
    except Exception as e:
        print(e)

    print('Peek stacks')
    for i in range(3):
        print(i, stacks.peek(i))

    print('Emptying stacks')
    for i in range(3):
        for j in range(3):
            print(i, stacks.pop(i))

    print('Pop from empty stacks')
    try:
        stacks.pop(0)
    except Exception as e:
        print(e)


if __name__ == '__main__':
    main()