"""
Sort a given stack, using at most one more stack
"""

def revSortStack(stack):
    second = list()
    while len(stack) > 0:
        top = stack.pop()
        
        while len(second) > 0 and second[-1] > top:
            stack.append(second.pop())
        
        second.append(top)

    return second

def ascSortStack(stack):
    second = list()
    while len(stack) > 0:
        top = stack.pop()

        while len(second) > 0 and second[-1] < top:
            stack.append(second.pop())

        second.append(top)

    return second

def main():
    stack = [1, 4, 2, 1, 3, 5, 10, 9]
    stack = ascSortStack(stack)
    print(stack)
    stack = revSortStack(stack)
    print(stack)

if __name__ == '__main__':
    main()