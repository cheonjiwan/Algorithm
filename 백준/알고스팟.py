input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
m,n=MIS();board=[]
for _ in range(n):
    board.append(list(MIS()))