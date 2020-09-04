def binary_search(arr,start,end,target):
    if start>end:
        return 0
    mid = (start+end)//2
    if (target==arr[mid]):
        return 1
    elif(target<arr[mid]):
        return binary_search(arr,start,mid-1,target)
    else:
        return binary_search(arr,mid+1,end,target)

n = int(input())
arr1 = list(map(int, input().split()))
m = int(input())
arr2 = list(map(int,input().split()))

arr1.sort()

for i in range(m):
    result = binary_search(arr1,0,n-1,arr2[i])
    if(result==1):
        print("yes", end=' ')
    else:
        print("no",end = ' ')