import sys
input = sys.stdin.readline

triangle = []
n = int(input().rstrip())
for _ in range(n):
    triangle.append(list(map(int,input().rstrip().split())))

for i in range(1,n):
    for j in range(i+1):
        # 왼쪽으로 내려오는 거
        if i==j:
            down_to_left=0
        else:
            down_to_left = triangle[i-1][j]
        # 오른쪽으로 내려오는 거
        if j==0:
            down_to_right = 0
        else:
            down_to_right = triangle[i-1][j-1]
        
        triangle[i][j] = triangle[i][j]+max(down_to_left,down_to_right)

print(max(triangle[n-1]))
            