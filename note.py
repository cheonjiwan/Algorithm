# 2차원 배열 시계방향 90도 회전 함수
def rotate(key):
    rotated_key = []
    q = deque()

    idx = 0
    for _ in range(len(key)):
        for i in range(len(key)):
            q.appendleft(key[i][idx])
        rotated_key.append(list(q))
        idx += 1
        q.clear()

    return rotated_key


# 동빈나 90도 회전 함수
def rotate_a_matrix_by_90_degree(a):
    n = len(a)  # 행 길이 계산
    m = len(a[0])  # 열 길이 계산
    result = [[0] * n for _ in range(m)]  # 결과 리스트
    for i in range(n):
        for j in range(m):
            result[j][n - i - 1] = a[i][j]
    return result


# 2차원 배열 선언
arr = eval(("[[0]*5]+" * 10)[:-1])

# 이진탐색, 주어진 숫자 개수 찾기
from bisect import bisect_left, bisect_right
def count_by_range(a, left, right):
    right_index = bisect_right(a, right)
    left_index = bisect_left(a, left)

    return right_index - left_index