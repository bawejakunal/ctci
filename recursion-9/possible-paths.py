"""
Possible ways for a robot to from top left (0, 0) to bottom right (X, Y)
Allowed moves: Right or Down
"""

def countWays(X, Y):
    matrix = [[1 for x in range(X+1)] for y in range(Y+1)]
    for y in range(1, Y+1):
        for x in range(1, X+1):
            matrix[y][x] = matrix[y][x-1] + matrix[y-1][x]
    return matrix[Y][X]

def main():
    X = int(input('X: ').strip())
    Y = int(input('Y: ').strip())
    print(countWays(X, Y))

if __name__ == '__main__':
    main()
