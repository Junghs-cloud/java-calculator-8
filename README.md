# 문자열 덧셈 계산기

## 체크 리스트

- [x] 사용자 입력 받기
- [x] 콜론을 사용했을 때 덧셈 구현하기
- [x] 커스텀 구분자를 사용했을 때 덧셈 구현하기
- [x] 잘못된 값을 입력했을 때 오류를 출력하기
- [x] MVC 패턴으로 분리하기

## 파일 구조

        📁calculator
        │
        │  🗒️Application.java
        │  
        ├─📁Controller
        │       🗒️CalculatorController.java
        │      
        ├─📁Model
        │       🗒️CalculatorModel.java
        │      
        └─📁View
                🗒️InputView.java
                🗒️OutputView.java



- Application.java: 전체 프로그램을 실행시킨다.
- CalculatorController.java: InputView를 이용하여 사용자의 입력을 받고 CalculatorModel을 이용하여 값을 구한다. 이후 OutputView에게 해당 값을 전달하여 답을 출력하도록 한다.
- CalculatorModel.java: 문자열을 보고 구분자를 토대로 분리하여 토큰들을 합한다. 이 과정에서 잘못된 입력은 IllegalArgumentException()을 출력하도록 한다.
- InputView.java: 입력을 담당한다.
- OutputView.java: 결과를 출력한다.

### 오류 발생 조건

- 입력 값 중 하나라도 숫자가 아닌 경우 -> 오류 발생
- 커스텀 구분자는 문자이므로 \\와 \n 사이에 오는 문자열이 두 글자 이상인 경우 -> 오류 발생
- 입력된 숫자 중 하나라도 음수가 있을 경우 -> 양수가 아니므로 오류 발생