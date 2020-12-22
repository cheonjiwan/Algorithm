def solution(people, limit):
    ans=0
    people=sorted(people,reverse=True)
    i,j=0,len(people)-1
    while i<=j:
        if people[i]+people[j]<=limit: i+=1;j-=1;ans+=1
        else: i+=1;ans+=1

    return ans
people=[20,50,50,80]
limit=100
print(solution(people,limit))