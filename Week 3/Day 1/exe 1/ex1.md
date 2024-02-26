## 1. Create Network Namespaces
```bash

ip netns add ns1
ip netns add ns2
```
![Alt text](image.png)
## 2. Create the Bridge
```bash

ip link add name br0 type bridge
ip link set br0 up
```

## 3. Create Veth Pairs
```bash
ip link add veth1 type veth peer name veth1-br
ip link add veth2 type veth peer name veth2-br
```
## 4. Attach Veth Ends to Namespaces
```bash

ip link set veth1 netns ns1
ip link set veth2 netns ns2

```

## 5.Attach the Other Ends to the Bridge
```bash

ip link set veth1-br master br0
ip link set veth2-br master br0
ip link set veth1-br up
ip link set veth2-br up

```

## 6. Assign IP Addresses
Assign IP addresses to the veth interfaces within each namespace. Make sure they are in the same subnet as the bridge.
```bash

ip netns exec ns1 ip addr add 10.10.1.1/24 dev veth1
ip netns exec ns1 ip link set veth1 up
ip netns exec ns1 ip link set lo up

ip netns exec ns2 ip addr add 10.10.1.2/24 dev veth2
ip netns exec ns2 ip link set veth2 up
ip netns exec ns2 ip link set lo up
```

## 7. (Optional) Configure the Bridge IP
You can optionally assign an IP address to the bridge itself on the host. This step is not strictly necessary for the namespaces to communicate with each other but can be useful for other purposes.
```bash

ip addr add 10.10.1.3/24 dev br0
```

## 8. Test Connectivity
```bash
ip netns exec ns1 ping 10.10.1.2
```
## 9. Using the file system table (/etc/fstab for instance), list local disk devices.
```bash
grep '^/dev/' /etc/fstab

```
## 8. Enable IP Forwarding
IP forwarding must be enabled on the host to allow traffic to be forwarded between network interfaces. You can enable IP forwarding temporarily (until the next reboot) with:
```bash
echo 1 > /proc/sys/net/ipv4/ip_forward
```
## 9. Set Up NAT Using iptables
```bash
iptables -t nat -A POSTROUTING -s 10.10.1.0/24 -o eth0 -j MASQUERADE

```
## Configure DNS (Optional but Recommended)
```bash
ip netns exec ns1 bash -c 'echo "nameserver 8.8.8.8" > /etc/resolv.conf'
```
## default route
```bash

ip netns exec ns1 ip route add default via 10.10.1.3

```
## Testing Connectivity

```bash

ip netns exec ns1 ping -c 3 www.google.com

```
