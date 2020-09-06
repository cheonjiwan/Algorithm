def move(myMap,direction):
    global size
    movedMap = [[0 for col in range(size)] for row in range(size)]
    sumMap= [[0 for col in range(size)] for row in range(size)]

    if(direction==0): # left
        # remove 0
        for i in range(size):
            index=0
            j = 0
            while j<size:
                if(myMap[i][j]==0):
                    while j<size and myMap[i][j]==0:
                        j+=1
                    if(j<size):
                        movedMap[i][index]=myMap[i][j]
                        #myMap[i][j]=0
                        index+=1
                    else:
                        continue
                else:
                    movedMap[i][index]=myMap[i][j]
                    index+=1
                j+=1
                
        
        # move
        for i in range(size):
            index=0
            j=0
            while j<size:
                if(j==size-1):
                    sumMap[i][index]=movedMap[i][j]
                    index+=1
                    break
                if(movedMap[i][j]==movedMap[i][j+1]):
                   sumMap[i][index]=movedMap[i][j]*2
                   j+=1
                   index+=1
                else:
                    sumMap[i][index]=movedMap[i][j]
                    index+=1
                j+=1    
    elif(direction==1): # down
        # remove 0
        for i in range(size):
            index=size-1
            j=size-1
            while j>=0:
                if(myMap[j][i]==0):
                    while j>=0 and myMap[j][i]==0:
                        j-=1
                    if(j>=0):
                        movedMap[index][i]=myMap[j][i]
                       # myMap[j][i]=0
                        index-=1
                    else:
                        continue
                else:
                    movedMap[index][i]=myMap[j][i]
                    index-=1
                j-=1
        # move
        for i in range(size):
            index=size-1
            j=size-1
            while j>=0:
                if(j==0):
                    sumMap[index][i]=movedMap[j][i]
                    index-=1
                    break
                if(movedMap[j][i]==movedMap[j-1][i]):
                   sumMap[index][i]=movedMap[j][i]*2
                   j-=1
                   index-=1
                else:
                    sumMap[index][i]=movedMap[j][i]
                    index-=1
                j-=1
    elif(direction==2): # right
        # remove 0
        
        for i in range(size):
            index=size-1
            j=size-1
            while j>=0:
                if(myMap[i][j]==0):
                    while j>=0 and myMap[i][j]==0:
                        j-=1
                    if(j>=0):
                        movedMap[i][index]=myMap[i][j]
                      #  myMap[i][j]=0
                        index-=1
                    else:
                        continue
                else:
                    movedMap[i][index]=myMap[i][j]
                    index-=1
                j-=1

        # move
        for i in range(size):
            index=size-1
            j=size-1
            while j>=0:
                if(j==0):
                    sumMap[i][index]=movedMap[i][j]
                    index-=1
                    break
                if(movedMap[i][j]==movedMap[i][j-1]):
                   sumMap[i][index]=movedMap[i][j]*2
                   j-=1
                   index-=1
                else:
                    sumMap[i][index]=movedMap[i][j]
                    index-=1
                j-=1
    elif(direction==3): #up
        # remove 0
        for i in range(size):
            index=0
            j=0
            while j<size:
                if(myMap[j][i]==0):
                    while j<size and myMap[j][i]==0:
                        j+=1
                    if(j<size):
                        movedMap[index][i]=myMap[j][i]
                     #   myMap[j][i]=0
                        index+=1
                    else:
                        continue
                else:
                    movedMap[index][i]=myMap[j][i]
                    index+=1
                j+=1

        # move
        for i in range(size):
            index=0
            j=0
            while j<size:
                if(j==size-1):
                    sumMap[index][i]=movedMap[j][i]
                    index+=1
                    break
                if(movedMap[j][i]==movedMap[j+1][i]):
                   sumMap[index][i]=movedMap[j][i]*2
                   j+=1
                   index+=1
                else:
                    sumMap[index][i]=movedMap[j][i]
                    index+=1
                j+=1
    return sumMap
                
def dfs(myMap,depth):
    global maxValue
    if depth==5:
        for Map_row in myMap:
            data = max(Map_row)
            if(data>maxValue):
                maxValue = data
        return
    
    for i in range(4):
        returnMap = move(myMap,i)
        dfs(returnMap,depth+1)

maxValue = 0
size = int(input())
myMap = []
for i in range(size):
    myMap.append(list(map(int,input().split())))

# 0:left, 1:down, 2:right, 3:up



dfs(myMap,0)
print(maxValue)