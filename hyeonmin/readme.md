# LEEHYEONMIN
## 2023-07-17 SSAFY_10_Algorithm_Study_Group




## 일부 폴더만 pull/push 하는 방법
1. 로컬에 프로젝트 폴더 하나 생성
2. > git init
3. > git remote add origin https://github.com/wo-ody/SSAFY10-Algorithm-Study.git
4. > git sparse-checkout init
5. > git sparse-checkout set 저장할repo의폴더명(ex:hyeonmin)
6. > git sparse-checkout list // set 되었는지 확인 한다.
7. > git pull origin main

8. 로컬에 생성되었는지 확인
9. .gitignore 생성하기
10. 제외항목
    - /.project
    - /README.md
    - /.gitignore
<br><br>
1.  commit/push 진행