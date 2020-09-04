def binary_search(array,start,end,target):
    if start>end:
        return None;
    mid = (start+end)//2
    if(target==array[mid]):
        return mid
    elif(target < array[mid]):
        return binary_search(array,start,mid-1,target)
    else:
        return binary_search(array,mid+1,end,target)
        

n, target = list(map(int,input().split()))
array = list(map(int,input().split()))

result = binary_search(array,0,n-1,target)

if result == None:
    print('찾으시는 값이 없습니다.')
else:
    print(result+1)
