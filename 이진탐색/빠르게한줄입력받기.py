import sys

# 하나의 문자열 데이터 입력받기
# readline()으로 입력하면 엔터 후 \n가 줄 바꿈 기호로 입력.
# 이 공백 문자를 제거하려면 rstrip() 반드시 호출
input_data = sys.stdin.readline().rstrip()

print(input_data)