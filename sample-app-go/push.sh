address="$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' gogs)"

git add -A
git commit -m "$(date)"
git remote add cicd "http://$address:3000/gogs/sample-app-go.git"
git push -u cicd master
