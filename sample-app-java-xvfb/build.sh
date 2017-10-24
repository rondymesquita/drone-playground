docker build -t xvfb .
docker run -ti --rm -v $(pwd):/home/ xvfb bash