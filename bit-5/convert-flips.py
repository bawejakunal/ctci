def main():
    a, b = list(map(int, input().split()))
    flips = a ^ b
    cnt = 0
    while flips != 0:
        cnt += (flips & 1)
        flips >>= 1
    print(cnt)

if __name__ == '__main__':
    main()