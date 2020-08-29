n = int(input())
str_list = input().split()
row = 1
col = 1

for i in range(len(str_list)):
    if str_list[i] == "L" and col > 1:
        col -= 1
    elif str_list[i] == "R" and col < n:
        col += 1
    elif str_list[i] == "U" and row > 1:
        row -= 1
    elif str_list[i] == "D" and row < n:
        row += 1

print(row, col)
