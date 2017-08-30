def main():
    num = int(input().strip())
    print(bin(num))
    even = 0x55555555 & num
    odd = 0xaaaaaaaa & num
    swap = (even << 1) | (odd >> 1)
    print("%d\t%s" % (swap, bin(swap)))

if __name__ == '__main__':
    main()