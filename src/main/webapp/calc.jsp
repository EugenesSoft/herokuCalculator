<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>


    <style>
    .button {
    font-weight: 700;
    text-align: center;
    color: white;
    text-decoration: none;
    padding: .8em 1em calc(.8em + 3px);
    border-radius: 3px;
    background: rgb(64, 199, 129);
    box-shadow: 0 -3px rgb(53, 167, 110) inset;
    transition: 0.2s;

    width: 50px;
    height: 50px;
    }

    button:hover {
    background: rgb(53, 167, 110);
    }

    button:active {
    background: rgb(33, 147, 90);
    box-shadow: 0 3px rgb(33, 147, 90) inset;
    }

    .buttonNumber {
    width: 50px;
    height: 50px;
    }

    .buttonZero {
    width: 104px;
    height: 50px;
    }

    .buttonResult {
    width: 50px;
    height: 100px;
    float: right;
    }

    .textArea {
    border: 1px solid #9E9E9E;
    color: #000000;
    padding: 3px;
    margin-top: 2px;
    margin-bottom: 2px;
    font-size: 25px;
    font-family: Verdana;
    background: #FFF;
    width: 266px;
    height: 50px;
    }

    .mainBlock {
    width: 266px;
    height: 253px;
    background: #fff819;
    padding: 5px;
    border: solid 1px black;
    float: left;
    position: relative;
    top: 40px;
    left: 33%;
    }
    </style>

</head>
<body>
<section>
    <br>
    <div class="mainBlock">
        <form>
            <input class="textArea" name="result" value="${result}" type="text" readonly="readonly">
            <br>
            <button class="button" name="btn" type="submit" value="1">1</button>
            <button class="button" name="btn" type="submit" value="2">2</button>
            <button class="button" name="btn" type="submit" value="3">3</button>
            <button class="button" name="btn" type="submit" value="plus">＋</button>
            <button class="button" name="btn" type="submit" value="C">C</button>
            <br>
            <button class="button" name="btn" type="submit" value="4">4</button>
            <button class="button" name="btn" type="submit" value="5">5</button>
            <button class="button" name="btn" type="submit" value="6">6</button>
            <button class="button" name="btn" type="submit" value="minus">－</button>
            <button class="button" name="btn" type="submit" value="AC">AC</button>
            <br>
            <button class="button" name="btn" type="submit" value="7">7</button>
            <button class="button" name="btn" type="submit" value="8">8</button>
            <button class="button" name="btn" type="submit" value="9">9</button>
            <button class="button" name="btn" type="submit" value="mult">×</button>
            <button class="button buttonResult" name="btn" type="submit" value="res">=</button>
            <br>

            <button class="button buttonZero" name="btn" type="submit" value="0">0</button>
            <button class="button" name="btn" type="submit" value=".">.</button>
            <button class="button" name="btn" type="submit" value="div">÷</button>
            <br>
        </form>
    </div>
</section>
</body>
</html>
