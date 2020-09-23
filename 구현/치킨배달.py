from itertools import combinations,permutations
import sys
input = sys.stdin.readline

INF = 987654321
n,m = map(int,input().split())
board = []
a = []
b = []

for _ in range(n):
    data = list(map(int,input().split()))
    board.append(data)

for r in range(n):
    for c in range(n):
        if board[r][c]==1: # 집
            a.append((r,c))
        elif board[r][c]==2: # 치킨
            b.append((r,c))


minCityValue = INF
minHoustValue = INF

cost = INF
totalHouseCost = INF
HouseCost = 0
chicken_combi = []

for i in range(1,m+1):
    chicken_combi = list(combinations(b,i))    
    for chicken in chicken_combi:
        for house in a:
            for chicken_pos in chicken:
                cost = min(cost, abs(house[0]-chicken_pos[0])+abs(house[1]-chicken_pos[1]))
            HouseCost += cost
            cost = INF
        totalHouseCost = min(totalHouseCost, HouseCost)
        HouseCost = 0
print(totalHouseCost)
