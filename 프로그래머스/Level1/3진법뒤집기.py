from collections import deque
def solution(n):
    q=deque()
    while n>0:
        q.appendleft(n%3)
        n//=3
    answer=0;d=1
    for i in range(len(q)):
        answer+=q[i]*d;d*=3
    return answer