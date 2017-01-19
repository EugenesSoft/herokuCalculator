<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>


    <style>
        .button {
            font-size: 22px;

            font-weight: 900;

            text-align: center;
            color: #295EAC;
            text-decoration: none;

            border-radius: 15px;
            background: #BDDFFB;
            transition: 0.2s;
            border: solid 3px black;
            margin-top: 3px;

            width: 50px;
            height: 50px;
        }

        .button:hover {
            background: #92C4EC;
        }

        .buttonCAC {
            color: #FFFFFF;
            background: #F54848;
        }

        .buttonCAC:hover {
            background: #EF2A2A;
        }

        .buttonZero {
            width: 104px;
            height: 50px;
        }

        .buttonResult {
            width: 50px;
            height: 103px;
            float: right;
            color: #FFFFFF;
            background: #1DBA2A;
            margin-right: 1px;
        }

        .buttonResult:hover {
            background: #0B9217;
        }

        .textArea {
            margin-left: -4px;
            text-align: right;
            border: 0px solid #9E9E9E;
            color: #000000;
            padding: 3px;
            margin-top: -5px;
            margin-bottom: 0px;
            font-size: 25px;
            font-family: Verdana;
            background: #FFF;
            width: 254px;
            height: 45px;
            border-radius: 15px;
        }
        .textArea2 {
            margin-left: -4px;
            text-align: right;
            border: 0px solid #9E9E9E;
            color: #000000;
            padding: 3px;
            margin-top: -7px;
            margin-bottom: 5px;
            font-size: 15px;
            font-family: Verdana;
            background: #FFF;
            height: 25px;
            width: 254px;
            border-radius: 15px;
        }

        .mainBlock {
            border-radius: 20px;
            width: 267px;
            height: 290px;
            background: #409EFE;
            padding: 5px;
            border: solid 7px black;
            float: left;
            position: relative;
            top: 40px;
            left: 33%;
        }

        .displayBlock {
            width: 245px;
            height: 60px;
            border-radius: 20px;
            background: #FFF;
            padding: 5px;
            border: solid 5px black;
            float: left;
            position: relative;
        }
    </style>

</head>
<body>
<section>
    <br>
    <div class="mainBlock">
        <form>
            <div class="displayBlock ">
                <input class="textArea" name="result" value="${result}" type="text" readonly="readonly">
                <input class="textArea2" name="result" value="${result2}" type="text" readonly="readonly">
            </div>

            <br>
            <button class="button" name="btn" type="submit" value="1">1</button>
            <button class="button" name="btn" type="submit" value="2">2</button>
            <button class="button" name="btn" type="submit" value="3">3</button>
            <button class="button buttonOperator2" name="btn" type="submit" value="plus">＋</button>
            <button class="button buttonCAC" name="btn" type="submit" value="C">C</button>
            <br>
            <button class="button" name="btn" type="submit" value="4">4</button>
            <button class="button" name="btn" type="submit" value="5">5</button>
            <button class="button" name="btn" type="submit" value="6">6</button>
            <button class="button buttonOperator2" name="btn" type="submit" value="minus">－</button>
            <button class="button buttonCAC" name="btn" type="submit" value="AC">AC</button>
            <br>
            <button class="button" name="btn" type="submit" value="7">7</button>
            <button class="button" name="btn" type="submit" value="8">8</button>
            <button class="button" name="btn" type="submit" value="9">9</button>
            <button class="button buttonOperator" name="btn" type="submit" value="mult">×</button>
            <button class="button buttonResult" name="btn" type="submit" value="res">=</button>
            <br>

            <button class="button buttonZero" name="btn" type="submit" value="0">0</button>
            <button class="button" name="btn" type="submit" value=".">.</button>
            <button class="button buttonOperator" name="btn" type="submit" value="div">÷</button>
            <br>
        </form>
    </div>
</section>
</body>
</html>
