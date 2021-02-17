input=__import__('sys').stdin.readline
MIS=lambda:map(str,input().rstrip().split())
n=int(input())
data=list(MIS())

flag=True;last=''
for word in data:
    if last=='': last=word[-1]
    else:
        if last!=word[-1]: flag=False
print(1) if flag else print(0)
