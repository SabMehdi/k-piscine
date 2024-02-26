## 1. nstall Docker
```bash

sudo apt update
sudo apt install -y docker.io

```
## 2. Start Docker Service:
```bash

sudo systemctl start docker

```

## 3. Run a Docker Container
```bash
sudo docker run -d --name mytestcontainer ubuntu sleep 3600

```
## 4. Explore Docker Processes
```bash

pstree -p | grep docker


```

## 5.Explore Docker Processes:
```bash

pstree -p | grep docker


```

## 6.Explore Process Trees

```bash

pstree -p | grep -e docker -e containerd -e podman -e conmon

```
