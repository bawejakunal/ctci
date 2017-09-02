"""
Given a set of numbers, return a list of all of its subsets
"""
import copy

def getSubSets(_set, size):
    """
    @param size: index to insert
    @param _set: given set of numbers
    @return: a list of subsets containing numbers from 0 to idx
    """
    subsets = None
    if size == 0:
        subsets = list()
        subsets.append(list())               # empty subset
    else:
        idx = size - 1
        subsets = getSubSets(_set, idx)      # subsets of elements till idx-1
        addSubsets = list()                  # additional subsets with idx
        for subset in subsets:
            newSubset = copy.copy(subset)
            newSubset.append(_set[idx])      # add set item from idx
            addSubsets.append(newSubset)     # addition subset
        subsets.extend(addSubsets)           # extend list of subsets

    return subsets 

def main():
    _set = [1,2,3]
    print(getSubSets(_set, len(_set)))

if __name__ == '__main__':
    main()