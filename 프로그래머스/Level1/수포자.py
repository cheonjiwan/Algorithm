def solution(answers):
    result=[]
    a=[1,2,3,4,5];b=[2,1,2,3,2,4,2,5];c=[3,3,1,1,2,2,4,4,5,5]
    grade=[[1,0],[2,0],[3,0]]
    a_idx,b_idx,c_idx=0,0,0
    for answer in answers:
        if answer==a[a_idx]: grade[0][1]+=1
        if answer==b[b_idx]: grade[1][1]+=1
        if answer==c[c_idx]: grade[2][1]+=1
        a_idx=(a_idx+1)%len(a)
        b_idx=(b_idx+1)%len(b)
        c_idx=(c_idx+1)%len(c)

    grade=sorted(grade,key=lambda x: -x[1])
    
    result.append(grade[0][0])
    for i in range(1,len(grade)):
        if grade[i][1]==grade[0][1]: result.append(grade[i][0])
        else:
            break
    
    return result

answers=[1,2,3,4,5]
# answers=[1,3,2,4,2]
print(solution(answers))