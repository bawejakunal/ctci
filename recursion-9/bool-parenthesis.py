"""
Given a boolean expression with &,|,^ operators
Count the number of ways of parenthesization for a given
output
Boolean outputs expected are 1 or 0, i.e true or false respectively
"""

def countRecursive(expr, result):
    if expr is None or len(expr) < 0:
        return 0

    if len(expr) == 1:
        return 1 if int(expr, 2) == result else 0

    count = 0
    for i in range(len(expr)-1):
        if expr[i] == '|':
            if result == 1:
                leftTrue = countRecursive(expr[:i], 1)
                leftFalse = countRecursive(expr[:i], 0)
                rightTrue = countRecursive(expr[i+1:], 1)
                rightFalse = countRecursive(expr[i+1:], 0)
                count += leftTrue * rightTrue
                count += leftTrue * rightFalse
                count += leftFalse * rightTrue
            else:
                leftFalse = countRecursive(expr[:i], 0)
                rightFalse = countRecursive(expr[i+1:], 0)
                count += leftFalse * rightFalse

        elif expr[i] == '&':
            left = 0
            right = 0
            if result == 1:
                left = countRecursive(expr[:i], 1)
                right = countRecursive(expr[i+1:], 1)
            else:
                left = countRecursive(expr[:i], 0)
                right = countRecursive(expr[i+1:], 0)
            count += left * right

        elif expr[i] == '^':
            leftTrue = countRecursive(expr[:i], 1)
            leftFalse = countRecursive(expr[:i], 0)
            rightTrue = countRecursive(expr[i+1:], 1)
            rightFalse = countRecursive(expr[i+1:], 0)
            if result == 1:
                count += leftTrue * rightFalse
                count += leftFalse * rightTrue
            else:
                count += leftFalse * rightFalse
                count += leftTrue * rightTrue

    return count

def countDP(counts, expr, result):

    # cached solution
    if expr in counts:
        if expr[result] is not None:
            return counts[expr][result]

    # build solution
    if expr not in counts:
        counts[expr] = [None, None]
    
    # trivial solution
    if len(expr) == 1:
        if int(expr, 2) == 1:
            counts[expr][0] = 0
            counts[expr][1] = 1
        else:
            counts[expr][0] = 1
            counts[expr][1] = 0

        return counts[expr][result]

    count = 0
    for i in range(len(expr)-1):
        if expr[i] == '|':
            if result == 1:
                leftTrue = countRecursive(expr[:i], 1)
                leftFalse = countRecursive(expr[:i], 0)
                rightTrue = countRecursive(expr[i+1:], 1)
                rightFalse = countRecursive(expr[i+1:], 0)
                count += leftTrue * rightTrue
                count += leftTrue * rightFalse
                count += leftFalse * rightTrue
            else:
                leftFalse = countRecursive(expr[:i], 0)
                rightFalse = countRecursive(expr[i+1:], 0)
                count += leftFalse * rightFalse

        elif expr[i] == '&':
            left = 0
            right = 0
            if result == 1:
                left = countRecursive(expr[:i], 1)
                right = countRecursive(expr[i+1:], 1)
            else:
                left = countRecursive(expr[:i], 0)
                right = countRecursive(expr[i+1:], 0)
            count += left * right

        elif expr[i] == '^':
            leftTrue = countRecursive(expr[:i], 1)
            leftFalse = countRecursive(expr[:i], 0)
            rightTrue = countRecursive(expr[i+1:], 1)
            rightFalse = countRecursive(expr[i+1:], 0)
            if result == 1:
                count += leftTrue * rightFalse
                count += leftFalse * rightTrue
            else:
                count += leftFalse * rightFalse
                count += leftTrue * rightTrue

    counts[expr][result] = count    # store result
    return counts[expr][result]


def countWays(expr, result):
    counts = dict()
    countDP(counts, expr, result)
    return counts[expr][result]

def main():
    expr = "1^0|0|1"
    print(countRecursive(expr, 1)) # expected 3
    print(countWays(expr, 1))

if __name__ == '__main__':
    main()