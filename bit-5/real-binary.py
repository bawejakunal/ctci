"""
Print binary representation of a real number between 0 to 1
"""

def binaryStr(num):
    if num <= 0 or num >= 1:
        return "ERROR"
    string = "."
    power = 1/2         # 2 ^ -1
    number = num

    while number > 0:
        if len(string) > 32:
            return "ERROR"

        # 1 after decimal point
        if number >= power:
            string += "1"
            number -= power
        else:
            string += "0"

        power /= 2          # high to low power

    return string

def main():
    num = float(input().strip())
    print(binaryStr(num))

if __name__ == '__main__':
    main()