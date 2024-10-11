docker pull webdb/app && \
docker rm -f $(docker ps -a -q --filter ancestor=webdb/app) webdb || echo && \
docker run --name webdb -d \
	--restart=always \
	--add-host="host.docker.internal:host-gateway" \
	-v $HOME/.webdb:/usr/src/app/static/version \
	-p 127.0.0.1:22071:22071 webdb/app
