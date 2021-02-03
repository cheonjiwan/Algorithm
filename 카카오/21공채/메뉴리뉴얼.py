from itertools import combinations

def solution(orders, course):
    orders=[sorted(i) for i in orders]
    mydic={};len_max={}
    for num in course:
        len_max[num]=0

    for order in orders:
        order_len=len(order)
        for num in course:
            if order_len<num: continue

            result=combinations(order,num)
            for item in result:
                item=''.join(item)
                if item not in mydic: mydic[item]=1
                else: mydic[item]+=1
                len_max[num]=max(len_max[num],mydic[item])

    results=[]
    for num in course:
        for key,value in mydic.items():
            if len(key)==num and len_max[num]>1 and len_max[num]==value :
                results.append(key)
    
    return sorted(results)

orders=["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]
course=[2,3,5]
print(solution(orders,course))