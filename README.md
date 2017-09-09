# Local Ci/CD environment over Docker using Drone and Gogs

## Requirements
- Docker (Docker version 17.06.2-ce, build cec0b72)
- Docker Compose (docker-compose version 1.15.0, build e12f3b9)
- Git (git version 2.7.4)

## Build

``` bash
chmod +x tasks.sh

# see help
./tasks.sh

# init
./tasks.sh init
```

# Configuring
```bash
# start
./tasks.sh up

# get ips from services
./tasks.sh inspect
```

# GOGS
Open on your browser the address given by `inspect`

### 1. Register a new user with
```bash
user:        gogs
password:    password
email:       gogs@email.com
```

### 2. Go to your repository folder and create a git user
```bash
git config user.name "gogs"
git config user.email "gogs@email.com"
```

### Add the remote gogs to your repository folder
```bash
git remote add cicd "http://<GOGS_IP>:<GOGS_PORT>/gogs/<NAME>.git"
git push -u cicd master
```

# Drone
Open on your browser the address given by `inspect`
### 1. Login with:
```bash
user:        gogs
password:    password
# Same user created on gogs
```
### 2. Activate your repository
### 3. Commit and push you repository
### 4. See the magic happens!

