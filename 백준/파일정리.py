n=int(input());mydic={}
for _ in range(n):
    data=input().split('.')
    if data[1] not in mydic:mydic[data[1]]=1
    else:mydic[data[1]]+=1

result=sorted(mydic.items(),key=lambda x:x[0])
for item in result:
    print(item[0],end=" ")
    print(item[1])