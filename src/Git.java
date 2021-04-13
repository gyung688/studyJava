
public class Git {

	public static void HowToUseGit(String[] args) {
		// 출처 : https://www.youtube.com/watch?v=Z9dvM7qgN9s
	}
	
	public void SetUp(){
		/*
		 * https://git-scm.com/downloads 에서 깃을 다운받는다.
		 * https://www.sourcetreeapp.com/ 에서 git GUI를 다운받는다.
		 * 터미널을 연다.
		 * git config --list //git에 대한 모든 환경설정이 .gitconfig라는 파일안에 저장되는데 이것을 확인할 수 있다.
		 * git config --global -e // editor로 내용을 확인할 수 있다.
		 * git --version //git version 2.31.1.windows.1 버젼을 확인할 수 있다.
		 *
		 * 사용자 정보 설정
		 * git config --global -e
		 * git config --global user.name "이름"
		 * git config --global user.email "이메일@gmail.com"
		 * git config user.name //설정한 것을 확인 할 수 있다.
		 * 
		 * os에 따라 줄바꿈이 달라서 수정하지 않았음에도 불구하고 문자열이 달라져 gitHistory에 문제가 있을 수 있다. 이걸 설정하는게 core.autocrlf인데
		 * git config --global core.autocrlf input //윈도우는 true mac은 input
		 * git-scm.com/docs  에서 명령어를 확인할 수 있따.
		 * 
		 * 깃 폴더 만들기
		 * cd projects
		 * mkdir git
		 * cd git
		 * dir /a 
		 * git init //초기화
		 * dir /a //초기화를 하면 git을 확인할 수 있다.
		 * rm -rf .git //git 제거
		 * 
		 * git status //상태 확인
		 * git config --global alias.st status //status를 st로만 쓰고싶을 때
		 * git st //status가 출력된다
		 * git config --h //속성값을 확인해볼 수 있다.
		 * 
		*/
	}
	
	public void BasicsOfGit(){
		/*
		 * git의  workflow
		 * 1. working directory //프로젝트의 파일들을 수정하는
		 * 2. staging area //작업하다가 버젼히스토리에 저장할 준비가 되어있는 파일을 옮겨놓는
		 * 3. .git directory //버젼의 히스토리를 갖고있음
		 * working directory에서 파일들을 수정하다가 어느저도 완성이 됐으면 staging area로 파일을 옮기고 commit을 해서 .git directory에 저장하게됨
		 * commit한 것을 checkout해서 언제든지 원하는 버젼으로 돌아갈 수 있다.
		 * push를 통해 git서버에 올릴 수 있고, pull로 다시 내 컴퓨터로 다운 받을 수 있다
		 * 각각의 commit엔 스냅샷된 정보를 기반으로 고유한 해시코드가 부과되는데 이 ID로 버젼정보를 참조할 수 있다.
		 * 
		 * Working Directory
		 * 1. untracked //git이 초기화가 됐는데, 아직 tracking이 되지 않은 파일들을 여기에 저장
		 * 2. tracked //git 이  이미 알고있는, tracking하는 파일이면 tracked에 저장됨 
		 * tracked는 unmodified와 modified로 나뉨
		 * modifed만 staging area로 옮길 수 있음
		*/
		
		/*
		 * 실습
		 * 
		 * cmd를 연다.
		 * projects/git/git로 이동
		 * echo hello world! > a.txt //텍스트파일 a에 hello world!저장
		 * echo hello world! > b.txt 
		 * echo hello world! > c.txt 
		 * git status 를 실행하면 아래가 나온다.
		 * (
		 * On branch master	//master branch 위에서 작업하고있고
		 * No commits yet	//commit된 것은 없고
		 * Untracked files	//untracked된 파일들이 있다.
		 * nothing added to commit but untracked files present(use "git add" to track) //커밋할게 없지만 untracked파일이 있으니 git add를 이용해 track할 수 있어
		 * )
		 * git add a.txt
		 * git status //현재 커밋 준비 된 파일이 있다고 나온다 (a.txt)
		 * git add *.txt //현재 모든 파일이 커밋 준비 돼있다.
		 * echo ellie >> a.txt
		 * git status //a.txt가 수정됐다고 나온다
		 * git add a.txt // 이제 모든 파일이 stging area에 있음
		 * git rm --cached * //모든파일을 untracked가 됨
		 * 
		 * 
		 */
		
		/*
		 * tracking하고 싶지 않은  파일들 관리
		 * echo log > log.log
		 * echo *.log > .gitignore //gitignore파일을 새로 만들면됨
		 * echo build/ >> .gitignore //echo 특정 디렉토리 안에있는 파일을 추가하고싶지 않을 때
		 * echo build/*.log >> .gitignore //build 안에 있는 log파일들만 빼고 싶을 때
		 * 
		 * diff
		 * echo haha >> a.txt
		 * git diff //이전과 달라진 부분을 보여준다
		 * type a.txt //a.txt 내용을 확인할 수 있다.
		 * (
		 * hello world
		 * ellie //hello world와 ellie는 staging area에 있고 haha는 working directory 에 있는 상황
		 * +haha
		 * )
		 * git diff --staged //stage area의 diff를 확인할 수 있다.
		 * git config --global -e //에 들어가 아래를 작성한다.
		 * [diff]
		 * 		tool = vscode	//diff tool은 vscode라는것을 이용하고 
		 * [difftool "vscode"]
		 * 		cmd = code --wait --diff $LOCAL $REMOTE //vscode명령어는 코드 다음에 기다리고 diff를 이용하고 LOCAL과 REMOTE를 비교한다
		 *
		 * git difftool
		 * vscode로 런칭할것인지 나옴 y를 누른다
		 * 
		 * git commit
		 * git log //언제 누가 commit했는지 보여준다.
		 * 
		 * 단순하게 commit하는 법
		 * echo add >> c.txt
		 * git add .
		 * git commit -m "second commit" //-m은 메세지옵션
		 * git log
		 * 
		 * staging area 안거치고 commit
		 * echo add >> c.txt
		 * git commit -am "third commit"
		*/
	}

}
