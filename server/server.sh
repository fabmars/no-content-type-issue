 docker run --rm --name no-content-type-nginx -v $PWD/nginx.conf:/etc/nginx/nginx.conf:ro -v $PWD/mime.types:/etc/nginx/mime.types:ro -p 80:80 -d nginx