input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input());data=list(MIS());stack=[]
result=[-1 for _ in range(n)]
for i in range(len(data)):
    try:
        while data[stack[-1]]<data[i]:
            result[stack.pop()]=data[i]
    except:
        pass
    stack.append(i)
        
for num in result:
    print(num,end=' ')