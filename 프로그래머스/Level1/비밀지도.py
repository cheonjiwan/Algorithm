from collections import deque
def solution(n,arr1,arr2):
    board=[[' ' for _ in range(n)] for _ in range(n)]
    answer=[]
    row=0
    for num in arr1:
        q=deque()
        while num!=0:
            q.appendleft(num%2);num//=2
        for idx in range(len(q),n):
            q.appendleft(0)
        for i in range(len(q)):
            if q[i]==1: board[row][i]='#'
        row+=1
    row=0
    for num in arr2:
        q=deque()
        while num!=0:
            q.appendleft(num%2);num//=2
        for idx in range(len(q),n):
            q.appendleft(0)
        for i in range(len(q)):
            if q[i]==1: board[row][i]='#'
        row+=1
    for row in board:
        answer.append(''.join(row))
    return answer


n=5
arr1=[9,20,28,18,11]
arr2=[30,1,21,17,28]
solution(n,arr1,arr2)