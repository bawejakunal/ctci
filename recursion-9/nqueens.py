"""
On a NxN chess board, place N queens such that no two queens are on the same
column, row or diagonal.
"""

def isCompatible(columns, col, row):
    if (row < 0 or row >= len(columns) or col < 0 or
        col >= len(columns)):
        return False

    #check all previously placed queens
    for c in range(col):
        # check for same row
        if columns[c] == row:
            return False

        # check for diagonals by row dist == col dist
        if abs(columns[c] - row) == (col - c):
            return False

        # no need to check for column equality as we always place
        # queen in new column

    return True


def __arrangeNQueens__(arrange, columns, current, total):
    """
    @param: arrange - set of arrangements
    @param: columns - current board configuration
    @param: current - column number to place queen into
    @param: total   - size of the board
    """

    # invalid
    if current < 0 or current > total:
        return

    # valid board generated
    elif current == total:
        arrange.append(columns.copy())

    else:
        for row in range(0, total):
            # check with previous placements
            if isCompatible(columns, current, row):
                columns[current] = row  # place queen and search further
                __arrangeNQueens__(arrange, columns, current + 1, total)


def arrangeQueens(N):
    """
    Place one queen at a time
    Try all columns at a row.
    Before placing a queen ensure its valid with previously place queens
    """
    arrangements = list()
    columns = [None] * N
    __arrangeNQueens__(arrangements, columns, 0, N)
    return arrangements

def main():
    N = int(input().strip())
    print(arrangeQueens(N))

if __name__ == '__main__':
    main()