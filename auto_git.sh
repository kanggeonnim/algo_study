#깃 remote 목록 받아오기, 최근 사용한 branch 받아오기

REMOTE_REPO="$(git remote)"
COMMIT_MESSAGE=day$(date "+%m%d")

repo_array=(${REMOTE_REPO// /})
for repo in "${repo_array[@]}"
do
  WORKING_BRANCH=$(git branch --show-current)
  git pull ${repo} ${WORKING_BRANCH}
  echo "> ${repo} ${WORKING_BRANCH} pull complete"
done

git add .
echo "> add all files"
git commit -m "${COMMIT_MESSAGE}"

for repo in "${repo_array[@]}"
do
  WORKING_BRANCH=$(git branch --show-current)
  git push ${repo} ${WORKING_BRANCH}
  echo "> ${repo} ${WORKING_BRANCH} push complete"
done

if [ $? = 0 ]; then
  echo "> workspace push done."
else
  git reset --soft HEAD^
  read -s -n 1 -p "> push faild. please check the git error message.Press any key to EXIT . . ."
fi

read -s -n 1 -p "> All process done. Press any key to EXIT"
