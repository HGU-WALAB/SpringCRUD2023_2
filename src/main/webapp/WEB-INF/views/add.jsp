<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>My Player</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        form {max-width: 800px; margin: auto;}
        label {margin-top: 10px; font-size: 18px; font-weight: bold;}
        input {margin-bottom: 15px; font-size: 16px;}
        .form-check-label {
            margin-right: 70px;
            font-size: 16px;
            font-weight: bold;
        }
        h2 {font-size: 24px; font-weight: bold; margin-bottom: 20px;}
        .btn-primary {font-size: 16px; font-weight: bold;}
    </style>
</head>

<body style="background-color:#F7EFE5">
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="list">My Player</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="list">선수 목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="add">선수 추가</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<form action="addok" method="post" class="mb-3 border p-3" style="margin-top: 50px;background-color: #FFFBF5" enctype="multipart/form-data">
    <h2 class="mb-4">선수 추가</h2>
    <div class="mb-3">
        <div class="row">
            <div class="col-md-6">
                <label for="name" class="form-label">이름*</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label for="weight" class="form-label">체중(kg)*</label>
                <input type="number" id="weight" name="weight" class="form-control" min="0" required>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="height" class="form-label">키(cm)*</label>
                <input type="number" id="height" name="height" class="form-control" min="0" required>
            </div>
            <div class="col-md-6">
                <label for="birthday" class="form-label">생일*</label>
                <input type="date" id="birthday" name="birthday" class="form-control" required>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="photo" class="form-label">이미지*</label>
                <input type="file" id="photo" name="photo" class="form-control" required>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label class="form-label">포지션*</label>
                    <input type="radio" id="gk" name="formation" value="GK" class="form-check-input" style="margin-top: 15px;margin-left: 40px" required>
                    <label for="gk" class="form-check-label">GK</label>
                    <input type="radio" id="df" name="formation" value="DF" class="form-check-input" style="margin-top: 15px" required>
                    <label for="df" class="form-check-label">DF</label>
                    <input type="radio" id="mf" name="formation" value="MF" class="form-check-input" style="margin-top: 15px" required>
                    <label for="mf" class="form-check-label">MF</label>
                    <input type="radio" id="fw" name="formation" value="FW" class="form-check-input" style="margin-top: 15px" required>
                    <label for="fw" class="form-check-label">FW</label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="pass" class="form-label">패스 (0-100)*</label>
                <input type="number" id="pass" name="pass" class="form-control" min="0" max="100" required>
            </div>
            <div class="col-md-6">
                <label for="shoot" class="form-label">슛 (0-100)*</label>
                <input type="number" id="shoot" name="shoot" class="form-control" min="0" max="100" required>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="defense" class="form-label">수비력 (0-100)*</label>
                <input type="number" id="defense" name="defense" class="form-control" min="0" max="100" required>
            </div>
            <div class="col-md-6">
                <label for="speed" class="form-label">속도 (0-100)*</label>
                <input type="number" id="speed" name="speed" class="form-control" min="0" max="100" required>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="intelligence" class="form-label">축구 지능 (0-100)*</label>
                <input type="number" id="intelligence" name="intelligence" class="form-control" min="0" max="100" required>
            </div>
            <div class="col-md-6">
                <label for="goalkeeping" class="form-label">골키퍼 능력 (0-100)*</label>
                <input type="number" id="goalkeeping" name="goalkeeping" class="form-control" min="0" max="100" required>
            </div>
        </div>
    </div>
    <div style="display: flex; justify-content: end">
        <input class="btn btn-warning" onclick="location.href='list'" type="button" value="취소" style="margin-right: 10px;">
        <input type="submit" value="제출" class="btn btn-primary" style="margin-right: 10px;">
    </div>
</form>
</body>
</html>