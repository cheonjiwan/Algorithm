from collections import deque
import sys
input=sys.stdin.readline

t=int(input().rstrip())
for _ in range(t):
    p=input().rstrip()
    n=int(input().rstrip())
    data=input().rstrip()[1:-1].split(',')
    if n==0: 
        data=deque([])
    else: data=deque(data)
    flag=False;error_flag=False
    for c in p:
        if c=='R':
            if not flag: flag=True
            else: flag=False
        elif c=='D':
            if flag: 
                if data: data.pop()
                else: 
                    print('error')
                    error_flag=True
                    break
            else: 
                if data: data.popleft()
                else: 
                    print('error')
                    error_flag=True
                    break
    if not error_flag:
        if flag:
            print('[',end='')
            for i in range(len(data)-1,-1,-1):
                if i==0:
                    print(data[i],end='')
                else: print('{0},'.format(data[i]),end='')
            print(']')
        else:
            print('[',end='')
            for i in range(len(data)):
                if i==len(data)-1:
                    print(data[i],end='')
                else: print('{0},'.format(data[i]),end='')
            print(']')
