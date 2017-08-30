"""
Draw a straight line on a monochrome screen
"""

def drawline(array, width, x1, x2, y):
    start_off = x1 % 8
    first_full_byte = x1 // 8
    if (start_off > 0):
        first_full_byte += 1    # current 0-index byte is partial

    end_off = x2 % 8
    last_full_byte = x2 // 8
    if (end_off < 7):           # current byte is partial so full till previous
        last_full_byte -= 1

    # fill full bytes
    for b in range(first_full_byte, last_full_byte + 1):
        array[y * (width // 8) + b] = 0xFF

    start_mask = 0xFF >> start_off                      # trailing ones
    end_mask = ~(~0 << 8) & ~(0xFF >> (end_off + 1))    # leading ones

    if (x1//8) == (x2//8):
        mask = start_mask & end_mask
        array[(width // 8) * y + (x1//8)] |= mask
    else:
        if start_off != 0:
            b = (width // 8) * y + first_full_byte - 1
            array[b] |= start_mask

        if end_off != 7:
            b = (width // 8) * y + last_full_byte - 1
            array[b] |= end_mask


def main():
    byte_arr = bytearray(20)
    drawline(byte_arr, 32, 3, 27, 4)
    for i in range(5):
        for j in range(4):
            print(bin(byte_arr[i * 4 + j]), end=' ')
        print()

if __name__ == '__main__':
    main()