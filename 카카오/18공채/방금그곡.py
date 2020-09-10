def replace_musicinfo(musicinfos):
    music_list = []
    for i in range(len(musicinfos)):
        data = musicinfos[i].split(',')
        music_list.append(data)
    return music_list

def replace_m(m):
    return_m = m
    
    return_m = return_m.replace('C#','a')
    return_m = return_m.replace('D#','b')
    return_m = return_m.replace('F#','c')
    return_m = return_m.replace('G#','d')
    return_m = return_m.replace('A#','e')
    
    return return_m  
    
def cal_time(time1, time2):
    h1,h2 = int(time1[0:2])*60,int(time2[0:2])*60
    m1,m2 = int(time1[3:5]),int(time2[3:5])
    return_m1,return_m2 = (h1+m1),(h2+m2)

    return return_m2-return_m1

def solution(m, musicinfos):
    answer = ''
    m = replace_m(m)
    music_list = replace_musicinfo(musicinfos)

    play = ''
    result = []

    count=1
    for music in music_list:
        time = cal_time(music[0],music[1])
        music[3] = replace_m(music[3])
        for i in range(time):
            play+=music[3][i%len(music[3])]
        print(play)
        if m in play:
            result.append([time,count,music[2]])
            count+=1
        play=''

    if len(result)==0:
        return '(None)'
    else:
        result = sorted(result,key= lambda x : [-x[0],x[1]])
        return result[0][2]

# m = 'ABC#DEFG'
# musicinfos = ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF","12:00,12:15,HELLO2,C#DEFGAB"]	
m = 'CDEFGAC'
musicinfos = ['12:00,12:06,HELLO,CDEFGA']

result = solution(m,musicinfos)
print(result)


