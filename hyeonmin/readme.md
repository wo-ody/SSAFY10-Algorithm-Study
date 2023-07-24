# LEEHYEONMIN
## 2023-07-17 SSAFY_10_Algorithm_Study_Group




## 일부 폴더만 pull/push 하는 방법
1. 로컬에 프로젝트 폴더 하나 생성
2. > git init
3. > git remote add origin https://github.com/wo-ody/SSAFY10-Algorithm-Study.git
4. > git sparse-checkout init
5. > git sparse-checkout set hyeonmin << 자기 이름 폴더로 변경하면 됨
6. > git sparse-checkout list // set 되었는지 확인 한다.
7. > git pull origin main

8. 로컬에 생성되었는지 확인
9. .gitignore 생성하기
10. 제외항목
    - /.project
    - /README.md
    - /.gitignore
<br><br>
11. commit/push 진행

## invalid path error 발생
pull 중에 error가 발생했다.
![Alt text](image.png)

검색해보니 windows 환경 git에서는 ?와 같은 특수문자가 포함되어 있으면 정상적으로 작동이 되지 않는다고 한다.

해결방법은 간단하다. 다음 코드를 순서대로 실행시키면 된다.
1. > git config core.protectNTFS false
2. > git checkout -f HEAD