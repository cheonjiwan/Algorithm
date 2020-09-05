input_data = input()
result = ''
for char in input_data:
    if ord(char)<=ord('Z') and ord(char)>=ord('A'):
        result += char.lower()
    else:
        result+=char.upper()

print(result)