def move(myMap,direction):
    global size,merge

    movedMap = [[0 for col in range(size)] for row in range(size)]
    #sumMap= [[0 for col in range(size)] for row in range(size)]

    if(direction==0): # left
        for i in range(size):
            index=0
            j = 0
            while j<size:
                if(myMap[i][j]==0):
                    j+=1
                    continue
                else:
                    if(index==0):
                        movedMap[i][index]=myMap[i][j]
                        index+=1
                    else:
                        if(myMap[i][j]==movedMap[i][index-1]):
                            if(merge==False):
                                movedMap[i][index-1]*=2
                                merge=True
                            else:
                                movedMap[i][index]=myMap[i][j]
                                index+=1
                                merge=False
                        else:
                            movedMap[i][index]=myMap[i][j]
                            index+=1
                            merge=False
                
                j+=1
            merge=False
                
    elif(direction==1): # down
        pass
    elif(direction==2): # right
        for i in range(size):
            index=size-1
            j = size-1
            while j>=0:
                if(myMap[i][j]==0):
                    j-=1
                    continue
                else:
                    if(index==size-1):
                        movedMap[i][index]=myMap[i][j]
                        index-=1
                    else:
                        if(myMap[i][j]==movedMap[i][index+1]):
                            if(merge==False):
                                movedMap[i][index+1]*=2
                                merge=True
                            else:
                                movedMap[i][index]=myMap[i][j]
                                index-=1
                                merge=False
                        else:
                            movedMap[i][index]=myMap[i][j]
                            index-=1
                            merge=False
                
                j-=1
            merge=False
    elif(direction==3): #up
        pass

    return movedMap
                
def dfs(myMap,depth):
    global maxValue
    if depth==10:
        for Map_row in myMap:
            data = max(Map_row)
            if(data>maxValue):
                maxValue = data
        return
    
    for i in range(4):
        returnMap = move(myMap,i)
        merge=False
        dfs(returnMap,depth+1)

maxValue = 0
size = int(input())
myMap = []
merge = False
for i in range(size):
    myMap.append(list(map(int,input().split())))

# 0:left, 1:down, 2:right, 3:up


myMap = move(myMap,2)
print(myMap)
# dfs(myMap,0)
# print(maxValue)