from collections import deque

key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]		
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]

def rotate(key):
    rotated_key = []
    q = deque()
    
    idx = 0
    for _ in range(len(key)):
        for i in range(len(key)):
            q.appendleft(key[i][idx])
        rotated_key.append(list(q))
        idx+=1
        q.clear()

    return rotated_key

# 동빈나 90도 회전 함수
def rotate_a_matrix_by_90_degree(a):
    n = len(a) # 행 길이 계산
    m = len(a[0]) # 열 길이 계산
    result = [[0] * n for _ in range(m)] # 결과 리스트
    for i in range(n):
        for j in range(m):
            result[j][n - i - 1] = a[i][j]
    return result

def check(new_lock):
    length = len(new_lock)//3

    for i in range(length,length*2):
        for j in range(length,length*2):
            if new_lock[i][j] != 1:
                return False

    return True

def solution(key, lock):
    key_len = len(key)
    lock_len = len(lock)

    new_lock = [[0] * (lock_len*3) for _ in range(lock_len*3)]
    for n in range(lock_len):
        for m in range(lock_len):
            new_lock[lock_len+n][lock_len+m] = lock[n][m]
    
    for _ in range(4):
        key = rotate(key)
        for i in range(lock_len*2):
            for j in range(lock_len*2):
                for x in range(key_len):
                    for y in range(key_len):
                        new_lock[i+x][j+y] += key[x][y]
                        if check(new_lock):
                            return True
                        
                for x in range(key_len):
                    for y in range(key_len):
                        new_lock[i+x][j+y] -= key[x][y]

    return False


print(solution(key,lock))