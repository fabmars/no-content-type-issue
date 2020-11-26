basedir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

docker run --rm --name content-type-nginx -v $basedir/foobar.json:/usr/share/nginx/html/foobar.json:ro -p 80:80 -d nginx
