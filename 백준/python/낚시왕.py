# 낚시왕
import sys,copy
from collections import deque
input = sys.stdin.readline
R,C,M = map(int,input().rstrip().split())
board = eval(("[[0]*(C+1)]+"*(R+1))[:-1])
# board = [[0]*(C+1) for _ in range(R+1)]
result = 0
row,col = 0,0
c_s = 0
for _ in range(M):
    r,c,s,d,z = map(int,input().rstrip().split())
    #board[r][c] = (r,c,s,d,z)
    board[r][c] = (s,d,z)

# start
for i in range(1,C+1):
    for j in range(1,R+1):
        if board[j][i] != 0:
            result += board[j][i][2]
            board[j][i]=0
            break
    
    # board2 = [[0]*(C+1) for _ in range(R+1)]
    board2 = eval(("[[0]*(C+1)]+"*(R+1))[:-1])
    for x in range(1,R+1):
        for y in range(1,C+1):
            if board[x][y]!=0:
                s,d,z = board[x][y]
                if d==1: # up
                    if x-s >=1:
                        row = x-s
                        col = y
                    else:
                        c_s = s-(x-1)
                        count= c_s//(R-1)
                        count2 = c_s - (count*(R-1))
                        if count==0:
                            d=2
                            row = 1+count2
                            col=y
                        else:
                            if count%2==0:
                                d=2
                                row = 1+count2
                                col = y
                            else:
                                if count2>0:
                                    d=1
                                else:
                                    d=2
                                row = R-count2
                                col=y
                elif d==2: # down
                    if x+s<=R:
                        row = x+s
                        col = y
                    else:
                        c_s = s-(R-x)
                        count = c_s//(R-1)
                        count2 = c_s-(count*(R-1))
                        if count==0:
                            d=1
                            row = R-count2
                            col = y
                        else:
                            if count%2==0:
                                d=1
                                row = R-count2
                                col = y
                            else:
                                if count2>0:
                                    d=2
                                else:
                                    d=1
                                row = 1+count2
                                col = y
                elif d==3: # right
                    if y+s<=C:
                        col = y+s
                        row = x
                    else:
                        c_s = s-(C-y)
                        count = c_s // (C-1)
                        count2 = c_s-(count*(C-1))
                        if count==0:
                            d=4
                            col = C-count2
                            row = x
                        else:
                            if count%2==0:
                                d=4
                                col = C-count2
                                row = x
                            else:
                                if count2>0:
                                    d=3
                                else:
                                    d=4
                                col = 1+count2
                                row = x
                elif d==4: # left
                    if y-s >=1:
                        col = y-s
                        row = x
                    else:
                        c_s = s-(y-1)
                        count = c_s // (C-1)
                        count2 = c_s - (count*(C-1))
                        if count==0:
                            d=3
                            col = 1+count2
                            row = x
                        else:
                            if count%2==0:
                                d=3
                                col = 1+count2
                                row = x
                            else:
                                if count2>0:
                                    d=4
                                else:
                                    d=3
                                col = C-count2
                                row = x

                if board2[row][col]!=0:
                    if board2[row][col][2] < z:
                        board2[row][col] = (s,d,z)
                        row,col = 0,0
                        c_s = 0
                else:            
                    board2[row][col] = (s,d,z)
                    row,col = 0,0
                    c_s = 0
    board = copy.deepcopy(board2)

print(result)