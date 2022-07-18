echo "생성할 계정(로그인ID, 홈 디렉터리, uid, gid, 로그인 셸)"
read username
read homedir
read uid
read gid
read shell
sudo useradd -m -d $homedir -u $uid -g $gid -s $shell $username
