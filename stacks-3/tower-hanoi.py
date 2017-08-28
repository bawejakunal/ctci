"""
Tower of hanoi solution
"""

def moveTop(source, destination):
    if len(source) < 1:
        raise Exception("Source tower empty")
    if len(destination) > 0 and destination[-1] <= source[-1]:
        raise ValueError("Invalid tower values")
    destination.append(source.pop())

def hanoiMoveTower(num, source, destination, _buffer):
    if num > 0:
        hanoiMoveTower(num - 1, source, _buffer, destination)
        moveTop(source, destination)
        hanoiMoveTower(num - 1, _buffer, destination, source)

def main():
    towers = [list(), list(), list()]
    for n in range(10, 0, -1):
        towers[0].append(n)
    print(towers)   # before
    hanoiMoveTower(len(towers[0]), towers[0], towers[2], towers[1])
    print(towers)   # after


if __name__ == '__main__':
    main()