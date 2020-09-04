n,m = map(int,input().split(' '))
heights = list(map(int,input().split()))

start = 0
end = max(heights)

result = 0
while start<=end:
    total = 0
    mid = (start+end)//2
    for height in heights:
        if height>mid:
            total+=height-mid 
    
    if(total<m):
        end = mid-1
    else:
        result = mid
        start = mid+1

print(result)

    
