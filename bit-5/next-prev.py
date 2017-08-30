"""
Given a number find the next greater and previous smaller numbers
such that the number of 1s in 32 bit representation is same as given
number.
"""

def getPrev(number):
    c = [0, 0]
    n = number

    # trailing ones
    while (n & 1) == 1:
        c[1] += 1
        n >>= 1

    if n == 0:
        return -1

    # traling zeroes
    while (n & 1) == 0 and n != 0:
        c[0] += 1
        n >>= 1

    p = sum(c)
    prevNum = number & ((~0) << (p + 1)) # clear pth and trailing bits to 0
    ones = (1 << (c[1] + 1)) - 1         # need c[1] + 1 1s
    ones <<= c[0] - 1                    # 1s followed by c[0]-1 0s
    prevNum |= ones
    return prevNum


def getNext(number):
    c = [0, 0]
    n = number

    # trailing zeros
    while (n & 1) == 0 and n != 0:
        c[0] += 1
        n >>= 1

    # trailing ones
    while (n & 1) == 1:
        c[1] += 1
        n >>= 1

    p = sum(c)
    if p == 31 or p == 0:
        return -1

    nextNum = number | (1 << p)         # set rightmost non-trailing zero
    nextNum &= (~0) << p                # zero all trailing bits after p
    nextNum |= (1 << (c[1] - 1)) - 1
    return nextNum

def main():
    number = int(input().strip())
    print('bin: %s' % bin(number))
    nextNum = getNext(number)
    prevNum = getPrev(number)
    print('next: %d\t%s' % (nextNum, bin(nextNum)))
    print('prev: %d\t%s' % (prevNum, bin(prevNum)))


if __name__ == '__main__':
    main()