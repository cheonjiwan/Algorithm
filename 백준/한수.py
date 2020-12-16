n=int(input());cnt=0
for i in range(1,n+1):
    if i<100: cnt+=1
    else:
        str_i=str(i);gap=int(str_i[0])-int(str_i[1]);flag=True
        for j in range(1,len(str_i)-1):
            if int(str_i[j])-int(str_i[j+1])!=gap: flag=False; break
        if flag: cnt+=1
print(cnt)