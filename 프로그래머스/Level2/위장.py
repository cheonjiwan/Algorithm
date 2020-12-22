from itertools import combinations
def solution(clothes):
    answer=1
    mydic={}
    for clothe in clothes:
        if clothe[1] not in mydic: mydic[clothe[1]]=[clothe[0]]
        else: mydic[clothe[1]].append(clothe[0])
    for item in mydic:
        answer*=len(mydic[item])+1    
    return answer-1
