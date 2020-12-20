def solution(name):
    ans=0
    ans1=0;ans2=0;cnt=0
    str_to_int=[min( ord(c)-ord('A'), 26-(ord(c)-ord('A')) ) for c in name]

    idx=0
    while True:
        ans+=str_to_int[idx]
        str_to_int[idx]=0
        if sum(str_to_int)==0: return ans

        left,right=1,1
        while str_to_int[idx-left]==0: left+=1
        while str_to_int[idx+right]==0: right+=1
        ans+=left if left<right else right
        idx+= -left if left<right else right