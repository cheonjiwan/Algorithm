from collections import deque

input=__import__('sys').stdin.readline
data=list(map(str,input().rstrip()))
n=int(input().rstrip())
tmp=deque()
for _ in range(n):
    order=list(map(str,input().rstrip().split()))
    if order[0]=='P':
        data.append(order[1])
    elif order[0]=='L':
        if data:
            tmp.appendleft(data.pop())
    elif order[0]=='B':
        if data:
            data.pop()
    elif order[0]=='D':
        if tmp:
            data.append(tmp.popleft())

result=data+list(tmp)
print(''.join(result))