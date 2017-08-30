"""
Check if a number is power of 2
"""

def main():
    n = int(input().strip())
    if n > 0 and (n & (n-1)) == 0:
        print('POWER OF TWO')
    else:
        print('NOPE')


if __name__ == '__main__':
    main()