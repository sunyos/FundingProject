<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<!-- bootstrap 4 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&fa
         mily=Nanum+Gothic&family=Roboto&display=swap"
	rel="stylesheet">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.join-form {
	font-family: 'Rajdhani', 'sans-serif';
	/* 하나의 플렉스 아이템이 자신의 컨테이너가 차지하는 공간에 맞추기 위해 크기를 키우거나 줄이는 방법을 설정하는 속성*/
	justify-content: center;
	align-items: center;
	text-align: center;
}

.join-form div {
	display: inline-block;
	text-align: left;
}

#pageTitle {
	font-size: 30px;
	text-align: left;
	margin-top: 150px;
	margin-bottom: 100px;
	font-family: 'Rajdhani', 'sans-serif';
	font-weight:bolder;	
}

.input-area {
	width: 400px;
}

.input-area button {
	width: 25%;
	height: 30px;
	background: rgba(100, 200, 167, .5);
	border: none;
	border-radius: 5px;
	font-size: 1em;
	color: white;
	margin-left: 300px;
}

.input-area input {
	width: 100%;
	padding: 15px 10px 10px;
	line-height: 1.2em;
	background: transparent;
	margin-bottom: 10px;
	border: 0.3px solid rgba(0, 0, 0, .2);
	border-radius: 10px;
	font-size: 19px;
	color: black;
	outline: none;
}

.input-area input::placeholder {
	opacity: 0.5;
}

.pwd-area input {
	background: rgba(0, 0, 0, .06);
}

label {
	line-height: 50px;
	font-size: 20px;
	font-weight: 700;
	color: rgba(0, 0, 0, .7);
	padding-bottom: 5px;
}

.usercode-area {
	width: 100%;
	display: inline;
}

.usercode-area input {
	width: 70px;
	margin-left: 20px;
}

.usercode-area label {
	font-size: 1em;
}

#joinBtn {
	margin-top: 50px;
	margin-bottom: 100px;
	background-color: rgb(116, 228, 190);
	border: none;
	color: white;
	font-size: 1.5em;
}

#joinBtn:hover {
	cursor: pointer;
	background-color: mediumaquamarine;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>


	<script>
		function checkMove() {
			if (confirm("입력한 내용은 저장되지 않습니다. 이동하시겠습니까?") == true) {
				location
						.replace("http://127.0.0.1:5500/WEB/Login/Login01.html")
			}
		}
	</script>

	<section class="join-form">

		<div class="input-area">

			<h1 id="pageTitle">회원가입</h1>


			<div class="name-area area">

				<label for="name">이름</label> <input type="text" id="name"
					name="name" placeholder="이름 입력"> <label for="email">이메일
					아이디</label> <input type="email" id="email" name="email"
					placeholder="이메일 입력">
				<button>인증하기</button>
				<br>

				<div class="pwd-area area">
					<label for="name">비밀번호</label> <input type="password"
						id="password1" name="password1" placeholder="비밀번호"> <input
						type="password" id="password2" name="password2"
						placeholder="비밀번호 확인">

				</div>


				<label for="ssn">주민번호 </label> <input type="email" id="email"
					name="email" placeholder="주민번호 입력"> <label for="tel">전화번호
				</label> <input type="tel" id="tel" name="tel" placeholder="전화번호 입력">

				<label for="email">주소 </label> <input type="email" id="email"
					name="email" placeholder="주소 입력"> <label>회원구분</label> <br>
				<div class="usercode-area">
					<input type="radio" class=usercode id="normal" name="usercode"
						value="일반회원"><label for="normal"> 일반회원</label> <input
						type="radio" class=usercode id="business" name="usercode"
						value="사업자회원"> <label for="business"> 사업자회원</label>
				</div>



				<input id="joinBtn" type="submit" value="가입하기">
			</div>








		</div>
	</section>

</body>
</html>