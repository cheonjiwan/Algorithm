from collections import deque

properties = list(map(int,input()))
location = int(input())

def solution(properties, location):
    cnt=0
    answer = 0
    properties = deque(properties)
    while True:
        flag=0
        for i in range(1,len(properties)):
            if(properties[0] < properties[i]):
                a = properties.popleft()
                properties.append(a)
                location -=1
                flag=1
                if(location == -1):
                    location = len(properties)-1
                break
            else:
                continue
        if flag==0:
            if location != 0:
                trash = properties.popleft()
                location -=1
                cnt+=1
            else:
                answer = cnt+1
                return answer

print(solution(properties,location))