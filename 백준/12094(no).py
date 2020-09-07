import sys, copy
from collections import deque


def move(myMap, direction, paramMax):
    global size, merge
    global visited

    maxValue = paramMax
    # movedMap = copy.deepcopy(copyMap)
    # movedMap = [[0] * size for _ in range(size)]
    movedMap = []
    row = deque()

    if direction == 0:  # left
        for i in range(size):
            index = 0
            j = 0
            while j < size:
                if myMap[i][j] != 0:
                    if index != 0 and myMap[i][j] == row[index - 1] and merge == False:
                        row[index - 1] *= 2
                        maxValue = max(maxValue, row[index - 1])
                        merge = True
                    else:
                        row.append(myMap[i][j])
                        # movedMap[i].append(myMap[i][j])
                        # new_c[i].append(myMap[i][j])
                        # movedMap[i][index] = myMap[i][j]
                        index += 1
                        merge = False

                j += 1

            merge = False
            for x in range(index,size):
                row.append(0)
            movedMap.append(list(row))
            row = deque()

    elif direction == 1:  # down
        for p in range(size):
            movedMap.append([])

        for i in range(size):
            count=0
            index = 0
            j = size - 1
            while j >= 0:
                if myMap[j][i] != 0:
                    if (
                        index != 0
                        and myMap[j][i] == row[index]
                        and merge == False
                    ):
                        row[index] *= 2
                        maxValue = max(maxValue, row[index])
                        merge = True
                    else:
                        row.appendleft(myMap[j][i])
                        count+=1
                        #movedMap[index][i] = myMap[j][i]
                        index -= 1
                        merge = False
                j -= 1
            merge = False
            for x in range(count,size):
                row.appendleft(0)
            for x in range(size):
                movedMap[x].append(row.popleft())
                
            row = deque()

    elif direction == 2:  # right
        for i in range(size):
            count=0
            index = 0
            j = size - 1
            while j >= 0:
                if myMap[i][j] != 0:
                    if (
                        index != 0
                        and myMap[i][j] == row[index]
                        and merge == False
                    ):
                        row[index] *= 2
                        maxValue = max(maxValue, row[index])
                        merge = True
                    else:
                        row.appendleft(myMap[i][j])
                        count+=1
                        # movedMap[i].append(myMap[i][j])
                        # movedMap[i][index] = myMap[i][j]
                        index -= 1
                        merge = False

                j -= 1

            merge = False
            for x in range(count,size):
                row.appendleft(0)
            movedMap.append(list(row))
            row = deque()

    elif direction == 3:  # up
        for x in range(size):
            movedMap.append([])

        for i in range(size):
            index = 0
            j = 0
            while j < size:
                if myMap[j][i] != 0:
                    if (
                        index != 0
                        and myMap[j][i] == row[index-1]
                        and merge == False
                    ):
                        row[index - 1] *= 2
                        maxValue = max(maxValue, row[index - 1])
                        merge = True
                    else:
                        row.append(myMap[j][i])
                        index += 1
                        merge = False
                j += 1
            merge = False
            for x in range(index,size):
                row.append(0)
            for x in range(size):
                movedMap[x].append(row.popleft())
                
            row = deque()

    return movedMap, maxValue


def checkMap(myMap, returnMap):
    for i in range(size):
        for j in range(size):
            if myMap[i][j] != returnMap[i][j]:
                return False
    return True


def dfs(myMap, depth):
    global flag
    if depth == 5:
        return

    for i in range(4):
        returnMap, returnMaxValue = move(myMap, i, visited[depth])
        # merge = False
        # flag = checkMap(myMap, returnMap)
        if visited[depth + 1] <= returnMaxValue:
            visited[depth + 1] = returnMaxValue
            flag = checkMap(myMap, returnMap)

        if flag == False:
            dfs(returnMap, depth + 1)


inputMaxValue = 0
size = int(sys.stdin.readline())
myMap = []
merge = False
flag = False
visited = [0] * 11
for i in range(size):
    myMap.append(list(map(int, sys.stdin.readline().split())))
    inputMaxValue = max(inputMaxValue, max(myMap[i]))

visited[0] = inputMaxValue
# 0:left, 1:down, 2:right, 3:up

dfs(myMap, 0)
print(max(visited))

#myMap,maxvalue=move(myMap,1,0)
#myMap=move(myMap,2,0)
#print(myMap)
