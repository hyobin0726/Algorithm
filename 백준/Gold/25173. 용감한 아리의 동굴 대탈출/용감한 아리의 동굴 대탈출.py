from collections import deque

#input 받기처리
n,m=map(int,input().split())
g=[list(map(int,input().split())) for _ in range(n)]
hero_hp,hero_attack,boss_hp,boss_attack=map(int,input().split())
stones=set()
for x in range(n):
    for y in range(m):
        if g[x][y]==2:
            hero_x,hero_y=x,y
            g[x][y]=0
        elif g[x][y]==3:
            boss_x,boss_y=x,y
            g[x][y]=0
        elif g[x][y]==1:
            stones.add((x,y))

#동남서북
dir=[(0,1),(1,0),(0,-1),(-1,0)]

#초기 방향 설정
for i in range(4):
    dx,dy=dir[i]
    if hero_x==boss_x+dx and hero_y==boss_y+dy:
        hero_dir=boss_dir=i
        break

while True:
    #아리의 공격 시작
    boss_hp-=hero_attack
    if boss_hp<=0:
        print("VICTORY!")
        exit()
    
    #아리의 이동
    #아리가 움직이지 못할 경우를 대비해서, 보스의 현재 위치를 저장함
    hero_saved_x,hero_saved_y=boss_x,boss_y
    for k in range(4):
        dx,dy=dir[hero_dir]
        nx,ny=hero_x+dx,hero_y+dy
        if 0<=nx<n and 0<=ny<m and g[nx][ny]==0 and (nx,ny)!=(boss_x,boss_y):
            hero_saved_x,hero_saved_y=hero_x,hero_y
            hero_x,hero_y=nx,ny
            break
        else:
            hero_hp-=1
            hero_dir=(hero_dir+1)%4
            if hero_hp<=0:
                print("CAVELIFE...")
                exit()
    
    #보스의 공격
    temp_x,temp_y,temp_dir=boss_x,boss_y,boss_dir
    cnt=1
    if stones:
        try:
            while True:
                cnt+=1
                dx,dy=dir[temp_dir]
                for i in range(cnt//2):
                    temp_x+=dx
                    temp_y+=dy
                    if (temp_x,temp_y) in stones:
                        raise
                temp_dir=(temp_dir+1)%4
        except:
            q=deque([(temp_x,temp_y,boss_attack)])
            v=[[0 for _ in range(m)] for _ in range(n)]
            while q:
                x,y,attack=q.popleft()
                if v[x][y] or attack<=0:continue
                v[x][y]=attack
                if (x,y)==(hero_x,hero_y):
                    hero_hp-=attack
                    if hero_hp<=0:
                        print("CAVELIFE...")
                        exit()
                    break
                for dx,dy in dir:
                    nx,ny=x+dx,y+dy
                    if 0<=nx<n and 0<=ny<m and g[nx][ny]!=1 and (nx,ny)!=(boss_x,boss_y):
                        q.append((nx,ny,attack-1))
    
    #보스의 이동
    boss_x,boss_y,boss_dir=hero_saved_x,hero_saved_y,hero_dir