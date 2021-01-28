from bisect import bisect_left
input=__import__('sys').stdin.readline

l=int(input().rstrip())
arr=list(map(int,input().rstrip().split()))
stack=[0]

for a in arr:
    if stack[-1]<a:
        stack.append(a)
    else:
        stack[bisect_left(stack,a)]=a

print(len(stack)-1)