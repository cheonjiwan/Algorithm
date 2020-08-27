a = input().split(".")
year = a[0]
month= a[1]
day = a[2]

if(len(year)<4):
    if(len(year)==3):
        year="0"+year
    elif(len(year)==2):
        year="00"+year
    elif(len(year)==1):
        year="000"+year
if(len(month)==1):
    month = "0"+month

if(len(day)==1):
    day = "0"+day

print(year+"."+month+"."+day)