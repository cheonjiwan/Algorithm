input=__import__('sys').stdin.readline
t=int(input().rstrip())

def solution(nums):
    for i in range(len(nums)-1):
        flag=False
        for j in range(len(nums[i])):
            if nums[i][j]!=nums[i+1][j]: flag=True;break
        if not flag: return False
    return True
        
for _ in range(t):
    n=int(input().rstrip())
    nums=[]
    for _ in range(n):
        nums.append(input().rstrip())
    nums=sorted(nums)

    result=solution(nums)
    if result: print('YES')
    else: print('NO')