"""
Given array A is sorted. It is said to have a magic index i if A[i] == i
Return i if magic index exists else return -1
"""

def findMagicIndex(array, start, end):
    if end < start:
        return -1
    mid = (start + end) // 2
    if array[mid] == mid:
        return mid
    elif array[mid] < mid:
        left = min(mid - 1, array[mid])
        idx = findMagicIndex(array, mid + 1, end)
        return idx if idx > -1 else findMagicIndex(array, start, left)
    else:
        right = max(mid + 1, array[mid])
        idx = findMagicIndex(array, start, mid - 1)
        return idx if idx > -1 else findMagicIndex(array, right, end)

def main():

    # Case-1 repeated indices
    array = [0 ,2, 3, 3, 3, 3, 7, 9, 10, 10]
    print(findMagicIndex(array, 0, len(array)-1))

    # case-2 no repeated
    array = [-3, -2, -1, 0, 1, 2, 3, 7]
    print(findMagicIndex(array, 0, len(array)-1))

    # case-3 none exists
    array = [5, 6, 7, 8, 9]
    print(findMagicIndex(array, 0, len(array)-1))


if __name__ == '__main__':
    main()