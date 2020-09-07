import sys

# sys.setrecursionlimit(10 ** 8)  # 10^8 까지 늘림.


def move(myMap, direction):
    global size, merge
    global maxValue
    movedMap = [[0 for col in range(size)] for row in range(size)]

    if direction == 0:  # left
        for i in range(size):
            index = 0
            j = 0
            while j < size:
                if myMap[i][j] != 0:
                    if (
                        index != 0
                        and myMap[i][j] == movedMap[i][index - 1]
                        and merge == False
                    ):
                        movedMap[i][index - 1] *= 2
                        maxValue = max(maxValue, movedMap[i][index - 1])
                        merge = True
                    else:
                        movedMap[i][index] = myMap[i][j]
                        index += 1
                        merge = False

                j += 1
            merge = False

    elif direction == 1:  # down
        for i in range(size):
            index = size - 1
            j = size - 1
            while j >= 0:
                if myMap[j][i] != 0:
                    if (
                        index != size - 1
                        and myMap[j][i] == movedMap[index + 1][i]
                        and merge == False
                    ):
                        movedMap[index + 1][i] *= 2
                        maxValue = max(maxValue, movedMap[index + 1][i])
                        merge = True
                    else:
                        movedMap[index][i] = myMap[j][i]
                        index -= 1
                        merge = False
                j -= 1
            merge = False
    elif direction == 2:  # right
        for i in range(size):
            index = size - 1
            j = size - 1
            while j >= 0:
                if myMap[i][j] != 0:
                    if (
                        index != size - 1
                        and myMap[i][j] == movedMap[i][index + 1]
                        and merge == False
                    ):
                        movedMap[i][index + 1] *= 2
                        maxValue = max(maxValue, movedMap[i][index + 1])
                        merge = True
                    else:
                        movedMap[i][index] = myMap[i][j]
                        index -= 1
                        merge = False

                j -= 1
            merge = False
    elif direction == 3:  # up
        for i in range(size):
            index = 0
            j = 0
            while j < size:
                if myMap[j][i] != 0:
                    if (
                        index != 0
                        and myMap[j][i] == movedMap[index - 1][i]
                        and merge == False
                    ):
                        movedMap[index - 1][i] *= 2
                        maxValue = max(maxValue, movedMap[index - 1][i])
                        merge = True
                    else:
                        movedMap[index][i] = myMap[j][i]
                        index += 1
                        merge = False
                j += 1
            merge = False

    return movedMap


def checkMap(myMap, returnMap):
    for i in range(size):
        for j in range(size):
            if myMap[i][j] != returnMap[i][j]:
                return False
    return True


def dfs(myMap, depth):
    global max_v
    if depth == 5:
        return
    if (maxValue == max_v):
        print(maxValue)
        sys.exit()

    for i in range(4):
        returnMap = move(myMap, i)
        # merge = False
        flag = checkMap(myMap, returnMap)
        if flag == False:
            dfs(returnMap, depth + 1)


maxValue = 0
flag = 0
size = int(sys.stdin.readline())
myMap = []
merge = False
total=0
for i in range(size):
    myMap.append(list(map(int, sys.stdin.readline().split())))
    if maxValue < max(myMap[i]):
        maxValue = max(myMap[i])
    for c in range(size):
        tmp = myMap[i][c]
        if tmp!=0:
            total+=tmp

max_v = 0
while total != 1:
    total//=2
    max_v *=2

# 0:left, 1:down, 2:right, 3:up

# myMap = move(myMap, 1)
# print(myMap)
dfs(myMap, 0)
print(maxValue)