## 1. nstall Docker
```bash

sudo apt update
sudo apt install -y docker.io

```
## 2. Start Docker Service:
```bash

sudo systemctl start docker

```

## 3. Run a Docker Container (replace docker by podman)
```bash
sudo docker run -d --name mytestcontainer ubuntu sleep 3600

```
## 4. Explore Docker Processes (replace docker by podman)
```bash

pstree -p | grep docker


```

## List Podman Processes
```bash

ps aux | grep -e podman -e conmon


```


## 6.list Process Trees

```bash

pstree -p | grep -e docker -e containerd -e podman -e conmon

```
