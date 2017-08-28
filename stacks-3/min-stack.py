"""
Stack with push, pop and min in O(1) time
"""

import random

class MinStack(object):
    """
    Stack which tracks min of an argument as well
    """
    def __init__(self):
        self.primary = list()
        self.minstack = list()

    def push(self, data):
        self.primary.append(data)
        if len(self.minstack) == 0 or self.minstack[-1] >= data:
            self.minstack.append(data)

    def isEmpty(self):
        return len(self.primary) == 0

    def pop(self):
        if len(self.primary) == 0:
            raise Exception("Empty stack")

        if self.minstack[-1] == self.primary[-1]:
            self.minstack.pop()

        return self.primary.pop()

    def min(self):
        if len(self.minstack) == 0:
            raise Exception("Empty stack")
        return self.minstack[-1]

def main():
    stack = MinStack()
    print('Empty' if stack.isEmpty() else 'Not Empty')

    print('Fill stack')
    for i in range(10):
        stack.push(random.randrange(1,6))

    print('Empty stack')
    for i in range(10):
        print(stack.min(), stack.pop())

if __name__ == '__main__':
    main()