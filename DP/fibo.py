# 메모이제이션 하기 위한 리스트
d = [0] * 100

def fibo(x):
    if x == 1 or x == 2 :
        return 1
    
    # 이미 계산한 적 있는 문제라면 그대로 반환
    if d[x] != 0:
        return d[x]
    
    # 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
    d[x] = fibo(x-1) + fibo(x-2)
    return d[x]

print(fibo(99))

d = [0] * 100

d[1] = 1
d[2] = 1
n = 99

for i in range(3,n+1):
    d[i] = d[i-1] + d[i-2]

print(d[n])