"""
Insert N into M from bits i to j (inclusive)
Assume: N has sufficient space to accomodate M
"""

def isValidIndex(idx):
    return 0 <= idx <= 31

def insert(N, M, i, j):
    if not (isValidIndex(i) and isValidIndex(j)) or j < i:
        raise ValueError('Index out of range')

    mask = (~0) << (j + 1)      # leading ones
    mask |= (1 << i) - 1        # trailing ones
    num = N & mask              # zero out i to j inclusive
    num |= M << i               # insert num
    return num

def main():
    print('Enter binary numbers as string')
    N = int(input('N: '), 2)
    M = int(input('M: '), 2)
    i = int(input('i: ').strip())
    j = int(input('j: ').strip())
    print(bin(insert(N, M, i, j)))

if __name__ == '__main__':
    main()