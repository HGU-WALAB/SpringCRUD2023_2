<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="css/main.css" type="text/css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>

<body>
<form action="선수정보처리서블릿URL" method="post">
    <!-- 이름 입력란 -->
    <label for="name">이름:</label>
    <input type="text" id="name" name="name" required><br>

    <!-- 체중 입력란 -->
    <label for="weight">체중:</label>
    <input type="number" id="weight" name="weight" min="0" required><br>

    <!-- 키 입력란 -->
    <label for="height">키:</label>
    <input type="number" id="height" name="height" min="0" required><br>

    <!-- 이미지 입력란 -->
    <label for="image">이미지:</label>
    <input type="text" id="image" name="image" required><br>

    <!-- 생년월일 입력란 -->
    <label for="birthday">생일:</label>
    <input type="date" id="birthday" name="birthday" required><br>

    <!-- 형성 입력란 -->
    <label for="formation">포지션:</label>
    <input type="text" id="formation" name="formation" required><br>

    <!-- 패스 입력란 -->
    <label for="pass">패스 (0에서 100까지):</label>
    <input type="number" id="pass" name="pass" min="0" max="100" required><br>

    <!-- 슛 입력란 -->
    <label for="shoot">슛 (0에서 100까지):</label>
    <input type="number" id="shoot" name="shoot" min="0" max="100" required><br>

    <!-- 수비 입력란 -->
    <label for="defense">수비력 (0에서 100까지):</label>
    <input type="number" id="defense" name="defense" min="0" max="100" required><br>

    <!-- 속도 입력란 -->
    <label for="speed">속도 (0에서 100까지):</label>
    <input type="number" id="speed" name="speed" min="0" max="100" required><br>

    <!-- 지능 입력란 -->
    <label for="intelligence">축구 지능 (0에서 100까지):</label>
    <input type="number" id="intelligence" name="intelligence" min="0" max="100" required><br>

    <!-- 골키퍼능력 입력란 -->
    <label for="goalkeeping">골키퍼 능력 (0에서 100까지):</label>
    <input type="number" id="goalkeeping" name="goalkeeping" min="0" max="100" required><br>

    <!-- 제출 버튼 -->
    <input type="submit" value="제출">
</form>
</body>
</html>
