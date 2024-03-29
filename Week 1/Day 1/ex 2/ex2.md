## 1. Find all files under the /etc directory whose names begin with rc:


```bash

find /etc -name 'rc*'
```
![Alt text](image.png)
## 2. Find all regular files belonging to you, output the result to the file /tmp/findme, and redirect errors to /dev/null:

```bash
find / -type f -user saber > /tmp/findme 2>/dev/null
```

![Alt text](image-1.png)
## 3. Find all subdirectories of /etc:


```bash

find /etc -type d
```

![Alt text](image-2.png)
## 4. Find all regular files under your home directory that have not been modified in the last 10 days:

```bash

find /home/saber -type f -mtime +10
```
![Alt text](image-3.png)
## 5. The 10 largest file in your computer
```bash
find / -type f | sort -r | head 

```
![Alt text](image-4.png)
