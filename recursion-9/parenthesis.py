"""
Given N, generate all combinations of N balanced parenthesis pairs
"""

def genParenDuplicate(remaining):
    """
    Repeated parenthesis are generated in recursive case
    We avoid repititions by using an hashset, though this
    does not help with time complexity
    """
    parens = set()
    if remaining <= 0:
        parens.add("")
    else:
        prev = genParenDuplicate(remaining - 1)
        for p in prev:
            parens.add("()" + p)        # add before
            for i in range(len(p)):
                if p[i] == '(':
                    parens.add(p[:i+1] + "()" + p[i+1:])
    return parens


def __genParenBackTrack__(parens, chars, leftRemaining, rightRemaining, idx):
    """
    To avoid duplicates we use a generative algorithm where parenthesis
    are generated from scratch. We backtrack through the search space
    in case we end up at unbalanced parenthesis
    """

    # backtrack from unbalanced
    if leftRemaining < 0 or rightRemaining < leftRemaining:
        return

    # valid parenthesis generated
    elif leftRemaining == 0 and rightRemaining == 0:
        parens.append("".join(chars))

    else:
        if leftRemaining > 0:
            chars[idx] = '('
            __genParenBackTrack__(parens, chars, leftRemaining - 1,
                                  rightRemaining, idx + 1)

        # equality NOT valid because once we insert at equality
        # the parenthesis will become invalid at next call as
        # rightRemaining < leftRemaining
        if rightRemaining > leftRemaining:
            chars[idx] = ')'
            __genParenBackTrack__(parens, chars, leftRemaining,
                                  rightRemaining - 1, idx + 1)

def genWithBackTrack(N):
    parens = list()
    chars = [''] * N * 2 # N pairs = 2N characters
    __genParenBackTrack__(parens, chars, N, N, 0)
    return parens

def main():
    N = int(input().strip())
    parenlist = genWithBackTrack(N)
    for p in parenlist:
        print(p, end=' ')
    print()

    parenset = genParenDuplicate(N)
    for p in parenset:
        print(p, end=' ')
    print()

    def __checkEqual__(s1, s2):
        for p in s1:
            if p not in s2:
                return False
        return True

    print('EQUAL' if __checkEqual__(parenlist, parenset) else 'WRONG')

if __name__ == '__main__':
    main()