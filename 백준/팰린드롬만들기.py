from copy import deepcopy
data=input();data=list(data)
i=0;j=len(data)-1;len_=1;tmp=data[:-1];flag=False
copy_data=deepcopy(data)
while True:
    if i>=j: print(len(data));break
    if data[i]==data[j]: i+=1; j-=1
    else:
        if not flag:
            data=deepcopy(copy_data)
            for idx in range(len_-1,-1,-1):
                data.append(tmp[idx])
            i=0;j=len(data)-1
            flag=True
        else:
            len_+=1
            data=deepcopy(copy_data)
            for idx in range(len_-1,-1,-1):
                data.append(tmp[idx])
            i=0;j=len(data)-1