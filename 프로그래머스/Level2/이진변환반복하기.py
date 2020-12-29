def solution(s):
    bin_cnt=0;cnt=0
    while s!='1':
        cnt+=s.count('0')
        s=s.replace('0','')
        s=bin(len(s))[2:]
        bin_cnt+=1
    return [bin_cnt,cnt]

s='110010101001'
solution(s)