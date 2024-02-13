## 1. How is permission granted to delete a file?

The files permissions are maneged by the directory that contains it, and the user must have have both execute and write permissions to execute this task. The first one allows the user to modify the content of the directory and the later one allows the user to perform operations like file suppression.

## 2. Create a file that your colleague can edit but not delete and another he can delete but not edit
```
sudo usermod -aG keiken saber

``````
sudo usermod -aG keiken user2

```
```
mkdir keiken

```
```
sudo chgrp keiken keiken
```

```
cd keiken
```
```
touch edit
```
```
chmod 764
```

```
chmod 775 /home/saber/keiken
```
```
touch del
```
```
chmod 774 /home/saber/keiken
```
```
chmod 744 /keiken/del
```
```



## 3. Does it make sense to be able to assign such rights?

In my opinion both of these rights combinations of rights don't really make sense because:

- If the user can edit a file they can empty its content, making it useless except in the case of a program only needing its existence.
- If the user can delete a file, it would make no sense to restrict write access except to prevent malicious code injection that could be executed with that file.

Other, less particuliar permissions, such as providing different access levels to group and others, are really important as they allow to manage permissions on specific files without giving too much rights (for example by giving root access). It also allows faster management as you can change permissions for an entire group instead of a single user by combining chmod with chgroup and or usermod -a -G.

## 4. What are the practical consequences of this experience?

See previous answers, but moreover, I discovered that directories permissions and particulary the sticky bit are the determining factors for file deletion.