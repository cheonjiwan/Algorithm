import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
info=[]
for _ in range(n):
    info.append(list(MIS()))

info=sorted(info,key=lambda x:(x[1],x[0]))
endtime=info[0][1]

cnt=1
for i in range(1,len(info)):
    nextStart,nextEnd=info[i]
    if endtime<=nextStart:
        cnt+=1
        endtime=nextEnd
print(cnt)
