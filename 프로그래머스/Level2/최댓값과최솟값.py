def solution(s):
    answer=''
    nums=list(map(int,s.split(' ')))
    answer+=str(min(nums))+' '+str(max(nums))
    return answer